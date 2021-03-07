package jsu.lj.salary.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.math.BigDecimal;

@Entity
@IdClass(PrimaryKey.class)
public class BaseSalary {
    @Id
    private String year;
    @Id
    private String month;
    private BigDecimal base;
    private BigDecimal late;
    private BigDecimal vacation;
    private BigDecimal overtime;

    public BaseSalary(String year, String month, BigDecimal base, BigDecimal late, BigDecimal vacation, BigDecimal overtime) {
        this.year = year;
        this.month = month;
        this.base = base;
        this.late = late;
        this.vacation = vacation;
        this.overtime = overtime;
    }

    public BaseSalary() {
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public BigDecimal getBase() {
        return base;
    }

    public void setBase(BigDecimal base) {
        this.base = base;
    }

    public BigDecimal getLate() {
        return late;
    }

    public void setLate(BigDecimal late) {
        this.late = late;
    }

    public BigDecimal getVacation() {
        return vacation;
    }

    public void setVacation(BigDecimal vacation) {
        this.vacation = vacation;
    }

    public BigDecimal getOvertime() {
        return overtime;
    }

    public void setOvertime(BigDecimal overtime) {
        this.overtime = overtime;
    }

    @Override
    public String toString() {
        return "BaseSalary{" +
                "year='" + year + '\'' +
                ", month='" + month + '\'' +
                ", base=" + base +
                ", late=" + late +
                ", vacation=" + vacation +
                ", overtime=" + overtime +
                '}';
    }
}
