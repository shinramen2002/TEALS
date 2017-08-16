//package textExcel;

// Update this file with your own code.

public class Spreadsheet implements Grid
{
	private String[][] spreadsheet;

	public Spreadsheet() {
		//Instantiate  12 columns (A-L) by 20 rows 
		   int width = 12;
		   int height = 20;
		   spreadsheet = new String[height][width];
		   		   // loop through height rows from top to bottom
		   for (int row = 0; row < height; row++) 
		     for (int col = 0; col < width; col++) 
		    	 spreadsheet[row][col] = "";		
	}
	@Override
	public String processCommand(String command)
	{
		// TODO Auto-generated method stub
		return command;
	}

	@Override
	public int getRows()
	{
		// TODO Auto-generated method stub
		return spreadsheet.length;
	}

	@Override
	public int getCols()
	{
		// TODO Auto-generated method stub
		return spreadsheet[0].length;
	}

	@Override
	public Cell getCell(Location loc)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getGridText()
	{
		// TODO Auto-generated method stub
		return null;
	}

}
