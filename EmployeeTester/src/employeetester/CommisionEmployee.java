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
public class CommisionEmployee extends Employee {

    private double grossSales, commissionRate;

    public CommisionEmployee() {
        super();
        this.grossSales = 0.0d;
        this.commissionRate = 0.0d;
    }

    public CommisionEmployee(double grossSales, double commissionRate, String firstName, String lastName, String socialSecurityNumber) {
        super(firstName, lastName, socialSecurityNumber);
        this.grossSales = grossSales;
        this.commissionRate = commissionRate;
    }

    public double getGrossSales() {
        return grossSales;
    }

    public double getCommissionRate() {
        return commissionRate;
    }

    public void setGrossSales(double grossSales) {
        this.grossSales = grossSales;
    }

    public void setCommissionRate(double commissionRate) {
        this.commissionRate = commissionRate;
    }

    @Override
    public double earning() {
        return grossSales * commissionRate;
    }
}
