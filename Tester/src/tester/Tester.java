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
public class Tester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Tickets t = new Tickets(100, 50);
        Windows w0 = new Windows(t, "windows-0");
        Windows w1 = new Windows(t, "windows-1");
        Windows w2 = new Windows(t, "windows-2");
        w0.start();
        w1.start();
        w2.start();

        for (int customer = 1; customer <= 100; ++customer) {
            switch ((int) (Math.random() * 3)) {
                case 0:
                    w0.addCustomer();
                    break;
                case 1:
                    w1.addCustomer();
                    break;
                case 2:
                    w2.addCustomer();
                    break;
                default:
                    break;
            }
        }
    }
}
