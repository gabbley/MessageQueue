
/**
 * <h1>Message</h1>Description here
 * 
 * @author Gabby Baniqued
 */
public class Message {

	private int priority;
	private int arrival;
	
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
	
	public String toString(){
		return "priority: " + priority + "\narrival: " + arrival;
	}

	
}
