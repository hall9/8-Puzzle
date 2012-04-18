
package proj3;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import proj3.Puzzle;

public class Proj3 {

	public static void main(String[] args) {
		 // Importing of the ant Dargs value
		String filepath = args[0];
		
		/*
		String filepath = "samplex.cmds";
		*/
		
		puzzlesolver(filepath);
	}

	/**
	 * This get the states within the file
	 * 
	 * @param filename	This is the file path to the given file
	 * @throws FileNotFoundException 
	 * @throws IOException	Exception throw if the file can't be opened
	 */
	static void puzzlesolver (String filename) {
		BufferedReader r;
		Scanner in = null;
		try {
			r = new BufferedReader(new FileReader(filename));
			in = new Scanner(r);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		int initial[][] = new int[3][3];
		int goal[][] = new int[3][3];
		Puzzle p = new Puzzle();
	
		for (int i = 0; i <= 2; i++) {
			for (int k = 0; k <= 2; k++) {
				initial[i][k] = in.nextInt();
			}
		}
		
		for (int i = 0; i <= 2; i++) {
			for (int k = 0; k <= 2; k++) {
				goal[i][k] = in.nextInt();
			}
		}
		
		p.solve(initial, goal);
	}
}
