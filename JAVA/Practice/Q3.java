package questionJAVA;

import java.util.Scanner;

public class Q3 {
	/*���g�@�ӵ{��Ū�J�@�Ӥ���100 - 999���Ʀr�A�M����ܥ����C��ƩM�B�n�M�t�C
	      �Ҧp932���C��ƩM�O14�B�C��ƿn�O54�B�C��Ʈt�O4�C(�ʦ�ƴ�Q��ƦA��Ӧ��)*/
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("��J�@�Ӥ���100 - 999���Ʀr:");
		int a = sc.nextInt();
		int hundred = a/100;
		int ten = a%100/10;
		int num = a%10;
		System.out.println("�A��J���O"+a);
		System.out.println("�C��ƩM�O"+(hundred+ten+num));
		System.out.println("�C��ƿn�O"+(hundred*ten*num));
		System.out.println("�C��Ʈt�O"+(hundred-ten-num));
		}
	}


