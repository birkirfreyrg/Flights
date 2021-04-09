package Flight;

public class Location {
	
	private String name;
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String setName) {
		name = setName;
	}
	
	Location(String newName) {
		name = newName;
	}
	
	public String toString() {
		String string = String.format("Location: %s", name);
		return string;
	}

	public static void main(String[] args) {
		Location Akureyri = new Location("Akureyri");
		Location rvk = new Location("Reykjav�k");
		Location olafsvik = new Location("�lafsv�k");
		System.out.println(Akureyri.name);
		System.out.println(rvk.name);
		System.out.println(olafsvik.name);
	}

}
