import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.*;
public class TextEditer {
	static boolean isNormalICommand ;
	static boolean isEmptyICommand ;
	static boolean isEmptyDCommand;
	static boolean isSingleDCommand;
	static boolean isDoubleDCommand;
	static boolean isEmptyLCommand;
	static boolean isSingleLCommand;
	static boolean isDoubleLCommand;
	public static SLLNode<String> tmpTail;
	
	 static SLL<String> lines ; 
	 static SLL<String> tmpLines;
	 static Scanner myKeyb = new Scanner(System.in);
	public static void main(String...strings) {
		System.out.print("Edit ");
		Scanner myKeyb = new Scanner(System.in);
		String fileName = myKeyb.nextLine();
		PrintWriter pw = null;
		FileOutputStream outstream = null;
		try { 
			 outstream = new FileOutputStream(fileName);
			 pw = new PrintWriter(outstream);
		}
		catch(Exception e) {
			System.out.println("Somthing went wrong with the file");
			System.exit(-1);
		}
		lines = new SLL<String>();
		while(true) {
			System.out.print((lines.length()+1)+"> ");
			String enteredLine = myKeyb.nextLine();
			String command = enteredLine.replaceAll("\\s+",",");
			
			if(isICommand(command)) {
				executeICommand(command);
			}
			else if(isDCommand(command)) {
				executeDCommand(command);
			}
			else if(isLCommand(command))
				executeLCommand(command);
			else if(isACommand(command))
				executeACommand(command);
			else if(isECommand(command))
				break;
			
			
			
			// Case the enteredLine was normal.
			else
			lines.addToTail(enteredLine);
			
		}
		SLLNode<String> tmp = lines.head;
		int i=1;
		while(tmp!=null) {
			pw.println(i+"> "+tmp);
			tmp=tmp.next;
			i++;
		}
			
	pw.close();
	}
	
	public static void executeDCommand(String command) {
		System.out.println("Executing D Command");
		int dNumber1 = -1;
		int dNumber2 = -1;
		try {
			if(isSingleDCommand) {
				System.out.println("Single D Command");
				dNumber1 = Integer.parseInt(command.substring(command.indexOf(',')+1));
				lines.delete(dNumber1);
			}
			if(isDoubleDCommand) {
				System.out.println("Double D Command");
				dNumber1 = Integer.parseInt(command.substring(command.indexOf(',')+1,command.lastIndexOf(',')));
				dNumber2 = Integer.parseInt(command.substring(command.lastIndexOf(',')+1));
				lines.deleteAllFromTo(dNumber1,dNumber2);
			}
			if (isEmptyDCommand) {
				System.out.println("Empty D Command");
				lines.delete(lines.length()-1);
			}
		}
		catch(InputMismatchException ime) {
			System.out.println("Something Went wrong with the dNumbers 1 and 2");
			System.out.println(ime.getMessage());
		}
	}
	
	public static void executeICommand(String command) {
		System.out.println("This is an I command");
		int iNumber =-1;
		try {
			if(isNormalICommand) {
				iNumber = Integer.parseInt(command.substring(command.indexOf(',')+1));
				lines.deleteAllFrom(iNumber);
				/* tmpTail = lines.tail;
				SLLNode<String> newTail = lines.nodeAt(iNumber-2);
				if(newTail == null) {
					System.out.println("Unavailable Destination");
					return;
				}
				lines.tail = newTail;
				lines.tail.next = null;*/
				return;
			}
			if(isEmptyICommand) {
				lines.deleteAllFrom(lines.length());
				
				return;
			}
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public static void executeLCommand(String command) {
		if(isEmptyLCommand) {
			lines.listAll();
			return;}
		int lNumber1 = -1;
		int lNumber2 = -1;
		try {
			if(isSingleLCommand) {
				System.out.println("Single L Command");
				lNumber1 = Integer.parseInt(command.substring(command.indexOf(',')+1));
				SLLNode<String> atN = lines.nodeAt(lNumber1-1 );
				int i=lNumber1;
				if(atN == null) {
					System.out.println("Wrong lNumber1");
					return;
				}
				do {
					System.out.println(i+"> "+atN);
					atN= atN.next;
					i++;
				}
				while(atN != null);
					
				
				return;
			}
			if(isDoubleLCommand) {
				System.out.println("Double L Command");
				lNumber1 = Integer.parseInt(command.substring(command.indexOf(',')+1,command.lastIndexOf(',')));
				lNumber2 = Integer.parseInt(command.substring(command.lastIndexOf(',')+1));
				SLLNode<String> atN = lines.nodeAt(lNumber1-1 );
				SLLNode<String> atM = lines.nodeAt(lNumber2-1);
				int i=lNumber1;
				if(atN == null || atM == null) {
					System.out.println("Wrong lNumber1 or lNumber2");
					return;
				}
				do {
					System.out.println(i+"> "+atN);
					atN= atN.next;
					i++;
				}
				while(atN != atM.next);
				return;
			}
		}
		catch(InputMismatchException ime) {
			System.out.println("Something Went wrong with the lNumbers 1 and 2");
			System.out.println(ime.getMessage());
		}
		
		
		
	}
	public static void executeACommand(String command) {

		lines.tail = tmpTail;
		
	}
	private static boolean isICommand(String command) {
		isEmptyICommand = false;
		isNormalICommand = false;
		if(command.indexOf("I") == 0 && command.length() ==1)  {
			isEmptyICommand = true;
			System.out.println("Empty Command");
		}
		else if(command.indexOf("I") == 0 && Character.isDigit(command.charAt(2))) {
			isNormalICommand = true;
			System.out.println("Normal Command");
		}
		return isEmptyICommand || isNormalICommand;
	}
	private static boolean isLCommand(String command) {
		isDoubleLCommand= false;
		isEmptyLCommand = false;
		isSingleLCommand = false;
		
		
		if(command.indexOf("L") == 0 && command.length() ==1)
			isEmptyLCommand = true;
		else if(command.indexOf("L") == 0 && command.charAt(1) == ',') {
			if(command.indexOf(',') == command.lastIndexOf(','))
				isSingleLCommand = true;
			else
				isDoubleLCommand = true;
		}
		
		
		
		
		if(isDoubleLCommand && isEmptyLCommand && isSingleLCommand )
			return false;
		return isDoubleLCommand ^ isEmptyLCommand  ^ isSingleLCommand ;
	}
	public static boolean isDCommand(String command) {
		isDoubleDCommand= false;
		isEmptyDCommand = false;
		isSingleDCommand = false;
		
		if(command.indexOf("D") == 0 && command.length() ==1)
			isEmptyDCommand = true;
		else if(command.indexOf("D") == 0 && command.charAt(1) == ',') {
			if(command.indexOf(',') == command.lastIndexOf(','))
				isSingleDCommand = true;
			else
				isDoubleDCommand = true;
		}
		
		
		
		if(isDoubleDCommand && isEmptyDCommand && isSingleDCommand )
			return false;
		return isDoubleDCommand ^ isEmptyDCommand  ^ isSingleDCommand ;
	}
	public static boolean isACommand(String command) {
		if(command.indexOf("A")==0 && command.length()<=2) {
			System.out.println("This is an A Command");
			return true;
		}
		return false;
	}
	public static boolean isECommand(String command) {
		if(command.indexOf("E")==0 && command.length()<=2) {
			System.out.println("This is an E Command");
			return true;
		}
		return false;
	}
	
}
