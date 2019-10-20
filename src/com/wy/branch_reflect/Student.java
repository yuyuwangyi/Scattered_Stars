package com.wy.branch_reflect;

/**
 * Author:wy
 * 2019/10/20
 * Description:反射测试类--学生类
 */


public class Student {

    private Integer id;

    private String stu_name;

    private String stu_gradle;

    private String stu_sex;

    private String stu_age;

    public Student() {
    }

    public Student(Integer id, String stu_name, String stu_gradle, String stu_sex, String stu_age) {
        this.id = id;
        this.stu_name = stu_name;
        this.stu_gradle = stu_gradle;
        this.stu_sex = stu_sex;
        this.stu_age = stu_age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStu_name() {
        return stu_name;
    }

    public void setStu_name(String stu_name) {
        this.stu_name = stu_name;
    }

    public String getStu_gradle() {
        return stu_gradle;
    }

    public void setStu_gradle(String stu_gradle) {
        this.stu_gradle = stu_gradle;
    }

    public String getStu_sex() {
        return stu_sex;
    }

    public void setStu_sex(String stu_sex) {
        this.stu_sex = stu_sex;
    }

    public String getStu_age() {
        return stu_age;
    }

    public void setStu_age(String stu_age) {
        this.stu_age = stu_age;
    }


    public String say(String stu_name){
        return stu_name + "说：我叫" + stu_name;
    }

    private void run(){
        return;
    }

}
