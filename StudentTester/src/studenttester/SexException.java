/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studenttester;

/**
 *
 * @author root
 */
public class SexException extends Exception {

    public SexException() {
        System.out.println("Sex value is invalid, it should be M or F!");
    }
}
