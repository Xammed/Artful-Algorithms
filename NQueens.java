import java.util.Scanner;


public class Driver {

		private static int numSolutions = 0;
		private static int numComparisons = 0;
	
	    private static boolean isSafe(int[] board, int k) {
	    	boolean isSafeSquare = true;
	        for (int i = 0; i < k && isSafeSquare; i++) {
	            if (board[i] == board[k]) {
	            	isSafeSquare = false;   
	            	numComparisons++;
	            }
	            else if ((board[i] - board[k]) == (k - i)) {
	            	isSafeSquare = false;   
	            	numComparisons++;
	            }
	            else if ((board[k] - board[i]) == (k - i)) {
	            	isSafeSquare = false;  
	            	numComparisons++;
	            }
	        }
	        return isSafeSquare;
	    }

	    private static String printQueens(int[] boardarray) {
	    	StringBuilder boardStr = new StringBuilder();
	        int length = boardarray.length;
	        for (int i = 0; i < length; i++) {
	            for (int j = 0; j < length; j++) {
	                boardStr.append(boardarray[i]==j?"Q ":"* ");
	            }
	             boardStr.append("\n");
	        }
	        return boardStr.toString();
	    }
  
	    private static void PropagateRow(int[] board, int k) {
	    	if(k==board.length) {
	    		System.out.println("Solution #" + (numSolutions+1) + " for a " 
	    	+ board.length + "x" + board.length+ "\n" +
	    	printQueens(board));
	    		numSolutions++;
	    	}
	    	else if(numSolutions==0){
	    		for (int i = 0; i < board.length; i++) {
	                board[k] = i;
	                if (isSafe(board, k)) {
	                	PropagateRow(board, k+1);
	                }
	            }
	    	}
	    }

	    public static void main(String[] args) {
	        Scanner scan = new Scanner(System.in);
	        System.out.println("Board size: ");
	        int size = scan.nextInt();
	    	int[] propagator = new int[size];
	        PropagateRow(propagator, 0);
	        if(numSolutions == 0) {
	        	System.out.println("No Solutions for "+size+"x"+size+ " board");
	        }
	        System.out.println("Number of Solutions: " + numSolutions);
	        System.out.println("Number of Comparisons: " + numComparisons);
	    }

	}