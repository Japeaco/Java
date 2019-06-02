import java.math.BigInteger;

public class LinearEquationSolver {
	
	public BigInteger linearEquationSolver(BigInteger a, BigInteger b, BigInteger N){
		
		//calculate gcd of a and N
		BigInteger g = a.gcd(N);
		BigInteger x;
		
		//create coprime BigInteger to compare gcd
		BigInteger coprime;
		coprime = new BigInteger("1");
	
		//check a and N are coprime	
		int com = g.compareTo(coprime);
		
		if(com == 0){
			
			//calculate modular inverse of a and N
			BigInteger inverse = a.modInverse(N);
			
			//x = -b * a^-1 in ZN - everything on right side besides x
			x = ((BigInteger.ZERO.subtract(b)).multiply(inverse).mod(N));
			
			//a*x + b = 0 in ZN - test if equation equals 0 with found x value
			System.out.println("a*x + b = " + (a.multiply(x).add(b).mod(N)));

		}
		
		else {
			//if not coprime return null; equation unsolvable
			return null;
		}
		
		return x;
		
	}

}
