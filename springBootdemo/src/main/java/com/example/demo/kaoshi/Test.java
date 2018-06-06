package com.example.demo.kaoshi;

public class Test {
	public static void main(String[] args) {
		int[] arr = { 3, 5, 9, 7, 4, 13, 15, 0, 2, 20 };
		// 定义外层循环
		for (int i = 0; i < arr.length - 1; i++) {
			// 定义内层循环
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] < arr[j + 1]) { // 比较相邻元素
					// 下面的三行代码用于交换两个元素
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}

		}
		// 循环遍历数组的元素
		for (int m = 0; m < arr.length; m++) {
			System.out.print(arr[m] + " "); // 打印元素和空格
		}
	}
}
