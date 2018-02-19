import java.util.*;
public class TextEditer {
	static boolean isNormalICommand ;
	static boolean isEmptyICommand ;
	static boolean isEmptyDCommand;
	static boolean isSingleDCommand;
	static boolean isDoubleDCommand;
	 static SLL<String> lines ; 
	 static Scanner myKeyb = new Scanner(System.in);
	public static void main(String...strings) {
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
			
			
			
			// Case the enteredLine was normal.
			else
			lines.addToTail(enteredLine);
			
		}
	
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
			System.out.println("Something Went wrong with the D NUmbets");
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
			
			}
			if(isEmptyICommand) {
				lines.deleteAllFrom(lines.length());
			}
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
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
}
