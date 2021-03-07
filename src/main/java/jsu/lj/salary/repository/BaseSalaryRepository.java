package jsu.lj.salary.repository;

import jsu.lj.salary.pojo.BaseSalary;
import jsu.lj.salary.pojo.PrimaryKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BaseSalaryRepository extends JpaRepository<BaseSalary, PrimaryKey> {
    @Override
    Optional<BaseSalary> findById(PrimaryKey primaryKey);

    List<BaseSalary> findAllByYear(String year);

}
