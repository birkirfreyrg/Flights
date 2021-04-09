package Flight;

import java.util.*;

public class LocationController {
	
	private List<Location> locations = new ArrayList<Location>();
	
	public List<Location> getLocations() {
		return this.locations;
	}
	
	public void createLocations(Location newLocation) {
		locations.add(newLocation);
	}

	public static void main(String[] args) {
		List<Location> fakeData = new ArrayList<Location>();
		Location Akureyri = new Location("Akureyri");
		Location rvk = new Location("Reykjav�k");
		Location olafsvik = new Location("�lafsv�k");
		LocationController.createLocations(Akureyri);
		createLocations(rvk);
		createLocations(olafsvik);
	}

}
