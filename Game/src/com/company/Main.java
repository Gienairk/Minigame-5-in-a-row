package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        rule();
	    Map map=new Map();
        map.zapGoa();
        map.stouneGeneration();
        map.testerzap();
        map.shovMap();
        Scanner in = new Scanner(System.in);
        boolean wePlay=true;
        boolean wrongData=true;
        while (wePlay){
            int x1=0,x2=0,y1=0,y2=0;
            String input = "a";
            System.out.print("введите координаты камня: ");
            wrongData=true;
            while (wrongData){
                try {
                    input = in.next();
                    x1 = Integer.parseInt(input);
                    input = in.next();
                    y1 = Integer.parseInt(input);
                    wrongData= false;
                }catch (Exception e){}
            }

            System.out.print("введите координаты свободной ячейки: ");
            wrongData=true;
            while (wrongData){
                try {
                    input = in.next();
                    x2 = Integer.parseInt(input);
                    input = in.next();
                    y2 = Integer.parseInt(input);
                    wrongData= false;
                }catch (Exception e){}
            }

            map.swapPosition(x1-1,y1-1,x2-1,y2-1);
            wePlay=map.nextTurn();
            map.shovMap();
        }
            System.out.println("Поздравляю вы выиграли");
    }

    public static void rule(){
        System.out.printf("Миниигра ряды %n Цель игры состоит в том, что бы составить ряды из нужных цифр в %n " +
                "нужных столбцах цифрами обозначаются камни и их тип %n X обозначенны закрытые поля, - пустые ячейки %n" +
                " передвигать камни можно только на пустые ячейки, причем только по вертикали и горизонтали %n координаты считаются сверху вниз и слева" +
                "на право, от 1, то есть нижняя правая ячейка имеет координаты 5 5 %n при выигрышной комбинации игра закончится%n");

    }
}
