
package proj3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import proj3.Puzzle;

public class Proj3 {

	public static void main(String[] args) throws IOException {
		/*
		 // Importing of the ant Dargs value
		String filepath = args[0];
		 */

		String filepath = "sample.cmds";
		puzzlesolver(filepath);

	}

	static void puzzlesolver (String filename) throws IOException {
		BufferedReader r = new BufferedReader(new FileReader(filename));

		Puzzle p = new Puzzle();
		
		String line;
		String element;

		int initial[][] = new int[3][3];
		int goal[][] = new int[3][3];

		while((line = r.readLine()) != null) {
			StringTokenizer token;
			token = new StringTokenizer (line);

			if (token.hasMoreTokens()) {
				element = token.nextToken();

				if ( element.equals("#") ) {
					// Do nothing skip line
				}
				else {
					initial[0][0] = Integer.parseInt(element);
					element = token.nextToken();
					initial[0][1] = Integer.parseInt(element);
					element = token.nextToken();
					initial[0][2] = Integer.parseInt(element);
					line = r.readLine();
					token = new StringTokenizer (line);
					element = token.nextToken();
					initial[1][0] = Integer.parseInt(element);
					element = token.nextToken();
					initial[1][1] = Integer.parseInt(element);
					element = token.nextToken();
					initial[1][2] = Integer.parseInt(element);
					line = r.readLine();
					token = new StringTokenizer (line);
					element = token.nextToken();
					initial[2][0] = Integer.parseInt(element);
					element = token.nextToken();
					initial[2][1] = Integer.parseInt(element);
					element = token.nextToken();
					initial[2][2] = Integer.parseInt(element);
					line = r.readLine();
					line = r.readLine();
					token = new StringTokenizer (line);
					element = token.nextToken();
					goal[0][0] = Integer.parseInt(element);
					element = token.nextToken();
					goal[0][1] = Integer.parseInt(element);
					element = token.nextToken();
					goal[0][2] = Integer.parseInt(element);
					line = r.readLine();
					token = new StringTokenizer (line);
					element = token.nextToken();
					goal[1][0] = Integer.parseInt(element);
					element = token.nextToken();
					goal[1][1] = Integer.parseInt(element);
					element = token.nextToken();
					goal[1][2] = Integer.parseInt(element);
					line = r.readLine();
					token = new StringTokenizer (line);
					element = token.nextToken();
					goal[2][0] = Integer.parseInt(element);
					element = token.nextToken();
					goal[2][1] = Integer.parseInt(element);
					element = token.nextToken();
					goal[2][2] = Integer.parseInt(element);
				}

			}
		}
		
		System.out.println("[*]Initial State(S0)");
		System.out.println("[*]======================");
		System.out.println("");
		/*
		for (int i = 0; i <= 2; i++) {
			for (int k = 0; k <= 2; k++) {
				System.out.print(initial[i][k]);
				System.out.print(" ");
			}
			System.out.println("");
		}
		
		
		
		System.out.println("[*]Goal State(Sg)");
		System.out.println("[*]======================");
		System.out.println("");
		
		for (int i = 0; i <= 2; i++) {
			for (int k = 0; k <= 2; k++) {
				System.out.print(goal[i][k]);
				System.out.print(" ");
			}
			System.out.println("");
		}
		
		*/
		p.solve(initial, goal);
		
	}
}
