/**
 * The PlaneComparator class overrides the
 * compare method in Java's Comparator
 * so that Plane objects can be compared
 * 
 * @author Lacey Cottner
 *@version 1.0
 *@since 12-06-2021
 *
 */
import java.util.Comparator;

public class PlaneComparator implements Comparator<Plane>{

	@Override
	public int compare(Plane o1, Plane o2) {
		if (o1.getCreation()<o2.getCreation())
			return -1;
		else if (o1.getCreation()>o2.getCreation()) 
			return 1;
		else
			return 0;
		
	}
	

}
