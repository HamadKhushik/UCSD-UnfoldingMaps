package module5;

import java.util.ArrayList;
import java.util.List;

import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.data.PointFeature;
import de.fhpotsdam.unfolding.marker.Marker;
import de.fhpotsdam.unfolding.utils.ScreenPosition;
import processing.core.PGraphics;

/** Implements a visual marker for ocean earthquakes on an earthquake map
 * 
 * @author UC San Diego Intermediate Software Development MOOC team
 * @author Your name here
 *
 */
public class OceanQuakeMarker extends EarthquakeMarker {
	
	public UnfoldingMap map;
	public List<Marker> cm;
	private CommonMarker lastClickedO;
	
	public OceanQuakeMarker(PointFeature quake, UnfoldingMap map2, List<Marker> cm2) {
		super(quake);
		map = map2;
		cm = cm2;
		// setting field in earthquake marker
		isOnLand = false;
	}
	
	

	/** Draw the earthquake as a square */
	@Override
	public void drawEarthquake(PGraphics pg, float x, float y) {
		pg.rect(x-radius, y-radius, 2*radius, 2*radius);


		// to draw lines between Markers!!
		
//		if (getClicked() == true) {
//			//System.out.println("Ocean quake clicked");
//			ArrayList<ScreenPosition> sps = new ArrayList<ScreenPosition>();
//
//
//			if (cm != null) {
//				for (Marker m : cm) {
//					if (!m.isHidden()) {
//						ScreenPosition sp = ((CityMarker)m).getScreenPosition(map);
//						sps.add(sp);
//
//					}
//
//					for (ScreenPosition k : sps) {
//						pg.fill(0, 0, 0);
//						//pg.noStroke();
//						pg.line(k.x-200, k.y-50, x-radius, y-radius);
//					}
//				}
//			}
//		}
	}
}
