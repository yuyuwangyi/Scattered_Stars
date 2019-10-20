package com.wy.branch_pattern;

/**
 * Author:wy
 * 2019/10/14
 * Description:主方法
 */


public class MainTest {

    public <E>String get(Pattern<E> pattern){
        return pattern.toStr();
    }


    public static void main(String[] args) {

        Pattern<String> pattern1 = new Pattern<>("123");

        Integer integer = pattern1.getT(1);

        System.out.println(integer);

        System.out.println(pattern1.get("hhh"));

        String str1 = new MainTest().get(new Pattern<String>("234"));

        String str2 = new MainTest().get(new Pattern<Integer>(345));

        System.out.println(str1+":"+str2);

    }

}
