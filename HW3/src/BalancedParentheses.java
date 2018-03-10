
public class BalancedParentheses {
	String inputStream;
	LLStack prReader = new LLStack();
	
	
	public String removeNonparanthesis(String expression) {
		
		
		return expression.replaceAll("[^{}\\[\\]()]", "");
	}
	public boolean readParanthesis(String expression, int i) {
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
	}
	
	public static void main(String...strings ) {
		String sth = "He(ll}o [Wo]lr([]d) This( is an E)xpression";
	BalancedParentheses bp = new BalancedParentheses();
	System.out.println(bp.isValidExpression(sth));
	System.out.println(bp.prReader);
	
	}

}
