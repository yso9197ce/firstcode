package questionJAVA;

import java.util.Scanner;

public class Q7 {
	/*���ܨϥΪ̿�J4�ӼƭȡA�N��4�ӼƭȥѤp�ܤj�ƦC��A�ѿù���X*/
	public static void main(String[] args) {
		int temp;
		Scanner sc = new Scanner(System.in);
		System.out.println("��J���B:");
		int a = sc.nextInt();
		System.out.println("��J���B:");
		int b = sc.nextInt();
		System.out.println("��J���B:");
		int c = sc.nextInt();
		System.out.println("��J���B:");
		int d = sc.nextInt();
		
		int[] array = {a,b,c,d};
		for(int i = 0;i<array.length;i++) {
			for(int j = 0;j<array.length-1;j++) {
				if(array[j] > array[j+1]) {
					temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
		}
		for(int i = 0;i<array.length;i++) {
			System.out.print(array[i]+"\t");
		}
	}
}
