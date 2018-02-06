
/*
 * Name : Abdullah Barnawi
 * ID#:201549390
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Q3 {
	static ArrayList<Pet> pets;
	static ArrayList<PetOwner> owners;
	static int choice = 1;
	static Scanner myKeyb;

	public static void main(String... strings) {
		pets= new ArrayList<>();
		owners = new ArrayList<>();
		generateSampleData();
		myKeyb = new Scanner(System.in);
		// try {
		while (choice != 5) {
			mainMenu();
			choice = myKeyb.nextInt();
			myKeyb.nextLine();
			switch (choice) {
			case 1:
				admitPet();
				break;
			case 2:
				listForOwner();

				break;
			case 3:
				System.out.println("Choose Kind:\n1-SwimmingPet\n2-FlyingPet");
				System.out.println("3-ReptilePet\n4-NormalPet\n");
				choice = myKeyb.nextInt();
				myKeyb.nextLine();
				if (choice == 1) {
					for (Pet p : pets) {
						if (p.getClass() == SwimmingPet.class)
							System.out.println(p);
					}
				}
				if (choice == 2) {
					for (Pet p : pets) {
						if (p.getClass() == FlyingPet.class)
							System.out.println(p);
					}
				}
				if (choice == 3) {
					for (Pet p : pets) {
						if (p.getClass() == ReptilePet.class)
							System.out.println(p);
					}
				}
				if (choice == 4) {
					for (Pet p : pets) {
						if (p.getClass() == NormalPet.class)
							System.out.println(p);
					}
				}

				break;
			case 4:
				boolean namefound = false;
				System.out.println("Enter Pet name:");
				String name = myKeyb.nextLine();

				for (Pet p : pets)
					if (p.getName().equalsIgnoreCase(name)) {
						System.out.println(p);
						namefound = true;
					}
				if (!namefound) {
					System.out.println("Pet Owner not found, Returning");
					return;
				}
				break;
			case 5:
				return;
			default:
				System.out.println("Wrong input, Terminating.");
				return;

			}
		}
		/*
		 * } catch(Exception e) { System.out.println(e.getMessage());
		 * System.out.println("Wrong input, Terminating."); return; }
		 */
	}

	public static void generateSampleData() {
		initializeOwners();

		pets.add(new NormalPet("Cat", owners.get(0), "Cat1", 3, "mouses"));
		owners.get(0).pets.add(pets.get(pets.size() - 1));
		pets.add(new NormalPet("Dog", owners.get(0), "Dog1", 5, "Cats"));
		owners.get(0).pets.add(pets.get(pets.size() - 1));
		pets.add(new NormalPet("Dog", owners.get(1), "Dog2", 7, "mouses"));
		owners.get(1).pets.add(pets.get(pets.size() - 1));
		pets.add(new FlyingPet("Eagle", owners.get(2), "Eagle", 13, "Meat"));
		owners.get(2).pets.add(pets.get(pets.size() - 1));
		pets.add(new FlyingPet("Flamingo", owners.get(2), "Flamingosta", 1, "bread"));
		owners.get(2).pets.add(pets.get(pets.size() - 1));
		pets.add(new FlyingPet("Bird", owners.get(1), "Soso", 2, "bread"));
		owners.get(1).pets.add(pets.get(pets.size() - 1));
		pets.add(new SwimmingPet("Fish", owners.get(0), "Blob", 3, "smaller fish"));
		owners.get(0).pets.add(pets.get(pets.size() - 1));
		pets.add(new SwimmingPet("Dolphin", owners.get(1), "Doplhino", 7, " Completly Anything"));
		owners.get(1).pets.add(pets.get(pets.size() - 1));
		pets.add(new ReptilePet("Snake", owners.get(2), "ScaryDude", 9, " Completly Anthing Even Humans!",true,false));
		owners.get(2).pets.add(pets.get(pets.size() - 1));
		pets.add(new ReptilePet("Turtle", owners.get(1), "NinjaTurtle", 1, "bread",false,false));
		owners.get(1).pets.add(pets.get(pets.size() - 1));



	}

	public static void listForOwner() {
		boolean namefound = false;
		System.out.println("Enter owner ID#:");
		int id = myKeyb.nextInt();
		myKeyb.nextLine();
		for (PetOwner p : owners)
			if (p.getNationalID() == id) {
				p.listPets();
				namefound = true;
			}
		if (!namefound) {
			System.out.println("Pet Owner not found, Returning");
			return;
		}
	}

	public static void initializeOwners() {
		owners.add(new PetOwner("Ali", 1));
		owners.add(new PetOwner("Abdullah", 2));
		owners.add(new PetOwner("Amir", 3));
	}

	public static void admitPet() {
		int choice = -1;

		System.out.println("Choose Pet Type: ");
		System.out.println("1-Fish");
		System.out.println("2-Bird,3-Flamingo");
		System.out.println("4-Snake,5-Spider");
		System.out.println("6-Dog,7-Cat,8-Rabbit,9-Horse,10-Hamster");
		choice = myKeyb.nextInt();
		myKeyb.nextLine();
		switch (choice) {
		/*
		 * protected String name; protected String food; protected String
		 * specialInformation; protected int age; protected boolean isPoisonous;
		 * protected boolean isNocturnal; protected PetOwner owner;
		 */
		case 1:
			pets.add(new SwimmingPet("Fish"));
			readPetInfo();
			break;
		case 2:
			pets.add(new FlyingPet("Bird"));
			readPetInfo();
			break;
		case 3:
			pets.add(new FlyingPet("Flamingo"));
			readPetInfo();
			break;
		case 4:
			pets.add(new ReptilePet("Snake"));
			readPetInfo();
			System.out.println("Is the Snake poisonus?");
			pets.get(pets.size() - 1).setPoisonous(myKeyb.nextBoolean());
			System.out.println("Is the Snake nocturnal?");
			pets.get(pets.size() - 1).setNocturnal(myKeyb.nextBoolean());
			break;
		case 5:
			pets.add(new ReptilePet("Spider"));
			readPetInfo();
			System.out.println("Is the Spider poisonus?");
			pets.get(pets.size() - 1).setPoisonous(myKeyb.nextBoolean());
			System.out.println("Is the Spider nocturnal?");
			pets.get(pets.size() - 1).setNocturnal(myKeyb.nextBoolean());
			break;
		case 6:
			pets.add(new NormalPet("Dog"));
			readPetInfo();
			break;
		case 7:
			pets.add(new NormalPet("Cat"));
			readPetInfo();
			break;
		case 8:
			pets.add(new NormalPet("Rabbit"));
			readPetInfo();
			break;
		case 9:
			pets.add(new NormalPet("Horse"));
			readPetInfo();
			break;
		case 10:
			pets.add(new NormalPet("Hamster"));
			readPetInfo();
			break;

		}

	}

	public static void readPetInfo() {
		boolean namefound = false;
		System.out.println("Enter pet owner ID#:");
		int id = myKeyb.nextInt();
		myKeyb.nextLine();
		for (PetOwner p : owners)
			if (p.getNationalID() == id) {
				pets.get(pets.size() - 1).setOwner(p);
				p.pets.add(pets.get(pets.size() - 1));
				namefound = true;
			}
		if (!namefound) {
			System.out.println("Pet Owner not found, Terminating");
			System.exit(0);
		}
		System.out.println("Enter pet name:");
		pets.get(pets.size() - 1).setName(myKeyb.nextLine());
		System.out.println("Enter pet age:");
		pets.get(pets.size() - 1).setAge(myKeyb.nextInt());
		myKeyb.nextLine();
		System.out.println("Enter pet food type:");
		pets.get(pets.size() - 1).setFood(myKeyb.nextLine());

	}

	public static void mainMenu() {
		System.out.println("Main Menu\n___________________________________________________");
		System.out.println("1-Admit new Pet\n2-List all pets of a certain owner\n3-List all pets of a certain kind");
		System.out.println("4-List all info regarding a certain pet\n5-Exit");
	}
}

