package day6;

public class FindSecondLargest {
	public static void main(String[] args) {
		secondLargest();
	}

	private static void secondLargest() {
		int[] arr = { 49,3,4,65,12,67,45 };
		int largest = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > largest) {
				largest = arr[i];
			}
		}
	int secondlargest=Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > secondlargest && arr[i]!=largest) {
				secondlargest = arr[i];
			}
		}
		System.out.println(largest);
		System.out.println("second largest is " + secondlargest);
	}
}
