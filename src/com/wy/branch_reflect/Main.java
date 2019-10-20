package com.wy.branch_reflect;

import java.lang.reflect.Method;
import java.lang.reflect.Type;

/**
 * Author:wy
 * 2019/10/20
 * Description:反射测试主类
 */


public class Main {

    public static void main(String[] args) {
//方法1
        Class test = Student.class;

        Method[] methods = test.getMethods();
        for (Method method : methods) {
            Type[] types = method.getGenericParameterTypes();
            System.out.println("方法名称：" + method.getName());
            for (Type type : types) {
                System.out.println("参数类型：" + type.getTypeName());
            }
        }
//方法2
        Class test2 = null;
        try {
            test2 = Class.forName("com.wy.branch_reflect.Student");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Method[] methods2 = test2.getMethods();
        for (Method method : methods2) {
            Type[] types = method.getGenericParameterTypes();
            System.out.println("方法名称2：" + method.getName());
            for (Type type : types) {
                System.out.println("参数类型2：" + type.getTypeName());
            }
        }
//方法3
        Class test3 = new Student().getClass();

        Method[] methods3 = test3.getMethods();
        for (Method method : methods2) {
            Type[] types = method.getGenericParameterTypes();
            System.out.println("方法名称3：" + method.getName());
            for (Type type : types) {
                System.out.println("参数类型3：" + type.getTypeName());
            }
        }

    }

}
