package come.nyse.test;


/**
 * Test Program for NYSE. This program checks if 
 * two integers in an array have a specific sume
 * 
 * @author Malik S
 *
 */

public class IntegersWithSameSum {


	
	/**
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
