/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeedrive;

/**
 *
 * @author root
 */
public class BasePlusCommissionEmp extends CommissionEmp implements Earning{
    float baseSalary;
    
    public BasePlusCommissionEmp(){
        super();
        this.baseSalary = 0.0f;
    }
    public BasePlusCommissionEmp(String name, float grossSales, float commissionRate, float baseSalary){
        super(name, grossSales, commissionRate);
        this.baseSalary = baseSalary;
    }
    
    @Override
    public float earning(){
        return baseSalary+grossSales*commissionRate;
    }
}
