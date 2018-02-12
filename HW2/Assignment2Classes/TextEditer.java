import java.util.*;
public class TextEditer {
	static boolean isNormalICommand ;
	static boolean isEmptyICommand ;
	 static SLL<String> lines ; 
	 static Scanner myKeyb = new Scanner(System.in);
	public static void main(String...strings) {
		lines = new SLL<String>();
		while(true) {
			System.out.print((lines.length()+1)+"> ");
			String enteredLine = myKeyb.nextLine();
			String command = enteredLine.replaceAll("\\s+","");
			
			if(isICommand(command)) {
				System.out.println("This is an I command");
				int iNumber =-1;
				try {
					if(isNormalICommand) {
						iNumber = Integer.parseInt(command.substring(1));
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
			
			
			// Case the enteredLine was normal.
			else
			lines.addToTail(enteredLine);
			
		}
	
	}
	private static boolean isICommand(String command) {
		isEmptyICommand = false;
		isNormalICommand = false;
		if(command.indexOf("I") == 0 && command.length() ==1)  {
			isEmptyICommand = true;
			System.out.println("Empty Command");
		}
		else if(command.indexOf("I") == 0 && Character.isDigit(command.charAt(1))) {
			isNormalICommand = true;
			System.out.println("Normal Command");
		}
		return isEmptyICommand || isNormalICommand;
	}
}
