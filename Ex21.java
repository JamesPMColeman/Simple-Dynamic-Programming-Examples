import java.util.Scanner;

public class Ex21 {
			
	static int N;
	static int[] game = new int[] {9, 2, 6, 5, 3, 1, 7, 5, 8, 4};
	static int[][] scores;
	static char[][] moves;

	private static void printMatrix() {
		
    	System.out.print("    ");	
		for (int col=1; col<=N; col++) System.out.printf("%12d", col );
       
    	System.out.println("\n");
		for (int row=1; row<=N; row++) {
        	System.out.printf("%4d", row );
        	for (int col=1; col<=N; col++) { 
            	System.out.printf("%8d(%2c)", scores[row-1][col-1], moves[row-1][col-1] );
			}
			System.out.println("\n");
		}
	}
	private static int makeMatrix(int a, int b) {

		if (a == b) {
			scores[a][b] = game[a];
			moves[a][b] = ' ';
			return game[a];
		} 
		else {
			int left = makeMatrix(a, b - 1);
			int down = makeMatrix(a + 1, b);
			scores[a][b] = sum(a, b) - min(down, left);
			scores[b][a] = scores[a][b];
			moves[a][b] = left > down ? 'F' : 'L';
			moves[b][a] = moves[a][b];
		}
		return scores[a][b];
	}

	private static int sum(int x, int y) {
		int result = 0;
		for (int i = x; i <=y; i++) {
			result += game[i];		
		}
		return result;
	}

	private static int min(int x, int y) {
		return (x > y) ? y : x;
	}

	private static void processInput() {

		try {
			Scanner input = new Scanner(System.in);
			System.out.println("Please enter the number of elements in your game.");
			N = input.nextInt();
			for (int i = 1; i <= N; i++) {
				System.out.println("Please enter v" + i + ": ");
				game[i - 1] = input.nextInt();
			}
		}
		catch (Exception e) { 
			System.out.println("I did not like that input");
			System.exit(1); 
		}
	}

	public static void main(String[] args) {
	/*	if (args.length > 0) {
			N = Integer.parseInt(args[0]);
			
			if (args.length == N + 1) {
				numbers = new int[N];
				for (int i = 1; i <= N; i++) 
					numbers[i - 1] = Integer.parseInt(args[i]);
			}
			else {
				System.out.println("Something was wrong with your input");
				System.out.println("Please try again");
				processInput();
			}
		}
		else processInput();
	*/
		processInput();
 		scores = new int[N][N];
		moves = new char[N][N];
		makeMatrix(0, N - 1);
		printMatrix();		
	}
}
