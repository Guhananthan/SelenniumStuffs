import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class JavaStreams {

	@Test
	public void regular() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("Abi");
		names.add("Anbu");
		names.add("Achu");
		names.add("Ram");
		names.add("zack");
		int count = 0;
		for (int i = 0; i < names.size(); i++) {
			String actual = names.get(i);
			if (actual.startsWith("A")) {
				count++;
			}
		}
		System.out.println(count);

	}

	@Test
	public void streamFilter() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("Abi");
		names.add("Anbuselvan");
		names.add("Achuthan");
		names.add("Ram");
		names.add("zacker");

		/*
		 * 1. There is no life for intermediate op if there is no Terminal op 2.
		 * Terminal op will execute only if intermediate op returns true
		 */

		long val = names.stream().filter(s -> s.startsWith("A")).count();
		System.out.println(val);

		long d = Stream.of("Abi", "Anbuselvan", "Achuthan", "Ram", "zacker").filter(s -> {
			s.startsWith("A");
			return false;
		}).count();
		System.out.println(d);

		// names.stream().filter(s->s.length()>4).forEach(s->System.out.println(s));
		names.stream().filter(s -> s.length() > 4).limit(1).forEach(s -> System.out.println(s));

	}

	@Test
	public void streamMap() {

		ArrayList<String> names = new ArrayList<String>();
		names.add("Man");
		names.add("Don");
		names.add("Woman");

		/* Print names which have the last letter 'n' with Uppercase */
		
		Stream.of("Abi", "Anbuselvan", "Achuthan", "Ram", "zacker").filter(s -> s.endsWith("n"))
				.map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));

		/* Print names which have first letter as "A" with Uppercase & sorted */
		
		List<String> names1 = Arrays.asList("Abi", "Anbuselvan", "Achuthan", "Ram", "zacker");
		names1.stream().filter(s -> s.startsWith("A")).sorted().map(s -> s.toUpperCase())
				.forEach(s -> System.out.println(s));

		/* Merging 2 different list */
		Stream<String> newStreams = Stream.concat(names1.stream(), names.stream());
		// newStreams.sorted().forEach(s->System.out.println(s));
		boolean flag = newStreams.anyMatch(s -> s.equalsIgnoreCase("zacker"));
		System.out.println(flag);
		Assert.assertTrue(flag);
	}

	@Test
	public void streamCollect() {
		List<String> ls = Stream.of("Abi", "Anbuselvan", "Achuthan", "Ram", "zacker")
				.filter(s -> s.endsWith("n"))
				.map(s -> s.toUpperCase()).collect(Collectors.toList());
		System.out.println(ls.get(0));
		
		/*Print unique numbers from the below array*/
		
		List<Integer> values = Arrays.asList(3,2,2,3,4,6,7,8,0,7,5,6,6);
		values.stream().distinct().sorted().forEach(s->System.out.println(s));
		/*sort the array get the 3rd Index  - 3,2,4,6,7,8,0,5*/
		List<Integer> li = values.stream().distinct().collect(Collectors.toList());
		System.out.println("array get the 3rd Index " +li.get(3));
	}

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
	}

}
