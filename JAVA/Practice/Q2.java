package questionJAVA;

public class Q2 {
	/*�C�L�X�Ҧ��� "���P��� "�A�ҿ� "���P��� "�O���@�ӤT��ơA��U��Ʀr�ߤ�M����Ӽƥ����C
	      �Ҧp�G153�O�@�� "���P��� "�A�]��153=1���T�����5���T�����3���T����*/
	public static void main(String[] args) {
		double flower,hundred,ten,num;
		for(int i = 100; i<1000; i++) {
			hundred = i/100;
			ten = i%100/10;
			num = i%10;
			flower = Math.pow(hundred,3)+Math.pow(ten,3)+Math.pow(num,3);
			if(i == flower) {
				System.out.println((int)flower);
			}
		}
	}

}
