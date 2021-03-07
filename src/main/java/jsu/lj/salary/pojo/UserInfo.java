package jsu.lj.salary.pojo;

public class UserInfo {
    private Salary salary;
    private String name;

    public UserInfo() {
    }

    public UserInfo(Salary salary, String name) {
        this.salary = salary;
        this.name = name;
    }

    public Salary getSalary() {
        return salary;
    }

    public void setSalary(Salary salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "salary=" + salary +
                ", name='" + name + '\'' +
                '}';
    }
}
