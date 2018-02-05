/*
 * Name : Abdullah Barnawi
 * ID#:201549390
 */

import java.util.Scanner;

public class Q2 {
	public static void main(String...strings) {
		/* Full Testing Aproach.
		 * Fraction fr1 = new Fraction(2, 6);
		Fraction fr2 = new Fraction(5, 4);
		Fraction fr3 = fr1.multiply(fr2);
		Fraction fr4 = fr1.devide(fr2);
		Fraction fr5 = fr1.add(fr2);
		Fraction fr6 = fr1.subtract(fr2);
		System.out.println(fr3.toString());
		System.out.println(fr4.toString());
		System.out.println(fr5.toString());
		System.out.println(fr6.toString());*/
		boolean exitTriggered = false;
		Scanner myKeyb= new Scanner(System.in);
		String fractionHolder = "";
		int choice=0;
		Fraction fr1 =null,fr2=null;
		while(!exitTriggered) {
			System.out.println("1-Enter one Fraction\n2-Enter two Fractions\n3-Exit\n");
			 choice =myKeyb.nextInt();
			 myKeyb.nextLine();
			if(choice ==3)
				return;
			if (choice ==2) {
				System.out.println("\nEnter Fraction 1:\n");
				try {
				fractionHolder = myKeyb.nextLine();
				fr1 = new Fraction(Integer.parseInt(fractionHolder.substring(0,fractionHolder.indexOf("/") )), Integer.parseInt(fractionHolder.substring(fractionHolder.indexOf("/")+1)));
				}
				catch(Exception e) {
					System.out.println("An error has occured ... Exiting"); return;
				}
				
				System.out.println("\nEnter Fraction 2:\n");
				try {
				fractionHolder = myKeyb.nextLine();
				fr2 = new Fraction(Integer.parseInt(fractionHolder.substring(0,fractionHolder.indexOf("/") )), Integer.parseInt(fractionHolder.substring(fractionHolder.indexOf("/")+1)));
				}
				catch(Exception e) {
					System.out.println("An error has occured ... Exiting"); return;
				}
				System.out.println("1-Display\n2-Add\n3-Subtract\n4-Multiply\n5-Devide\n6-Exit");
				choice =myKeyb.nextInt();
				myKeyb.nextLine();
				if(choice ==6) return;
				if(choice ==1) System.out.println(fr1+" "+fr2);
				if(choice ==2) System.out.println(fr1.add(fr2));
				if(choice ==3) System.out.println(fr2.subtract(fr2));
				if(choice ==4) System.out.println(fr1.multiply(fr2));
				if(choice ==5) System.out.println(fr1.devide(fr2));
					
				
			}
			if (choice ==1) {
				System.out.println("\nEnter one Fraction:\n");
				try {
				fractionHolder = myKeyb.nextLine();
				fr1 = new Fraction(Integer.parseInt(fractionHolder.substring(0,fractionHolder.indexOf("/") )), Integer.parseInt(fractionHolder.substring(fractionHolder.indexOf("/")+1)));
				}
				catch(Exception e) {
					System.out.println("An error has occured ... Exiting"); return;
				}
				System.out.println("1-Display Fraction\n2-Exit");
				choice =myKeyb.nextInt();
				myKeyb.nextLine();
				if(choice ==2) return;
				if(choice ==1) System.out.println(fr1);
			}
		}
		
		
	}

}

class Fraction {
	public  int num;
	public  int den;
	public double value;
	/*public int simpleNum;
	public int simpleDen;*/
	 public Fraction(int num,int den) {
		 if (den ==0) {
			throw new IllegalArgumentException("Cant have the Devisor to be zero");
		}
		 this.num=num;
		 this.den=den;
		 if (num ==0) {
			this.den=1;
			
		}
		 simplify();
		 value = num/den;
	 }
	 public static int getSimplificaitonFactor(int num,int den) {
		 int factor=1;
		 for(int i=2;i<=Math.min(den, num);i++)
			 if(num%i==0 && den%i==0)
				 factor*=i;
		/* Debugging Message
		 * System.out.println(factor+ " is the factor");*/
		 return factor;
	 }
	 public  void simplify() {
		  int factor= getSimplificaitonFactor(num, den);
		  num /=factor;
		  den /=factor;
		  
	 }
	 public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
		simplify();
	}
	public int getDen() {
		return den;
	}
	public void setDen(int den) {
		this.den = den;
		simplify();
	}
	public String toString() {
		 return num + "/" +den;
	 }
	public  Fraction multiply(Fraction other) {
		Fraction result = new Fraction(num*other.num, den*other.den);
		System.out.println(this.toString()+" * "+other.toString()+" = "+result.toString());
		return result;
	}
public  Fraction devide(Fraction other) {
	Fraction result = new Fraction(num*other.den, den*other.num);
	System.out.println(this.toString()+" / "+other.toString()+" = "+result.toString());
		return result;
	}
public  Fraction add(Fraction other) {
	Fraction result = new Fraction(1, 1);
	result.setDen(this.den*other.den);
	result.setNum((other.den*this.num)+(this.den*other.num));
	System.out.println(this.toString()+" + "+other.toString()+" = "+result.toString());
		return result;
	}
public  Fraction subtract(Fraction other) {
	Fraction result = new Fraction(1, 1);
	result.setDen(this.den*other.den);
	result.setNum((other.den*this.num)-(this.den*other.num));
	System.out.println(this.toString()+" - "+other.toString()+" = "+result.toString());
		return result;
	}
	
	
}
