import java.util.*;
public class TextEditer {
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
				iNumber = Integer.parseInt(command.substring(1));
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}
			
			
			// Case the enteredLine was normal.
			lines.addToTail(enteredLine);
			
		}
	
	}
	private static boolean isICommand(String enteredLine) {
		return enteredLine.indexOf("I") == 0 && (Character.isDigit(enteredLine.charAt(1)) || Character.isDigit(enteredLine.charAt(1)));
	}
}
