package com.minsub.althorism;

import java.util.Scanner;

public class Symmetry2 {
		long m10(int m){ // 함수m10 : 10의 input승 구하기
	        long result=1;
	        for(int i=0;i<m;i++) result*=10;
	        return result;
	    }
	    long back(long input){ // 함수 back : 숫자를 거꾸로
	    	Symmetry2 h=new Symmetry2();
	        long result=0; 
	        int l=0; //l:length 자릿수. 일단 자릿수(l)을 구한다
	        for(long m=1; input/m!=0 ; m*=10) l++;
	        if(input==0) l=1;
	        for(int i=0; i<l; i++) result+=((input/h.m10(i))%10)*h.m10(l-1-i);
	        return result;
	    }
	    public static void main(String[] args) {
	    	Symmetry2 h=new Symmetry2();
	        Scanner num=new Scanner(System.in);
	        int n, i, j, l=1, lh=1, n9=0; //l:length 자릿수, lh:length_half
	        long half=0;
	        boolean check_odd=true; //자릿수가 홀수개인지 아닌지 여부
	        n=29;
	        long[] arr=new long[n];
	        for(i=0;i<n;i++){
	            if(check_odd){ //자릿수가 홀수개이면 : half를 마지막숫자를 제외하고 거울처럼 반복
	                arr[i]=half*h.m10(lh-1);
	                arr[i]+=h.back(half/10);
	                half++;
	            }
	            else{ // 자릿수가 짝수개이면 : half를 거울처럼 반복
	                arr[i]=half*h.m10(lh);
	                arr[i]+=h.back(half);
	                half++;
			}
			// 숫자가 9로만 이루어진 수일 경우,
			for (n9 = 0, j = 0;
					j < lh && (half / h.m10(j)) % 10 == 9;
					j++)
				n9++;
			
			if (n9 == lh) { // : 일단 arr[++i]에 대입한 후, 자릿수 하나 늘리고 half 재설정
				
				arr[++i] = (check_odd) ? half * h.m10(lh - 1) + (half / 10) : half * h.m10(lh) + half;
				
				check_odd = (!check_odd);
				l++;
				
				if (check_odd)
					lh++;
				
				half = h.m10(lh - 1);
			}
		}
		System.out.println(arr[--i]);
	    }
}
