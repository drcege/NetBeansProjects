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
public class HourlyEmp extends Employee implements Earning{
    float wage, hours;
    
    public HourlyEmp(){
        super();
        this.wage = 0.0f;
        this.hours = 0.0f;
    }
    public HourlyEmp(String name, float wage, float hours){
        super(name);
        this.wage = wage;
        this.hours = hours;
    }

    @Override
    public float earning(){
        return wage * hours;
    }
}
