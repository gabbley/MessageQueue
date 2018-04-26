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

	/**
	 * Assigns messages to queues based on priority
	 * 
	 * @param m
	 * 		Message to be added to its respective queue
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
		// arrival time and priority are always the same, dont change
		// removes things out of queues in order of priorty? but where do they
		// go vvv
		// i can put them in another data structure
		// pre fill with about 15 messages
		// post iteration, empty

		qs.add(q1);
		qs.add(q2);
		qs.add(q3);
		qs.add(q4);
		qs.add(q5);
	}

	/**
	 * Processes messages and orders them based on priority and arrival time
	 * 
	 * @return int priority
	 *
	 */
	public static void processMessage() {
		for (int i = 0; i < MESSAGE_NUM; i++) { // add 15 messages to arrayList
			messages.add(new Message((int) (Math.random() * 5), i));
		}

		int n = 0;
		for (n = 0; n < messages.size(); n++) {
			assignQueue(messages.get(n)); // fill queues based on priority
		}

		// iterate through queues
		while (!allEmpty()) { // until the queues are empty
			for (int i = 0; i < qs.size(); i++) {
				Queue<Message> q = qs.get(i);
				for (int j = 0; j < q.size(); j++) { // iterate through messages
					Message m = q.peek();
					System.out.println(m);
					System.out.println(m.getPriority());
					if (j - m.getArrival() >= 4) {
						processedMessages.add(q.remove());
					}
				}
			}
		}
	}

	/**
	 * Returns true if all of the queues are empty
	 * 
	 * @return boolean
	 * 		true if queues are empty, false otherwise
	 */
	public static boolean allEmpty() {
		boolean b = true;
		for (Queue<Message> q : qs) {
			if (!q.isEmpty())
				b = false;
		}
		return true; 
	}

	public static void main(String[] args) {
		qs = new ArrayList<Queue<Message>>();
		messages = new ArrayList<Message>();
		processedMessages = new ArrayList<Message>();
		fillArr();
		processMessage();
		System.out.println(qs);
		System.out.println(processedMessages);
	}
}
