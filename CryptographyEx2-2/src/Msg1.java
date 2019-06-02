import java.math.BigInteger;

public final class Msg1 {
	
	private BigInteger modulus;
	private BigInteger base;
	private BigInteger valueA;
	
	public Msg1(BigInteger p, BigInteger g, BigInteger valueA) {
		
		this.modulus = p;
		this.base = g;
		this.valueA = valueA;
		
	}
	
	public BigInteger getModulus(){
		return modulus;
	}

	public BigInteger getBase(){
		return base;
	}

	public BigInteger getValueA(){
		return valueA;
	}

}
