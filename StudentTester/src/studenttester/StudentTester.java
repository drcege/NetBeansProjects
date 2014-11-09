/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studenttester;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author root
 */
public class StudentTester {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     * @throws studenttester.SexException
     * @throws studenttester.DateException
     */
    public static void main(String[] args) throws IOException, SexException, DateException {
        // TODO code application logic here
        int stuNum = 0;
        char sex = 0;
        String name, clas;
        int year = 0, month = 0, day = 0;
        boolean isValidNum, isValidSex, isValidDate;
        Scanner in = new Scanner(System.in);

        isValidNum = false;
        do {
            String stuString;
            do {
                System.out.print("Please enter the number of students:");
                stuString = in.nextLine();
            } while (stuString.isEmpty());
            try {
                stuNum = Integer.parseInt(stuString);
                isValidNum = true;
            } catch (Exception e) {
            }
        } while (!isValidNum);
        Student[] stu = new Student[stuNum];

        for (int i = 0; i < stuNum; ++i) {
            isValidSex = isValidDate = false;
            System.out.println();
            System.out.println("Student #" + (i + 1));
            do {
                System.out.print("Name:");
                name = in.nextLine();
            } while (name.isEmpty());

            do {
                String sexString;
                do {
                    System.out.print("Sex:");
                    sexString = in.nextLine();
                } while (sexString.isEmpty());
                try {
                    sex = checkSex(sexString);
                    isValidSex = true;
                } catch (SexException e) {
                }
            } while (!isValidSex);

            do {
                System.out.print("Class:");
                clas = in.nextLine();
            } while (clas.isEmpty());

            do {
                String dateString;
                do {
                    System.out.print("Date of birth(yyyy-mm-dd):");
                    dateString = in.nextLine();
                } while (dateString.isEmpty());
                try {
                    int[] date = checkDate(dateString);
                    isValidDate = true;
                    year = date[0];
                    month = date[1];
                    day = date[2];
                } catch (DateException e) {
                }
            } while (!isValidDate);

            stu[i] = new Student(name, sex, clas, year, month, day);
        }
        System.out.println();
        System.out.println("Unsorted:");
        for (int i = 0; i < stuNum; ++i) {
            System.out.println(stu[i].toString());
        }
        Arrays.sort(stu);
        System.out.println("Sorted:");
        for (int i = 0; i < stuNum; ++i) {
            System.out.println(stu[i].toString());
        }
    }

    /**
     *
     * @param sexString
     * @return
     * @throws SexException
     */
    public static char checkSex(String sexString) throws SexException {
        if ("M".equals(sexString) || "F".equals(sexString)) {
            return sexString.charAt(0);
        } else {
            throw new SexException();
        }
    }

    /**
     *
     * @param dateString
     * @return
     * @throws DateException
     */
    public static int[] checkDate(String dateString) throws DateException {
        String str[] = dateString.split("-");
        if (str.length != 3) {
            throw new DateException();
        }
        int[] array = new int[str.length];
        try {
            for (int i = 0; i < str.length; ++i) {
                array[i] = Integer.parseInt(str[i]);
            }
        } catch (NumberFormatException e) {
            throw new DateException();
        }

        // 年份判断
        if (array[0] < 0) {
            throw new DateException();
        }
        // 月份判断
        if (array[1] < 1 || array[1] > 12) {
            throw new DateException();
        }
        // 天数判断
        if (array[1] == 2) {
            if ((array[0] % 4 == 0 && array[0] % 100 != 0) || (array[0] % 400 == 0)) {
                if (array[2] < 1 || array[2] > 29) {
                    throw new DateException();
                }
            } else {
                if (array[2] < 1 || array[2] > 28) {
                    throw new DateException();
                }
            }
        } else if (array[1] == 4 || array[1] == 6 || array[1] == 9 || array[1] == 11) {
            if (array[2] < 1 || array[2] > 30) {
                throw new DateException();
            }
        } else {
            if (array[2] < 1 || array[2] > 31) {
                throw new DateException();
            }
        }
        return array;
    }
}
