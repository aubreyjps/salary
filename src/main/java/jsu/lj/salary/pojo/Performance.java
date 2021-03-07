package jsu.lj.salary.pojo;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Performance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id = 0;
    private String phonenum;
    private String year;
    private String month;
    private String info;
//  状态，0：待审核,1：通过，2：未通过
    private int status;
    private BigDecimal money;

    public Performance() {
    }

    public Performance(String phonenum, String year, String month, String info, int status, BigDecimal money) {
        this.phonenum = phonenum;
        this.year = year;
        this.month = month;
        this.info = info;
        this.status = status;
        this.money = money;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
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

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Performance{" +
                "id=" + id +
                ", phonenum='" + phonenum + '\'' +
                ", year='" + year + '\'' +
                ", month='" + month + '\'' +
                ", info='" + info + '\'' +
                ", status=" + status +
                ", money=" + money +
                '}';
    }
}
