package Q3;

public class RecursionClass {
static double sum=0;
	 public static double addOverNs(int n){
		 if(n==1)
			 return 1;
		 double number = 1.0/n;
		 if(n%2==0)
		 sum += number;
		 else
			 sum-=number;
		 return  addOverNs(n-1)+sum ;
	 }
	 
	 static void cubes (int n) 
	 { 
		 for (int i = 1; i <=n; i++) 
			 System.out.println(i * i * i + "");
	 
	 }
	 static void recursiveCubes(int n) {
		 if(n==1) {
			 System.out.println((int)n);
			 return;
		 }
		 
			 recursiveCubes(n-1);
			 System.out.println((int)Math.pow(n, 3));
		 
	 }
	public static void main(String...strings ) {
		recursiveCubes(10);
		cubes(10);
		System.out.println(addOverNs(5));
	}
	 
}
