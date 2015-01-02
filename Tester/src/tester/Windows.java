/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tester;

/**
 *
 * @author root
 */
public class Windows extends Thread {

    Tickets t = null;
    int customerNum = 0;    //顾客数量
    int restTime = 0;       //休息时间
    int restCnt;            //休息次数

    public Windows(Tickets t, String name) {
        super(name);
        this.t = t;
        restTime = (int) (Math.random() * 10) + 1;
    }

    public void addCustomer() {
        ++customerNum;    //新增购票顾客
    }

    @Override
    public void run() {
        while (t.sellID < t.size) {    // 当前已售票号小于总票数
            if (customerNum > 0) {     // 有等待用户
                synchronized (t) {
                    if (!t.isAdded && t.remain == 10) {    // 只有第一次少于10可以加票
                        t.remain += 50;
                        t.isAdded = true;
                        System.out.println("---- (*^_^*)  Added other 50 tickets, " + t.remain + " tickets remained ----");
                    }
                    if (t.remain > 0) {    // 有剩余票，卖给顾客
                        ++t.sellID;
                        --t.remain;
                        --customerNum;
                        System.out.println(currentThread().getName() + " sold ticket #" + t.sellID + ", " + t.remain + " tickets remained");
                    }
                }
            }
            // 随机概率休息，暂定十分之一；若票数不足10张时休息次数不够，强制休息
            if ((int) (Math.random() * 10) == 1 || (restCnt < 2 && t.remain < 10)) {
                System.out.println(currentThread().getName() + " is going to leave " + restTime + " ms");
                try {
                    Thread.sleep(restTime);
                } catch (InterruptedException ex) {
                }
                System.out.println(currentThread().getName() + " is back");
                ++restCnt;
            }
        }
        System.out.println(currentThread().getName() + " closed");
    }
}
