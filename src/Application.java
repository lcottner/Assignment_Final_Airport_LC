/**
 * The Application class holds the main method
 * which creates a timer for the Helper class
 * @author Lacey Cottner
 *@version 1.0
 *@since 12-06-2021
 *
 */
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;

public class Application {

	public static void main(String []args) {
		
		System.out.println("Every timestep is one minute");
		System.out.println("There is a 30% chance to generate a plane");
		System.out.println("There is a 10% chance for a plane to generate an emergency");
		System.out.println("If a plan has an emergency, it will be added to the priority queue");
		System.out.println("The comparator for the priority queue is based off the time step generation");
		System.out.println("Aka if two planes both have an emergency, the one that was created first will take precedence");


		
		Timer timer = new Timer();
	    TimerTask task = new Helper();
	         
	    timer.schedule(task, 2000, 5000);
		
	}
}
