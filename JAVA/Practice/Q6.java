package questionJAVA;

import java.util.Scanner;

public class Q6 {
	/*���ܨϥΪ̿�J���B�A�N�����B�H100���B50���B20���B10���B5���B1�����سf���զX�X�Ӫ��B�C
	      �զX�覡���̷ӭ��B�Ѥj�ܤp�����Ǩϥγf���A�B�C�سf�����ƶq���L���h�A
	      �L�k�ϥ�100���ɤ~��ϥ�50���A�L�k�ϥ�50���ɤ~�i�H�ϥ�20���A�̦�����*/
	public static void main(String[] args) {
		int reminder;
		Scanner sc = new Scanner(System.in);
		System.out.println("��J���B:");
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
		
		System.out.println("�i���o100��: "+hundred+" ��");
		System.out.println("�i���o50��: "+fifty+" ��");
		System.out.println("�i���o20��: "+twenty+" ��");
		System.out.println("�i���o10��: "+ten+" ��");
		System.out.println("�i���o5��: "+five+" ��");
		System.out.println("�i���o1��: "+one+" ��");
	}

}
