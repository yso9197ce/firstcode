package questionJAVA;

import java.util.Scanner;

public class Q4 {
	/*�n�D�ϥΪ̭��ƿ�J��Ƽƭ�(�ƭȥi�ର���Ƥ]�i�ର�t�ơA�õL�S�w�d��)�A�����J0����A
	      �p��æL�X�o�Ǿ�Ƥ����̤j�ȡB�̤p�ȥH�Υ��̪������Ȧܤp���I��1��A
	      �p�G�@��}�l��J0�A�h��X�S�����G*/	 
	public static void main(String[] args) {
		int max = 0;
		int min = 0;
		int sum = 0;
		int count = 0;
		int a;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("��J�@���:(�Y��J0�Y�N���J����)");
		a = sc.nextInt();
		max = a;
		min = a;
		
		if(a == 0) {
			System.out.println("�S�����G");
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
			System.out.println("��J�@���:(�Y��J0�Y�N���J����)");
			a = sc.nextInt();
			}
			System.out.println("�̤j�Ȭ�:"+max);
			System.out.println("�̤p�Ȭ�:"+min);
			System.out.println("�����Ȭ�:"+sum/count);
		}
		
	}

}
