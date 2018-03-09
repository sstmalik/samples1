package come.nyse.test;

import java.util.ArrayList;
import java.util.List;

/**
 * Create a Generic stack using a list to push and pop elements
 * 
 * @author Malik
 *
 * @param <T>
 */
class GenericStack<T>{

	private List<T> underlyingList = new ArrayList<T>();
	int top = -1;
	
	/**
	 * Method to push an element to the stack. 
	 * Adds an item to the end of the underlying list
	 * @param input
	 */
	public void push(T input){
		underlyingList.add(++top,input);
	} 
	
	
	/**
	 * @return <T>
	 * Method to pop the last added element to the list. 
	 * returns null when there are no elements. 
	 * Removes the last added element
	 */
	public T pop(){
		if(top > -1){
			return underlyingList.remove(top--);
		} else {
			return null;
		}
	}
	
	
	/**
	 * @return <T>
	 * Method to  view the last added element to the list. 
	 * returns null when there are no elements. 
	 * does not remove the last added element
	 */
	public T peek(){
		if(top > -1){
			return underlyingList.get(top);
		} else {
			return null;
		}
		
	}
	
	/**
	 * prints all the elements in the stack
	 */
	public void printStack(){
		underlyingList.forEach(x-> System.out.print(" -- "+x));
		System.out.println(top+1);
	}
	
	
}