package questionJAVA;

import java.util.Scanner;

public class Q10 {
	//猜數字
	public static void main(String[] args) {
		int answer = 58;
		System.out.println("輸入猜的數字:");
		Scanner sc = new Scanner(System.in);
		int guess = sc.nextInt();
		while(true) {
			if(guess == answer) {
				System.out.println("猜對了就是"+answer);
				break;
			}
			else if(guess > answer) {
				System.out.println("再小一點");
				System.out.println("繼續猜");
				guess = sc.nextInt();
			}
			else if(guess < answer) {
				System.out.println("再大一點");
				System.out.println("繼續猜");
				guess = sc.nextInt();
			}
		}

	}

}
