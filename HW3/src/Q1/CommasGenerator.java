package Q1;

public class CommasGenerator {
	static String result = new String();
	public static String putCommas(Integer number) {
		
	if(number<100)
		return number+",";
	
	
		
	return result.concat(putCommas(number/100));	
	}
	
	private static String putCommas(int n) {
		if(n <= 999)
			return "" + n;
		return putCommas(n / 1000)+","+(n % 1000);
	}
	private static String putCommas(String str) {
		int n = Integer.parseInt(str);
		if(n <= 999)
			return "" + n;
		return putCommas(n / 1000)+","+(n % 1000);
	}


	
	public static void main(String...strings ) {
		System.out.println(putCommas(1234567));
		System.out.println(putCommas("1234567"));

		
	}

}
