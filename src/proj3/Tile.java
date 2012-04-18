package proj3;

public class Tile implements Comparable<Tile> {

	/**
	 * implementing the comapareTo for the heap class
	 * 
	 * @param t1 the tile to compare with
	 */
	@Override
	public int compareTo(Tile t1) {
		int smallerOrNot = 0;

		if (this.cost > t1.cost) {
			smallerOrNot = 1;
		}
		else if (this.cost < t1.cost) {
			smallerOrNot = -1;
		}
		else {
			if (this.numMoves > t1.numMoves ) {
				smallerOrNot = 1;
			}
			else if (this.numMoves < t1.numMoves ) {
				smallerOrNot = -1;
			}
		}

		return smallerOrNot;
	}


	/**
	 * When creating a new tile.
	 * 
	 * @param state1	The state of the puzzle 
	 * @param numMoves1		The number of moves this tile has been thru to get where it is now
	 * @param heuristic1	The number of elements within the state that don't match the goal state
	 * @param cost1		The numMoves + heuristic
	 * @param parent1	A pointer to its last move
	 */
	public Tile (int state1[][], int numMoves1, int heuristic1, int cost1, Tile parent1) {

		state = state1;
		numMoves = numMoves1;
		heuristic = heuristic1;
		cost = cost1;
		parent = parent1;
		status = true;
	}

	public int state[][];
	public int numMoves;
	public int heuristic;
	public int cost;
	public Tile parent;
	public boolean status;
}
