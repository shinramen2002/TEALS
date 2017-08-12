import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture. This class inherits from SimplePicture and
 * allows the student to add functionality to the Picture class.
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture {
	///////////////////// constructors //////////////////////////////////

	/**
	 * Constructor that takes no arguments
	 */
	public Picture() {
		/*
		 * not needed but use it to show students the implicit call to super() child
		 * constructors always call a parent constructor
		 */
		super();
	}

	/**
	 * Constructor that takes a file name and creates the picture
	 * 
	 * @param fileName
	 *            the name of the file to create the picture from
	 */
	public Picture(String fileName) {
		// let the parent class handle this fileName
		super(fileName);
	}

	/**
	 * Constructor that takes the width and height
	 * 
	 * @param height
	 *            the height of the desired picture
	 * @param width
	 *            the width of the desired picture
	 */
	public Picture(int height, int width) {
		// let the parent class handle this width and height
		super(width, height);
	}

	/**
	 * Constructor that takes a picture and creates a copy of that picture
	 * 
	 * @param copyPicture
	 *            the picture to copy
	 */
	public Picture(Picture copyPicture) {
		// let the parent class do the copy
		super(copyPicture);
	}

	/**
	 * Constructor that takes a buffered image
	 * 
	 * @param image
	 *            the buffered image to use
	 */
	public Picture(BufferedImage image) {
		super(image);
	}

	////////////////////// methods ///////////////////////////////////////

	/**
	 * Method to return a string with information about this picture.
	 * 
	 * @return a string with information about the picture such as fileName, height
	 *         and width.
	 */
	public String toString() {
		String output = "Picture, filename " + getFileName() + " height " + getHeight() + " width " + getWidth();
		return output;

	}

	/** Method to set the blue to 0 */
	public void zeroBlue() {
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] rowArray : pixels) {
			for (Pixel pixelObj : rowArray) {
				pixelObj.setBlue(0);
			}
		}
	}

	// ** Method to keep Blue Values **/
	/** Method to set the blue to 0 */
	public void keepOnlyBlue() {
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] rowArray : pixels) {
			for (Pixel pixelObj : rowArray) {
				pixelObj.seteverythingtoblue(0);
			}
		}
	}

	/**
	 * Method that mirrors the picture around a vertical mirror in the center of the
	 * picture from left to right
	 */
	public void mirrorVertical() {
		Pixel[][] pixels = this.getPixels2D();
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		int width = pixels[0].length;
		for (int row = 0; row < pixels.length; row++) {
			for (int col = 0; col < width / 2; col++) {
				leftPixel = pixels[row][col];
				rightPixel = pixels[row][width - 1 - col];
				rightPixel.setColor(leftPixel.getColor());
			}
		}
	}

	public void mirrorHorizontal() {
		Pixel[][] pixels = this.getPixels2D();
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		Pixel templeftpixel = null;
		Pixel temprightpixel = null;
		int width = pixels[0].length;
		for (int row = 0; row < pixels.length; row++) {
			for (int col = 0; col < width / 2; col++) {
				templeftpixel = pixels[row][col];
				temprightpixel = pixels[row][width - 1 - col];
				leftPixel = pixels[pixels.length - 1 - row][col];
				rightPixel = pixels[pixels.length - 1 - row][width - 1 - col];
				leftPixel.setColor(templeftpixel.getColor());
				rightPixel.setColor(temprightpixel.getColor());
			}
		}
	}

	public void mirrorHorizontalBotToTop() {
		Pixel[][] pixels = this.getPixels2D();
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		Pixel templeftpixel = null;
		Pixel temprightpixel = null;
		int width = pixels[0].length;
		for (int row = 0; row < pixels.length; row++) {
			for (int col = 0; col < width / 2; col++) {
				// templeftpixel = pixels[row][col];
				// temprightpixel = pixels[row][width - 1 - col];
				// leftPixel = pixels[pixels.length - 1 - row][col];
				// rightPixel = pixels[pixels.length - 1 - row][width - 1 - col];
				// leftPixel.setColor(templeftpixel.getColor());
				// rightPixel.setColor(temprightpixel.getColor());
				// REVERSE ORDER
				templeftpixel = pixels[pixels.length - 1 - row][col];
				temprightpixel = pixels[pixels.length - 1 - row][width - 1 - col];
				leftPixel = pixels[row][col];
				rightPixel = pixels[row][width - 1 - col];
				leftPixel.setColor(templeftpixel.getColor());
				rightPixel.setColor(temprightpixel.getColor());
			}
		}
	}

	public void mirrorVerticalRightToLeft() {
		Pixel[][] pixels = this.getPixels2D();
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		int width = pixels[0].length;
		for (int row = 0; row < pixels.length; row++) {
			for (int col = 0; col < width / 2; col++) {
				leftPixel = pixels[row][col];
				rightPixel = pixels[row][width - 1 - col];
				leftPixel.setColor(rightPixel.getColor());
			}
		}
	}

	/** Mirror just part of a picture of a temple */
	public void mirrorTemple() {
		int mirrorPoint = 276;
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		int count = 0;
		Pixel[][] pixels = this.getPixels2D();
		//
		// // loop through the rows
		// for (int row = 27; row < 97; row++) {
		// // loop from 13 to just before the mirror point
		// for (int col = 13; col < mirrorPoint; col++) {
		//
		// leftPixel = pixels[row][col];
		// rightPixel = pixels[row][mirrorPoint - col + mirrorPoint];
		// rightPixel.setColor(leftPixel.getColor());
		// }
		// }
		// loop through the rows
		for (int row = 27; row < 97; row++) {
			// loop from 13 to just before the mirror point
			for (int col = 13; col < mirrorPoint; col++) {
				leftPixel = pixels[row][col];
				rightPixel = pixels[row][mirrorPoint - col + mirrorPoint];
				rightPixel.setColor(leftPixel.getColor());
				count++;
			}
		}
		System.out.println("Total Count of loop: " + count);
	}
	
