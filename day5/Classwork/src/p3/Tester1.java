package p3;

public class Tester1 {

	public static void main(String[] args) {
		HDFC hdfc=new HDFC();
		hdfc.createAccount("a", "saving", 5000);
		hdfc.withdraw(123, 456);
		BOB bob=new BOB();
		bob.createAccount("a", "saving", 5000);
		bob.withdraw(123, 456);
		Bank ref;
	//	System.out.println(ref);
		ref=hdfc;
		ref.withdraw(123, 500);
		ref=bob;
		ref.withdraw(345, 567);
	

	}

}
