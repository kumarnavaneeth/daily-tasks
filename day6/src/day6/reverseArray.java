package day6;

import java.util.Arrays;

public class reverseArray {
public static void main(String[] args) {
	int[] a= {1,2,3,4,5};
	reverse(a);
}
private static void reverse(int[] a) {
	int start =0;
	int end=a.length-1;
	while(start<end) {
		int temp=a[start];
		a[start]=a[end];
		a[end]=temp;
		start++;
		end--;
	}
	for(int element:a)
		System.out.println(element);
}
}
