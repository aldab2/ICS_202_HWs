package Q1;

public class ReverseString {
	static Queue queue = new Queue();
	
	public static Stack executeReversal(Stack stack) {
		while(!stack.isEmpty()) {
			queue.enqueue(stack.pop());
		}
		while(!queue.isEmpty()) {
			stack.push(queue.dequeue());
		}
		
		return stack;
	}
	
public static void main(String...strings) {
	Stack numbers = new Stack();
	for(int i=0;i<10;i++)
		numbers.push(i);
	System.out.println("Before Reversing: "+numbers);
	executeReversal(numbers);
	System.out.println("After Reversing: "+numbers);

}
}
