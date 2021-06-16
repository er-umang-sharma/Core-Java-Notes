package p1;

public class MyPrintable implements Printable {
	@Override
	public void print()
	{
		//Implementing class can directly access i/f constants.
		System.out.println("in my print "+SIZE);
	}

}
