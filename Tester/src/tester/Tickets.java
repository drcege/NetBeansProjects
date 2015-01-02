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
public class Tickets {

    int size;          //总票数
    int remain = 0;    //剩余票数
    int sellID = 0;    //售票序号
    boolean isAdded = false;    //是否已经加票

    public Tickets(int size, int remain) {
        this.size = size;
        this.remain = remain;
    }
}
