import java.util.Scanner;

public class Ex21 {
			
	static int N = 6;
	static int[] gameList = new int[] {3, 1, 7, 5, 8, 4};
	static int[][] scores = new int[N][N];
	char[][] moves = new char[N][N];

	private static int makeMatrix(int a, int b) {

		if (a == b) {
			scores[a][b] = gameList[a];
			return gameList[a];
		} 
		else {
			scores[a][b] = sum(a, b) - min(makeMatrix(a + 1, b), makeMatrix(a, b - 1));
		}
		return 99;
	}

	private static int sum(int x, int y) {
		return 1;
	}

	private static int min(int x, int y) {
		return 1;
	}

	private static void processInput() {
/*
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter the number of elements in your game.");
		N = input.nextInt();
		numbers = new int[N]; 
		System.out.println("Please enter the integers of your game.");
		String nums = input.nextLine();
		for (int j = 0; j < N; j++) {
			numbers[j] = Integer.parseInt(nums[j]);	
		}
*/	}

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
		System.out.println(makeMatrix(0, 5));
			
	}
}
