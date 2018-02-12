/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.akhilesh.chatapp;

import java.math.BigDecimal;

/**
 *
 * @author Akhilesh
 */
public class TestClass {

    public static void main(String[] args) {
        A a = new A();
        a.display();
        
    }

}

class A {

    static int num;

    static {
        System.out.println("Static block");
    }
    void display(){
        System.out.println("Akhilesh");
    }
}
