package Percolation;

public class Percolation {

	boolean[][] grid;
    // creates n-by-n grid, with all sites initially blocked
	int open = 0;
    public Percolation(int n) {
    	for (int i = 0; i<grid.length; i++) {
    		for(int j = 0; j<grid.length; j++) {
    			grid[i][j] = false;
    		}
    	}
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
    	grid[row][col] = true;
    	open++;
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
    	return grid[row][col] == true;
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
    	return grid[row][col] == false;
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
    	return open;
    }

    // does the system percolate?
    public boolean percolates() {
    	boolean percs = true;
    	UnionHandler helper = new UnionHandler(grid.length*grid.length);
    	
    	return percs;
    }


}