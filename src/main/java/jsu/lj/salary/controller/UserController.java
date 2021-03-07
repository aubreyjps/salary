package jsu.lj.salary.controller;

import jsu.lj.salary.pojo.User;
import jsu.lj.salary.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;


@Controller
public class UserController {

    public static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    RedisTemplate redisTemplate;


    @PostMapping("/success")
    public String success(String phonenum){
        User user = getData(phonenum);
        if (user.isAdmit())
            return "redirect:admit/admitIndex.html";
        else
            return "redirect:user/userIndex.html";
    }

    @PostMapping("/register.action")
    public String register(String phonenum, String name, String password, String sex) {
        User user = new User(phonenum,name, passwordEncoder.encode(password),sex.equals("1"));
        setData(user);
        return "/login";
    }

    @PostMapping("/getData")
    @ResponseBody
    public User getData(String phonenum){
        User user = null;
        if (redisTemplate.hasKey(phonenum))
            user = (User) redisTemplate.opsForValue().get(phonenum);
        else
            user = userRepository.findByPhonenum(phonenum);
        if (user == null)
            return null;
        else
            return user;
    }

    public void setData(User user){
        redisTemplate.opsForValue().set(user.getPhonenum(),user);
        userRepository.save(user);
    }

    @PostMapping("/imgUpdate")
    public String SingleFileUpLoad(@RequestParam("file") MultipartFile file,String phonenum) {
        logger.info("文件修改：" + phonenum);
        //判断文件是否为空
        if(file.isEmpty()){
            return "5xx";
        }

        //创建输入输出流
        InputStream inputStream = null;
        OutputStream outputStream = null;

        try {
            String path = "target/classes/static/images/";
//            //静态路径位置
//            String staticPath = ClassUtils.getDefaultClassLoader().getResource("static").getPath();
            //获取文件的输入流
            inputStream = file.getInputStream();
            //获取上传时的文件名
            String fileName = file.getOriginalFilename();
            String[] str = fileName.split("\\.");
//            // 图片存储目录及图片名称
//            String url_path = "images" + File.separator + fileName;
            //图片保存路径
            String savePath = path + phonenum + "." + str[1];
            //注意是路径+文件名
            File targetFile = new File(savePath);
            logger.info(savePath);

            //判断文件父目录是否存在
            if(!targetFile.getParentFile().exists()){
                //不存在就创建一个
                targetFile.getParentFile().mkdir();
            }

            //获取文件的输出流
            outputStream = new FileOutputStream(targetFile);
            FileCopyUtils.copy(inputStream, outputStream);
            User user = getData(phonenum);
            user.setImage("images/"+phonenum+"."+str[1]);
            setData(user);
            logger.info("images/"+phonenum+"."+str[1]);
        } catch (IOException e) {
            e.printStackTrace();
            //出现异常，则告诉页面失败
            return "5xx";
        } finally {
            //无论成功与否，都有关闭输入输出流
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return "my";
    }

    @GetMapping("/updateUser.action")
    @ResponseBody
    public String update(String phonenum, String data, String value){
        logger.info("更新phone:"+phonenum+",data:"+data+",value:"+value);
        User user = getData(phonenum);
        switch (data){
            case "name":
                user.setName(value);
                break;
            case "email":
                user.setEmail(value);
                break;
            case "phone":
                user.setPhonenum(value);
                break;
            case "qq":
                user.setQq(value);
                break;
            case "password":
                user.setPassword(passwordEncoder.encode(value));
                break;
            case "sex":
                user.setSex(Boolean.getBoolean(value));
                break;
            default:
                return "0";
        }
        setData(user);
        return "1";
    }

    @PostMapping("/updatePass.action")
    public String updatePass(String password,String passwordNew){
        update(passwordNew,"password",password);
        return "redirect:/logout";
    }

    @GetMapping("/delRedis")
    @ResponseBody
    public String delRedis(String phonenum){
        if (redisTemplate.hasKey(phonenum)) {
            logger.info("删除redis");
            redisTemplate.delete(phonenum);
        }
        return "1";
    }
}


