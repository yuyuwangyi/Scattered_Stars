package com.wy.branch_pattern;

/**
 * Author:wy
 * 2019/10/14
 * Description:范型
 */


public class Pattern<T>  {

    private T t;

    public Pattern(T t){
        this.t = t;
    }

    public Pattern() {

    }

    public <E> E get(E e){
        return e;
    }

    public <T> T getT(T t){
        return t;
    }

    public String toStr(){
        return t.toString();
    }
}
