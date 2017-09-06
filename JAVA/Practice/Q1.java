package questionJAVA;

public class Q1 {
	/*有一對兔子，從出生後第3個月起每個月都生一對兔子，小兔子長到第三個月後每個月又生一對兔子，
	      假如兔子都不死，  問每個月的兔子對數為多少？*/
	public static void main(String[] args) {
		int rabbit = 1;
		int temp = 0;
		int sum = 0;
		System.out.println("第1個月兔子有1對");
		for(int i = 2; i<=12; i++) {
			sum = rabbit+temp;
			System.out.println("第"+i+"個月兔子有"+sum+"對");
			temp = rabbit;
			rabbit = sum;			
		}
	}
}
