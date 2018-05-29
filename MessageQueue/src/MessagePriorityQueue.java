import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * <h1>MessagePriorityQueue</h1>Description here
 * 
 * @author Gabby Baniqued
 */
public class MessagePriorityQueue {

	private static ArrayList<Queue<Message>> qs;
	private static ArrayList<Message> processedMessages;
	private static int time;

	final static int MESSAGE_NUM = 15;
	final static int QUEUE_NUM = 5;
	final static int LIMIT = 10000;

	MessagePriorityQueue() {
		fillArr();
		time = 0;
	}

	/**
	 * Assigns messages to queues based on priority
	 * 
	 * @param m
	 *            Message to be added to its respective queue
	 *
	 */
	public static void add(Message m) {
		int p = m.getPriority();
		switch (p) {
		case 0:
			qs.get(0).add(m);
			break;
		case 1:
			qs.get(1).add(m);
			break;
		case 2:
			qs.get(2).add(m);
			break;
		case 3:
			qs.get(3).add(m);
			break;
		case 4:
			qs.get(4).add(m);
			break;
		default:
			System.out.println("Message has invalid priority");
		}
	}

	/**
	 * Fills array with 5 queues for each priority
	 */
	public static void fillArr() {
		for (int i = 0; i < QUEUE_NUM; i++) {
			qs.add(new LinkedList<Message>());
		}
	}

	
	
	/**
	 * Processes messages and orders them based on priority and arrival time
	 *
	 */
//	
//	public static void processMessage(){
//		
//	}
	public static void processMessage() {
		for (time = 0; time < MESSAGE_NUM; time++) { // add 15 messages
			add(new Message((int) (Math.random() * 5), time));
		}

		int wait = 0;

		// iterate through queues
		// until the queues are empty
		int i = 0;

		for (; time < LIMIT; time++) {

			Queue<Message> q = qs.get(i); // check if empty, each of the 5
											// queues

			if (!q.isEmpty()) { // until the end of each queue
				Message m = q.peek(); // highest priority message
				wait = time - m.getArrival();
				if (wait >= 4) {
					processedMessages.add(q.remove());
					m.incWait();
					System.out.println(m);
					System.out.println("added to processed msg\n");
					add(new Message((int) (Math.random() * 5), time));
				}
	
				if (i < 4)
					i++;
			}

		}

		while (!isEmpty()) {
			for (Queue<Message> q : qs) {
				if (!q.isEmpty()){
					q.peek().incWait();
					processedMessages.add(q.peek());
					q.remove();
				}
			}
		}

	}

	/**
	 * Returns true if all of the queues are empty
	 * 
	 * @return boolean true if queues are empty, false otherwise
	 */
	public static boolean isEmpty() {
		boolean b = true;
		for (Queue<Message> q : qs) {
			if (!q.isEmpty()) {
				b = false;
				return b;
			}
		}
		return b;
	}

	/**
	 * Calculates the average wait time of Messages
	 * 
	 * @return int average wait time
	 */
	public static int waitTime() {
		int time = 0;
		for (Message m : processedMessages)
			time += m.getWait();

		//System.out.println(processedMessages.size());
		return time / processedMessages.size();
	}

	public static void main(String[] args) {
		qs = new ArrayList<Queue<Message>>();
		processedMessages = new ArrayList<Message>();
		fillArr();
		processMessage();
//		System.out.println(waitTime());
//		System.out.println(processedMessages);
		
		for (Message m : processedMessages)
			System.out.println(m);
	}
}

