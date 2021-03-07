package jsu.lj.salary.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(PrimaryKey2.class)
public class Salary {
    @Id
    private String year;
    @Id
    private String month;
    @Id
    private String phonenum;
    private short lateNum;
    private short vacNum;
    private short overNum;
//    private BigDecimal otherPay;
//    private String otherInfo;

    public Salary() {
    }

    public Salary(String year, String month, String phonenum, short lateNum, short vacNum, short overNum) {
        this.year = year;
        this.month = month;
        this.phonenum = phonenum;
        this.lateNum = lateNum;
        this.vacNum = vacNum;
        this.overNum = overNum;
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

    public short getLateNum() {
        return lateNum;
    }

    public void setLateNum(short lateNum) {
        this.lateNum = lateNum;
    }

    public short getVacNum() {
        return vacNum;
    }

    public void setVacNum(short vacNum) {
        this.vacNum = vacNum;
    }

    public short getOverNum() {
        return overNum;
    }

    public void setOverNum(short overNum) {
        this.overNum = overNum;
    }

    @Override
    public String toString() {
        return "Salary{" +
                "year='" + year + '\'' +
                ", month='" + month + '\'' +
                ", phonenum='" + phonenum + '\'' +
                ", lateNum=" + lateNum +
                ", vacNum=" + vacNum +
                ", overNum=" + overNum +
                '}';
    }
}
