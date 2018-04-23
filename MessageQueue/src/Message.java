
public class Message {

	private int priority;
	private int arrival;
	
	public Message(int p, int arr){
		priority = p;
		arrival = arr;
	}

	public int getPriority() {
		return priority;
	}
 
	public void setPriority(int priority) {
		this.priority = priority;
	}

	public int getArrival() {
		return arrival;
	}

	public void setArrival(int arrival) {
		this.arrival = arrival;
	}
	
}
