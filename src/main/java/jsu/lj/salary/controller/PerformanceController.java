package jsu.lj.salary.controller;

import jsu.lj.salary.pojo.Performance;
import jsu.lj.salary.pojo.PerformanceInfo;
import jsu.lj.salary.repository.PerformanceRepository;
import jsu.lj.salary.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
public class PerformanceController {

    @Autowired
    PerformanceRepository performanceRepository;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/user/getPerformance.action")
    public List<Performance> getData(String phonenum,String year,String month){
        List<Performance> performances = performanceRepository.findAllByPhonenumAndYearAndMonth(phonenum,year,month);
        return performances;
    }

    @GetMapping("/user/setPerformance.action")
    public String setData(String phonenum, String year, String month, String info, BigDecimal money){
        Performance performance = new Performance(phonenum,year,month,info,0,money);
        performanceRepository.save(performance);
        return "1";
    }

    @GetMapping("/admit/getPerAndName.action")
    public List<PerformanceInfo> getPAN(){
        List<Performance> performances = performanceRepository.findAllByStatus(0);
        List<PerformanceInfo> performanceInfos = new ArrayList<>();
        for (Performance performance:performances){
            performanceInfos.add(new PerformanceInfo(performance,userRepository.findNameByPhonenum(performance.getPhonenum())));
        }
        return performanceInfos;
    }

    @GetMapping("/admit/updatePer.action")
    public String update(int id,int status){
        Optional<Performance> performance = performanceRepository.findById(id);
        if (performance.equals(Optional.empty()))
            return "0";
        else {
            Performance performance1 = performance.get();
            performance1.setStatus(status);
            performanceRepository.save(performance1);
            return "1";
        }

    }
}
