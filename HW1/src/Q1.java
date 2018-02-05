
//Abdullah Barnawi
// ID#:201549390

import java.util.Random;

public class Q1{
	public static void main(String[] args) {
		Random rnd = new Random();
		Random binrnd = new Random();
		Student[] stu = new Student[10];
		for(int i=0;i<stu.length;i++) {
			if(binrnd.nextBoolean())
				stu[i] = new Graduate(rnd.nextInt(1500), 4*rnd.nextDouble() );
			else 			stu[i] = new Undergraduate(rnd.nextInt(100), 4*rnd.nextDouble());

		}
	/*	for(int i=0;i<stu.length;i++)
			System.out.println(stu[i].toString());*/
		for(int i=0;i<stu.length;i++)
			stu[i].displayStudent();
	}
}
 abstract class Student {
protected int id;
protected double gpa;


public Student() {
	id=0;
	gpa =0;
}

public Student(int id,double gpa) {
	if (gpa>=4 || gpa<0) throw new IllegalArgumentException("Gpa generated is = "+gpa);
	this.id = id;
	this.gpa= gpa;
	
	
}

public  abstract String getStatus();

public final void displayStudent() {
	
	System.out.println(this.toString());
 }
public String toString() {
	
	return "ID#: " +id +" GPA: "+ gpa ;
}
}

class Graduate extends Student {
	public   String getStatus() {
		if (this.gpa >=3) {
			return "Good";
		}
		else
			return "Probation";
		
	}

	public Graduate() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Graduate(int id, double gpa) {
		super(id, gpa);
		// TODO Auto-generated constructor stub
	}
	public String toString() {
		return getClass()+"[ "+super.toString()+" Status: "+getStatus()+" ]";	}

}
class Undergraduate extends Student {
	public   String getStatus() {
		if (this.gpa >=3) {
			return "Honor";
		}
		else if (this.gpa >=2) {
			return "Probation";
		}
		else
			return "Probation";
		
	}

	public Undergraduate() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Undergraduate(int id, double gpa) {
		super(id, gpa);
		// TODO Auto-generated constructor stub
	}
	public String toString() {
		return getClass()+"[ "+super.toString()+"Status: "+getStatus()+" ]";
	}

}