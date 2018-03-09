import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StackImpl {

	private int[] underlyingArray = new int[10];
	
	int top = -1;
	int maxSize = underlyingArray.length;
	int size = 0;
	
	public void push(int input){
		if(maxSize==top){
			return;
		}
		underlyingArray[++top] = input;
		size++;
	}
	
	public int pop(){
		if(size == 0 ){
			return -1;
		} else {
			size--;
			int returnVal = underlyingArray[top];
			underlyingArray[top] = 0;
			top--;
			return returnVal;
		}
	}
	
	public int peek(){
		if(size == 0 ){
			return -1;
		} else {
			
			int returnVal = underlyingArray[top];
			
			return returnVal;
		}
	}
	
	public void printStack(){
		Arrays.stream(underlyingArray).filter(x-> x!=0 ).
		forEach(x-> System.out.print(" -- "+x));
		System.out.println();
	
		
	}
	
	public static void main(String[] args) {
		StackImpl stack = new StackImpl();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.printStack();
		System.out.println(stack.pop());
		stack.printStack();
		System.out.println(stack.peek());
		stack.push(6);
		stack.printStack();
		System.out.println(stack.peek());
		
		GenericStack<String> genStack = new GenericStack<String>();
		genStack.push("a");
		genStack.push("b");
		genStack.push("c");
		genStack.push("d");
		genStack.printStack();
		System.out.println(genStack.pop());
		genStack.printStack();
		System.out.println(genStack.peek());
		genStack.push("e");
		System.out.println(genStack.peek());
		genStack.printStack();
	}
	
	
}
class GenericStack<T>{

	private List<T> underlyingList = new ArrayList<T>();
	int top = -1;
	
	public void push(T input){
		underlyingList.add(++top,input);
	} 
	
	public T pop(){
		return underlyingList.remove(top--);
	}
	
	public T peek(){
		return underlyingList.get(top);
	}
	
	public void printStack(){
		underlyingList.forEach(x-> System.out.print(" -- "+x));
		System.out.println(top+1);
	}
	
	
}
	
