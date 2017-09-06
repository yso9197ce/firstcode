package questionJAVA;

import java.util.Scanner;

public class Q6 {
	/*提示使用者輸入金額，將此金額以100元、50元、20元、10元、5元、1元六種貨幣組合出該金額。
	      組合方式為依照面額由大至小的順序使用貨幣，且每種貨幣的數量為無限多，
	      無法使用100元時才能使用50元，無法使用50元時才可以使用20元，依此類推*/
	public static void main(String[] args) {
		int reminder;
		Scanner sc = new Scanner(System.in);
		System.out.println("輸入金額:");
		int money = sc.nextInt();
		
		int hundred = money/100;
		reminder = money-(hundred*100);
		int fifty = reminder/50;
		reminder = reminder-(fifty*50);
		int twenty = reminder/20;
		reminder = reminder-(twenty*20);
		int ten = reminder/10;
		reminder = reminder-(ten*10);
		int five = reminder/5;
		reminder = reminder-(five*5);
		int one = reminder;
		
		System.out.println("可換得100元: "+hundred+" 個");
		System.out.println("可換得50元: "+fifty+" 個");
		System.out.println("可換得20元: "+twenty+" 個");
		System.out.println("可換得10元: "+ten+" 個");
		System.out.println("可換得5元: "+five+" 個");
		System.out.println("可換得1元: "+one+" 個");
	}

}
