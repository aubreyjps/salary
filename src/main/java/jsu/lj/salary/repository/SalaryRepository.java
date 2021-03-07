package jsu.lj.salary.repository;

import jsu.lj.salary.pojo.PrimaryKey2;
import jsu.lj.salary.pojo.Salary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SalaryRepository extends JpaRepository<Salary, PrimaryKey2> {

    List<Salary> findAllByYearAndMonth(String year,String month);

    @Override
    Optional<Salary> findById(PrimaryKey2 primaryKey2);

}
