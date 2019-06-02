package distributedSystems;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class WaveAlgorithm {
	
	public static void main(String args[]) {
		
		int noOfNodes = 15;

		Node[] balancedTree = new Node[noOfNodes];
		Node[] unbalancedTree = new Node[noOfNodes];
		Node[] arbitraryTree = new Node[noOfNodes];
		
		//create array same length as number of nodes
		for(int i = 0; i < noOfNodes; i++) {
				balancedTree[i] = new Node(i);
		}
		
		//add each ENodes neighbours to their map
		balancedTree[7].addneighbours(balancedTree[8], 0);
		balancedTree[7].addneighbours(balancedTree[6], 0);
		balancedTree[6].addneighbours(balancedTree[7], 0);
		balancedTree[6].addneighbours(balancedTree[4], 0);
		balancedTree[6].addneighbours(balancedTree[13], 0);
		balancedTree[8].addneighbours(balancedTree[7], 0);
		balancedTree[8].addneighbours(balancedTree[5], 0);
		balancedTree[8].addneighbours(balancedTree[9], 0);
		balancedTree[4].addneighbours(balancedTree[6], 0);
		balancedTree[4].addneighbours(balancedTree[0], 0);
		balancedTree[4].addneighbours(balancedTree[10], 0);
		balancedTree[13].addneighbours(balancedTree[6], 0);
		balancedTree[13].addneighbours(balancedTree[1], 0);
		balancedTree[13].addneighbours(balancedTree[14], 0);
		balancedTree[5].addneighbours(balancedTree[8], 0);
		balancedTree[5].addneighbours(balancedTree[3], 0);
		balancedTree[5].addneighbours(balancedTree[11], 0);
		balancedTree[9].addneighbours(balancedTree[8], 0);
		balancedTree[9].addneighbours(balancedTree[2], 0);
		balancedTree[9].addneighbours(balancedTree[12], 0);
		balancedTree[0].addneighbours(balancedTree[4], 0);
		balancedTree[10].addneighbours(balancedTree[4], 0);
		balancedTree[1].addneighbours(balancedTree[13], 0);
		balancedTree[14].addneighbours(balancedTree[13], 0);
		balancedTree[3].addneighbours(balancedTree[5], 0);
		balancedTree[11].addneighbours(balancedTree[5], 0);
		balancedTree[2].addneighbours(balancedTree[9], 0);
		balancedTree[12].addneighbours(balancedTree[9], 0);
		
		//create array same length as number of nodes
		for(int i = 0; i < noOfNodes; i++) {
			unbalancedTree[i] = new Node(i);
		}
		
		//add each ENodes neighbours to their map
		unbalancedTree[11].addneighbours(unbalancedTree[6], 0);
		unbalancedTree[11].addneighbours(unbalancedTree[13], 0);
		unbalancedTree[6].addneighbours(unbalancedTree[11], 0);
		unbalancedTree[6].addneighbours(unbalancedTree[3], 0);
		unbalancedTree[6].addneighbours(unbalancedTree[10], 0);
		unbalancedTree[13].addneighbours(unbalancedTree[11], 0);
		unbalancedTree[13].addneighbours(unbalancedTree[12], 0);
		unbalancedTree[13].addneighbours(unbalancedTree[14], 0);
		unbalancedTree[3].addneighbours(unbalancedTree[6], 0);
		unbalancedTree[3].addneighbours(unbalancedTree[2], 0);
		unbalancedTree[3].addneighbours(unbalancedTree[4], 0);
		unbalancedTree[10].addneighbours(unbalancedTree[6], 0);
		unbalancedTree[10].addneighbours(unbalancedTree[9], 0);
		unbalancedTree[10].addneighbours(unbalancedTree[7], 0);
		unbalancedTree[12].addneighbours(unbalancedTree[13], 0);
		unbalancedTree[14].addneighbours(unbalancedTree[13], 0);
		unbalancedTree[2].addneighbours(unbalancedTree[3], 0);
		unbalancedTree[2].addneighbours(unbalancedTree[1], 0);
		unbalancedTree[4].addneighbours(unbalancedTree[3], 0);
		unbalancedTree[4].addneighbours(unbalancedTree[5], 0);
		unbalancedTree[9].addneighbours(unbalancedTree[10], 0);
		unbalancedTree[9].addneighbours(unbalancedTree[8], 0);
		unbalancedTree[7].addneighbours(unbalancedTree[10], 0);
		unbalancedTree[1].addneighbours(unbalancedTree[2], 0);
		unbalancedTree[1].addneighbours(unbalancedTree[0], 0);
		unbalancedTree[5].addneighbours(unbalancedTree[4], 0);
		unbalancedTree[8].addneighbours(unbalancedTree[9], 0);
		unbalancedTree[0].addneighbours(unbalancedTree[1], 0);
		
		//create array same length as number of nodes
		for(int i = 0; i < noOfNodes; i++) {
			arbitraryTree[i] = new Node(i);
		}
				
		//add each ENodes neighbours to their map
		arbitraryTree[10].addneighbours(arbitraryTree[14], 0);
		arbitraryTree[10].addneighbours(arbitraryTree[6], 0);
		arbitraryTree[14].addneighbours(arbitraryTree[10], 0);
		arbitraryTree[14].addneighbours(arbitraryTree[2], 0);
		arbitraryTree[14].addneighbours(arbitraryTree[8], 0);
		arbitraryTree[6].addneighbours(arbitraryTree[10], 0);
		arbitraryTree[6].addneighbours(arbitraryTree[7], 0);
		arbitraryTree[2].addneighbours(arbitraryTree[14], 0);
		arbitraryTree[2].addneighbours(arbitraryTree[3], 0);
		arbitraryTree[8].addneighbours(arbitraryTree[14], 0);
		arbitraryTree[8].addneighbours(arbitraryTree[12], 0);
		arbitraryTree[8].addneighbours(arbitraryTree[0], 0);
		arbitraryTree[7].addneighbours(arbitraryTree[6], 0);
		arbitraryTree[7].addneighbours(arbitraryTree[4], 0);
		arbitraryTree[3].addneighbours(arbitraryTree[2], 0);
		arbitraryTree[12].addneighbours(arbitraryTree[8], 0);
		arbitraryTree[0].addneighbours(arbitraryTree[8], 0);
		arbitraryTree[4].addneighbours(arbitraryTree[7], 0);
		arbitraryTree[4].addneighbours(arbitraryTree[9], 0);
		arbitraryTree[4].addneighbours(arbitraryTree[13], 0);
		arbitraryTree[9].addneighbours(arbitraryTree[4], 0);
		arbitraryTree[13].addneighbours(arbitraryTree[4], 0);
		arbitraryTree[13].addneighbours(arbitraryTree[1], 0);
		arbitraryTree[13].addneighbours(arbitraryTree[11], 0);
		arbitraryTree[1].addneighbours(arbitraryTree[13], 0);
		arbitraryTree[1].addneighbours(arbitraryTree[5], 0);
		arbitraryTree[11].addneighbours(arbitraryTree[13], 0);
		arbitraryTree[5].addneighbours(arbitraryTree[1], 0);
		
		
		//run the wave algorithm (uncomment which tree you want to run with the algorithm)
		waveAlgorithm(noOfNodes, balancedTree);
		//waveAlgorithm(noOfNodes, unbalancedTree);
		//waveAlgorithm(noOfNodes, arbitraryTree);
		
		
	}
	
	public static void waveAlgorithm(int noOfNodes, Node[] tree) {
		
		int iterations = noOfNodes * 20;
		int count = 1;
		
		while(iterations > 0) {
			
			System.out.println("new iteration " + count);
			count += 1;
			
			List selectedNodes = new ArrayList();
		
			//select random number of nodes to initiate algorithm
			Random r2 = new Random();
			int noOfNodesSelected = r2.nextInt(noOfNodes);
				
			//select nodes at random to run algorithm
			while(noOfNodesSelected > 0) {
					
				Random r3 = new Random();
					
				int selectedNode = r3.nextInt(noOfNodes);
					
				//if list does not already contain that node
				if(selectedNodes.contains(selectedNode) != true) {	
					selectedNodes.add(selectedNode);
					noOfNodesSelected -= 1;
				}		
			}
		
			//loop through selected nodes
			for(int i=0; i < selectedNodes.size(); i++){
				System.out.println("Node " + (int) selectedNodes.get(i) + " selected");
				
				Node currentNode = tree[(int) selectedNodes.get(i)];
				
				//if the node has more than one false neighbour
				if(currentNode.countFalseNeighbours() > 1) {				
					currentNode.receive();
					if(currentNode.getBuffer().isEmpty()) {
						System.out.println("Node " + currentNode.getNode() + " waiting to receive");
					}
				}
				//if the node has one false neighbour remaining and has not sent a message
				else if(currentNode.countFalseNeighbours() == 1 && currentNode.getSent() == 0) {
					currentNode.sendToSilentNeighbour(currentNode, "token");
				}
				//if the node has one false neighbour remaining and has sent a message
				else if(currentNode.countFalseNeighbours() == 1 && currentNode.getSent() == 1) {
					currentNode.receive();
				}	
				//if the node has no false neighbours it can decide
				else if(currentNode.countFalseNeighbours() == 0) {
					currentNode.nodeDecides(currentNode);
				}
			}
			
			iterations -= 1;
		}
	}
}
