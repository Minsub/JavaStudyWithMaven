package com.minsub.althorism.google;




/**
 * 정렬된 k개의 리스트가 있다.
k개의 리스트 중 적어도 한개의 숫자를 포함하는 구간 간격이 가장 작은 숫자의 범위를 구하시오.

예:
List 1: [4, 10, 15, 24, 26] 
List 2: [0, 9, 12, 20] 
List 3: [5, 18, 22, 30] 

위 예에서 구간 간격이 가장 작은 숫자의 범위는 [20, 24] 이다. 
[20, 24]의 구간 간격은 4이다. 이 범위는 List 1에서는 24, 
List 2는 20, List 3에서는 22를 포함한다.
 * @author Minsub Ji
 *
 */
public class Google1 {
    public static void main(String[] args) {
       //generate test code
       int[] list1 = {4, 10, 15, 24, 26};
       int[] list2 = {0, 9, 12, 20};
       int[] list3 = {5, 18, 22, 30};
      
        
        // begin althorism
        int nIdx1=0, nIdx2=0, nIdx3=0;
        int i1=0, i2=0, i3=0;
        int tmp = Integer.MAX_VALUE;

        for (int i = 0; i < list1.length + list2.length + list3.length; i++) { 
            int min = Math.min(list1[i1], Math.min(list2[i2], list3[i3]));
            int max = Math.max(list1[i1], Math.max(list2[i2], list3[i3]));
            
            if(max-min < tmp) {
                tmp = max-min;
                nIdx1=i1; nIdx2=i2; nIdx3=i3;
            }
            
            if (list1.length - 1 == i1 && list2.length -1 == i2) {
                i3++;
                continue;
            } else if (list2.length - 1 == i2 && list3.length -1 == i3) {
                i1++;
                continue;
            } else if (list1.length - 1 == i1 && list3.length -1 == i3) {
                i2++;
                continue;
            }
            
            
            if (min == list1[i1] && list1.length -1 != i1) { 
               i1++;
            } else if (min == list2[i2] && list2.length -1 != i2) { 
                i2++;
            } else if (min == list3[i3] && list3.length -1 != i3) { 
                i3++;
            }
        }
        
        // confirm
        System.out.println("List1: " + list1[nIdx1]);
        System.out.println("List2: " + list2[nIdx2]);
        System.out.println("List3: " + list3[nIdx3]);
        
    }
    
}
