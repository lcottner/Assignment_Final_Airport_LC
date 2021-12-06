/**
 * The Helper class holds the main timestep loop
 * for generating planes, generating emergencies,
 * updating distances, and updating the queues
 * 
 * @author Lacey Cottner
 *@version 1.0
 *@since 12-06-2021
 *
 */
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;
 
class Helper extends TimerTask
{
    public static int a = 0;
    private int count=0;
	public LinkedList <Plane> link=new LinkedList<Plane>();
	public Airport airport = new Airport();
	public String landed="";
    
    
	/**
	   * The run method contains the processes
	   * that will run in each timestep
	   * 
	   * @param unused
	   * @return nothing
	   */
    public void run()
    {
    	System.out.println("----------------------------");
        System.out.println("Timestep: " + ++a + " minute(s)");
        
      //30% chance to generate a plane  
      if (Math.random()<.30)
    	  adding();
      else {
    	  System.out.println("No plane was generated");
      }
      Airport.state();
      
      if (Airport.runway==true)
    	 if  (Airport.timing() ==false) {
    		 linkRemove();
    		 count--;
    	 }
      System.out.println();
      
      
      	for (int i=0; i<link.size();i++) {
      	
      		
		Plane.updateDistances(link.get(i));
		
		System.out.println("Plane Id: " +link.get(i).getId());
		
		
		//10% chance to generate an emergency
		if (Math.random()<.10 && link.get(i).getDistance()>0) {
			if (link.get(i).getEmergency()==false) {
			link.get(i).emergencyUpdate();
			airport.addToPQueue(link.get(i));
			}
		}
		
		if (link.get(i).getEmergency()==false && link.get(i).getDistance()==0 && link.get(i).isWaiting() ==false) {
			airport.addToQueue(link.get(i));
			link.get(i).setWaiting(true);
		}
		
		if (link.get(i).getDistance()==0 && Airport.runway==false) {
			if (airport.peekPQueue() == null) {
				landed=airport.peekQueue().getId();
				Airport.arrived(airport.removeFromQueue());
			}
			else if (airport.peekPQueue().getDistance()==0) {
				landed=airport.peekPQueue().getId();
				Airport.arrived(airport.removeFromPQueue());
			}
				else if (airport.peekQueue() != null){
					landed=airport.peekQueue().getId();
					Airport.arrived(airport.removeFromQueue());
				}
			
			
      	}
		
		System.out.println("Distance: " + link.get(i).getDistance() + " feet away");

		System.out.println("Emergency: " + link.get(i).getEmergency());
		System.out.println();
      	}
        
      	System.out.println("----------------------------");
      	System.out.println();
      	
    }
    
    /**
	   * The adding method creates a new Plane and adds it to the linked
	   * list
	   * 
	   * @param unused
	   * @return nothing
	   */
    public void adding() {
    	link.add(new Plane(a));
    	count++;
    }
    
    
    /**
	   * The linkRemove method checks which plane
	   * has landed by using it's id
	   * and removes it from the linked list.
	   * 
	   * @param unused
	   * @return String
	   */
    public void linkRemove() {
    	for (int i=0; i<link.size(); i++) {
    		if (link.get(i).getId().equals(landed))
    		link.remove(i);
    	}
    	landed="";
    	
    }
}