package distributedSystems;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;

public class Node {
	
	private int value;	
	private Node silentNeigh;
	private int sentToken = 0;
	
	//Each node contains a map of its neighbours
	Map<Node, Integer> neighboursList = new HashMap<Node, Integer>();
	//Each node contains a map with a buffer respective to its neighbours
	private LinkedList<Node> buffer = new LinkedList<Node>();
	
	public Node(int value) {
		this.value = value;
	}
	
	//return value for Node
	public int getNode() {
		return value;
	}
	
	//get whether node has sent a message
	public int getSent() {
		return sentToken;
	}
	
	//get this nodes silent neighbour
	public Node getSilentNeigh() {
		return silentNeigh;
	}
	
	//add a neighbouring node to the list
	public void addneighbours(Node node, Integer received) {
		neighboursList.put(node, received);
	}
	
	//A message has been received from another node and is waiting in the buffer
	public void sendToBuffer(Node node) {
		buffer.addLast(node);
	}
	
	//return a list of this nodes neighbours
	public Queue getBuffer() {
		return buffer;		
	}
	
	//return a list of this nodes neighbours
	public Map<Node, Integer> getNeighbours() {
		return neighboursList;		
	}
	
	//return number of neighbours in list
	public Integer getNoOfNeighbours() {
		return neighboursList.size();
	}
	
	//counts number of neighbours the Node has not received a token from
	public Integer countFalseNeighbours() {
		
		int count = 0;
		
		//loop through neighbours and count false nodes
		for (Map.Entry<Node, Integer> entry : neighboursList.entrySet()) {
		    if(entry.getValue() == 0) {
		    	count++;
		    }
		}
		return count;
	}
	
	//receive a token from a neighbour
	public void receive() {

		//if the node has a token in its buffer it can receive that token
		if(getBuffer().isEmpty() == false) {
			//choose token at front of queue to handle receiving of more than one token in buffer
			Node node = (Node) getBuffer().poll();
			for (Map.Entry<Node, Integer> entry : getNeighbours().entrySet()) {
			    if(entry.getKey() == node && entry.getValue() == 0) {
			    	//update token received from neighbour
			    	neighboursList.put(entry.getKey(), 1);
					System.out.println("Node " + getNode() + " received token from " + entry.getKey().toString());
			    }
			}	
		}
	}
	
	public void nodeDecides(Node node) {	
		//received token from all neighbours, so this node decides
		if(countFalseNeighbours() == 0) {
			System.out.println(toString() + " decides");
		}
	}
	
	//send all processes that are not the silent neighbour the decision
	public void sendToNeighbours(Node node, String token) {
		for (Map.Entry<Node, Integer> entry : getNeighbours().entrySet()) {
		    if(entry.getKey() != getSilentNeigh()) {
		    	//update token received from neighbour
		    	neighboursList.put(entry.getKey(), 1);
				System.out.println("Node " + getNode() + " sent token to " + entry.getKey().toString());
				sentToken += 1;
		    }
		}
	}
	
	//method that sends a token to the silent neighbour
	public void sendToSilentNeighbour(Node node, String token) {

		//get silent neighbour
		calcSilentNeigh();
		Node silentNeigh = getSilentNeigh();
			
		//send to receiving nodes buffer
		silentNeigh.sendToBuffer(node);
		
		System.out.println("Node " + getNode() + " sent token to " + silentNeigh.toString());
			
		sentToken += 1;	
	}
	
	public Node calcSilentNeigh() {		
		//search for the neighbour that is false
			for (Map.Entry<Node, Integer> entry : neighboursList.entrySet()) {
				if(entry.getValue() == 0) {
					return silentNeigh = entry.getKey();
				}
			}
		return silentNeigh;
	}
	
	public String toString() {
		return "Node " + getNode();		
	}

}