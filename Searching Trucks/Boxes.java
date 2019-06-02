package truckLoadingProblem;

public class Boxes {
	
	private int height;
	private int width;
	
	public Boxes(int height, int width){		
		this.height = height;
		this.width = width;		
	}
	
	public int getHeight(){
		return height;
	}
	
	public int getWidth(){
		return width;
	}
	
	public String toString(){
		return " " + getHeight() + "," + getWidth();
	}

}
