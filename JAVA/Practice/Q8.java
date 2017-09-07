package questionJAVA;

import java.util.Scanner;

public class Q8 {
	/*提示使用者輸入分數，將其分數依照不同等級由螢幕輸出。分數分級如下:
		等級                                   分數區間
		A             90~100     
		B              80~89
		C              70~79
		D              60~69
		E               0~59 */
	public static void main(String[] args) {
		System.out.println("輸入分數:");
		Scanner sc = new Scanner(System.in);
		int score = (sc.nextInt())/10;
		
		switch(score){
			case 10:
				System.out.println("A");
				break;
			case 9:
				System.out.println("A");
				break;
			case 8:
				System.out.println("B");
				break;
			case 7:
				System.out.println("C");
				break;
			case 6:
				System.out.println("D");
				break;
			default:
				System.out.println("E");
		}

	}

}
