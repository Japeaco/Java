package truckLoadingProblem;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Algorithms {
	
	public int nextFitAlgorithm(ArrayList<Boxes> boxes){
		
		//store start time
		long startTime = System.nanoTime();
		
		List<Trucks> trucks = new ArrayList<Trucks>();
		
		int count = 0;
		int i = 0;
		int j = 0;
		int x = 0;
		
		//create first truck
		Trucks firstTruck = new Trucks();
		count++;
		trucks.add(firstTruck);
		
		//place first box in first truck
		if(firstTruck.getBoxes().isEmpty()){
			
			Stack<Boxes> firstStack = new Stack<Boxes>();
			
			Boxes firstBox = boxes.get(i);
			
			firstStack.push(firstBox);
			firstTruck.addStack(firstStack);
			
			i++;
		}
		
		//loop through list of boxes
		while(i < boxes.size()){
			
			//return the current box and the previous box to compare
			Boxes currentBox = boxes.get(i);
			Boxes previousBox = boxes.get(i-1);
			
			Trucks currentTruck = trucks.get(j);
			Stack<Boxes> currentStack = currentTruck.getStacks().get(x);
			
			int totalWidth = 0;
			int totalHeight = 0;
			int noOfBoxes = 0;
			
			ArrayList<Stack<Boxes>> allStacks = currentTruck.getStacks();
				
			//loop through all stacks in a truck
			for(int k = 0; k < allStacks.size(); k++){
					
				for(int z = 0; z < allStacks.size(); z++)
				{
					totalWidth += allStacks.get(z).elementAt(0).getWidth();
				}
				
				for(int q = 0; q < allStacks.size(); q++)
				{
					noOfBoxes += allStacks.get(q).size();
				}
					
				for(int l = 0; l < currentStack.size(); l++)
				{
					totalHeight += currentStack.get(l).getHeight();
				}
			}
			
			
			//check if box fits in same truck
			//if yes, put in same truck
			if(currentBox.getWidth() <= previousBox.getWidth()
					&& totalHeight < currentTruck.getStackHeight() 
					&& noOfBoxes < currentTruck.getCapacity())
			{	
				//add box to truck
				currentStack.push(currentBox);
				
			}
			
			//If box is larger, check if it can be in a new pile
			else if(noOfBoxes < currentTruck.getCapacity()
					&& currentBox.getWidth() <= (currentTruck.getWidth() - totalWidth))
			{	
				Stack<Boxes> nextStack = new Stack<Boxes>();
						
				currentTruck.addStack(nextStack);
				nextStack.push(currentBox);		
				
				x++;
			}
			
			//if no, create new, empty truck and put box in
			else
			{
				//create new truck and put box in truck
				j++;
				count++;
				x = 0;
				
				Trucks nextTruck = new Trucks();
				Stack<Boxes> nextStack = new Stack<Boxes>();
	
				trucks.add(nextTruck);
				Trucks newTruck = trucks.get(j);
				newTruck.addStack(nextStack);
				nextStack.push(currentBox);
			}
			
			i++;
			
		}
		
		//store end time
		long endTime   = System.nanoTime();
		//end time minus start time produces total algorithm run time
		long totalTime = endTime - startTime;
		
		//print out all the trucks and boxes stored in each
		for(int k = 0; k < trucks.size(); k++){
		
			System.out.println("Truck: " + trucks.get(k).getStacks());
		
		}
		
		System.out.println("Number of trucks: " + count);
		System.out.printf("Total time: %d nanoseconds", totalTime);
		
		return 0;
		
	}
	
	public int firstFitAlgorithm(List<Boxes> boxes){
		
		//store start time
		long startTime = System.nanoTime();
		
		List<Trucks> trucks = new ArrayList<Trucks>();
		
		int count = 0;
		int i = 0;
		int y = 0;
		
		//create first truck
		Trucks firstTruck = new Trucks();
		trucks.add(firstTruck);
		count++;
		
		//place first box in first truck
		if(firstTruck.getBoxes().isEmpty())
		{				
			Stack<Boxes> firstStack = new Stack<Boxes>();
			
			Boxes firstBox = boxes.get(i);
			
			firstStack.push(firstBox);
			firstTruck.addStack(firstStack);
			
			i++;
		}
		
		//loop through all the boxes
		while(i < boxes.size()){
			
			boolean inTruck = false;
			
			Boxes currentBox = boxes.get(i);
			
			//loop through all the trucks
			for(int j = 0; j < trucks.size(); j++){
				
				int totalWidth = 0;
				int noOfBoxes = 0;
				
				Trucks currentTruck = trucks.get(j);
				ArrayList<Stack<Boxes>> allStacks = currentTruck.getStacks();
				
				for(int z = 0; z < allStacks.size(); z++)
				{
					totalWidth += allStacks.get(z).elementAt(0).getWidth();
				}
				
				for(int q = 0; q < allStacks.size(); q++)
				{
						noOfBoxes += allStacks.get(q).size();
				}
				
				//loop through all stacks in a truck
				for(int k = 0; k < allStacks.size(); k++)
				{									
					int totalHeight = 0;
	
					//return each stack
					Stack<Boxes> currentStack = currentTruck.getStacks().get(k);
					
					for(int l = 0; l < currentStack.size(); l++){
						totalHeight += currentStack.get(l).getHeight();
					}
					
					//if truck with available space found place on top of current stack in truck
					if(currentBox.getWidth() <= currentStack.peek().getWidth() 
							&& totalHeight < currentTruck.getStackHeight() && noOfBoxes < currentTruck.getCapacity())
					{
						//add box to truck and set boolean
						inTruck = true;
						
						currentStack.push(currentBox);
						
						break;
					}
					
					//If box is larger, check if it can be put in a new stack in the same truck
					else if(k == (allStacks.size()-1) && currentBox.getWidth() <= (currentTruck.getWidth() - totalWidth))
					{	
						inTruck = true;
						
						Stack<Boxes> nextStack = new Stack<Boxes>();
						
						currentTruck.addStack(nextStack);
						nextStack.push(currentBox);	
						
						break;
					}
					
				}
				
				if(inTruck == true){
					break;
				}
				
			}	
				//if not, put in new, empty truck
				if(inTruck == false)
				{
					//create new truck and put box in truck
					y++;
					count++;
					
					Trucks nextTruck = new Trucks();
					Stack<Boxes> nextStack = new Stack<Boxes>();
		
					trucks.add(nextTruck);
					Trucks newTruck = trucks.get(y);
					newTruck.addStack(nextStack);
					nextStack.push(currentBox);
				} 
			
			i++;
		}
		
		//store end time
		long endTime   = System.nanoTime();
		//end time minus start time produces total algorithm run time
		long totalTime = endTime - startTime;
		
		//print out all trucks and boxes stored in each
		for(int k = 0; k < trucks.size(); k++){
				
			System.out.println("Truck: " + trucks.get(k).getStacks());
		
		}
		
		System.out.println("Number of trucks: " + count);
		System.out.printf("Total time: %d nanoseconds", totalTime);
		
		return 0;
	}

}
