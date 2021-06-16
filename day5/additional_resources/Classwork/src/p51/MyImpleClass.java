package p51;

public class MyImpleClass implements Printable, Sortable {

	@Override
	public void print() {
		System.out.println("in my print " + Sortable.SIZE);
	}
	@Override
	public double print() {
		System.out.println("in print double " + Sortable.SIZE);
	}

	
	
}
