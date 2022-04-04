package com.yixihan.test.test01;

/**
 * @author : yixihan
 * @create : 2022-04-04-13:36
 */
public class Manager extends Employee{

    String name = "manager";

    public void getName2 () {
        System.out.println ("this.name " + name);
        System.out.println ("super.name " +  super.name);
    }
}
