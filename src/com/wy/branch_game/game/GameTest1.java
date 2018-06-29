package com.wy.branch_game.game;

import java.util.Random;
import java.util.Scanner;

public class GameTest1 {
    public static int input(int start,int end){
        System.out.println("请输入从"+start+"到"+end+"的一个数");
        Scanner scanner=new Scanner(System.in);
        int a=scanner.nextInt();
        while (true) {

            if(a<start||a>end){
                System.out.println("输入错误！请重新输入！");
                a=scanner.nextInt();
            }else {
                break;
            }
        }
        return a;
    }
    public static int random(){
        Random random=new Random();
        return random.nextInt(100);
    }
    public static void compare() {
        int count=0;
        int start=0;
        int end=100;
        int random = random();
        int input = input(start, end);
        while (true) {

            if(input>random){
                end=input;
                count++;
            }
            if(input==random){
                if(count<=3){
                    System.out.println("正确！");
                    break;
                }
            }
            if(input<random){
                start=input;
                count++;
            }

            if(count>3){
                System.out.println("GameOver!");
                break;
            }
            input=input(start,end);
        }
        System.out.println("游戏结束！！！");
    }
}
