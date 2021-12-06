/**
 * The Plane class holds variables
 * and methods to simulate a plane 
 * 
 * @author Lacey Cottner
 *@version 1.0
 *@since 12-06-2021
 *
 */
public class Plane {
	int ran;
	String id;
	int distance;
	int creation;
	boolean landed;
	boolean waiting;
	
	/**
	   * This is the Plane constructor
	   * @param int creation
	   */
	public Plane(int a){
		ran=(int) (Math.random()*100000);
		id= String.format("%05d", ran);
		distance=800;
		creation=a;
	}
	
	
	/**
	   * This sets the emergency variable of a 
	   * plane to true, and announces that the plane
	   * has an emergency
	   * 
	   * @param args unused.
	   * @return void
	   */
	public void emergencyUpdate() {
		emergency=true;
		System.out.println("Plane " + id + " has an emergency");
		System.out.println("It has been added to the priority queue");
	}

	/**
	   * This takes the Plane in the parameter
	   * and reduces its distance by 100
	   * until it is at 0 
	   * 
	   * @param Plane
	   * @return void
	   */
	public static void updateDistances(Plane h) {
		
		if (h.getDistance()<=0) {
			h.setDistance(0);
		}
		else
			h.setDistance(h.getDistance()- 100);
	}
	
	
	/**
	 * @return the emergency
	 */
	public boolean getEmergency() {
		return emergency;
	}

	/**
	 * @param emergency the emergency to set
	 */
	public void setEmergency(boolean emergency) {
		this.emergency = emergency;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the distance
	 */
	public int getDistance() {
		return distance;
	}

	/**
	 * @param distance the distance to set
	 */
	public void setDistance(int distance) {
		this.distance = distance;
	}
	
	/**
	 * @return the waiting
	 */
	public boolean isWaiting() {
		return waiting;
	}

	/**
	 * @param waiting the waiting to set
	 */
	public void setWaiting(boolean waiting) {
		this.waiting = waiting;
	}

	/**
	 * @return the landed
	 */
	public boolean isLanded() {
		return landed;
	}

	/**
	 * @param landed the landed to set
	 */
	public void setLanded(boolean landed) {
		this.landed = landed;
	}

	boolean emergency=false;
	
	
	/**
	 * @return the creation
	 */
	public int getCreation() {
		return creation;
	}

	/**
	 * @param creation the creation to set
	 */
	public void setCreation(int creation) {
		this.creation = creation;
	}
	
}
