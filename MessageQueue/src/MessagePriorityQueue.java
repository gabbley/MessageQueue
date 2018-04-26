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
	private static ArrayList<Message> messages;
	private static ArrayList<Message> processedMessages;

	final static int MESSAGE_NUM = 15;
	final static int LIMIT = 10000;

	/**
	 * Assigns messages to queues based on priority
	 * 
	 * @param m
	 *            Message to be added to its respective queue
	 *
	 */
	public static void assignQueue(Message m) {
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
		Queue<Message> q1 = new LinkedList<Message>();
		Queue<Message> q2 = new LinkedList<Message>();
		Queue<Message> q3 = new LinkedList<Message>();
		Queue<Message> q4 = new LinkedList<Message>();
		Queue<Message> q5 = new LinkedList<Message>();

		qs.add(q1);
		qs.add(q2);
		qs.add(q3);
		qs.add(q4);
		qs.add(q5);
	}

	/**
	 * Processes messages and orders them based on priority and arrival time
	 *
	 */
	public static void processMessage() {
		int time = 0;
		for (time = 0; time < MESSAGE_NUM; time++) { // add 15 messages
			assignQueue(new Message((int) (Math.random() * 5), time));
		}

		for (; time < LIMIT; time++) {
			assignQueue(new Message((int) (Math.random() * 5), time));
		}

		// iterate through queues
		// until the queues are empty

		for (int i = 0; i < qs.size(); i++) {
			Queue<Message> q = qs.get(i); // check if empty
			if (!q.isEmpty()) {
				Message m = q.peek();
				System.out.println(m);
				if (time - m.getArrival() >= 4) {
					processedMessages.add(q.remove());
					System.out.println("added to processed msg\n");
					m.incWait();
				}
			}
		}

		while (!allEmpty()) {
			for (Queue<Message> q : qs)
				if (!q.isEmpty())
					q.remove();
		}

	}

	/**
	 * Returns true if all of the queues are empty
	 * 
	 * @return boolean true if queues are empty, false otherwise
	 */
	public static boolean allEmpty() {
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

		return time / processedMessages.size();
	}

	public static void main(String[] args) {
		qs = new ArrayList<Queue<Message>>();
		messages = new ArrayList<Message>();
		processedMessages = new ArrayList<Message>();
		fillArr();
		processMessage();
		System.out.println(waitTime());
	}
}
