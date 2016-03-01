
public class Paxos implements Runnable {
	
	Node node;
	
	public Paxos(Node node) {
		this.node = node;
	}

	@Override
	public void run() {
		new Thread(new Proposer(node)).start();
		new Thread(new Acceptor(node)).start();
	}

}
