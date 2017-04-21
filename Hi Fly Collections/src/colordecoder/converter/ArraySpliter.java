package colordecoder.converter;

public class ArraySpliter {
	public UserDefinedReturns splitArray(int[] arrContents, int splitLength){
		int arrayCount = arrContents.length/splitLength;
		boolean splitarray = arrContents.length/splitLength >= 1;
		boolean lastArray = arrContents.length%splitLength != 0;
		int[][] splitArrayContents = new int[arrayCount][splitLength];
		int[] lastArrayContents = new int[arrContents.length%splitLength];
		if(splitarray){
			for(int i = 0; i < arrayCount; i++){
				for(int j = 0; j < splitLength; j++){
					int temp = i*splitLength + j;
					splitArrayContents[i][j] = arrContents[temp];
				}
			}
		}
		if(splitarray && lastArray){
			for(int i = 0; i < lastArrayContents.length; i++){
				int temp = arrayCount*splitLength + i;
				lastArrayContents[i] = arrContents[temp];
			}
		}else if(lastArray){
			lastArrayContents = arrContents;
		}
		return new UserDefinedReturns(splitArrayContents, lastArrayContents);
	}
	public static void printArray(int[] arr){
		if(arr.length!=0){
			for(int i = 0; i < arr.length; i++){
				if(i < arr.length-1){
					System.out.print(arr[i]);
					System.out.print(" ");
				}
				else{
					System.out.print(arr[i]);
					System.out.println();
				}
			}
		}else{
			System.out.println("No Elements ");
		}
	}
	public static void main(String args[]){
		ArraySpliter AS = new ArraySpliter();
		int[] arrContents = {2,3,4,6,8,1,2,3,4,7,9,5};
		int splitLength = 2147483647;
		UserDefinedReturns UDR= AS.splitArray(arrContents, splitLength);
		System.out.println("===============================================");
		System.out.println("Array Length --> "+UDR.splitArrayContents.length*splitLength);
		for(int i = 0; i < UDR.splitArrayContents.length; i++){
			printArray(UDR.splitArrayContents[i]);
		}
		System.out.println("===============================================");
		System.out.println("Array Length --> "+UDR.lastArrayContents.length);
		printArray(UDR.lastArrayContents);		
		System.out.println("===============================================");
	}
}