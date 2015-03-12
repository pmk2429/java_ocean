package inheritanceDemo;

public class Square extends Rectangle{
	public Square(){}
	
	public Square(double side){
		super(side, side);
	}
	
	public Square(double side, String name, String color, boolean filled){
		super(side, side, name, color, filled);
	}
	
	public double getSide(){
		return 0.0;
	}
	
	public void setSide(double side){
		
	}
	
	public void setWidth(double side){
		this.width = side;
	}
	
	public void setLength(double side){
		this.length = side;
	}
	
	public String toString(){
		return "";
	}
}
