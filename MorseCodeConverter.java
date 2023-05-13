//@author: Hasnan Khan
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MorseCodeConverter {
	static MorseCodeTree tree = new MorseCodeTree();;
	public static String printTree() {
		String x = "";
		ArrayList<String> output = new ArrayList<String>();
		output = tree.toArrayList();
		for(int i=0 ;i<output.size();i++) {
			x = x + output.get(i) + " ";
		}
		return x;
		
	}
	//converts morse code to english
	public static String convertToEnglish(String code) {
		String[] s = code.split(" ");
		String output = "";
		for(int i = 0; i<s.length; i++) {
			if(s[i].equals("/")) {
				output+= " ";
			}else {
				output += tree.fetch(s[i]);
			}
		}
		return output;
		}
	//reads line of file and runs the convertToEnglish method
	public static String convertToEnglish(File codeFile) throws FileNotFoundException {
		Scanner scan = new Scanner (codeFile);
		String s = "";
		while(scan.hasNextLine()) {
			s += convertToEnglish(scan.nextLine());
			if(scan.hasNextLine()) {
				s+= " ";
			}
		}
		scan.close();
		System.out.println(s);
		return s;
		
		
	}
}