//	left arm
//	Top Left = 154 / 101 = Top Right = 154 / 169
//	Lower left = 195 / 101 = Lower Right = 195 / 169
	
//	Right Arm:
//		Top Left = 170 / 237 = Top Right = 170 / 293
//		Lower left = 196/ 237 = Lower Right = 196/ 293
	
	public void mirrorArms() {
		Pixel[][] pixels = this.getPixels2D();
		
		//Left Arm
		int leftwidth = 68;
		int leftrows = 41;
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		for (int row = 0; row < leftrows ; row++) {
			for (int col = 0; col < leftwidth / 2 ; col++) {
				//left pixel 2nd arm
				leftPixel = pixels[154 + row][101 + col];
				//right  pixel 2nd arm
				rightPixel = pixels[154 + row][169 - 1 - col];
				pixels[196 + row][104 + col].setColor(leftPixel.getColor()); 
				pixels[196 + row][172 - 1 - col].setColor(rightPixel.getColor());
			
			}
		}
		
		//Right Arm Loop
		int rightwidth = 56;
		int rightrows = 26;
		Pixel rightarmleftPixel = null;
		Pixel rightarmrightPixel = null;
		for (int row = 0; row < rightrows ; row++) {
			for (int col = 0; col < rightwidth / 2 ; col++) {
				//left pixel 2nd arm
				rightarmleftPixel = pixels[170 + row][237 + col];
				//right  pixel 2nd arm
				rightarmrightPixel = pixels[170 + row][293 - 1 - col];
				pixels[197 + row][237 + col].setColor(rightarmleftPixel.getColor()); 
				pixels[197 + row][293 - 1 - col].setColor(rightarmrightPixel.getColor());
			
			}
		}
	}
	
