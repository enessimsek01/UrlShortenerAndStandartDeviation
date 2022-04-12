package com.enessimsek;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;

public class StandartSapmaHesabi implements Runnable {

    public double standartSapmaHesapla(short[] sayilar, short threadSayisi) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(threadSayisi);
        int length = sayilar.length / threadSayisi;

        List<Long> result = new ArrayList<>();
        for (int i = 0; i < threadSayisi; i++) {
            int low = length * i;
            int high = length + low;

            result.add(executorService.submit(callable(sayilar, low, high)).get());
        }

        for (Long aLong : result) {
            System.out.println(result);
        }

        return 0;
    }

    Callable<Long> callable(short[] arr, int low, int high) {
        return () -> {
            Long result = 0L;
            for (int i = low; i < high; i++) {
                result += arr[i];
            }
            Long avg=result/arr.length;

            List<Double> longList=new ArrayList<>();
            for(int i=0;i<arr.length;i++){
                double pow = Math.pow((avg - arr[i]), 2);
                longList.add(pow);
            }
            double total=0;
            for (Double aDouble : longList) {
                total+=aDouble;
            }
            double v = total / (arr.length - 1);
            double sqrt = Math.sqrt(v);
            System.out.println(sqrt);
            return 0L;
        };
    }


    @Override
    public void run() {

        try {
            Scanner scanner=new Scanner(System.in);
            System.out.println("Enter size of array: ");
            int length=scanner.nextInt();
            short[] sayilar=new short[length];
            System.out.println("Number of Threads: ");
            short threadSayisi=scanner.nextShort();
            System.out.println("Enter elements of array: ");
            for(int i=0;i<length;i++){
                sayilar[i]=scanner.nextShort();
            }
            standartSapmaHesapla(sayilar,threadSayisi);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
