/**
 * The Airport class initializes a queue and a priority queue
 * to simulate airplanes landing on a runway
 * @author Lacey Cottner
 *@version 1.0
 *@since 12-06-2021
 *
 */
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Airport {

	Comparator <Plane> comparator = new PlaneComparator();
	private Queue<Plane> approach= new LinkedList<Plane>();
	private PriorityQueue <Plane> readyToLand= new PriorityQueue<Plane>(100, comparator);

	public static boolean runway=false;
	private static String id;
	private static int count=5;
	

	/**
	   * The arrived method sets the runway variable to true
	   * and announces which plane is landing
	   * 
	   * @param String
	   * @return void
	   */
	public static void arrived(String a) {
		id=a;
		runway=true;
		System.out.println("Plane "+ id + " is now landing");
	}
	
	
	/**
	   * The timing method keeps track of
	   * how long the plane takes to clear
	   * the runway
	   * 
	   * @param unused
	   * @return void
	   */
	public static boolean timing(){
	System.out.println("Plane "+ id + " will land in: " + count + " minute(s)");
		
		if (count>0) {
		count--;
		return true;}
		
		else {
			System.out.println("* Plane "+ id + " has landed! *");
			count=5;
			runway=false;
			return false;
		}
	}
	
	/**
	   * The state method announces if the runway
	   * is clear if the runway is false
	   * 
	   * @param unused
	   * @return void
	   */
	public static void state() {
		if (runway==false) {
			System.out.println("The runway is clear");
		}
		
		else {
			System.out.println("The runway is occupied");
		}
	}
	
	
	/**
	   * The addToPQueue takes the Plane and adds
	   * it to the readyToLand queue
	   * 
	   * @param Plane
	   * @return void
	   */
	public void addToPQueue(Plane a) {
		readyToLand.add(a);
	}
	
	/**
	   * The peekPQueue looks at the Plane at the top of the stack
	   * of the readyToLand queue and returns it
	   * 
	   * @param unused
	   * @return Plane
	   */
	public Plane peekPQueue() {
		return readyToLand.peek();
	}
	
	/**
	   * The removeFromPQueue removes the Plane at the top of the stack
	   * of the readyToLand queue and returns it's id
	   * 
	   * @param unused
	   * @return String
	   */
	public String removeFromPQueue() {
		Plane temp=readyToLand.remove();
		return temp.getId();
	}
	
	/**
	   * The addToQueue takes the Plane and adds
	   * it to the approach queue
	   * 
	   * @param Plane
	   * @return void
	   */
	public void addToQueue(Plane a) {
		approach.add(a);
	}
	
	/**
	   * The peekQueue looks at the Plane at the top of the stack
	   * of the approach queue and returns it
	   * 
	   * @param unused
	   * @return Plane
	   */
	public Plane peekQueue() {
		return approach.peek();
	}
	
	
	/**
	   * The removeFromQueue removes the Plane at the top of the stack
	   * of the approach queue and returns it's id
	   * 
	   * @param unused
	   * @return String
	   */
	public String removeFromQueue() {
		Plane temp=approach.remove();
		return temp.getId();
	}
	
	
}
