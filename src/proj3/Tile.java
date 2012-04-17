package proj3;

public class Tile {

	public Tile (int state1[][], int cost1, int notMatch1, int heuristic1, Tile parent1) {
		
		state = state1;
		cost = cost1;
		notMatch = notMatch1;
		heuristic = heuristic1;
		parent = parent1;
		status = true;
		
	}
	
	public int state[][];
	public int cost;
	public int notMatch;
	public int heuristic;
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
