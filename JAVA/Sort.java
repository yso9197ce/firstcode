import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sort {

	public static void main(String[] args) {
	
	//���ϥΪ̿�J�ʺA���ת��Ʀr	
		List<Integer> input = new ArrayList<Integer>();
		System.out.println("�п�J1~9999�Ʀr(��J0�N����):");
		Scanner sc = new Scanner(System.in);
		int inputNumber = sc.nextInt();
		while(inputNumber != 0) {
			input.add(inputNumber);
			System.out.println("�п�J1~9999�Ʀr(��J0�N����):");
			inputNumber = sc.nextInt();
		}
		int[] inputArray = new int[input.size()];
		for(int i = 0 ; i < input.size() ; i++) {
			inputArray[i] = input.get(i);
		}
		
	//�N��J���Ʀr�Ѥp�ƨ�j(bubble sort)
		int temp;
		for(int i = 0 ; i < inputArray.length ; i++) {
			for(int j = 0 ; j < inputArray.length-1 ; j++) {
				if(inputArray[j] > inputArray[j+1]) {
					temp = inputArray[j];
					inputArray[j] = inputArray[j+1];
					inputArray[j+1] = temp;
				}
			}
		}
		
	//�Ʀr���r
		StringBuffer[] output = new StringBuffer[inputArray.length];
		String[] chNumber = {"�s","�@","�G","�T","�|","��","��","�C","�K","�E"};
		String[] chUnit = {"�Q","��","�d"};
		Integer numInput;    
		Integer numLength;   
		String numString; 
		for(int i = 0 ; i < inputArray.length ; i++) {
			StringBuffer cnStr = new StringBuffer();   //����r�Ȧs
			numInput = inputArray[i];
			numString = numInput.toString();    //��J���Ʀr��r��
			numLength = numString.length();     //���X�r����ץi�o���X���
			char[] a = numString.toCharArray();
			for(int j=0 ; j<numLength ; j++) {
				int b = (int)(a[j]-'0');        //�N�r��(�Ʀr)��^���
			//=====���B�z10~19�C ex:15 �q"�@�Q��"�ܬ�"�Q��"=====
				if(numLength == 2 && a[0] == '1') {  
					cnStr.append(chUnit[0]);   //���X����������r
					cnStr.append(chNumber[(int)(a[1]-'0')]);
					break;
				}
			//=====�Ҽ{�U�إX�{0���ɾ�=======	
				else{
					if(b == 0){
						try{
					//=====�p�G�ӼƦr�O0�A�᭱�Ʀr�]��0�A�h���[���󤤤�Ʀr=======		
							if((int)(a[j]-'0') == 0 && (int)(a[j+1]-'0') == 0){
								continue;
							}
					//=====�p�G�ӼƦr�O0�A�e�᭱�Ʀr�]����0�A�h���[���󤤤�Ʀr=======
							else if((int)(a[j-1]-'0') == 0 && (int)(a[j+1]-'0') == 0){
							continue;
							}
					//=====�p�G�e�@�ӼƦr�O0�A�ӼƦr�]��0�B�O�̫�@��ơA�h���[���󤤤�Ʀr=======	
							else if((int)(a[j-1]-'0') == 0 && (j == numLength-1 && b == 0)){
							continue;
							}
					//=====�p�G�ӼƦr�O0�B�O�̫�@��ơA�h���[���󤤤�Ʀr=======
							else if(j == numLength-1 && b == 0) {
							continue;
							}
					//=====��L���p�U�h�K�[����Ʀr=======
							else{
							cnStr.append(chNumber[b]);
							}
						}catch(Exception e){   //�קK�W�Lindex
							continue;
						}
					}
			//=====��X�Y�Y��ƬO"0"�A�h���Υ[���Cex:705 �q"�C�ʹs�Q��"�ܬ�"�C�ʹs��"=======		
					else if(b != 0) {
						cnStr.append(chNumber[b]);
						if((numLength-j-2) >= 0) {
							cnStr.append(chUnit[numLength-j-2]);
						}
					}
				}						
			}
			output[i] = cnStr;	
		}
		
	//�L�X���G
		System.out.println("�̤j�p�ƧǨåH��r���:");
		for(int i = 0 ; i < output.length ; i++) {			
			System.out.print(output[i]+"\t");
		}
	}
}
