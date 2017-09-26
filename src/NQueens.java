import java.util.*;

public class NQueens {
	
	static int[] array;
	static int numSols = 0;
	
	public static void placeQueen(int r, int n) {
    	for(int i = 0; i < n; i++) {
            if (QueenPlacementOkay(r, i)) {
                array[r] = i;
                if(r == n - 1) { 
                    printSolution(array);
                    numSols++;
                }
                else 
                    placeQueen(r + 1, n);
            }
        }
    }

    public static boolean QueenPlacementOkay(int row, int column) {
        for(int i = 0; i < row; i++) 
            if((array[i] == column) || ((i - row) == (array[i] - column)) || ((i - row) == (column - array[i])))
            // Make sure the placement is NOT in the same row, column, major diagonal, and off diagonal.     
            	return false;
        
        return true;
    }

    public static void printSolution(int[] x) {
        for(int i = 0; i < x.length; i++) {
            for (int j = 0; j < x.length; j++) {
                if(array[i] == j) 
                    System.out.print(" Q ");
                else 
                	System.out.print(" * ");
            }
            System.out.println();
        }
        System.out.println();
    }	

    public static void main(String args[]) {
    	System.out.print(" Enter an integer >= 4 : ");	
    	array = new int[new Scanner(System.in).nextInt()];
    	System.out.println();
    	placeQueen(0, array.length);
    	System.out.println("Number of solutions found: " + numSols);
    }
}