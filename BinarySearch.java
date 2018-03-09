package come.nyse.test;

public class BinarySearch {
	public static void main(String[] args) {
		
		int[] inputArr = {1,2,3,4,5,6,7,8,9,10,11,21,23,45,55,32,22};
		binarySearch(inputArr, 0, inputArr.length, 11);
		
	}
	
	public static int binarySearch(int[] inputArr,int low, int high, int itemToSearch){
		
		int mid = low + (high-low)/2;
		System.out.println("mid is "+mid +" for "+low +" and "+high);
		
		if(inputArr[mid]==itemToSearch){
			System.out.println(" item found at index "+mid);
			return mid;
		}
		if(itemToSearch < inputArr[mid]){
			binarySearch(inputArr, low, mid-1, itemToSearch);
		} else {
			binarySearch(inputArr,mid+1,high,itemToSearch);
		}
		
		 
		return 0;
	}
}
