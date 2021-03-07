package jsu.lj.salary.pojo;

import java.io.Serializable;

public class PrimaryKey2 implements Serializable {
    private String year;
    private String month;
    private String phonenum;

    public PrimaryKey2() {
    }

    public PrimaryKey2(String year, String month, String phonenum) {
        this.year = year;
        this.month = month;
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

    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }

    @Override
    public String toString() {
        return "PrimaryKey2{" +
                "year='" + year + '\'' +
                ", month='" + month + '\'' +
                ", phonenum='" + phonenum + '\'' +
                '}';
    }
}