//	Seagull
//	Top Left = 234/ 235 = Top Right = 234/ 344
//	Lower left = 321 / 235 = Lower Right = 321/ 344
	
	public void mirrorGull() {
		Pixel[][] pixels = this.getPixels2D();
		
		//Left Arm
		int width = 109;
		int rows = 87;
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		for (int row = 0; row < rows ; row++) {
			for (int col = 0; col < width / 2 ; col++) {
				//left pixel 2nd arm
				leftPixel = pixels[234 + row][235 + col];
				//right  pixel 2nd arm
				rightPixel = pixels[234 + row][343 - 1 - col];
				pixels[234 + row][345 + col].setColor(leftPixel.getColor()); 
				pixels[234 + row][453 - 1 - col].setColor(rightPixel.getColor());
			
			}
		}
	}

	/**
	 * copy from the passed fromPic to the specified startRow and startCol in the
	 * current picture
	 * 
	 * @param fromPic
	 *            the picture to copy from
	 * @param startRow
	 *            the start row to copy to
	 * @param startCol
	 *            the start col to copy to
	 */
	public void copy(Picture fromPic, int startRow, int startCol) {
		Pixel fromPixel = null;
		Pixel toPixel = null;
		Pixel[][] toPixels = this.getPixels2D();
		Pixel[][] fromPixels = fromPic.getPixels2D();
		for (int fromRow = 0, toRow = startRow; fromRow < fromPixels.length
				&& toRow < toPixels.length; fromRow++, toRow++) {
			for (int fromCol = 0, toCol = startCol; fromCol < fromPixels[0].length
					&& toCol < toPixels[0].length; fromCol++, toCol++) {
				fromPixel = fromPixels[fromRow][fromCol];
				toPixel = toPixels[toRow][toCol];
				toPixel.setColor(fromPixel.getColor());
			}
		}
	}
	
	public void copy(Picture fromPic, int startRow, int endRow, int startCol, int endCol) {
		Pixel fromPixel = null;
		Pixel toPixel = null;
		Pixel[][] toPixels = this.getPixels2D();
		Pixel[][] fromPixels = fromPic.getPixels2D();
		for (int fromRow = 0, toRow = startRow; fromRow < fromPixels.length - endRow
				&& toRow < toPixels.length - endRow; fromRow++, toRow++) {
			for (int fromCol = 0, toCol = startCol; fromCol < fromPixels[0].length - endCol
					&& toCol < toPixels[0].length - endCol; fromCol++, toCol++) {
				fromPixel = fromPixels[fromRow][fromCol];
				toPixel = toPixels[toRow][toCol];
				toPixel.setColor(fromPixel.getColor());
			}
		}
	}

	/** Method to create a collage of several pictures */
	public void createCollage() {
		Picture flower1 = new Picture("flower1.jpg");
		Picture flower2 = new Picture("flower2.jpg");
		this.copy(flower1, 0, 0);
		this.copy(flower2, 100, 0);
		this.copy(flower1, 200, 0);
		Picture flowerNoBlue = new Picture(flower2);
		flowerNoBlue.zeroBlue();
		this.copy(flowerNoBlue, 300, 0);
		this.copy(flower1, 400, 0);
		this.copy(flower2, 500, 0);
		this.mirrorVertical();
		this.write("collage.jpg");
	}
	
	public void createCollageWithEndRowsAndColumns() {
		Picture flower1 = new Picture("flower1.jpg");
		Picture flower2 = new Picture("flower2.jpg");
		this.copy(flower1, 0, 50, 0, 0);
		this.copy(flower2, 100, 50, 0, 0);
		this.copy(flower1, 200, 0);
		Picture flowerNoBlue = new Picture(flower2);
		flowerNoBlue.zeroBlue();
		this.copy(flowerNoBlue, 300, 0);
		this.copy(flower1, 400, 0);
		this.copy(flower2, 500, 0);
		this.mirrorVertical();
				this.write("D:\\temp\\collage.jpg");
	}
	

	/** Method to create a collage of several pictures */
	public void myCollage() {
		Picture flower1 = new Picture("flower1.jpg");
		Picture flower2 = new Picture("flower2.jpg");
		Picture flower3 = new Picture("flower1.jpg");
		this.copy(flower1, 0, 0);
		Picture flowerNoBlue = new Picture(flower2);
		flowerNoBlue.zeroBlue();
		flowerNoBlue.mirrorHorizontal();
		this.copy(flowerNoBlue, 100, 0);
		this.copy(flower3, 200, 0);
		this.copy(flowerNoBlue, 300, 0);
		this.copy(flower1, 400, 0);
		this.copy(flower3, 500, 0);
		this.mirrorVertical();
		this.write("collage.jpg");
	}

	/**
	 * Method to show large changes in color
	 * 
	 * @param edgeDist
	 *            the distance for finding edges
	 */
	public void edgeDetection(int edgeDist) {
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		Pixel[][] pixels = this.getPixels2D();
		Color rightColor = null;
		for (int row = 0; row < pixels.length; row++) {
			for (int col = 0; col < pixels[0].length - 1; col++) {
				leftPixel = pixels[row][col];
				rightPixel = pixels[row][col + 1];
				rightColor = rightPixel.getColor();
				if (leftPixel.colorDistance(rightColor) > edgeDist)
					leftPixel.setColor(Color.BLACK);
				else
					leftPixel.setColor(Color.WHITE);
			}
		}
	}

	/*
	 * Main method for testing - each class in Java can have a main method
	 */
	public static void main(String[] args) {
		Picture beach = new Picture("beach.jpg");
		beach.explore();
		beach.zeroBlue();
		beach.explore();

	}

} // this } is the end of class Picture, put all new methods before this
