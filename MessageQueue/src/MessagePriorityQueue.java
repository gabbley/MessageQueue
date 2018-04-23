import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class MessagePriorityQueue {

	private static ArrayList<Queue<Message>> qs;

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

		qs.add(q1);
		qs.add(q2);
		qs.add(q3);
		qs.add(q4);
		qs.add(q5);
	}
	
	public static void main(String[] args){
		qs = new ArrayList<Queue<Message>>();
		fillArr();
		for (Queue<Message> q : qs){
			for (Message m : q){
				assignQueue(m);
			}
		}
		System.out.println(qs);
	}
	
}
