package 刷题.剑指offer;

import java.util.*;

/**
 * 题目描述
 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。
 如果不存在则输出0。
 */
public class 数组中出现次数超过一半的数字 {


    public static int MoreThanHalfNum_Solution(int [] array) {

        Map<Integer, Integer> map = new HashMap<>();

        List<Integer> list = new ArrayList<>();
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            if (!map.containsKey(array[i])) {
                map.put(array[i], 1);
                list.add(array[i]);
            } else {
                map.put(array[i], map.get(array[i]) + 1);
            }
        }

        for (int i = 0; i < list.size(); i++) {
            if (array.length / 2 < map.get(list.get(i))) {
                result = list.get(i);
            }
        }
        return result;
    }

/*
 public int MoreThanHalfNum_Solution(int [] array) {
        Arrays.sort(array);
        int count=0;
         
        for(int i=0;i<array.length;i++){
            if(array[i]==array[array.length/2]){
                count++;
            }
        }
        if(count>array.length/2){
            return array[array.length/2];
        }else{
            return 0;
        }
         
    }*/
    public static void main(String[] args) {
        int[] array = {1,2,3,2,2,2,5,4,2};
        MoreThanHalfNum_Solution(array);
    }
}
