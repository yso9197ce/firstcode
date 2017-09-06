package questionJAVA;

import java.util.Scanner;

public class Q4 {
	/*要求使用者重複輸入整數數值(數值可能為正數也可能為負數，並無特定範圍)，直到輸入0為止，
	      計算並印出這些整數中的最大值、最小值以及它們的平均值至小數點第1位，
	      如果一剛開始輸入0，則輸出沒有結果*/	 
	public static void main(String[] args) {
		int max = 0;
		int min = 0;
		int sum = 0;
		int count = 0;
		int a;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("輸入一整數:(若輸入0即代表輸入結束)");
		a = sc.nextInt();
		max = a;
		min = a;
		
		if(a == 0) {
			System.out.println("沒有結果");
		}		
		else{
			while(a != 0) {
		
			if(a > max) {
				max = a;
			}
			if(a < min) {
				min = a;
			}
			sum += a;
			count++;
			System.out.println("輸入一整數:(若輸入0即代表輸入結束)");
			a = sc.nextInt();
			}
			System.out.println("最大值為:"+max);
			System.out.println("最小值為:"+min);
			System.out.println("平均值為:"+sum/count);
		}
		
	}

}
