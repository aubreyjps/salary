package jsu.lj.salary.repository;

import jsu.lj.salary.pojo.Performance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PerformanceRepository extends JpaRepository<Performance, Integer> {

    List<Performance> findAllByPhonenumAndYearAndMonth(String phonenum,String year,String month);

    List<Performance> findAllByStatus(int status);
}
