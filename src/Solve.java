import java.util.Random;

public class Solve {
    private int[][] matrix = new int[9][9];
    boolean solved = false;

    public Solve(){
	Random random = new Random();
	int randomInteger = random.nextInt(15);
   
	while(randomInteger<12)
	    {
		      randomInteger = random.nextInt(15);
	    }
	
	for(int i = 0; i<randomInteger;i++)
	    {
		int row = random.nextInt(9);
		int col = random.nextInt(9);
		int val = random.nextInt(9);
		if(check(row,col,val))
		    {
			matrix[row][col]=val;
		    }
		
	    }

	show();
	System.out.println(" =========================");
	solver();
	show();
    }

    public boolean solver(){
	for(int row = 0; row < 9; row++)
	    {
		for(int col = 0; col < 9; col++)
		    {

			if(matrix[row][col] == 0)
			    {

				for(int number = 1; number <= 9; number++)
				    {
					if(check(row, col, number))
					    {

						matrix[row][col] = number;

						if(solver())
						    {
							return true;
						    }else
						    {
							matrix[row][col] = 0;
						    }
					    }
				    }

				return false;
			    }
		    }
	    }

	return true;
    }

    private boolean check(int row, int col, int value){

	for(int i = 0; i < 9; i++)
	    {

		if(matrix[row][i] == value)
		    {

			return false;
		    }
		if(matrix[i][col] == value)
		    {

			return false;
		    }
	    }

	int rowStart = row - row % 3;
	int colStart = col - col % 3;

	for(int i = rowStart; i < rowStart + 3; i++)
	    {
		for(int j = colStart; j < colStart + 3; j++)
		    {
			if(matrix[i][j] == value)
			    {
				return false;
			    }
		    }
	    }

	return true;

    }

    private void show(){
	for(int row = 0; row < 9; row++)
	    {
		if(row % 3 == 0)
		    {
			System.out.println(" |-------|-------|-------|");
		    }

		for(int col = 0; col < 9; col++)
		    {
			if(col % 3 == 0)
			    {
				System.out.print(" |");
			    }
			System.out.print(" " + matrix[row][col]);

			if(col == 8)
			    {
				System.out.print(" |");
			    }
		    }
		System.out.println("");
	    }
	System.out.println(" |-------|-------|-------|");
    }
}
