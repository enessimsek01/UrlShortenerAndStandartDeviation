package com.enessimsek;

public class Main {
    public static void main(String[] args) {
        StandartSapmaHesabi standartSapmaHesabi=new StandartSapmaHesabi();
        Thread t1=new Thread(standartSapmaHesabi);
        t1.start();
    }

}