class PetOwner {
	private String name;
	private int nationalID;
	public ArrayList<Pet> pets;

	public PetOwner(String name, int nationalID) {
		super();
		this.name = name;
		this.nationalID = nationalID;
		this.pets = new ArrayList<Pet>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNationalID() {
		return nationalID;
	}

	public void setNationalID(int nationalID) {
		this.nationalID = nationalID;
	}

	public ArrayList<Pet> getPets() {
		return pets;
	}

	public void setPets(ArrayList<Pet> pets) {
		this.pets = pets;
	}

	public void listPets() {
		for (Pet p : pets)
			System.out.println(p);
	}

	@Override
	public String toString() {

		return "Name " + name + " NationalID#: " + nationalID;
	}

}

abstract class Pet {
	protected String type;
	protected String name;
	protected String food;
	protected String specialInformation;
	protected int age;
	protected boolean isPoisonous;
	protected boolean isNocturnal;
	protected PetOwner owner;

	public Pet(String type, PetOwner owner, String name, int age, String food, boolean isPoisonous,
			boolean isNocturnal) {
		super();
		this.type = type;
		this.owner = owner;
		this.name = name;
		this.age = age;
		this.food = food;
		this.isPoisonous = isPoisonous;
		this.isNocturnal = isNocturnal;
		specialInformation = "";

	}

