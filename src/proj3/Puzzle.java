package proj3;
import java.util.Comparator;

import proj3.Tile;
import proj3.BinaryHeap;

public class Puzzle implements Comparator<Tile> {

	BinaryHeap q = new BinaryHeap(); 

	public void solve(int initial[][], int goal[][]) {

		if (initial == goal) {
			// The tiles are a match
		}
		else
		{
			Tile initialTile = new Tile(initial, 99,99,99, null);
			initialTile.heuristic = 0;
			initialTile.notMatch = notMatch(goal,initial);
			initialTile.cost = initialTile.heuristic + initialTile.notMatch;
			
			int kids = genChildren(initialTile, goal);
		}
	}
	
	private int notMatch (int goal[][], int current[][]) {
		int numNotMatch = 0;
		
		for (int i = 0; i < 3; i++) {
			for (int k = 0; k < 3; k++) {
				if (goal[i][k] != current[i][k]) {
					numNotMatch += 1;
				}
			}
		}
		
		return numNotMatch;
	}

	private int genChildren (Tile current, int goal[][]) {
		int x = 2;
		int y = 2;

		current.status = false;

		for (int i = 0; i < 3; i++) {
			for (int k = 0; k < 3; k++) {
				if (current.state[i][k] == 0) {
					y = i;
					x = k;
				}
			}
		}
		
			Tile left = new Tile(null, 99,0,0, current);
			Tile right = new Tile(null, 99,0,0, current);
			Tile down = new Tile(null, 99,0,0, current);
			Tile up = new Tile(null, 99,0,0, current);

			
			//Moving Down
			if (y != 2) {
				down.state = current.state;
				down.state[y][x] = current.state[y+1][x];
				down.state[y+1][x] = 0;
				down.notMatch = notMatch(goal, down.state);
				down.heuristic = current.heuristic + 1;
				down.cost = down.notMatch + down.heuristic;
				
				System.out.println("down");
				printTile(down);
			}

			//Moving Right
			if (x != 2) {
				right.state = current.state;
				right.state[y][x] = current.state [y][x+1];
				right.state[y][x+1] = 0;
				right.notMatch = notMatch(goal, right.state);
				right.heuristic = current.heuristic + 1;
				right.cost = right.notMatch + right.heuristic;
				
				System.out.println("right");
				printTile(right);
			}

			//Moving Left
			if (x != 0) {
				left.state = current.state;
				left.state[y][x] =  current.state[y][x-1];
				left.state[y][x-1] = 0;
				left.notMatch = notMatch(goal, left.state);
				left.heuristic = current.heuristic + 1;
				left.cost = left.notMatch + left.heuristic;
				
				System.out.println("left");
				printTile(left);
			}

			//Moving Up
			if (y != 0 ) {
				up.state = current.state;
				up.state[y][x] =  current.state[y-1][x];
				up.state[y-1][x] = 0;
				up.notMatch = notMatch(goal, up.state);
				up.heuristic = current.heuristic + 1;
				up.cost = up.notMatch + up.heuristic;
				
				System.out.println("up");
				printTile(up);
			}
			
			
		return 1;
	}
	
	public void printTile (Tile tile) {
		
		for (int i = 0; i < 3; i++) {
			for (int k = 0; k < 3; k++) {
				System.out.print(tile.state[i][k]);
				System.out.print(" ");
			}
			System.out.println("");
		}
		
		System.out.println("Cost = " + tile.cost);
		System.out.println("g = " + tile.notMatch);
		System.out.println("h = " + tile.heuristic);
		
		System.out.println("");
		System.out.println("");
		
	}
	
}
