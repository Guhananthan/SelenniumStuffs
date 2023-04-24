import java.util.*;
public class JavaBrushUp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<String> a = new ArrayList<String>();
		a.add("rahul");
		a.add("Shetty");
		a.add("academy");
		a.add("selenium");
		System.out.println(a.get(3));
		
		System.out.println(a.contains("selenium"));
		
		String[] name = {"rahul","Shetty","selenium"};
		List<String> nameArrayList = Arrays.asList(name);
		System.out.println(nameArrayList.contains("selenium"));
		
		
		String s = "Rahul Shetty Academy";

		String[] splittedString = s.split("Shetty");

		System.out.println(splittedString[0]);

		System.out.println(splittedString[1]);

		System.out.println(splittedString[1].trim());

		for(int i =s.length()-1;i>=0;i--)

		{

		System.out.println(s.charAt(i));

		}
		
		
		
	}

}
