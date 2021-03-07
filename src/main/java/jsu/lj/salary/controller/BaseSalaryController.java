package jsu.lj.salary.controller;

import jsu.lj.salary.pojo.BaseSalary;
import jsu.lj.salary.pojo.PrimaryKey;
import jsu.lj.salary.repository.BaseSalaryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@RestController
public class BaseSalaryController {

    @Autowired
    BaseSalaryRepository baseSalaryRepository;

    Logger logger = LoggerFactory.getLogger(BaseSalaryController.class);

    @Autowired
    RedisTemplate redisTemplate;
    Calendar calendar = Calendar.getInstance();

    @GetMapping("/getSalary")
    public BaseSalary getData(String year,String month) {
        BaseSalary baseSalary;
        int cyear = calendar.get(Calendar.YEAR);
        int cmonth = calendar.get(Calendar.MONTH)+1;
        if (Integer.parseInt(year) == cyear && Integer.parseInt(month) == cmonth) {
            if (redisTemplate.hasKey("BaseSalary"))
                baseSalary = (BaseSalary) redisTemplate.opsForValue().get("BaseSalary");
            else {
                Optional<BaseSalary> optionalBaseSalary = baseSalaryRepository.findById(new PrimaryKey(year, month));
                if (optionalBaseSalary.equals(Optional.empty()))
                    return null;
                else {
                    baseSalary = optionalBaseSalary.get();
                    redisTemplate.opsForValue().set("BaseSalary", baseSalary);
                }
            }
        }
        else {
            Optional<BaseSalary> optionalBaseSalary = baseSalaryRepository.findById(new PrimaryKey(year, month));
            if (optionalBaseSalary.equals(Optional.empty()))
                return null;
            else {
                baseSalary = optionalBaseSalary.get();
            }
        }
        return baseSalary;
    }

    @GetMapping("/admit/saveSalary.action")
    public String saveSalary(String year, String month, BigDecimal base, BigDecimal late, BigDecimal vacation, BigDecimal overtime){
        logger.info("存放salary："+year+" "+month+" "+base+" "+late+" "+vacation);
        BaseSalary baseSalary = new BaseSalary(year,month,base,late,vacation,overtime);
        save(baseSalary);
        return "1";
    }

    public boolean save(BaseSalary baseSalary){
        int cyear = calendar.get(Calendar.YEAR);
        int cmonth = calendar.get(Calendar.MONTH)+1;
        if (cyear == Integer.parseInt(baseSalary.getYear()) && cmonth == Integer.parseInt(baseSalary.getMonth())){
            redisTemplate.opsForValue().set("BaseSalary",baseSalary);
        }
        baseSalaryRepository.save(baseSalary);
        return true;
    }

    @GetMapping("/admit/updateSalary.action")
    public String updateSalary(String year,String month,BigDecimal base,BigDecimal late,BigDecimal vacation,BigDecimal overtime){
        BaseSalary baseSalary = getData(year,month);
        baseSalary.setBase(base);
        baseSalary.setVacation(vacation);
        baseSalary.setLate(late);
        baseSalary.setOvertime(overtime);
        save(baseSalary);
        return "1";
    }

    @GetMapping("/getDataYear")
    public List<BaseSalary> getDataYear(String year){
        List<BaseSalary> baseSalaries;
        baseSalaries = baseSalaryRepository.findAllByYear(year);
        return baseSalaries;
    }

    @GetMapping("/init")
    public void init(String year){
//        int year = calendar.get(Calendar.YEAR);
        BigDecimal defDecimal = new BigDecimal(0);
        BaseSalary baseSalary;
        for (int i=1;i<=12;i++) {
            if (i < 10)
                baseSalary = new BaseSalary(year, "0" + i, defDecimal, defDecimal, defDecimal, defDecimal);
            else
                baseSalary = new BaseSalary(year, "" + i, defDecimal, defDecimal, defDecimal, defDecimal);
            baseSalaryRepository.save(baseSalary);
        }
    }

    @GetMapping("/admit/delRedis.action")
    public String delRedis(){
        if (redisTemplate.hasKey("BaseSalary")) {
            logger.info("删除redis");
            redisTemplate.delete("BaseSalary");
        }
        return "1";
    }

}
