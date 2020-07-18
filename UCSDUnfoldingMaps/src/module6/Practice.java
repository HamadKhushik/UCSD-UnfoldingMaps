///*
// * package module6;
// * 
// * import java.util.ArrayList; import java.util.List;
// * 
// * import demos.Airport;
// * 
// * // linear search practice to search airport code public class Practice {
// * 
// * private String city; private String country; private String code;
// * 
// * public Practice(String ci, String co, String cd) { city = ci; country = co;
// * cd = code;
// * 
// * }
// * 
// * public void readData() { List<Practice> data = new ArrayList<Practice>();
// * 
// * } // Binary Search Algorithm public String getCode(Practice p, String toFind)
// * {
// * 
// * int low = 0; int high = airports.length; int mid;
// * 
// * while (low <= high) { mid = low + (high - low)/2; // to get the result in
// * range of int //(low + high)/2; int compare =
// * toFind.compareTo(airports[mid].getCity()); if (compare < 1) { high = mid - 1;
// * } else if (compare > 1) { low = mid + 1; } else return
// * airports[mid].getCode();
// * 
// * } return null; }
// * 
// * 
// * }
// */