import java.math.BigInteger;
import java.util.Random;

public class DiffieHellman {
	
	public Msg1 msg1;
	public Msg2 msg2;
	public BigInteger p;
	
	public Person Alice = new Person();
	public Person Bob = new Person();
	
	//set modulus
	public void setModulus(BigInteger p){
		this.p = p;
	}
	
	//retrieve modulus
	public BigInteger getModulus(){
		return p;
	}
	
	//retrieve msg1
	public Msg1 getMsg1(){
		return msg1;
	}
	
	//retrieve msg2
	public Msg2 getMsg2(){
		return msg2;
	}
	
	//computeds message A to B
	public Msg1 computeMessageAToB() {
		
		Random rnd = new Random();
		BigInteger g;
		
		//produce randomly generated generator 0 to p-1
		do {
		    g = new BigInteger(getModulus().bitLength(), rnd);
		} while (g.compareTo(getModulus()) >= 0);
		
		//Alice knows the modulus, base and her own secret
		Alice.setModulus(getModulus());
		Alice.setBase(g);
		//produce randomly generated secret 0 to p-1
		Alice.setSecret();
		
		//create valueA with base g to the power of secretA modulus p
		BigInteger valueA = g.modPow(Alice.getSecret(), getModulus());
		
		//Alice knows her value
		Alice.setValue(valueA);
		
		//create message 1
		this.msg1 = new Msg1(getModulus(), g, valueA);
		
		return msg1;
		
	}

	//computes message B to A
	public Msg2 computeMessageBToA(Msg1 msg1) {
		
		//Bob knows modulus and base and his own secret
		Bob.setModulus(getModulus());
		Bob.setBase(msg1.getBase());		
		//produce randomly generated secret 0 to p-1
		Bob.setSecret();
		
		//create valueB with base g to the power of secretB modulus p
		BigInteger valueB = msg1.getBase().modPow(Bob.getSecret(), msg1.getModulus());
		
		//Bob knows his value
		Bob.setValue(valueB);
		
		//create message 2 sending valueB to Alice
		this.msg2 = new Msg2(valueB);
		
		return msg2;
		
	}
	
	public BigInteger computeKeyA(Msg2 msg2){
		
		//Alice computes her key
		//create keyA with base valueB to the power of secretA modulus p
		Alice.setKey(msg2.getValueB().modPow(Alice.getSecret(), msg1.getModulus()));
		
		return Alice.getKey();
		
	}
	
	public BigInteger computeKeyB(Msg1 msg1){
		
		//Bob computes his key
		//create keyB with base valueA to the power of secretB modulus p
		Bob.setKey(msg1.getValueA().modPow(Bob.getSecret(), msg1.getModulus()));
		
		return Bob.getKey();
		
	}

}
