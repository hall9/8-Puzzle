package proj3;

public class Tile implements Comparable<Tile> {
	
	@Override
	public int compareTo(Tile t1) {
		int smallerOrNot = 0;
		
		if (this.cost > t1.cost) {
			smallerOrNot = 1;
		}
		else if (this.cost < t1.cost) {
			smallerOrNot = -1;
		}
		
		return smallerOrNot;
	}

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
	
	
	/*public String toString() {
		
		String tile = "";
		
		for (int i = 0; i < 3; i++) {
			for (int k = 0; k < 3; k++) {
				tile.concat( String.valueOf(state[i][k]) );
				tile.concat( "\n" );
			}
			tile.concat( "\n" );
		}
		
		tile.concat( String.valueOf( cost ) );
		tile.concat( String.valueOf( notMatch ) );
		tile.concat( String.valueOf( heuristic ) );
		
		tile.concat( "\n" );
		tile.concat( "\n" );
		
		return tile;
	}*/
	
}
