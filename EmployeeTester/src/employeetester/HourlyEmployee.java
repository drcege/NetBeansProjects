/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeetester;

/**
 *
 * @author root
 */
public class HourlyEmployee extends Employee {

    private double wage;
    private int hours;

    public HourlyEmployee() {
        super();
        this.wage = 0.0d;
        this.hours = 0;
    }

    public HourlyEmployee(double wage, int hours, String firstName, String lastName, String socialSecurityNumber) {
        super(firstName, lastName, socialSecurityNumber);
        this.wage = wage;
        this.hours = hours;
    }

    public double getWage() {
        return wage;
    }

    public int getHours() {
        return hours;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    @Override
    public double earning() {
        return wage * hours;
    }

}
