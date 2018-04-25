import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class MessagePriorityQueue {

	private static ArrayList<Queue<Message>> qs;
	private static ArrayList<Message> messages;

	final static int MESSAGE_NUM = 15;

	public static void assignQueue(Message m) {
		int p = m.getPriority();
		switch (p) {
		case 0:
			qs.get(0).add(m);
		case 1:
			qs.get(1).add(m);
		case 2:
			qs.get(2).add(m);
		case 3:
			qs.get(3).add(m);
		case 4:
			qs.get(4).add(m);
		default:
			System.out.println("Message has invalid priority");

		}
	}

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

	public static void soManyMessages() {
		ArrayList<Message> messages = new ArrayList<Message>();
		for (int i = 0; i < MESSAGE_NUM; i++) {
			messages.add(new Message((int) (Math.random() * 5), ((int) Math.random() * 20)));
		}
		System.out.println("soManyMessages()");

	}


	public static void processMessage() {
		for (int i = 0; i < qs.size(); i++) {
			Queue<Message> queueMessage = qs.get(i);
			for (int j = 0; j < queueMessage.size(); j++) {
				assignQueue(queueMessage.peek());
				soManyMessages();
				messages.add(queueMessage.remove());
			}
		}
	}
	
	public static void main(String[] args) {
		qs = new ArrayList<Queue<Message>>();
		fillArr();
		processMessage();
		System.out.println(qs);
	}

}
