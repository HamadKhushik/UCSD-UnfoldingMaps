package module6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.data.PointFeature;
import de.fhpotsdam.unfolding.data.ShapeFeature;
import de.fhpotsdam.unfolding.marker.Marker;
import de.fhpotsdam.unfolding.marker.SimpleLinesMarker;
import de.fhpotsdam.unfolding.marker.SimplePointMarker;
import de.fhpotsdam.unfolding.utils.MapUtils;
import de.fhpotsdam.unfolding.geo.Location;
import parsing.ParseFeed;
import processing.core.PApplet;

/**
 * An applet that shows airports (and routes) on a world map.
 * 
 * @author Adam Setters and the UC San Diego Intermediate Software Development
 *         MOOC team
 *
 */
public class AirportMap extends PApplet {

	UnfoldingMap map;
	private List<Marker> airportList;
	List<Marker> routeList;

	private CommonMarker lastSelected;
	private CommonMarker lastClicked;
	private HashSet<String> set;
	private String country; // for user input

	public void setup() {
		// setting up PAppler
		size(800, 600, OPENGL);

		// setting up map and default events
		map = new UnfoldingMap(this, 50, 50, 750, 550);
		MapUtils.createDefaultEventDispatcher(this, map);

		// get features from airport data
		List<PointFeature> features = ParseFeed.parseAirports(this, "airports.dat");

		// list for markers, hashmap for quicker access when matching with routes
		airportList = new ArrayList<Marker>();
		HashMap<Integer, Location> airports = new HashMap<Integer, Location>();

		// create markers from features
		for (PointFeature feature : features) {
			AirportMarker m = new AirportMarker(feature);

			m.setRadius(5);
			airportList.add(m);

			// put airport in hashmap with OpenFlights unique id for key
			airports.put(Integer.parseInt(feature.getId()), feature.getLocation());

		}

		// parse route data
		List<ShapeFeature> routes = ParseFeed.parseRoutes(this, "routes.dat");
		routeList = new ArrayList<Marker>();
		for (ShapeFeature route : routes) {

			// get source and destination airportIds
			int source = Integer.parseInt((String) route.getProperty("source"));
			int dest = Integer.parseInt((String) route.getProperty("destination"));

			// get locations for airports on route
			if (airports.containsKey(source) && airports.containsKey(dest)) {
				route.addLocation(airports.get(source));
				route.addLocation(airports.get(dest));
			}

			SimpleLinesMarker sl = new SimpleLinesMarker(route.getLocations(), route.getProperties());

			// System.out.println(sl.getProperties());

			// UNCOMMENT IF YOU WANT TO SEE ALL ROUTES
			routeList.add(sl);
		}

		// UNCOMMENT IF YOU WANT TO SEE ALL ROUTES
		map.addMarkers(routeList);
		hideRoutes();

		airportList = subset();
		map.addMarkers(airportList);
		// map.addMarkers(countryList);

	}

	public void draw() {
		background(0);
		map.draw();

	}

	@Override
	public void mouseMoved() {
		// clear the last selection
		if (lastSelected != null) {
			lastSelected.setSelected(false);
			lastSelected = null;

		}
		selectMarkerIfHover(airportList);
		// loop();
	}

	// If there is a marker selected
	private void selectMarkerIfHover(List<Marker> markers) {
		// Abort if there's already a marker selected
		if (lastSelected != null) {
			return;
		}

		for (Marker m : markers) {
			CommonMarker marker = (CommonMarker) m;
			if (marker.isInside(map, mouseX, mouseY)) {
				lastSelected = marker;
				marker.setSelected(true);
				return;
			}
		}
	}

	@Override
	public void mouseClicked() {
		if (lastClicked != null) {
			unhideMarkers();
			lastClicked = null;
		} else if (lastClicked == null) {
			checkAirportsForClick();

		}
	}

	// Helper method that will check if an airport marker was clicked on
	// and respond appropriately
	private void checkAirportsForClick() {
		String source;
		if (lastClicked != null)
			return;
		
		// Loop over the airport markers to see if one of them is selected
		for (Marker marker : airportList) {
			if (!marker.isHidden() && marker.isInside(map, mouseX, mouseY)) {
				lastClicked = (CommonMarker) marker;
				
				// Add all the Airport codes on routes out of the CLicked Airport in a HashSet
				set = new HashSet<String>();  // set of all the airport codes out of the CLICKED airport
				source = (String) marker.getProperty("code");  // get the code of the Clicked Airport
				System.out.println(source);
				for (Marker route : routeList) {
					
					// condition to check if the Clicked airport is either Destination or Source in the Route
					if (route.getProperty("sCode").equals(source) || route.getProperty("dCode").equals(source)) {  
						route.setHidden(false);  // if true, unhide the Route
						set.add((String) route.getProperty("sCode"));  // add the codes to Set
						set.add((String) route.getProperty("dCode"));  // add the codes to Set
					} else {
						route.setHidden(true);
					}

				}
				// Hide all the other airports
				for (Marker mhide : airportList) {
					// condition to check i the Airport was clicked or is on any Route out of the Clicked Airport
					if (mhide != lastClicked && !(set.contains(mhide.getProperty("code")))) {
						mhide.setHidden(true);
					}
				}
				return;
			}
		}
	}

	// loop over and unhide all markers and routes
	private void unhideMarkers() {
		for (Marker marker : airportList) {
			marker.setHidden(false);
		}

//		for (Marker route : routeList) {
//			route.setHidden(false);
//		}

	}

	// loop over and hide all routes
	  private void hideRoutes() {
	  
	  for (Marker m : routeList) { m.setHidden(true); }
	  
	  }
	 
	 

	public List<Marker> subset() { // create a subset of airports as per user input

		Scanner sc = new Scanner(System.in); // to read in the user input
		System.out.println("Enter the country to view the Airports/ Press Enter to view all the airports in the world");
		country = sc.nextLine();
		if (country.equals("")) {  // if user hits "Enter" show all the routes
			return airportList;
		}
		HashSet<String> countrySet = new HashSet<String>(); // create a set for countries in the file
		for (Marker m : airportList) {

			countrySet.add((String) m.getProperty("country")); // add the countries in the file to set
		}
		while (!countrySet.contains(country)) {
			System.out.println("The Country entered is not correct, Please enter again"); // check if country is in the
																							// file
			country = sc.nextLine();
			
		}

		ArrayList<Marker> countryList = new ArrayList<Marker>();
		for (Marker m : airportList) {
			if (m.getProperty("country").equals(country)) { // if the airport is in the selected country add it into the
															// list
				countryList.add(m);
			}
		}
		return countryList;
	}


}