	public Pet(String type) {
		this.type = type;
		name = "";
		food = "";
		specialInformation = " ";
		age = 0;
		isPoisonous = false;
		isNocturnal = false;
		owner = null;

	}

	public String getSpecialInformation() {
		return specialInformation;
	}

	public void setSpecialInformation(String specialInformation) {
		this.specialInformation = specialInformation;
	}

	public void setOwner(PetOwner owner) {
		this.owner = owner;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFood() {
		return food;
	}

	public void setFood(String food) {
		this.food = food;
	}

	public int getAge(  ) {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isPoisonous() {
		return isPoisonous;
	}

	public void setPoisonous(boolean isPoisonous) {
		this.isPoisonous = isPoisonous;
	}

	public boolean isNocturnal() {
		return isNocturnal;
	}

	public void setNocturnal(boolean isNocturnal) {
		this.isNocturnal = isNocturnal;
	}

	public PetOwner getOwner() {

		return owner;
	}

	public String toString() {

		return getPetInfo();
	}

	public abstract String getPetInfo();

}

class SwimmingPet extends Pet {

	public SwimmingPet(String type) {
		super(type);
		specialInformation = "This animal must live in water to survive";
		isPoisonous = false;
		isNocturnal = false;
	}

	public SwimmingPet(String type, PetOwner owner, String name, int age, String food) {
		super(type, owner, name, age, food, false, false);
		specialInformation = "This animal must live in water to survive";

	}

	@Override
	public String getPetInfo() {
		// TODO Auto-generated method stub
		return ">>>Fish name: "+ name + " Type: "+type+ ". Age: "+age+" years. It eats "+food+". It is owned by "+ owner.getName()+"\n "+specialInformation;
		}

}

class FlyingPet extends Pet {

	public FlyingPet(String type) {
		super(type);
		specialInformation = "Keep away from open spaces, this animal can fly away";
		isPoisonous = false;
		isNocturnal = false;
	}
	public FlyingPet(String type, PetOwner owner, String name, int age, String food) {
		super(type, owner, name, age, food, false, false);
		specialInformation = "Keep away from open spaces, this animal can fly away";

	}

	@Override
	public String getPetInfo() {
		// TODO Auto-generated method stub
		return ">>>Bird name: "+ name + " Type: "+type+ ". Age: "+age+" years. It eats "+food+". It is owned by "+ owner.getName()+"\n "+specialInformation;
		}

}

class NormalPet extends Pet {

	public NormalPet(String type) {
		super(type);
		specialInformation = "";
		isPoisonous = false;
		isNocturnal = false;
	}
	public NormalPet(String type, PetOwner owner, String name, int age, String food) {
		super(type, owner, name, age, food, false, false);
	}

	@Override
	public String getPetInfo() {
		// TODO Auto-generated method stub
		return ">>>Pet name: "+ name + " Type: "+type+ ". Age: "+age+" years. It eats "+food+". It is owned by "+ owner.getName()+"\n "+specialInformation;
		}
}

class ReptilePet extends Pet {

	public ReptilePet(String type) {
		super(type);
		specialInformation = "";

	}
	public ReptilePet(String type, PetOwner owner, String name, int age, String food,boolean Nucturnal, boolean Poisnous) {
		super(type, owner, name, age, food, Poisnous, Nucturnal);
	}

	@Override
	public String getPetInfo() {
		String info= null;
		if(isNocturnal && isPoisonous)
		info = "It is Noncturnal and Poisonous";
		if(!isNocturnal && isPoisonous)
		info = "It is  not Noncturnal and is  Poisonous";
		if(isNocturnal && !isPoisonous)
		info = "It is Noncturnal and  notPoisonous";
		else 
		info = "It is not Noncturnal nor Poisonous";

		return ">>>Reptile name: "+ name + " Type: "+type+ ". Age: "+age+" years. It eats "+food+ " "+info+". It is owned by "+ owner.getName()+"\n "+specialInformation;
		}
}