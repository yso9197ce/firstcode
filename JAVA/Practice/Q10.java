package questionJAVA;

import java.util.Scanner;

public class Q10 {
	//�q�Ʀr
	public static void main(String[] args) {
		int answer = 58;
		System.out.println("��J�q���Ʀr:");
		Scanner sc = new Scanner(System.in);
		int guess = sc.nextInt();
		while(true) {
			if(guess == answer) {
				System.out.println("�q��F�N�O"+answer);
				break;
			}
			else if(guess > answer) {
				System.out.println("�A�p�@�I");
				System.out.println("�~��q");
				guess = sc.nextInt();
			}
			else if(guess < answer) {
				System.out.println("�A�j�@�I");
				System.out.println("�~��q");
				guess = sc.nextInt();
			}
		}

	}

}
