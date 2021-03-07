package jsu.lj.salary.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    private String phonenum;
    private String name;
    private String password;
    private boolean sex;
    private String email;
    private String qq;
    private String image;
    private boolean isAdmit;

    public User(String phonenum, String name, String password, boolean sex, String email, String qq, String image, boolean isAdmit) {
        this.phonenum = phonenum;
        this.name = name;
        this.password = password;
        this.sex = sex;
        this.email = email;
        this.qq = qq;
        this.image = image;
        this.isAdmit = isAdmit;
    }

    public User(String phonenum, String name, String password, boolean sex) {
        this.phonenum = phonenum;
        this.name = name;
        this.password = password;
        this.sex = sex;
        this.email = "123123123@qq.com";
        this.qq = "123123123";
        this.image = "images/user.png";
        this.isAdmit = false;
    }

    public User() {
    }

    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isAdmit() {
        return isAdmit;
    }

    public void setAdmit(boolean admit) {
        isAdmit = admit;
    }

    @Override
    public String toString() {
        return "User{" +
                "phonenum='" + phonenum + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", sex=" + sex +
                ", email='" + email + '\'' +
                ", qq='" + qq + '\'' +
                ", image='" + image + '\'' +
                ", isAdmit=" + isAdmit +
                '}';
    }
}