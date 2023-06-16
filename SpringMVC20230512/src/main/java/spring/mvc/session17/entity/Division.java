package spring.mvc.session17.entity;

public class Division {
	private int x;
	private int y;
	private int result;
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	@Override
	public String toString() {
		return "Division [x=" + x + ", y=" + y + ", result=" + result + "]";
	}
	
	
	
}
