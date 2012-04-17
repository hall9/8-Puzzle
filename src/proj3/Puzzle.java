package proj3;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.lang.*;
import proj3.Tile;
import proj3.BinaryHeap;

public class Puzzle {

	BinaryHeap<Tile> openQ = new BinaryHeap<Tile>();
	LinkedList<Tile> closedTiles = new LinkedList<Tile>();
	int goal[][];
	
	public void solve(int initial[][], int g[][]) {
		openQ.makeEmpty();
		goal = g;
		
		Tile initialTile = new Tile(initial, 0, heuristic(goal,initial), heuristic(goal,initial), null);
		
		printTile(initialTile);
		
		if (initial == goal) {
			// The tiles are a match
		}
		else
		{
			openQ.insert(initialTile);
			solver();
		}
	}
	
	private void goalReached(Tile goalTile) {
		System.out.println("[*]======================");
		System.out.println("[*]Goal State(Sg) reached:");
		System.out.println("");
		printTile(goalTile);
		System.out.println("[*]---------");
		System.out.println("[*]Solution Cost is: " + goalTile.cost);
		System.out.println("");
		System.out.println("[*]Size of the openQ at end of search process: " + openQ.sizeOf());
		System.out.println("");
		
		System.out.println("[*]First five(or Less) states removed from openQ: ");
		int tilesClosed = 5;
		if (closedTiles.size() < 5) {
			tilesClosed = closedTiles.size();
		}
		
		for (int i = 1; i <= tilesClosed; i++) {
			System.out.println("");
			System.out.println("[*]State #" + i);
			System.out.println("");
			printTile(closedTiles.remove());
		}
		
	}
	
	private void solver() {
		boolean solved = false;
		
		while (!openQ.isEmpty() && !solved) {
			Tile sk = openQ.deleteMin();
			
			if (Arrays.deepEquals(sk.state, goal)) {
				// sk is the goal state
				solved = true;
				goalReached(sk);
			}
			else {
				genChildren(sk);
				closedTiles.add(sk);
			}	
		}
	}

	private int heuristic (int goal[][], int current[][]) {
		int heuristic = 0;
		
		for (int i = 0; i < 3; i++) {
			for (int k = 0; k < 3; k++) {
				if (goal[i][k] != current[i][k]) {
					if (goal[i][k] != 0) {
						heuristic += 1;
					}
				}
			}
		}
		
		return heuristic;
	}

	private void genChildren (Tile current) {
		int x = -1;
		int y = -1;
		
		current.status = false;

		for (int i = 0; i < 3; i++) {
			for (int k = 0; k < 3; k++) {
				if (current.state[i][k] == 0) {
					y = i;
					x = k;
				}
			}
		}
		
		Tile down = new Tile(null,99,99,99, current);
		Tile right = new Tile(null, 99,99,99, current);
		Tile left = new Tile(null, 99,99,99, current);
		Tile up = new Tile(null, 99,99,99, current);

			
			//Moving Down
			if (y != 2) {
				down.state = clone2dArray(current.state);
				down.state[y][x] = down.state[y+1][x];
				down.state[y+1][x] = 0;
				down.numMoves = current.numMoves + 1;
				down.heuristic = heuristic(goal, down.state);
				down.cost = down.numMoves + down.heuristic;
				
				if (!checkAncestry (down, down.parent)) {
					openQ.insert(down);
				}
			}

			//Moving Right
			if (x != 2) {
				right.state = clone2dArray(current.state);
				right.state[y][x] =  right.state[y][x+1];
				right.state[y][x+1] = 0;
				right.numMoves = current.numMoves + 1;
				right.heuristic = heuristic(goal, right.state);
				right.cost = right.numMoves + right.heuristic;
				
				if (!checkAncestry (right, right.parent)) {
					openQ.insert(right);
				}
			}

			//Moving Left
			if (x != 0) {
				left.state = clone2dArray(current.state);
				left.state[y][x] =  left.state[y][x-1];
				left.state[y][x-1] = 0;
				left.numMoves = current.numMoves + 1;
				left.heuristic = heuristic(goal, left.state);
				left.cost = left.numMoves + left.heuristic;
				
				if (!checkAncestry (left, left.parent)) {
					openQ.insert(left);
				}
			}

			//Moving Up
			if (y != 0 ) {
				up.state = clone2dArray(current.state);
				up.state[y][x] =  up.state[y-1][x];
				up.state[y-1][x] = 0;
				up.numMoves = current.numMoves + 1;
				up.heuristic = heuristic(goal, up.state);
				up.cost = up.numMoves + up.heuristic;
				
				if (!checkAncestry (up, up.parent)) {
					openQ.insert(up);
				}
			}	
	}
	
	private boolean checkAncestry (Tile current, Tile ancestor) {
		boolean found;
		
		
		if (ancestor == null) {
			// not found, at the root
			found = false;
		}
		else if ( Arrays.deepEquals(current.state, ancestor.state)) {
			// found
			found = true;
		}
		else {
			// not found but going up the tree to see
			found = checkAncestry(current, ancestor.parent);
		}
		
		return found;
	}
	
	public static int[][] clone2dArray(int[][] array) {
		int rows = array.length;
		
		int[][] newArray = (int[][]) array.clone();
		
		for( int row = 0; row<rows; row++) {
			newArray[row] = (int[]) array[row].clone();
		}
		
		return newArray;
		
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
		System.out.println("g = " + tile.numMoves);
		System.out.println("h = " + tile.heuristic);
	}
}
