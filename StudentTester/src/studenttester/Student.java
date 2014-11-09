/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studenttester;

import java.util.Calendar;

/**
 *
 * @author root
 */
public class Student implements Comparable {

    private static int TOTAL_STUDENT_NUMBER = 0;

    private String name;
    private char sex;
    private String clas;
    private int id;
    private int year, month, day;

    public Student() {
        this("", '\u0000', "", 0, 0, 0);
    }

    public Student(String name, char sex, String clas, int year, int month, int day) {
        this.name = name;
        this.sex = sex;
        this.clas = clas;
        this.id = ++TOTAL_STUDENT_NUMBER;
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public String getName() {
        return name;
    }

    public String getClas() {
        return clas;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClas(String clas) {
        this.clas = clas;
    }

    public void setBirth(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int age() {
        Calendar cal = Calendar.getInstance();
        int yearBirth = cal.get(Calendar.YEAR);
        return year - yearBirth;
    }

    @Override
    public String toString() {
        return ("Name:" + name + "  " + "Class:" + clas + "  " + "ID:" + id + "  " + "Date of birth:" + year + "-" + month + "-" + day);
    }

    @Override
    public int compareTo(Object obj) {
        Student stu = (Student) obj;
        if (this.year < stu.year) {
            return 1;
        } else if (this.year > stu.year) {
            return -1;
        } else {
            if (this.month < stu.month) {
                return 1;
            } else if (this.month > stu.month) {
                return -1;
            } else {
                if (this.day < stu.day) {
                    return 1;
                } else if (this.day > stu.day) {
                    return -1;
                } else {
                    return 0;
                }
            }

        }
    }
}
