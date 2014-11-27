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
public class EmployeeTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String[] firstName = {"Adam", "Amy","Bill", "Peter", "Alice", "Chris", "Thor", "Carl", "Jack", "Alex"};
        String[] lastName = {"Smith", "Taylor", "Green", "Jack","Bird", "Sean", "Allen", "Brown", "Jones", "Queen"};
        String[] socialSecurityNumber = {"000", "001", "002", "003", "004", "005", "006", "007", "008", "009"};

        Employee[] employees = new Employee[10];
        for (int i = 0; i < 10; ++i) {
            int random = (int) (Math.random() * 4);
            // 随机产生员工类型，单位工资和工时由函数生成，使得总工资不同但范围接近
            switch (random) {
                case 0:
                    employees[i] = new SalaridEmployee(1000 + 50 * i, firstName[i], lastName[i], socialSecurityNumber[i]);
                    break;
                case 1:
                    employees[i] = new HourlyEmployee(30 + 5 * i, 150, firstName[i], lastName[i], socialSecurityNumber[i]);
                    break;
                case 2:
                    employees[i] = new CommisionEmployee(3000 + 50 * i, 0.5, firstName[i], lastName[i], socialSecurityNumber[i]);
                    break;
                case 3:
                    employees[i] = new BasePlusCommisionEmployee(1000, 1000 + 10 * i, 0.5, firstName[i], lastName[i], socialSecurityNumber[i]);
                    break;
            }
        }
        for (int i = 0; i < 10; ++i) {
            System.out.println(employees[i].toString());
        }
    }
}
