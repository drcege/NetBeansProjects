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
public class BasePlusCommisionEmployee extends CommisionEmployee {

    private double baseSalary;

    public BasePlusCommisionEmployee() {
        super();
        this.baseSalary = 0.0d;
    }

    public BasePlusCommisionEmployee(double baseSalary, double grossSales, double commissionRate, String firstName, String lastName, String socialSecurityNumber) {
        super(grossSales, commissionRate, firstName, lastName, socialSecurityNumber);
        this.baseSalary = baseSalary;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    @Override
    public double earning() {
        return baseSalary + getGrossSales() * getCommissionRate();
    }
}
