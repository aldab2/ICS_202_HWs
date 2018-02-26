import java.util.concurrent.ThreadLocalRandom;

//****************************  DLL.java  *******************************
//                  generic doubly linked list class

public class DLL<T> {
    private DLLNode<T> head, tail;
    public DLL() {
        head = tail = null;
    }
    public boolean isEmpty() {
        return head == null;
    }
    public void setToNull() {
        head = tail = null;
    }
    public T firstEl() {
        if (head != null)
             return head.info;
        else return null;
    }
    public void addToHead(T el) {
        if (head != null) {
             head = new DLLNode<T>(el,head,null);
             head.next.prev = head;
        }
        else head = tail = new DLLNode<T>(el);
    }
    public void addToTail(T el) {
        if (tail != null) {
             tail = new DLLNode<T>(el,null,tail);
             tail.prev.next = tail;
        }
        else head = tail = new DLLNode<T>(el);
    }
    public T deleteFromHead() {
        if (isEmpty()) 
             return null;
        T el = head.info;
        if (head == tail)   // if only one node on the list;
             head = tail = null;
        else {              // if more than one node in the list;
             head = head.next;
             head.prev = null;
        }
        return el;
    }
    public T deleteFromTail() {
        if (isEmpty()) 
             return null;
        T el = tail.info;
        if (head == tail)   // if only one node on the list;
             head = tail = null;
        else {              // if more than one node in the list;
             tail = tail.prev;
             tail.next = null;
        }
        return el;
    }
    public void printAll() { 
        for (DLLNode<T> tmp = head; tmp != null; tmp = tmp.next)
             System.out.print(tmp.info + " ");
    }
    public T find(T el) {
        DLLNode<T> tmp;
        for (tmp = head; tmp != null && !tmp.info.equals(el); tmp = tmp.next);
        if (tmp == null)
             return null;
        else return tmp.info;
    }
    public void printReverse() {
    	DLLNode<T> tmp;
    	for(tmp=tail;tmp!= null;tmp=tmp.prev)
    		System.out.print(tmp.info+" ");
    }
    public void deleteIth(int n) {
    	while(!isEmpty()) {
    		if(head == tail) {
    			System.out.println("Deleting last element: "+ head.info);
    			deleteFromHead();
    			printAll();
    			return;
    		}
    	int i =1;
    	boolean moveForward = true;
    	DLLNode<T> tmp=head;
    	while(i<=n) {
			if(i>=n) break;
			else
    		do {
    			tmp = tmp.next;
        		i++;
        		if(tmp==tail)
        			moveForward = false;
    			//System.out.println(" After Moving Forward  i = "+i+" and the tmp value is "+tmp.info);
if(i>=n) break;
    		}
    		while(moveForward && i<=n);
    		
    		if(i>=n) break;

    		else
    		do {tmp=tmp.prev;
			i++;
			if(tmp== head)
				moveForward = true;
			//System.out.println(" After Moving Backward  i = "+i+" and the tmp value is "+tmp.info);
			if(i>=n) break;

    		}
    		while(!moveForward && i<=n);
	
    		if(i>=n) break;

    		
    			
    		}
    	if(tmp == head) {
    		System.out.println("Deleting from head: "+tmp.info);
			deleteFromHead();
			printAll();
    		System.out.println();
			
    	}
		else if(tmp == tail) {
			System.out.println("Deleting from tail: "+tmp.info);
			deleteFromTail();
			printAll();
    		System.out.println();
		}
		else {
			System.out.println("Deleting: "+tmp.info);
			tmp.prev.next= tmp.next;
			tmp.next.prev = tmp.prev;
			printAll();
    		System.out.println();
    		
    	}
    	}
    	
    }
    public static void main(String...strings ) {
    	DLL<Integer> dll  = new DLL<>();
    	
    	dll.addToTail(3);
    	dll.addToTail(1);
    	dll.addToTail(2);
    	dll.addToTail(5);
    	dll.addToTail(8);
    	dll.addToTail(7);
    	dll.addToTail(9);
    	dll.addToTail(0);
    	dll.printAll();
    	System.out.println("\n------");
    	dll.printReverse();
    	System.out.println("\n----------");
    	
    	DLL<Integer> dll2 = new DLL<Integer>();
   for(int i=0;i<10;i++)
	   dll2.addToTail( ThreadLocalRandom.current().nextInt(0, 9 + 1));
   dll2.printAll();
   System.out.println();
   dll2.deleteIth(7);
    	
		
	}
    
}