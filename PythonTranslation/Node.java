import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Node {

	int id;
	boolean isRunning = true;
	int port;
	int udpPort;
	String ipAddress;
	int leaderId = -1;
	boolean terminate = false;
	boolean isNode = true;
	HashMap<Integer, Node> peers = new HashMap<Integer, Node>();

	public Node(int id) {
		this.id = id;
	}

	public void loadIpTable() {
		File dir = new File(".");
		File ipFile;
		try {
			ipFile = new File(dir.getCanonicalPath() + File.separator + "ipPortTable.txt");
			BufferedReader br = new BufferedReader(new FileReader(ipFile));
			String line = null;
			while ((line = br.readLine()) != null) {
				String[] tokens = line.split(",");
				int nodeId = Integer.parseInt(tokens[0]);
				if(this.id == nodeId) {
					port = Integer.parseInt(tokens[2]);
					ipAddress = tokens[1];
					udpPort = Integer.parseInt(tokens[3]);
				}
				else {
					Node n = new Node(nodeId);
					n.port = Integer.parseInt(tokens[2]);
					n.ipAddress = tokens[1];
					n.udpPort = Integer.parseInt(tokens[3]);
					this.peers.put(n.id, n);
				}
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}

	public static void main(String args[]) {
		Node node = new Node(Integer.parseInt(args[0]));
		node.loadIpTable();
		System.out.println("Node " + node.id + " started with port number " + node.port);
		new Thread(new LeaderElection(node)).start();
		new Thread(new Paxos(node)).start();
	}

}
