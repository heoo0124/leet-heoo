package com.leetheoo.hard;

/**
 * <pre>
 *  file:com.leeheoo.hard.Candy
 *  Copyright (c) 2022, eccang.com All Rights Reserved.
 *
 *  Description: 07
 *  ${TODO}
 *  https://leetcode.cn/problems/candy/?plan=zhitongche&plan_progress=zl0rswe
 *  Revision History
 *  Date,                  Who,                        What;
 *  2022/9/6 18:21        @author yangtaiwei          Initial.
 *
 * </pre>
 */
public class Candy
{
    public static void main(String[] args) {
        System.out.println(new Candy().candyPro(new int[]{3,1,2}));
    }

    private int candyPro(int[] ratings) {
        int n = ratings.length;
        int ret = 1;
        int inc = 1, dec = 0, pre = 1;
        for (int i = 1; i < n; i++) {
            if (ratings[i] >= ratings[i - 1]) {
                dec = 0;
                pre = ratings[i] == ratings[i - 1] ? 1 : pre + 1;
                ret += pre;
                inc = pre;
            } else {
                dec++;
                if (dec == inc) {
                    dec++;
                }
                ret += dec;
                pre = 1;
            }
        }
        return ret;
    }


    private int candy(int[] ratings)
    {
        int sum = 0;
        int[] candy = new int[ratings.length];
        shellSort(ratings, ratings.length);
        for (int i = 0; i < ratings.length; i++)
        {
            if(i==0){
                candy[i]=1;
            }else{
                if(ratings[i] == ratings[i-1])
                {
                    candy[i] = candy[i-1];
                }else {
                    candy[i] = candy[i-1]+1;
                }
            }
            sum+=candy[i];
        }
        /*int idddle = 1;
        int res = 0;
        int[] candy = new int[ratings.length];
        if(isOrder(ratings)){
            for (int i = 0; i < ratings.length; i++) {
                candy[i] = i;
            }
        }
        for (int i = 0; i < ratings.length; i++) {
            if(ratings.length == 1){
                return 1;
            }else if(i < ratings.length -1) {
                int div = ratings[i]-ratings[i+1];
                if(div > 0){
                    if(candy[i] == 0){
                        candy[i+1] +=1;
                        candy[i] = candy[i+1] + 1;
                    }else if(candy[i] > 0) {
                        candy[i+1] = candy[i];
                    }
                }else if (div == 0){
                    if(candy[i] == 0){
                        candy[i] +=1;
                        candy[i+1] = candy[i];
                    }else if(candy[i] > 0) {
                        candy[i+1] = candy[i];
                    }
                }else {
                    if(candy[i] == 0){
                        candy[i] +=1;
                        candy[i+1] = candy[i];
                    }else if(candy[i] > 0) {
                        candy[i+1] = candy[i];
                    }
                }
            } else {
                if(ratings[i]-ratings[i-1] > 0){
                    candy[i] =candy[i-1] +1;
                }else if (ratings[i]-ratings[i-1] == 0){
                    candy[i] =candy[i-1];
                } else {
                    candy[i] +=1;
                }
            }
        }*/
        for (int i : candy) {
            System.out.println(i);
        }
        return sum;
    }

    public void shellSort(int[] array,int length){

        int temp = 0;
        int incre = length;

        while(true){
            incre = incre/2;
            //根据增量分为若干子序列
            for(int k = 0;k<incre;k++){

                for(int i=k+incre;i<length;i+=incre){

                    for(int j=i;j>k;j-=incre){
                        if(array[j]<array[j-incre]){
                            temp = array[j-incre];
                            array[j-incre] = array[j];
                            array[j] = temp;
                        }else{
                            break;
                        }
                    }
                }
            }

            if(incre == 1){
                break;
            }
        }
    }

    private boolean isOrder(int[] ratings){
        for(int i=0;i < ratings.length-1;i++) {
            if(ratings[i] > ratings[i+1]) {
                return false;
            }
        }

        for(int i = ratings.length-1; i > 0; i--) {
            if(ratings[i] > ratings[i-1]) {
                return false;
            }
        }
        return true;
    }
}
