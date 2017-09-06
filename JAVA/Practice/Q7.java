package questionJAVA;

import java.util.Scanner;

public class Q7 {
	/*提示使用者輸入4個數值，將此4個數值由小至大排列後，由螢幕輸出*/
	public static void main(String[] args) {
		int temp;
		Scanner sc = new Scanner(System.in);
		System.out.println("輸入金額:");
		int a = sc.nextInt();
		System.out.println("輸入金額:");
		int b = sc.nextInt();
		System.out.println("輸入金額:");
		int c = sc.nextInt();
		System.out.println("輸入金額:");
		int d = sc.nextInt();
		
		int[] array = {a,b,c,d};
		for(int i = 0;i<array.length;i++) {
			for(int j = 0;j<array.length-1;j++) {
				if(array[j] > array[j+1]) {
					temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
		}
		for(int i = 0;i<array.length;i++) {
			System.out.print(array[i]+"\t");
		}
	}
}
