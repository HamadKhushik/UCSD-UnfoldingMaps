package module6;

import java.util.List;

import de.fhpotsdam.unfolding.data.Feature;
import de.fhpotsdam.unfolding.data.PointFeature;
import de.fhpotsdam.unfolding.marker.SimpleLinesMarker;
import processing.core.PConstants;
import processing.core.PGraphics;

/** 
 * A class to represent AirportMarkers on a world map.
 *   
 * @author Adam Setters and the UC San Diego Intermediate Software Development
 * MOOC team
 *
 */
public class AirportMarker extends CommonMarker {
	public static List<SimpleLinesMarker> routes;
	
	public AirportMarker(Feature city) {
		super(((PointFeature)city).getLocation(), city.getProperties());
	
	}
	
	@Override
	public void drawMarker(PGraphics pg, float x, float y) {
		pg.fill(200,0,50);
		pg.ellipse(x, y, 5, 5);
		
		
	}

	//@Override  commenting out this line draws the title on top of markers
	public void showTitle(PGraphics pg, float x, float y) {
		 // show rectangle with title
		String name = getName() + ", " + getCountry() + ", " + getCode();
		pg.pushStyle();
		
		pg.rectMode(PConstants.CORNER);
		
		pg.stroke(110);
		pg.fill(255,255,255);
		pg.rect(x, y + 15, pg.textWidth(name) +6, 18, 5);
		
		pg.textAlign(PConstants.LEFT, PConstants.TOP);
		pg.fill(0);
		pg.text(name, x + 3 , y +18);
		
		
		pg.popStyle();
		
		// show routes
		
		
	}
	
	public String toString() {
		return getName();
	}
	
	public String getName(){
		
		return (String) getProperty("name");
	}
	
	public String getCity() {
		
		return (String) getProperty("city");
	}
	
	public String getCountry() {
		
		return (String) getProperty("country");
	}
	
	public String getCode() {
		
		return (String) getProperty("code");
	}
	
	
	
}
