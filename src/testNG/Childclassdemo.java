package testNG;

public class Childclassdemo extends Parentclass {
	int speed=80;

	void run(){System.out.println("running safely with 60km");}  
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Parentclass g= new Childclassdemo();
		g.run();
		System.out.println(g.speed);
	}

}
