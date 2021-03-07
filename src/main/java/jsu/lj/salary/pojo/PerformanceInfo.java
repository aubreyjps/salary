package jsu.lj.salary.pojo;

public class PerformanceInfo {
    private Performance performance;
    private String name;

    public PerformanceInfo() {
    }

    public PerformanceInfo(Performance performance, String name) {
        this.performance = performance;
        this.name = name;
    }

    public Performance getPerformance() {
        return performance;
    }

    public void setPerformance(Performance performance) {
        this.performance = performance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "PerformanceInfo{" +
                "performance=" + performance +
                ", name='" + name + '\'' +
                '}';
    }
}
