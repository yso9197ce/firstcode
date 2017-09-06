package questionJAVA;

import java.util.Scanner;

public class Q5 {
	/*使用者從螢幕輸入正整數n、m，將n至m所有整數由小至大印出，但每列只印出最多7個數字，
	      如果輸入m小於(等於)n，則輸出沒有結果*/	 
	public static void main(String[] args) {
		int small;
		int big;
		int count = 0;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("輸入起始值:");
		small = sc.nextInt();
		System.out.println("輸入終止值:");
		big = sc.nextInt();
		
		if(!(small < big)) {
			System.out.println("沒有結果");
		}else {
			for(int i = 0; i <= big-small; i++) {
				System.out.print(small+i+"\t");
				count++;
				if(count == 7) {
					System.out.println(" ");
					count = 0;
				}
			}			
		}
	}
}
