package Flight;

public class Passenger {
	
	private int id;
	private String name;
	private int age;
	
	public String getName() {return this.name;}
	
	public void setName(String newName) {name = newName;}
	
	public int getAge() {return this.age;}
	
	public void setAge(int newAge) {age = newAge;}
	
	public int getId() {return this.id;}
	
	Passenger() {
		id = -1;
		name = "name";
		age = 0;
	}
	
	Passenger(String newName, int newAge) {
		id = -1;
		name = newName;
		age = newAge;
	}
	
	public String toString() {
		String string = String.format("Passenger id: %d, Passenger name: %s, Passenger age: %d\n",id, name, age);
		return string;
	}

	public static void main(String[] args) {
		Passenger p = new Passenger("John", 25);
		System.out.println(p);
	}

}
