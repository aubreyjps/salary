package jsu.lj.salary.controller;

import jsu.lj.salary.pojo.PrimaryKey2;
import jsu.lj.salary.pojo.Salary;
import jsu.lj.salary.pojo.UserInfo;
import jsu.lj.salary.repository.SalaryRepository;
import jsu.lj.salary.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@RestController
public class SalaryController {

    @Autowired
    SalaryRepository salaryRepository;

    @Autowired
    UserRepository userRepository;

    Calendar calendar = Calendar.getInstance();
    @GetMapping("/admit/getSalary.action")
    public List<UserInfo> getSalary(){
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH)+1;
        List<Salary> salaries;
        List<UserInfo> userInfos = new ArrayList<>();
        if (month < 10) {
            salaries = salaryRepository.findAllByYearAndMonth(year + "", "0" + month);
        }
        else {
            salaries = salaryRepository.findAllByYearAndMonth(year + "", month + "");
        }
        for(Salary salary:salaries){
            userInfos.add(new UserInfo(salary,userRepository.findNameByPhonenum(salary.getPhonenum())));
        }
        return userInfos;
    }

    @GetMapping("/admit/updateSal.action")
    public String updateSal(Salary salary){
        salaryRepository.save(salary);
        return "1";
    }

    @GetMapping("/user/getSal.action")
    public Salary getSal(String phonenum,String year,String month){
        Optional<Salary> salary = salaryRepository.findById(new PrimaryKey2(year,month,phonenum));
        if (salary.equals(Optional.empty()))
            return null;
        else
            return salary.get();
    }

}
