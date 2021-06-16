package p5;

public class MyImpleClass implements Printable, Sortable {

	@Override
	public void print() {
		System.out.println("in my print " + Sortable.SIZE);
	}

	@Override
	public void print(int data) {
		System.out.println("in overloaded print with int");
		
	}
	
}
