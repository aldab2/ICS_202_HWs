package Q1;

public class BalancedParentheses {
	String inputStream;
	LLStack prReader = new LLStack();
	
	
	public static String removeNonparanthesis(String expression) {
		
		
		return expression.replaceAll("[^{}\\[\\]()]", "");
	}
	/*public boolean readParanthesis(String expression, int i) {
		char symbol = expression.charAt(i);
		if(prReader.isEmpty() && (symbol==')' ||symbol=='}'  || symbol==']'  ))
			return false;
		if(prReader.isEmpty()) 
		{
			prReader.push(symbol);
			return true;
		}
			
		
		if(prReader.topEl().equals('[')) {
			if(symbol != ']')
				return false;
			prReader.pop();
		}
		else if(prReader.topEl().equals("{"))
		{
			if(symbol != '}')
				return false;
			prReader.pop();
		}
		else if(prReader.topEl().equals("("))
		{
			if(symbol != ')')
				return false;
			prReader.pop();
		}
		
		return false;
		
	}
	public boolean isValidExpression(String expression) {
		String cleanExpresion = removeNonparanthesis(expression);
		int i=0;
		while( i<cleanExpresion.length()) {
			if(!readParanthesis(cleanExpresion, i))
				return false;
			
			i++;
		}
			
		
		
		
		return true ;
	}*/
	public boolean isValidExpression(String expression) {
		expression = removeNonparanthesis(expression);
		int i=0;
		char ch ='a';
		char poppedChar= 'a';
		while(i<expression.length()) {
			ch=expression.charAt(i);
			if(ch =='(' || ch=='[' || ch=='{') {
				prReader.push(ch);
			}
			else if(ch==')' || ch==']' || ch=='}') {
			if(prReader.isEmpty())
				return false;
			poppedChar = (char) prReader.pop();
			
			if((poppedChar == '(' && ch!=')') || (poppedChar == '[' && ch!=']') || (poppedChar == '{' && ch!='}')) {
			
				return false;
			}
			}
			i++;
			
		}
		if(prReader.isEmpty())	
		return true;
		return false;
	}
	public static void main(String...strings ) {
		String sth = "Th[i(s[] i)s (an {Exp})ressi]on";
		String tester = removeNonparanthesis(sth);
	BalancedParentheses bp = new BalancedParentheses();
	System.out.println(bp.isValidExpression(sth));
	
	}

}
