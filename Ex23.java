import java.util.Scanner;

public class Ex23 {

	private static int[][] matrix;
	private static String[][] path;
	private static String a, b;

	private static int score(int x, int y) {
		int diagonal = matrix[x - 1][y - 1] + match(a.charAt(x), b.charAt(y)); 
		int up = 2 + matrix[x - 1][y];
		int left = 2 + matrix[x][y - 1];
		// I get the feeling this one is unnecessary 
		if (diagonal == up && up == left) {
			path[x][y] = "D/U/L";
			return diagonal;
		}
		if (diagonal == up && up < left) {
			path[x][y] = "D/U";
			return diagonal;
		}
		if (diagonal == left && up > left) {
			path[x][y] = "D/L";
			return diagonal;
		}
		if (diagonal <= up && diagonal <= left) {
			path[x][y] = "D";
			return diagonal;
		}
		if (up < diagonal && up < left) {
			path[x][y] = "U";
			return up;
		}
		if (left < up && left < diagonal) {
			path[x][y] = "L";
			return left;
		}
		return -1;
	}

	private static int match(char a, char b) {
		if (a == '-' && b != '-' || a != '-' && b == '-') return 2;
		if (a != b) return 1;
		return 0;
	}

	private static void computeSequence(int x, int y) {
		
		if (x == 0) {
			matrix[x][y] = 2 * y + match(a.charAt(x), b.charAt(y)); 
			path[x][y] = "B";
		}
		else if (y == 0) {
			matrix[x][y] = 2 * x + match(a.charAt(x), b.charAt(y)); 
			path[x][y] = "B";
		}
		else {
			matrix[x][y] = score(x, y);
		}
		if (x == a.length() - 1 && y == b.length() - 1) return;
		else if (y == b.length() - 1) computeSequence(++x, 0);
		else computeSequence(x, ++y);	
	}
	private static void traceBack() {
		System.out.println("This is the end");
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
		a = temp1 + "-";
		b = temp2 + "-";
		matrix = new int[a.length()][b.length()];
		path = new String[a.length()][b.length()];
		System.out.println("a length: " + a.length());
		System.out.println("b length: " + b.length());
	}

	private static void printMatrix() {
		System.out.print("    ");
        for (int col=0; col < b.length(); col++) System.out.printf("%13c", b.charAt(col));

        System.out.println("\n");
        for (int row=1; row<=a.length(); row++) {
            System.out.printf("%4c", a.charAt(row - 1));
            for (int col=1; col<=b.length(); col++) {
                System.out.printf("%8d(%3s)", matrix[row-1][col-1], path[row-1][col-1] );
            }
            System.out.println("\n");
        }
	}

	public static void main(String[] args) {
		processInput();
		computeSequence(0, 0);
		printMatrix();
		traceBack();
	}
}
