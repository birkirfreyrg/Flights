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
		Location Akureyri = new Location("Akureyri");
		Location rvk = new Location("Reykjavík");
		Location olafsvik = new Location("Ólafsvík");
		LocationController lc = new LocationController();
		lc.createLocations(Akureyri);
		lc.createLocations(rvk);
		lc.createLocations(olafsvik);
		List<Location> fakeData = new ArrayList<Location>();
		fakeData = lc.getLocations();
		System.out.println(fakeData.toString());
	}
}
