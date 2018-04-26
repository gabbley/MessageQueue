
/**
 * <h1>Message</h1>Description here
 * 
 * @author Gabby Baniqued
 */
public class Message {

	private int priority;
	private int arrival;
	private int wait;
	
	/**
	 * Constructor for Message
	 * 
	 * @param p
	 * 			priority of Message			
	 * 
	 * @param arr
	 * 			time of arrival
	 *
	 */
	public Message(int p, int arr){
		priority = p;
		arrival = arr;
		wait = arr;
	}

	/**
	 * getter for priority of message
	 * 
	 * @return int priority
	 *
	 */
	public int getPriority() {
		return priority;
	}

	/**
	 * getter for arrival time of message
	 * 
	 * @return int arrival
	 *
	 */
	public int getArrival() {
		return arrival;
	}
	
	/**
	 * getter for waiting time of message
	 * 
	 * @return int wait
	 *
	 */
	public int getWait() {
		return wait;
	}
	
	/**
	 * setter for waiting time of message
	 * 
	 * param w
	 * 		wait time
	 *
	 */
	public void incWait() {
		wait++;
	}
	
	
	public String toString(){
		return "priority: " + priority + "\narrival: " + arrival + "\nwait: " + wait;
	}

	
}
