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
public class SalaridEmp extends Employee implements Earning{
    float weeklySalary;
    private String memberName;
    
    public SalaridEmp(){
        super();
        this.weeklySalary = 0.0f;
        this.memberName = "";
    }
    public SalaridEmp(String name, float weeklySalary, String memberName){
        super(name);
        this.weeklySalary = weeklySalary;
        this.memberName = memberName;
    }
    
    @Override
    public float earning() {
        return weeklySalary * 4;
    }
}
