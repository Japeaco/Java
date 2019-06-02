import java.math.BigInteger;
import java.util.Random;

public class test {
	
	public static void main(String args[]){
		
		BigInteger p = new BigInteger("7845436743865585325468");
		
		DiffieHellman d = new DiffieHellman();
		
		d.setModulus(p);
		System.out.println(d.getModulus());
		d.computeMessageAToB();
		d.computeMessageBToA(d.getMsg1());
		d.computeKeyA(d.getMsg2());
		d.computeKeyB(d.getMsg1());
		
		System.out.println("secretA = " + d.Alice.getSecret());
		System.out.println("secretB = " + d.Bob.getSecret());
		System.out.println("msg1.modulus = " + d.getMsg1().getModulus());
		System.out.println("msg1.base = " + d.getMsg1().getBase());
		System.out.println("msg1.valueA = " + d.getMsg1().getValueA());
		System.out.println("msg2.valueB = " + d.getMsg2().getValueB());
		System.out.println("keyA = " + d.Alice.getKey());
		System.out.println("keyB = " + d.Bob.getKey());
		
	}

}