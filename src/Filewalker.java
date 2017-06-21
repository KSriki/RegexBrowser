import java.io.File;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Filewalker {

	public void walk ( String path, String regex ){
		File root = new File(path);
		File[] list = root.listFiles();
		
		if (list==null) return;
		
		for (File f : list){
			if (f.isDirectory()){
				walk(f.getAbsolutePath(), regex);
				//System.out.println("Dir: " + f.getAbsoluteFile() );
			}else{
				Pattern pattern = Pattern.compile(regex);
				Matcher matcher = pattern.matcher(f.getName());
				
				if (matcher.find()) {
					
					System.out.println("File: "+ f.getAbsoluteFile());
					
				}
				
				
			}
		}

	}
	public static void main(String[] args){
		Scanner console = new Scanner(System.in);
		String dir = "";
		String regex = "";
		if (console == null) {
			System.err.println("No console.");
			System.exit(1);
		}
		while (true) {
			System.out.println("Enter your regex: ");
			regex = console.nextLine();
			Pattern pattern = Pattern.compile(regex);
//
//			System.out.println("Enter directory to search: ");
//			dir = console.nextLine();
//			Matcher matcher = pattern.matcher(dir);
	
			Filewalker filewalker = new Filewalker();
			filewalker.walk("/home/",regex);
			
		}
	
	}


}