/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeedrive;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author root
 */
public class EmployeeDrive {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Employee[] emp = new Employee[5];
        Scanner in = new Scanner(System.in);

        int mode;    // 输入模式
        do {
            System.out.print("请选择输入方式（0 控制台输入，1 文件输入）：");
            mode = Integer.parseInt(in.nextLine());
        } while (mode != 0 && mode != 1);

        if (0 == mode) {    // 控制台输入
            String name, memberName;
            float weeklySalary, grossSales, commissionRate, wage, hours, baseSalary;
            int i = 0;

            System.out.println("#" + i + " SalaridEmp");
            System.out.print("Name:");
            name = in.nextLine();
            System.out.print("weeklySalary:");
            weeklySalary = Float.parseFloat(in.nextLine());
            System.out.print("memberName:");
            memberName = in.nextLine();
            emp[i++] = new SalaridEmp(name, weeklySalary, memberName);

            System.out.println("#" + i + " CommissionEmp");
            System.out.print("Name:");
            name = in.nextLine();
            System.out.print("grossSales:");
            grossSales = Float.parseFloat(in.nextLine());
            System.out.print("commissionRate:");
            commissionRate = Float.parseFloat(in.nextLine());
            emp[i++] = new CommissionEmp(name, grossSales, commissionRate);

            System.out.println("#" + i + " HourlyEmp");
            System.out.print("Name:");
            name = in.nextLine();
            System.out.print("wage:");
            wage = Float.parseFloat(in.nextLine());
            System.out.print("hours:");
            hours = Float.parseFloat(in.nextLine());
            emp[i++] = new HourlyEmp(name, wage, hours);

            for (int j = 0; j < 2; j++) {
                System.out.println("#" + i + " BasePlusCommissionEmp");
                System.out.print("Name:");
                name = in.nextLine();
                System.out.print("grossSales:");
                grossSales = Float.parseFloat(in.nextLine());
                System.out.print("commissionRate:");
                commissionRate = Float.parseFloat(in.nextLine());
                System.out.print("baseSalary:");
                baseSalary = Float.parseFloat(in.nextLine());
                emp[i++] = new BasePlusCommissionEmp(name, grossSales, commissionRate, baseSalary);
            }
        } else {    // 文件输入
            BufferedReader fin = new BufferedReader(new FileReader("EmpInfo.txt"));
            for (int i = 0; i < 5; ++i) {
                String line = fin.readLine();
                String[] info = line.split(",");
                switch (info[0]) {
                    case "SalaridEmp":
                        emp[i] = new SalaridEmp(info[1], Float.parseFloat(info[2]), info[3]);
                        break;
                    case "HourlyEmp":
                        emp[i] = new HourlyEmp(info[1], Float.parseFloat(info[2]), Float.parseFloat(info[3]));
                        break;
                    case "CommissionEmp":
                        emp[i] = new CommissionEmp(info[1], Float.parseFloat(info[2]), Float.parseFloat(info[3]));
                        break;
                    case "BasePlusCommissionEmp":
                        emp[i] = new BasePlusCommissionEmp(info[1], Float.parseFloat(info[2]), Float.parseFloat(info[3]), Float.parseFloat(info[4]));
                        break;
                    default:
                        System.out.println("File error!");
                        return;
                }
            }
            fin.close();
        }
        BufferedWriter fout = new BufferedWriter(new FileWriter("Salary.txt"));
        fout.write("ID\tName\tSalary");
        fout.newLine();
        for (int i = 0; i < 5; ++i) {
            fout.write(emp[i].getId()+"\t"+emp[i].getName()+"\t$"+((Earning)emp[i]).earning());
            fout.newLine();
        }
        fout.close();
        System.out.println("员工工资单已输出到文件 Salary.txt");
    }
}
