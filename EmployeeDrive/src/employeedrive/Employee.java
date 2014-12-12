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
public class Employee {
    static int EMP_ID = 0;
    int id;
    String name;
    
    public Employee(){
        this("");
    }
    public Employee(String name){
        this.id = EMP_ID++;
        this.name = name;
    }
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
}
