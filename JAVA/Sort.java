import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sort {

	public static void main(String[] args) {
	
	//讓使用者輸入動態長度的數字	
		List<Integer> input = new ArrayList<Integer>();
		System.out.println("請輸入1~9999數字(輸入0代表結束):");
		Scanner sc = new Scanner(System.in);
		int inputNumber = sc.nextInt();
		while(inputNumber != 0) {
			input.add(inputNumber);
			System.out.println("請輸入1~9999數字(輸入0代表結束):");
			inputNumber = sc.nextInt();
		}
		int[] inputArray = new int[input.size()];
		for(int i = 0 ; i < input.size() ; i++) {
			inputArray[i] = input.get(i);
		}
		
	//將輸入的數字由小排到大(bubble sort)
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
		
	//數字轉國字
		StringBuffer[] output = new StringBuffer[inputArray.length];
		String[] chNumber = {"零","一","二","三","四","五","六","七","八","九"};
		String[] chUnit = {"十","百","千"};
		Integer numInput;    
		Integer numLength;   
		String numString; 
		for(int i = 0 ; i < inputArray.length ; i++) {
			StringBuffer cnStr = new StringBuffer();   //中文字暫存
			numInput = inputArray[i];
			numString = numInput.toString();    //輸入的數字轉字串
			numLength = numString.length();     //取出字串長度可得知幾位數
			char[] a = numString.toCharArray();
			for(int j=0 ; j<numLength ; j++) {
				int b = (int)(a[j]-'0');        //將字串(數字)轉回整數
			//=====先處理10~19。 ex:15 從"一十五"變為"十五"=====
				if(numLength == 2 && a[0] == '1') {  
					cnStr.append(chUnit[0]);   //取出對應的中文字
					cnStr.append(chNumber[(int)(a[1]-'0')]);
					break;
				}
			//=====考慮各種出現0的時機=======	
				else{
					if(b == 0){
						try{
					//=====如果該數字是0，後面數字也為0，則不加任何中文數字=======		
							if((int)(a[j]-'0') == 0 && (int)(a[j+1]-'0') == 0){
								continue;
							}
					//=====如果該數字是0，前後面數字也都為0，則不加任何中文數字=======
							else if((int)(a[j-1]-'0') == 0 && (int)(a[j+1]-'0') == 0){
							continue;
							}
					//=====如果前一個數字是0，該數字也為0且是最後一位數，則不加任何中文數字=======	
							else if((int)(a[j-1]-'0') == 0 && (j == numLength-1 && b == 0)){
							continue;
							}
					//=====如果該數字是0且是最後一位數，則不加任何中文數字=======
							else if(j == numLength-1 && b == 0) {
							continue;
							}
					//=====其他情況下則添加中文數字=======
							else{
							cnStr.append(chNumber[b]);
							}
						}catch(Exception e){   //避免超過index
							continue;
						}
					}
			//=====找出若某位數是"0"，則不用加單位。ex:705 從"七百零十五"變為"七百零五"=======		
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
		
	//印出結果
		System.out.println("依大小排序並以國字表示:");
		for(int i = 0 ; i < output.length ; i++) {			
			System.out.print(output[i]+"\t");
		}
	}
}
