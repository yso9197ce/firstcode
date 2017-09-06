package questionJAVA;

import java.util.Scanner;

public class Q3 {
	/*级糶祘Α弄ざ100 - 999计礛陪ボウ–计㎝縩㎝畉
	      ㄒ932–计㎝琌14–计縩琌54–计畉琌4(κ计搭计搭计)*/
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("块ざ100 - 999计:");
		int a = sc.nextInt();
		int hundred = a/100;
		int ten = a%100/10;
		int num = a%10;
		System.out.println("块琌"+a);
		System.out.println("–计㎝琌"+(hundred+ten+num));
		System.out.println("–计縩琌"+(hundred*ten*num));
		System.out.println("–计畉琌"+(hundred-ten-num));
		}
	}


