package truckLoadingProblem;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class test {
	
	public static void main(String args[]){
	
		//create boxes
		Boxes box1 = new Boxes(1,45);
		Boxes box2 = new Boxes(1,65);
		Boxes box3 = new Boxes(1,12);
		Boxes box4 = new Boxes(1,84);
		Boxes box5 = new Boxes(1,21);
		Boxes box6 = new Boxes(1,19);
		Boxes box7 = new Boxes(1,56);
		Boxes box8 = new Boxes(1,9);
		Boxes box9 = new Boxes(1,78);
		Boxes box10 = new Boxes(1,29);
		Boxes box11 = new Boxes(1,91);
		Boxes box12 = new Boxes(1,11);
		
		ArrayList<Boxes> boxes = new ArrayList<Boxes>();
		
		//add boxes to list
		boxes.add(box1);
		boxes.add(box2);
		boxes.add(box3);
		boxes.add(box4);
		boxes.add(box5);
		boxes.add(box6);
		boxes.add(box7);
		boxes.add(box8);
		boxes.add(box9);
		boxes.add(box10);
		boxes.add(box11);
		boxes.add(box12);
		
		Algorithms algorithms = new Algorithms();
		
		//call next fit algorithm
		System.out.println("Next fit algorithm: \n");
		algorithms.nextFitAlgorithm(boxes);
		
		//call first fit algorithm
		System.out.println("\n\nfirst fit algorithm: \n");
		algorithms.firstFitAlgorithm(boxes);
		
		Boxes box13 = new Boxes(1,10);
		Boxes box14 = new Boxes(1,20);
		Boxes box15 = new Boxes(1,30);
		Boxes box16 = new Boxes(1,40);
		Boxes box17 = new Boxes(1,50);
		Boxes box18 = new Boxes(1,60);
		
		ArrayList<Boxes> boxes2 = new ArrayList<Boxes>();
		
		boxes2.add(box13);
		boxes2.add(box14);
		boxes2.add(box15);
		boxes2.add(box16);
		boxes2.add(box17);
		boxes2.add(box18);
		
		//call next fit algorithm
		System.out.println("\n\nNext fit algorithm: \n");
		algorithms.nextFitAlgorithm(boxes2);
				
		//call first fit algorithm
		System.out.println("\n\nfirst fit algorithm: \n");
		algorithms.firstFitAlgorithm(boxes2);
		
		Boxes box19 = new Boxes(1,60);
		Boxes box20 = new Boxes(1,50);
		Boxes box21 = new Boxes(1,40);
		Boxes box22 = new Boxes(1,30);
		Boxes box23 = new Boxes(1,20);
		Boxes box24 = new Boxes(1,10);
		
		ArrayList<Boxes> boxes3 = new ArrayList<Boxes>();
		
		boxes3.add(box19);
		boxes3.add(box20);
		boxes3.add(box21);
		boxes3.add(box22);
		boxes3.add(box23);
		boxes3.add(box24);
		
		//call next fit algorithm
		System.out.println("\n\nNext fit algorithm: \n");
		algorithms.nextFitAlgorithm(boxes3);
				
		//call first fit algorithm
		System.out.println("\n\nfirst fit algorithm: \n");
		algorithms.firstFitAlgorithm(boxes3);
		
		ArrayList<Boxes> randomBoxes = new ArrayList<Boxes>();
		
		Random randomGenerator = new Random();
		for (int i = 0; i < 100; i++){
			int randomInt = (randomGenerator.nextInt(49) + 1);
			Boxes randomBox = new Boxes(1, randomInt);
			randomBoxes.add(randomBox);
		}
		
		//call next fit algorithm
		System.out.println("\n\nNext fit algorithm: \n");
		algorithms.nextFitAlgorithm(randomBoxes);
		
		//call first fit algorithm
		System.out.println("\n\nfirst fit algorithm: \n");
		algorithms.firstFitAlgorithm(randomBoxes);
		
		ArrayList<Boxes> randomBoxes2 = new ArrayList<Boxes>();
		
		Random randomGenerator2 = new Random();
		for (int i = 0; i < 250; i++){
			int randomInt = (randomGenerator2.nextInt(49) + 1);
			Boxes randomBox2 = new Boxes(1, randomInt);
			randomBoxes2.add(randomBox2);
		}
		
		//call next fit algorithm
		System.out.println("\n\nNext fit algorithm: \n");
		algorithms.nextFitAlgorithm(randomBoxes2);
		
		//call first fit algorithm
		System.out.println("\n\nfirst fit algorithm: \n");
		algorithms.firstFitAlgorithm(randomBoxes2);
		
		ArrayList<Boxes> randomBoxes3 = new ArrayList<Boxes>();
		
		Random randomGenerator3 = new Random();
		for (int i = 0; i < 500; i++){
			int randomInt = (randomGenerator3.nextInt(49) + 1);
			Boxes randomBox3 = new Boxes(1, randomInt);
			randomBoxes3.add(randomBox3);
		}
		
		//call next fit algorithm
		System.out.println("\n\nNext fit algorithm: \n");
		algorithms.nextFitAlgorithm(randomBoxes3);
		
		//call first fit algorithm
		System.out.println("\n\nfirst fit algorithm: \n");
		algorithms.firstFitAlgorithm(randomBoxes3);
		
		ArrayList<Boxes> randomBoxes4 = new ArrayList<Boxes>();
		
		Random randomGenerator4 = new Random();
		for (int i = 0; i < 500; i++){
			int randomInt = (randomGenerator4.nextInt(49) + 1);
			Boxes randomBox4 = new Boxes(1, randomInt);
			randomBoxes4.add(randomBox4);
		}
		
		//call next fit algorithm
		System.out.println("\n\nNext fit algorithm: \n");
		algorithms.nextFitAlgorithm(randomBoxes4);
		
		//call first fit algorithm
		System.out.println("\n\nfirst fit algorithm: \n");
		algorithms.firstFitAlgorithm(randomBoxes4);
		
		ArrayList<Boxes> randomBoxes5 = new ArrayList<Boxes>();
		
		Random randomGenerator5 = new Random();
		for (int i = 0; i < 10; i++){
			int randomInt = (randomGenerator5.nextInt(49) + 1);
			Boxes randomBox5 = new Boxes(1, randomInt);
			randomBoxes5.add(randomBox5);
		}
		
		//call next fit algorithm
		System.out.println("\n\nNext fit algorithm: \n");
		algorithms.nextFitAlgorithm(randomBoxes5);
		
		//call first fit algorithm
		System.out.println("\n\nfirst fit algorithm: \n");
		algorithms.firstFitAlgorithm(randomBoxes5);
		
		ArrayList<Boxes> randomBoxes6 = new ArrayList<Boxes>();
		
		Random randomGenerator6 = new Random();
		for (int i = 0; i < 5; i++){
			int randomInt = (randomGenerator6.nextInt(49) + 1);
			Boxes randomBox6 = new Boxes(1, randomInt);
			randomBoxes6.add(randomBox6);
		}
		
		//call next fit algorithm
		System.out.println("\n\nNext fit algorithm: \n");
		algorithms.nextFitAlgorithm(randomBoxes6);
		
		//call first fit algorithm
		System.out.println("\n\nfirst fit algorithm: \n");
		algorithms.firstFitAlgorithm(randomBoxes6);
	
	}
}
