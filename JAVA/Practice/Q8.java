package questionJAVA;

import java.util.Scanner;

public class Q8 {
	/*���ܨϥΪ̿�J���ơA�N����ƨ̷Ӥ��P���ťѿù���X�C���Ƥ��Ŧp�U:
		����                                   ���ư϶�
		A             90~100     
		B              80~89
		C              70~79
		D              60~69
		E               0~59 */
	public static void main(String[] args) {
		System.out.println("��J����:");
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
