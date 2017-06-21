import java.io.Console;
import java.util.regex.Pattern;
import java.util.Scanner;
import java.util.regex.Matcher;

public class RegexTestHarness {

	public static void main(String[] args){
		Scanner console = new Scanner(System.in);
		if (console == null) {
			System.err.println("No console.");
			System.exit(1);
		}
		while (true) {
			System.out.println("Enter your regex: ");
			Pattern pattern = Pattern.compile(console.nextLine());

			System.out.println("Enter input string to search: ");
			Matcher matcher = pattern.matcher(console.nextLine());

			boolean found = false;

			while (matcher.find()) {
				System.out.printf("I found the text %s starting at " +
						"index %d and ending at index %d\n",
						matcher.group(),
						matcher.start(),
						matcher.end());
				found = true;
			}
			if(!found){
				System.out.println("No match found.");
			}
		}
	}
	public static void RegexExamples(){
		String any = ".*";

		String test1 = "Hello", test2 = "29", test3 = "";

		System.out.println(test1.matches(any));
		System.out.println(test2.matches(any));
		System.out.println(test3.matches(any));

		System.out.println();

		String almostAny = ".+";

		System.out.println(test1.matches(almostAny));
		System.out.println(test2.matches(almostAny));
		System.out.println(test3.matches(almostAny));
		System.out.println();

		String numbersOnly = "\\d*"; // Disallow empty strings by swapping * for +

		System.out.println(test1.matches(numbersOnly));
		System.out.println(test2.matches(numbersOnly));
		System.out.println(test3.matches(numbersOnly));

		System.out.println();

		String colorOptions = "(red|yellow|green)";

		System.out.println("red".matches(colorOptions));

		System.out.println("blue".matches(colorOptions));

		System.out.println();

		String eitherGray = "gr(a|e)y";

		System.out.println("gray".matches(eitherGray));
		System.out.println("grey".matches(eitherGray));
		System.out.println("griy".matches(eitherGray));

		System.out.println();

		String shoe = "shoe(s)?";

		System.out.println("shoe".matches(shoe));
		System.out.println("shoes".matches(shoe));
		System.out.println("shoess".matches(shoe));

	}

}
