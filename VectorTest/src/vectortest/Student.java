/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vectortest;

import java.util.Calendar;

/**
 * 学生类
 * @author root
 */
public class Student {

    private String id;
    private String name;
    private char sex;
    private String clas;
    private int year, month, day;

    public Student() {
        this("", "", '\u0000', "", 0, 0, 0);
    }

    public Student(String id, String name, char sex, String clas, int year, int month, int day) {
        this.id = id;
            this.name = name;
        this.sex = sex;
        this.clas = clas;
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public String getId() {
        return id;
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

    public void setId(String id) {
        this.id = id;
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
        return ("ID:" + id + ", Name:" + name + ", Sex:" + sex + ", Class:" + clas + ", Birthday:" + year + "-" + month + "-" + day);
    }
}
