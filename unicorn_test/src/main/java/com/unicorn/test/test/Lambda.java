package com.unicorn.test.test;

/**
 * @Author:wangsusheng
 * @Date: 2019/12/2 15:00
 */
public class Lambda {

  // Runnable runnable =()-> System.out.println("hello");

    public static void main(String[] args) {
        int num=0;
        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                System.out.println(num);
            }
        };

    }
}
