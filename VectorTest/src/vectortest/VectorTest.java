/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vectortest;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Scanner;

/**
 * 第四次作业
 * @author root
 */
public class VectorTest {

    private static Hashtable students;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in = new Scanner(System.in);
        students = new Hashtable();
        // 临时变量
        int choice;
        String stuID;

        do {
            // 输入操作选项
            do {
                System.out.println();
                System.out.println("0-exit 1-init 2-search 3-update 4-delete 5-printAll") ;
                System.out.print("Please input an integer:");
                try {
                    choice = Integer.parseInt(in.nextLine());
                    if (choice >= 0 && choice <= 5) {
                        break;
                    }
                } catch (Exception e) {
                }
            } while (true);
            // 操作处理
            switch (choice) {
                case 0:    // 退出
                    return;
                case 1:    // 初始化
                    initStudents();
                    break;
                case 2:    // 查询
                    System.out.print("ID:");
                    stuID = in.nextLine();
                    Student stuSearch = getStudent(stuID);
                    if (stuSearch == null) {
                        System.out.println("The student does not exist！");
                    } else {
                        System.out.println(stuSearch);
                    }
                    break;
                case 3:    // 更新
                    System.out.print("ID:");
                    stuID = in.nextLine();
                    if (getStudent(stuID) == null) {
                        System.out.println("The student does not exist！");
                    } else {
                        Student stuUpdate = inputStudent(stuID);
                        updateStudent(stuID, stuUpdate);
                    }
                    break;
                case 4:    // 删除
                    System.out.print("ID:");
                    stuID = in.nextLine();
                    if(deleteStudent(stuID) == null){
                        System.out.println("The student does not exit!");
                    } else {
                        System.out.println("The student was deleted successfully.");
                    }
                    break;
                case 5:    // 全部输出
                    printVector();
                    break;
                default:    // 跳过
                    break;
            }
        } while (true);
    }

    /**
     * 初始化，从键盘读取若干学生的信息。
     */
    public static void initStudents() {
        String id;
        Scanner in = new Scanner(System.in);

        do {
            System.out.print("ID:");
            id = in.nextLine();
        } while (id.isEmpty());
        while (!id.equals("0000")) {
            // 从键盘读取一个学生的信息
            addStudent(inputStudent(id));
            do {
                System.out.print("ID:");
                id = in.nextLine();
            } while (id.isEmpty());
        }
    }

    /**
     * 查找并返回学号为stuID的学生。
     * 若未找到该学生，返回null。
     * @param stuID
     * @return Student
     */
    public static Student getStudent(String stuID) {
        if (stuID.isEmpty()) {
            return null;
        }
        return (Student) students.get(stuID);
    }

    /**
     * 删除学号为stuID的学生，并返回该学生对象的引用。
     * 若未找到该学生，返回null。
     * @param stuID
     * @return Student
     */
    public static Student deleteStudent(String stuID) {
        if (stuID.isEmpty()) {
            return null;
        }
        return (Student) students.remove(stuID);
    }

    /**
     * 添加参数定义的学生对象到学生集合。
     * @param stu
     */
    public static void addStudent(Student stu) {
        students.put(stu.getId(), stu);
    }

    /**
     * 更新学生集合中学号为stuID的学生对象信息，更新后的信息为stu.
     * @param stuID
     * @param stu
     */
    public static void updateStudent(String stuID, Student stu) {
        if (stuID.isEmpty()) {
            return;
        }
        students.put(stuID, stu);
    }

    /**
     * 输出每一个学生的信息。
     */
    public static void printVector() {
        Enumeration stu = students.elements();
        while (stu.hasMoreElements()) {
            System.out.println(stu.nextElement());
        }
    }

    /**
     * 从键盘读取一个指定学号的学生的信息，并返回该学生对象。
     *
     * @param stuID
     * @return Student
     */
    public static Student inputStudent(String stuID) {
        String name, clas;
        char sex;
        int year, month, day;
        Scanner in = new Scanner(System.in);

        do {
            System.out.print("Name:");
            name = in.nextLine();
        } while (name.isEmpty());
        do {
            System.out.print("Sex:");
            try {
                sex = checkSex(in.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Sex value is invalid, it should be M or F!");
            }
        } while (true);
        do {
            System.out.print("Class:");
            clas = in.nextLine();
        } while (clas.isEmpty());
        do {
            System.out.print("Birthday(yyyy-mm-dd):");
            try {
                int[] birth = checkDate(in.nextLine());
                year = birth[0];
                month = birth[1];
                day = birth[2];
                break;
            } catch (Exception e) {
                System.out.println("Birthday value is invalid!");
            }
        } while (true);
        return new Student(stuID, name, sex, clas, year, month, day);
    }

    /**
     * 检测输入字符串是否为合法性别。 若为"M"或"F"则转化为相应的字符，否则抛出异常。
     *
     * @param sexString
     * @return char
     * @throws Exception
     */
    public static char checkSex(String sexString) throws Exception {
        if ("M".equals(sexString) || "F".equals(sexString)) {
            return sexString.charAt(0);
        } else {
            throw new Exception();
        }
    }

    /**
     * 检测输入字符串是否为合法出生日期。 若为"yyyy-mm-dd"格式且日期合法，将年月日分割后返回，否则抛出异常。
     *
     * @param dateString
     * @return int[]
     * @throws Exception
     */
    public static int[] checkDate(String dateString) throws Exception {
        String str[] = dateString.split("-");
        if (str.length != 3) {
            throw new Exception();
        }
        int[] array = new int[str.length];
        for (int i = 0; i < str.length; ++i) {
            array[i] = Integer.parseInt(str[i]);
        }

        // 年份判断
        if (array[0] < 0) {
            throw new Exception();
        }
        // 月份判断
        if (array[1] < 1 || array[1] > 12) {
            throw new Exception();
        }
        // 天数判断
        if (array[1] == 2) {
            if ((array[0] % 4 == 0 && array[0] % 100 != 0) || (array[0] % 400 == 0)) {
                if (array[2] < 1 || array[2] > 29) {
                    throw new Exception();
                }
            } else {
                if (array[2] < 1 || array[2] > 28) {
                    throw new Exception();
                }
            }
        } else if (array[1] == 4 || array[1] == 6 || array[1] == 9 || array[1] == 11) {
            if (array[2] < 1 || array[2] > 30) {
                throw new Exception();
            }
        } else {
            if (array[2] < 1 || array[2] > 31) {
                throw new Exception();
            }
        }
        return array;
    }
}
