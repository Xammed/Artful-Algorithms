import java.util.Scanner;

public class Driver {
	private static long ops = 1;
	private static long prodTotal = 0;
	public static void main(String[] args) {
		int best = optimizeJobProducts(); float average = prodTotal/ops;
		System.out.println("Average Productivity: " + average);
		System.out.println("Improvement over Average: " + (best - average));
	}
	private static void swap(int[] input, int a, int b) {
	    int tmp = input[a];
	    input[a] = input[b];
	    input[b] = tmp;
	}
	private static int optimizeJobProducts() {
		int[][] jobMatrix = collectInput();
		int n = jobMatrix.length;
		int[] indexes = new int[n];
		int[] elements = new int[n];
		for (int i = 0; i < n; i++) {
		    indexes[i] = 0;
		    elements[i]=i;
		}
		int[] bestConfig = elements;
		int[] worstConfig = elements;
		int maxProduct = getTotalValue(jobMatrix, elements);
		int minProduct = getTotalValue(jobMatrix, elements);
		for(int i =0; i<n ;i++) {
		    if (indexes[i] < i) {
		        swap(elements, i % 2 == 0 ?  0: indexes[i], i);
		        int productivity = getTotalValue(jobMatrix, elements);
		        prodTotal += productivity;
		        if(productivity>maxProduct) {
		        	maxProduct = productivity;
		        	bestConfig = elements.clone();
		        }
		        if(productivity < minProduct) {
		        	minProduct = productivity;
		        	worstConfig = elements.clone();
		        }
		        ops++;
		        indexes[i]++;
		        i = 0;
		    }
		    else {
		        indexes[i] = 0;
		    }
		}
		System.out.println("BEST CONFIG:");
		printConfig(bestConfig, maxProduct);
		System.out.println("WORST CONFIG:");
		printConfig(worstConfig, minProduct);
		return maxProduct;
	}
	private static void printConfig(int[] bestConfig, int productivity) {
		StringBuilder results = new StringBuilder("Total Observed: " + ops);
		for (int i = 0; i<bestConfig.length; i++) 
			results.append("\nWorker " + i + " gets job " + bestConfig[i]);
		results.append("\nTotal Productivity: " + productivity);
		System.out.println(results);
	}
	private static int[][] collectInput(){
		Scanner scan = new Scanner(System.in);
		StringBuilder matrixViewer = new StringBuilder();
		System.out.println("Enter Size");
		int dimen = scan.nextInt();
		int[][] jobVals = new int[dimen][dimen];
		for(int i = 0; i<dimen; i++) {
			for(int j = 0; j<dimen; j++) {
				jobVals[i][j] = scan.nextInt();
				matrixViewer.append(jobVals[i][j] + "     ");
			}
			matrixViewer.append("\n");
		}
		System.out.println(matrixViewer);
		return jobVals;
	}
	private static int getTotalValue(int[][] matrix, int[] workerConfig) {
		int productivity =0;
		for (int i = 0; i<workerConfig.length; i++) 
			productivity += matrix[i][workerConfig[i]];
		return productivity;
	}
}
