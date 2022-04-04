package com.yixihan.test.test01;

/**
 * @author : yixihan
 * @create : 2022-04-04-13:37
 */
public class Main {

    public static void main(String[] args) {
        Employee w1 = new Manager ();
//        Manager w2 = (Manager) w1;
        System.out.println (w1.getClass ());
        Manager w2 = null;

        if (w1 instanceof Manager) {
            w2 = (Manager) w1;
        }
        System.out.println (w2.getClass ());

        Employee w3 = new Employee ();

        if (w3 instanceof Manager) {
            w2 = (Manager) w3;
        }

//        System.out.println (w1.name);
//        w1.getName1 ();
//        System.out.println ("============");
//        System.out.println (w2.name);
//        w2.getName2 ();
    }
}
