package project1;
import java.util.Scanner;

public class CarTest {
	
	public static void main(String args[]) {
		
		SmallCar Car1 = new SmallCar();
		Car1.setRented(true);
		
		System.out.println(Car1);
		
		Scanner input = new Scanner(System.in);

		System.out.println("\nEnter kilometres traveled in car: ");
		int kilometres = input.nextInt();
		System.out.println("Fuel consumed is: " + Car1.drive(kilometres) + " litre/s");
		System.out.println("Fuel in car: " + Car1.getFuelInTank());
		System.out.println("Fuel added is: " + Car1.addFuel() + " litre/s");
		System.out.println("Fuel in car: " + Car1.getFuelInTank());
		System.out.println("Is the tank full?: " + Car1.isTankFull());
	}
}
