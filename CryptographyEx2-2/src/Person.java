import java.math.BigInteger;
import java.util.Random;

public class Person {
	
	public BigInteger p;
	public BigInteger g;
	public BigInteger secret;
	public BigInteger value;
	public BigInteger key;
	
	public Person(){
		this.p = getModulus();
		this.g = getBase();
		this.secret = getSecret();
		this.value = getValue();
	}
	
	public void setModulus(BigInteger p){
		this.p = p;
	}
	
	public BigInteger getModulus(){
		return p;
	}
	
	public void setBase(BigInteger g){
		this.g = g;
	}
	
	public BigInteger getBase(){
		return g;
	}
	
	public void setSecret(){
		Random rnd = new Random();
		BigInteger secret;
		
		do {
		    secret = new BigInteger(getModulus().bitLength(), rnd);
		} while (secret.compareTo(getModulus()) >= 0);
		
		this.secret = secret;
	}
	
	public BigInteger getSecret(){
		return secret;
	}
	
	public void setValue(BigInteger value){
		this.value = value;
	}
	
	public BigInteger getValue(){
		return value;
	}
	
	public void setKey(BigInteger key){
		this.key = key;
	}
	
	public BigInteger getKey(){
		return key;
	}
}
