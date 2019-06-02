package distributedSystems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class ENode {
	
	private int value;
	private ENode silentNeigh;
	private int sentToken = 0;
	private boolean hasDecided;
	
	boolean wakeUpSent;
	Integer wakeUpsReceived = 0;
	
	String[] allowedState = {"sleep" , "leader", "lost"};
	String state = "sleep";
	
	boolean initiator;
	
	int winner = 0;
	
	//Each node contains a map of its neighbours
	Map<ENode, Integer> neighboursList = new HashMap<ENode, Integer>();
	//Each node contains a map with a buffer respective to its neighbours
	private LinkedList<ENode> buffer = new LinkedList<ENode>();
	
	//Node object
	public ENode(int value) {
		this.value = value;
	}
	
	//get value of node
	public int getNode() {
		return value;
	}
	
	//get whether node has sent a message
	public int getSent() {
		return sentToken;
	}
	
	public void setHasDecided(boolean hasDecided) {
		this.hasDecided = hasDecided;
	}
	
	public boolean getHasDecided() {
		return hasDecided;
	}
	
	//get this nodes silent neighbour
	public ENode getSilentNeigh() {
		return silentNeigh;
	}
	
	//set whether node has woken up
	public void setWakeUpSent(boolean wakeUpSent) {
		this.wakeUpSent = wakeUpSent;
	}
	
	//get whether node has woken up
	public boolean getWakeUpSent() {
		return wakeUpSent;
	}
	
	//return amount of wake ups this node has received
	public int getWakeUpsReceived() {
		return wakeUpsReceived;
	}
	
	public void setWinner(int winner) {
		this.winner = winner;
	}
	
	public int getWinner() {
		return winner;
	}
	
	//set state of node
	public void setState(String state) {
		//check if string is one of three states node is allowed to be
		if(Arrays.asList(allowedState).contains(state)) {
			this.state = state;
		}
	}
	
	//return current state of node
	public String getState() {
		return state;
	}
	
	//get this nodes silent neighbour
	public void setInitiator(boolean initiator) {
		this.initiator = initiator;
	}
		
	//get this nodes silent neighbour
	public boolean getInitiator() {
		return initiator;
	}
	
	//add a neighbouring node to the list
	public void addneighbours(ENode node, Integer received) {
		neighboursList.put(node, received);
	}
	
	//return a list of this nodes neighbours
	public Map<ENode, Integer> getNeighbours() {
		return neighboursList;		
	}
	
	//A message has been received from another node and is waiting in the buffer
	public void sendToBuffer(ENode node) {
		buffer.addLast(node);
	}
		
	//return a list of this nodes neighbours
	public Queue getBuffer() {
		return buffer;		
	}
	
	//return number of neighbours in list
	public Integer getNoOfNeighbours() {
		return neighboursList.size();
	}
	
	//counts number of neighbours the Node has not received a token from
	public Integer countFalseNeighbours() {
		
		int count = 0;
		
		//loop through neighbours and count false nodes
		for (Map.Entry<ENode, Integer> entry : neighboursList.entrySet()) {
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
			//choose first token received
			ENode node = (ENode) getBuffer().poll();
			for (Map.Entry<ENode, Integer> entry : getNeighbours().entrySet()) {
			    if(entry.getKey() == node && entry.getValue() == 0) {
			    	//update token received from neighbour
			    	neighboursList.put(entry.getKey(), 1);
					System.out.println("Node " + getNode() + " received token from " + entry.getKey().toString());
					//calculate winner with received token
					calculateMinID(entry.getKey().getWinner());
					System.out.println("Winning node is " + getWinner());
			    }
			}	
		}
	}
	
	public void receiveWakeUp() {
		//if the node has a token in its buffer it can receive that token
		if(getBuffer().isEmpty() == false) {
			//choose token at front of queue to handle receiving more than one token in the buffer
			ENode node = (ENode) getBuffer().poll();
			for (Map.Entry<ENode, Integer> entry : getNeighbours().entrySet()) {
			    if(entry.getKey() == node) {
			    	//update token received from neighbour
			    	entry.getKey().setWakeUpSent(true);
					wakeUpsReceived += 1;
					System.out.println("Node " + getNode() + " received wakeup from " + entry.getKey().toString());
					setWinner(getNode());
			    }
			}	
		}
	}
	
	//calculate the minimum ID between two nodes
	public void calculateMinID(int recNode) {
		
		int firstNode = getWinner();
		int secondNode = recNode;
		
		int minimum = Math.min(firstNode, secondNode);
		
		setWinner(minimum);
	}
	
	public void nodeDecides() {
		//received token from all neighbours, so this node decides
		if(countFalseNeighbours() == 0) {
			System.out.println(toString() + " decides");
			if(getWinner() == getNode()) {
				setState("leader");
				System.out.println("Node " + getNode() + " is the leader");
			}
			else {
				setState("lost");
				System.out.println("Node " + getNode() + " is lost, Node " + getWinner() + " is the leader");
			}
			
			setHasDecided(true);
			
		}
	}
	
	//send all processes that are not the silent neighbour the decision
	public void sendToNeighbours(ENode node, String token) {
		for (Map.Entry<ENode, Integer> entry : getNeighbours().entrySet()) {
			if(entry.getKey() != getSilentNeigh() && sentToken != getNoOfNeighbours()) {
				entry.getKey().sendToBuffer(node);
				System.out.println("Node " + getNode() + " sent token and winning Node " + getWinner() + " to " + entry.getKey().toString());
				
				sentToken += 1;
		   }
		}
	}
	
	//method that sends a token to the silent neighbour
	public void sendToSilentNeighbour(ENode node, int winner) {

		//get silent neighbour
		calcSilentNeigh();
		ENode silentNeigh = getSilentNeigh();
			
		//send to receiving nodes buffer
		silentNeigh.sendToBuffer(node);
	
		System.out.println("Node " + getNode() + " sent token and Node " + getWinner() + " to " + silentNeigh.toString());
		
		sentToken += 1;	
	}
	
	//method that sends a wakeup 
	public void sendWakeUp(ENode node, String wakeup) {	
		//search for the neighbour that is false
		for (Map.Entry<ENode, Integer> entry : neighboursList.entrySet()) {
				entry.getKey().sendToBuffer(node);
				System.out.println("Node " + getNode() + " sent wakeup to " + entry.getKey().toString());
		}
	}
	
	public ENode calcSilentNeigh() {		
		//search for the neighbour that is false
		for (Map.Entry<ENode, Integer> entry : neighboursList.entrySet()) {
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