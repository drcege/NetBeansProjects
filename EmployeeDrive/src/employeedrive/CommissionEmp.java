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
public class CommissionEmp extends Employee implements Earning{
    float grossSales, commissionRate;
    
    public CommissionEmp(){
        super();
        this.grossSales = 0.0f;
        this.commissionRate = 0.0f;
    }
    public CommissionEmp(String name, float grossSales, float commissionRate){
        super(name);
        this.grossSales = grossSales;
        this.commissionRate = commissionRate;
    }
    
    @Override
    public float  earning(){
        return grossSales * commissionRate;
    }
}
