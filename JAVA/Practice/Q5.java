package questionJAVA;

import java.util.Scanner;

public class Q5 {
	/*�ϥΪ̱q�ù���J�����n�Bm�A�Nn��m�Ҧ���ƥѤp�ܤj�L�X�A���C�C�u�L�X�̦h7�ӼƦr�A
	      �p�G��Jm�p��(����)n�A�h��X�S�����G*/	 
	public static void main(String[] args) {
		int small;
		int big;
		int count = 0;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("��J�_�l��:");
		small = sc.nextInt();
		System.out.println("��J�פ��:");
		big = sc.nextInt();
		
		if(!(small < big)) {
			System.out.println("�S�����G");
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
