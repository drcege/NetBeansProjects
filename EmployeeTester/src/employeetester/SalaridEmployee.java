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
public class SalaridEmployee extends Employee {

    private double weeklySalary;

    public SalaridEmployee() {
        super();
        this.weeklySalary = 0.0d;
    }

    public SalaridEmployee(double weeklySalary, String firstName, String lastName, String socialSecurityNumber) {
        super(firstName, lastName, socialSecurityNumber);
        this.weeklySalary = weeklySalary;
    }

    public double getWeeklySalary() {
        return weeklySalary;
    }

    public void setWeeklySalary(double weeklySalary) {
        this.weeklySalary = weeklySalary;
    }

    @Override
    public double earning() {
        return weeklySalary * 4;
    }

}
