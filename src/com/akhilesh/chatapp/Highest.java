/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.akhilesh.chatapp;

/**
 *
 * @author Akhilesh
 */
public class Highest {
     public static void main(String[] args) {
        int[] nums = {-1,-2,-5};
        int highest = Integer.MIN_VALUE;
        
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > highest){
                highest = nums[i];
            }
        }
        System.out.println(highest);
    }
}
