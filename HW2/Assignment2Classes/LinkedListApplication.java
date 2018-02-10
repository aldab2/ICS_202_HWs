/*import LinkedList.SLL;

import LinkedList.SLLNode;*/

public class LinkedListApplication {
	public static void main(String[] args) {
		SLL<String> myList = new SLL<String>();
		for(int i = 0; i < 5; i++)
			myList.addToHead("A" + i);
			
		myList.printAll();
	}
}