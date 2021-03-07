package jsu.lj.salary.pojo;

import java.io.Serializable;

public class PrimaryKey implements Serializable {

        private String year;

        private String month;

        public PrimaryKey(String year, String month) {
                this.year = year;
                this.month = month;
        }

        @Override
        public String toString() {
                return "PrimaryKey{" +
                        "year='" + year + '\'' +
                        ", month='" + month + '\'' +
                        '}';
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

        public PrimaryKey() {
        }
}
