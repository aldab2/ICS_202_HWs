import com.sun.org.apache.xml.internal.resolver.helpers.Debug;

/*package LinkedList;*/

//**************************  SLL.java  *********************************
//           a generic singly linked list class 

public class SLL<T> {
    protected SLLNode<T> head, tail;
    
    public SLL(SLLNode<T> head,SLLNode<T> tail) {
    	this.head = head;
    	this.tail = tail;
    	
    }
    public SLL() {
        head = tail = null;
    }
    public boolean isEmpty() {
        return head == null;
    }
    public void addToHead(T el) {
        head = new SLLNode<T>(el,head);
        if (tail == null)
            tail = head;
    }
    public void addToTail(T el) {
        if (!isEmpty()) {
            tail.next = new SLLNode<T>(el);
            tail = tail.next;
        }
        else head = tail = new SLLNode<T>(el);
    }
    public T deleteFromHead() { // delete the head and return its info; 
        if (isEmpty()) 
             return null;
        T el = head.info;
        if (head == tail)       // if only one node on the list;
             head = tail = null;
        else head = head.next;
        return el;
    }
    public T deleteFromTail() { // delete the tail and return its info;
        if (isEmpty()) 
             return null;
        T el = tail.info;
        if (head == tail)       // if only one node in the list;
             head = tail = null;
        else {                  // if more than one node in the list,
             SLLNode<T> tmp;    // find the predecessor of tail;
             for (tmp = head; tmp.next != tail; tmp = tmp.next);
             tail = tmp;        // the predecessor of tail becomes tail;
             tail.next = null;
        }
        return el;
    }
    public void delete(T el) {  // delete the node with an element el;
        if (!isEmpty())
            if (head == tail && el.equals(head.info)) // if only one
                 head = tail = null;       // node on the list;
            else if (el.equals(head.info)) // if more than one node on the list;
                 head = head.next;    // and el is in the head node;
            else {                    // if more than one node in the list
                 SLLNode<T> pred, tmp;// and el is in a nonhead node;
                 for (pred = head, tmp = head.next;  
                      tmp != null && !tmp.info.equals(el); 
                      pred = pred.next, tmp = tmp.next);
                 if (tmp != null) {   // if el was found;
                     pred.next = tmp.next;
                     if (tmp == tail) // if el is in the last node;
                        tail = pred;
                 }
            }
    }
    public void printAll() {
        for (SLLNode<T> tmp = head; tmp != null; tmp = tmp.next)
            System.out.print(tmp.info + " ");                
    }
    public void listAll() {
    	int i=1;
    	for(SLLNode<T> tmp = head; tmp!=null ; tmp = tmp.next,i++) {
    		System.out.println(i+"> "+tmp.info);
    	}
    	
    }
    public boolean isInList(T el) {
        SLLNode<T> tmp;
        for (tmp = head; tmp != null && !tmp.info.equals(el); tmp = tmp.next);
        return tmp != null;
    }
    public void insertBefore(T newElem,T existingElem) {
    	if(head.info.equals(existingElem)) {
    		head = new SLLNode<T>(newElem, head);
    		return;
    	}
    	SLLNode<T> tmp;
    	for(tmp=head;tmp!=null &&  tmp.next !=null && !tmp.next.info.equals(existingElem) ; tmp = tmp.next);
    	if(tmp.next!= null) {
    		SLLNode<T> el = new SLLNode<T>(newElem, tmp.next);
        	tmp.next = el;

    	}
    	else 
    		System.out.println("\nWARINING: Element "+existingElem + " does not exist in the linked list. Insertion failed");
    	
    }
    public void deleteBefore(T existingElem) {
    	if(head == null)
    		return;
    	if(head.info.equals(existingElem)) {
    		System.out.println("\nWARINING: Element "+existingElem + " is the 1st element in the linked list. Deletion failed");
    		return;
    	}
    		
    	SLLNode<T> tmp;
    	if(head.next.info.equals(existingElem)) {
    		head = head.next;
    	}
    	else {
    	for(tmp=head;tmp!=null &&  tmp.next.next !=null && !tmp.next.next.info.equals(existingElem) ; tmp = tmp.next);
    	if(tmp.next.next!= null) {
    	tmp.next =tmp.next.next;

    	}
    	else 
    		System.out.println("\nWARINING: Element "+existingElem + " does not exist in the linked list. Deletion failed");
    	}
    }
    public void insertAfter( T newElem, T existingElem) {
    if(tail.info.equals(existingElem)) {
    	SLLNode<T> el = new SLLNode<T>(newElem, null);
    	tail.next = tail = el;
    	return;
    }
    	if(head == tail) {
    		if (head.info.equals(existingElem)) {
				SLLNode<T> el = new SLLNode<T>(newElem, null);
				head.next= tail = el;
				return;
			
			}
    	}
    	SLLNode<T> tmp = head;
    	for(; !tmp.next.equals(null) && !tmp.info.equals(existingElem); tmp = tmp.next);
    	if(!tmp.next.equals(null)) {
    		SLLNode<T> el = new SLLNode<T>(newElem, tmp.next);
    		tmp.next = el;
    	}
    	else if(tmp.next.equals(null)) {
    		SLLNode<T> el = new SLLNode<T>(newElem, null);
    		tmp.next = el;
    		head = el;
    		
    	}
    	if(head.next.equals(null))
    		System.out.println("\nWARINING: Element "+existingElem + " does not exist in the linked list. Deletion failed");

    	
    }
    public int length() {
    	int cnt = 0;
    	for(SLLNode<T> tmp = head;tmp!=null;tmp=tmp.next) {
    		cnt++;
    	}
    	return cnt;
    }
    public void deleteAllFrom(int n) {
    	SLLNode<T> tmp = head;
    	if(n==0 || n==1) {
    		tail = head = null;
    	}
    	else if(n ==2) {
    		head = tail;
    		head.next = null;
    		
    	}
    	else {
    	for(int i=1; tmp!=null && i<n-1;tmp=tmp.next, i++);
    	if(tmp == null) {
    		System.out.println("\nCant Delete From more than the List. Nothing will happen");
    		return;
    	}
    	tail = tmp;	
    	tail.next= null;
    	}
    }
    public void delete( int n) {
    	if(n > length() || n<0) {
    		System.out.println("Worng Operation , Nothing Will be Cunducted N>Length()");
    		return;
    	}
    	if(n ==1) {
    		
    		System.out.println("Deleted 1st Element_ 'Supposedly -_-' ");
    		if(length()==1) {
    		head = tail = null;
    		return;
    		}
    		else {
    			
    			deleteFromHead();
    			return;
    			
    		}
    		
    	}
    	if(n == length() && n!=1) {
    		// delete last element
    		System.out.println("Deleted Last Element_ 'Supposedly -_-' ");
    		deleteFromTail();
    		return;
    	}
    	SLLNode<T> tmp;
    	int i=1;
    	for(tmp=head ;tmp!=null && i<n-1 ;tmp=tmp.next, i++);
    		if(tmp ==null) {
    		
    			System.out.println("Unexpected Error");
    			return;
    		}
    		else {
    			tmp.next = tmp.next.next;
    			if(tmp.next == null)
    				tail = tmp.next;
    		}
    	
    		
    }
    public void deleteAllFromTo(int  n, int m) {
    	SLLNode<T> tmp = head;
    	if( n > m) {
    		System.out.println("Wrong Operation , Nothing Will happen N>M");
    		return;
    	}
    	if(n == m ) {
    		
    		System.out.println("Deleteing one number");
    		delete(n);
    		return;
    	}
    	if( n==1  && m==length()) {
    		head = tail = null;
    		return;
    	}
    	
    	 tmp = nodeAt(n-2);
    	 SLLNode<T> atM =nodeAt(m-1);
    	 SLLNode<T> atN = nodeAt(n-1);
    	 if(atM == null) {
    		 System.out.println("M is Null unexpected error");
    		 return;
    	 }
    	 /*System.out.println("tmp is"+tmp);
    	 System.out.println("N is"+atN);
    		 System.out.println("M is"+atM);*/
    		 if(n ==1 ) {
    	    	head = atM.next;
    	    	return;
    	    	}
    		 else {
    			 if(atM.next == null) {
    				 tail =tmp.next = null;
    				 
    			 }
    			 else
    			 tmp.next = atM.next;
    		 }
    		 
    	 
    	
    }
    public SLLNode<T> nodeAt(int n){
    	if( n <0 || n>length()) {
    		//System.out.println(" n less than zero or greater than the legnth(");
    		return null;
    	}
    	SLLNode<T> tmp ;
    	int i=0;
    	for(tmp = head; tmp!=null && i!=n;tmp=tmp.next,i++);
    	return tmp;
    		
    	
    	
    	
    }
    public static void main(String...args) {
    	
    	SLL<Integer> arr = new SLL<>();
    	arr.addToTail(3);arr.addToTail(5);arr.addToTail(4);
    	arr.addToTail(2);arr.addToTail(9);arr.printAll();
    	//////////////////////////////////////////////////
    	arr.insertBefore(new Integer(5), new Integer(9));
    	System.out.println();
    	arr.printAll();
    	arr.insertBefore(new Integer(7), new Integer(5));
    	System.out.println();
    	arr.printAll(); 
    	arr.insertBefore(new Integer(8), new Integer(10));
    	arr.printAll();
    	arr.deleteBefore(new Integer(5));
    	System.out.println();
    	arr.printAll(); 
    	
    	arr.insertAfter(new Integer(6), new Integer(9));
    	System.out.println();
    	arr.printAll();
    	arr.insertAfter(new Integer(6), new Integer(6));
    	System.out.println();
    	arr.printAll();
    	arr.deleteBefore(new Integer(10));
    	System.out.println();
    	arr.printAll();
    

    }
}
