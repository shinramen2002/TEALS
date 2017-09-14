//package textExcel;

//Update this file with your own code.

public class SpreadsheetLocation implements Location
{
	Grid _grid;
	String _cellname;
	
    @Override
    public int getRow()
    {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int getCol()
    {
        // TODO Auto-generated method stub
        return 0;
    }
    
    public SpreadsheetLocation(String cellName)
    {
    	_grid = new Spreadsheet();
    	_cellname = cellName;
        // TODO: Fill this out with your own code
    }

}
