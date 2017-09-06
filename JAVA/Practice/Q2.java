package questionJAVA;

public class Q2 {
	/*┮Τ "计 "┮孔 "计 "琌计ㄤ计ミよ㎝单赣计セō
	      ㄒ153琌 "计 "153=1Ωよ∠5Ωよ∠3Ωよ*/
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
