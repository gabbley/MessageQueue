import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PriorityMessageQueue {
	private static ArrayList<Queue<Message>> qs;
	private static ArrayList<Message> processedMessages;
	private static int time;

	final static int MESSAGE_NUM = 15;
	final static int QUEUE_NUM = 5;
	final static int LIMIT = 120;
	public static int runningTime = 0;

	PriorityMessageQueue() {
		qs = new ArrayList<Queue<Message>>();
		processedMessages = new ArrayList<Message>();
		fillArr();

		for (time = 0; time < MESSAGE_NUM; time++) { // add 15 messages
			assignQueues(new Message((int) (Math.random() * 5), time));
		}

		process();
		

		for (int i = 0; i < QUEUE_NUM; i++){
			//reorderMessages(i);
			System.out.println("Average Wait Time for Priority " + i + ": " + analyze(i) + "\n");
		}

	}

	/**
	 * Assigns messages to queues based on priority
	 * 
	 * @param m
	 *            Message to be added to its respective queue
	 *
	 */
	public static void assignQueues(Message m) {
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

	public static void process() {

		for (int n = 0; n < QUEUE_NUM; n++) { // does all 5 queues
			Queue<Message> q = qs.get(n);
			while (!q.isEmpty()) {
				assignQueues(new Message((int) (Math.random() * 5), time));
				Message m = q.peek(); // top priority rn
				if (time - m.getArrival() >= 4) {
					m.setWait(time - m.getArrival());
					processedMessages.add(q.remove());
				}
				time++;
			}

		}

		while (!isEmpty()) {
			for (int n = 0; n < QUEUE_NUM; n++) { // does all 5 queues
				Queue<Message> q = qs.get(n);
				while (!q.isEmpty()) {
					Message m = q.peek(); // top priority rn
					if (time - m.getArrival() >= 4) {
						m.setWait(time - m.getArrival());
						processedMessages.add(q.remove());
					}
					time++;
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

	public void reorderMessages(int i) {
		ArrayList<Message> temp = new ArrayList<Message>(processedMessages.size());
		for (int n = 0; n < processedMessages.size(); n++) {
			if (processedMessages.get(n).getPriority() == i) {
				temp.add(processedMessages.get(i));
			}
		}
		processedMessages = temp;
	}

	public int analyze(int i) {
		int avg = 0;
		int count = 0;
		for (int n = 0; n < processedMessages.size(); n++) {
			if (processedMessages.get(n).getPriority() == i) {
				avg += processedMessages.get(i).getWait();
				count++;
			}
		}
		return avg / count;
	}

	public static void main(String[] args) {
		PriorityMessageQueue pmq = new PriorityMessageQueue();
		System.out.println(processedMessages);
	}

}
