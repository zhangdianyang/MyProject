package com.zdy.testp;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.Currency;
import java.util.Random;

/**
 * @author zdy
 */
public class Selection {

    /**
     * 选择排序
     * @param notSort
     * @return
     */
    public int[] selectionSort(int [] notSort){
        for(int i = 0; i < notSort.length; i++){
            int index = 0;
            int notSortTempTwo = notSort[i];
            for(int j = i; j < notSort.length; j++){
                if(notSort[j] > notSortTempTwo){
                    notSortTempTwo = notSort[j];
                    index = j;
                }
            }
            if(index != 0){
                int temp = notSort[i];
                notSort[i] = notSort[index];
                notSort[index] = temp;
            }
        }
        return notSort;
    }

    /**
     * 插入排序
     * @param notSort
     * @return
     */
    public int[] insertSort(int [] notSort){

        return notSort;
    }



    public static void main(String[] args) {
        Random random = new Random();
        int [] a = new int[1000000];
        for(int i = 0; i < 1000000; i++){
            a[i] = random.nextInt(10);
        }
        Selection selection = new Selection();
        long startTime = System.currentTimeMillis();
        int[] ints = selection.selectionSort(a);
        long endTime = System.currentTimeMillis();
        System.out.println("耗时：" + (endTime - startTime));
    }


}
