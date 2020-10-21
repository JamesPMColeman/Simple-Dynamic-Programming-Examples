import java.util.Scanner;

public class Ex23 {

	private static int[][] matrix;
	private static String a, b;

	private static void computeSequence() {
		System.out.println("Here");
	}

	private static boolean valid(String a, String b) {
		if (a.length() < 1 && 1 > b.length()) return false;
		for (char c : a.toCharArray()) 
			if (c != 'A' && c != 'C' && c != 'G' && c != 'T') return false;  
		for (char c : b.toCharArray()) 
			if (c != 'A' && c != 'C' && c != 'G' && c != 'T') return false;  
		return true;
	}	

	private static void processInput() {
		String temp1, temp2;
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter your first DNA sequence:");
		temp1 = input.nextLine().toUpperCase();
		System.out.println("Please enter your second DNA sequence:");
		temp2 = input.nextLine().toUpperCase();
		if (!valid(temp1, temp1)) {
			System.out.println("Something seems off with your DNA sequences. Please try again");
			processInput();
		}
		matrix = new int[temp1.length()][temp2.length()];
		a = temp1;
		b = temp2;
	}

	public static void main(String[] args) {
		processInput();
		computeSequence();
	}
}
