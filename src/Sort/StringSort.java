package Sort;

import java.util.Arrays;
import java.util.Scanner;

public class StringSort {

	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()){
			String string  = scanner.nextLine();
			String[] strs = string.split(" ");
			Arrays.sort(strs);
			System.out.println(Arrays.toString(strs));
		}
	}
}
