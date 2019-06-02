package truckLoadingProblem;

import java.util.ArrayList;
import java.util.Stack;


public class Trucks {
	
	private int stackHeight;
	private int width;
	private int capacity;
	private Stack<Boxes> stack = new Stack<Boxes>();
	private ArrayList<Stack<Boxes>> boxes = new ArrayList<Stack<Boxes>>();
	
	public Trucks(){
		this.stackHeight = 20;
		this.width = 100;
		this.capacity = 25;
	}
	
	public int getStackHeight(){
		return stackHeight;
	}
	
	public int getWidth(){
		return width;
	}    
	
	public int getCapacity(){
		return capacity;
	}
	
	public Stack<Boxes> getBoxes(){
		return stack;
	}
	
	public void addStack(Stack<Boxes> stack){
		boxes.add(stack);
	}
	
	public ArrayList<Stack<Boxes>> getStacks(){
		return boxes;
	}
	
	public String toString(){
		return "\nBoxes in truck: " + getStacks();
	}

}
