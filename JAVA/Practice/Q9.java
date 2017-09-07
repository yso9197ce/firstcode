package questionJAVA;

import java.util.Scanner;

public class Q9 {
	/*提示使用者輸入計程車里程，並計算費用後顯示於螢幕。里程計算方法如下:
		里程(公尺)    		費用
		 <1500     		70元
		 >1500                    每多500公尺+5元
	       不足500公尺以500公尺計算         */
	public static void main(String[] args) {
		System.out.println("輸入里程:");
		Scanner sc = new Scanner(System.in);
		int distance = sc.nextInt();
		int grade;
		
		if(distance <= 1500) {
			System.out.println("費用為70元");
		}else {
			grade = (distance-1500)/500;
			if((distance-1500)%500 > 0) {
				grade += 1;
			}
		System.out.println("費用為"+(70+grade*5)+"元");
		}
	}
}
