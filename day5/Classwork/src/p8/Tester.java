package p8;

public class Tester {

	public static void main(String[] args) {
		Computable[] refs = { new Circle(10, 20, 5.6), 
				new Rectangle(50, 70, 12.5, 10) };
		for (Computable c : refs)
			System.out.println(c + " area " + c.calcArea() 
			+ " peri " + c.calcPerimeter());

	}

}
