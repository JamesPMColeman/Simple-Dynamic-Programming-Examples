import java.util.Scanner;

public class Ex23 {

	private static int[][] matrix;
	private static char[][] path;
	private static String a, b;

	private static int score(int x, int y) {
		return 1;
	}

	private static int match(char a, char b) {
		if (a != b) return 1;
		return 0;
	}

	private static void computeSequence(int x, int y) {
		
		if (x == 0) {
			matrix[x][y] = 2 * y + match(a.charAt(x), b.charAt(y)); 
			path[x][y] = 'B';
		}
		else if (y == 0) {
			matrix[x][y] = 2 * x + match(a.charAt(x), b.charAt(y)); 
			path[x][y] = 'B';
		}
		else {
			System.out.println(x + ", " + y);
			matrix[x][y] = score(x, y);
		}
		if (x == a.length() - 1 && y == b.length() - 1) return;
		else if (y == b.length() - 1) computeSequence(++x, 0);
		else computeSequence(x, ++y);	
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
		path = new char[temp1.length()][temp2.length()];
		a = temp1;
		b = temp2;
		System.out.println("a length: " + a.length());
		System.out.println("b length: " + b.length());
	}

	private static void printMatrix() {
		System.out.print("    ");
        for (int col=0; col < b.length(); col++) System.out.printf("%12c", b.charAt(col) );

        System.out.println("\n");
        for (int row=1; row<=a.length(); row++) {
            System.out.printf("%4c", a.charAt(row - 1));
            for (int col=1; col<=b.length(); col++) {
                System.out.printf("%8d(%2c)", matrix[row-1][col-1], path[row-1][col-1] );
            }
            System.out.println("\n");
        }
	}

	public static void main(String[] args) {
		processInput();
		computeSequence(0, 0);
		printMatrix();
	}
}
