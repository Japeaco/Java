import java.math.BigInteger;

public class Question2b {
	
	public static void main(String args[]){
		
		LinearEquationSolver l = new LinearEquationSolver();
		
		BigInteger a = new BigInteger("34325464564574564564768795534569998743457687643234566579654234676796634378768"
				+ "434237897634345765879087764242354365767869780876543424");
		BigInteger b = new BigInteger("24243252873562935279236582385723952735639239823957923562835832582635283562852"
				+ "252525256882909285959238420940257295265329820035324646");
		BigInteger N = new BigInteger("34248723532593458235023583785345602939423526832829428589598243238758257023423"
				+ "84876259232895263823795235732659632932938392985950720935732042930927056234852738"
				+ "93582930285732889238492377364284728834632342522323422");
		
		System.out.println(a.gcd(N));
		
		System.out.println("x: " + l.linearEquationSolver(a, b, N));
		
	}

}