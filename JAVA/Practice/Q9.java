package questionJAVA;

import java.util.Scanner;

public class Q9 {
	/*���ܨϥΪ̿�J�p�{�����{�A�íp��O�Ϋ���ܩ�ù��C���{�p���k�p�U:
		���{(����)    		�O��
		 <1500     		70��
		 >1500                    �C�h500����+5��
	       ����500���إH500���حp��         */
	public static void main(String[] args) {
		System.out.println("��J���{:");
		Scanner sc = new Scanner(System.in);
		int distance = sc.nextInt();
		int grade;
		
		if(distance <= 1500) {
			System.out.println("�O�ά�70��");
		}else {
			grade = (distance-1500)/500;
			if((distance-1500)%500 > 0) {
				grade += 1;
			}
		System.out.println("�O�ά�"+(70+grade*5)+"��");
		}
	}
}
