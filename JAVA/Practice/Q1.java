package questionJAVA;

public class Q1 {
	/*���@��ߤl�A�q�X�ͫ��3�Ӥ�_�C�Ӥ볣�ͤ@��ߤl�A�p�ߤl����ĤT�Ӥ��C�Ӥ�S�ͤ@��ߤl�A
	      ���p�ߤl�������A  �ݨC�Ӥ몺�ߤl��Ƭ��h�֡H*/
	public static void main(String[] args) {
		int rabbit = 1;
		int temp = 0;
		int sum = 0;
		System.out.println("��1�Ӥ�ߤl��1��");
		for(int i = 2; i<=12; i++) {
			sum = rabbit+temp;
			System.out.println("��"+i+"�Ӥ�ߤl��"+sum+"��");
			temp = rabbit;
			rabbit = sum;			
		}
	}
}
