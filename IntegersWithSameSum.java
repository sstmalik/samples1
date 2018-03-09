package come.nyse.test;


/**
 * 
 * @author Sheik Thamby Malik S
 *
 */
public class IntegersWithSameSum {

	
	
	public static void main(String[] args) {
		int[] inputArr = new int[]{1, 2, 3, 4, 5, 6};
		listPairsForSum(inputArr, 7);
		
	}
	
	/*
	 * Generic method that can check for pairs that add up to any sum
	 */
	public static void listPairsForSum(int[] inputArr,int sumToCheck){
		//iterate throught the array
		for(int i=0;i<inputArr.length;i++){
			//iterate from the next element of the array and add to see if the sum matches
			for(int j=i+1;j<inputArr.length;j++){
				if(inputArr[i]+inputArr[j]==sumToCheck){
					System.out.println(inputArr[i]+" "+inputArr[j]);
				}
			}
		}
	}
	
	
}
