public class IntArrayWorker
{
  /** two dimensional matrix */
  private int[][] matrix = null;
  public int totalcountof1 = 0;
  public int totalcountof2 = 0;
  public int totalcountof3 = 0;
 
  /** set the matrix to the passed one
    * @param theMatrix the one to use
    */
  public void setMatrix(int[][] theMatrix)
  {
    matrix = theMatrix;
  }
  
  /**
   * Method to return the total 
   * @return the total of the values in the array
   */
  public int getTotal()
  {
    int total = 0;
    for (int row = 0; row < matrix.length; row++)
    {
      for (int col = 0; col < matrix[0].length; col++)
      {   
    	  total = total +  matrix[row][col];
      }
    }
    return total;
  }
  
  /** Get Count from exercise
   * @param theMatrix the one to use
   */
  public int getCount(int count)
  {   
    if (count == 1)
    	return totalcountof1;
    else if (count == 2)
    	return totalcountof2;
    else if (count == 3)
    	return totalcountof3;
    else
    	return 0;
  }
  
  public int getLargest()
  { 
	  int largetValueIntheMatrix = 0;
	    for (int[] rowArray : matrix)
	    {
	      for (int item : rowArray)
	      {	    
	          if (item > largetValueIntheMatrix)
	          	largetValueIntheMatrix = item;
	      }
	    }
	    return largetValueIntheMatrix;	  
  }
  
  /**
   * Method to return the total using a nested for-each loop
   * @return the total of the values in the array
   */
  public int getTotalNested()
  {
    int total = 0;
    for (int[] rowArray : matrix)
    {
      for (int item : rowArray)
      {
        total = total + item;
      }
    }
    return total;
  }
  
  /**
   * Method to fill with an increasing count
   */
  public void fillCount()
  {
    int numCols = matrix[0].length;
    int count = 1;
    for (int row = 0; row < matrix.length; row++)
    {
      for (int col = 0; col < numCols; col++)
      {
        matrix[row][col] = count;
        count++;
      }
    }
  }
  
  /**
   * print the values in the array in rows and columns
   */
  public void print()
  {
    for (int row = 0; row < matrix.length; row++)
    {
      for (int col = 0; col < matrix[0].length; col++)
      {
        System.out.print( matrix[row][col] + " " );
      }
      System.out.println();
    }
    System.out.println();
  }
  
  
  /** 
   * fill the array with a pattern
   */
  public void fillPattern1()
  {
    for (int row = 0; row < matrix.length; row++)
    {
      for (int col = 0; col < matrix[0].length; 
           col++)
      {
        if (row < col)
        {
          matrix[row][col] = 1;
          totalcountof1 = totalcountof1 + 1;
        }
        else if (row == col)
        {
          matrix[row][col] = 2;
          totalcountof2 = totalcountof2 + 1;
        }
        else
        {
          matrix[row][col] = 3;
          totalcountof3 = totalcountof3 + 1;
        }
      }
    }
  }
 
}