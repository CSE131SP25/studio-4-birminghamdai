package studio4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;

import edu.princeton.cs.introcs.StdDraw;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class InterpretDrawingFile {

	public static void main(String[] args) throws FileNotFoundException {
		JFileChooser chooser = new JFileChooser("resources");
		chooser.showOpenDialog(null);
		File f = new File(chooser.getSelectedFile().getPath());
		Scanner in = new Scanner(f); //making Scanner with a File
		String type = in.next();
		int r = in.nextInt();
		int g = in.nextInt();
		int b = in.nextInt();
		boolean filled = in.nextBoolean();
		double x = in.nextDouble();
		double y = in.nextDouble();
		double majorAxis = in.nextDouble();
		double minorAxis = in.nextDouble();
		
		StdDraw.setPenColor (r,g,b);
		
		
		if (type.equals("ellipse")) {
			if (filled == true) {
				StdDraw.filledEllipse(x,y,majorAxis,minorAxis);
			}else {
				StdDraw.ellipse(x,y,majorAxis,minorAxis);
			}
		}
		
		if (type.equals("rectangle")) {
			if (filled == true) {
				StdDraw.filledRectangle(x, y, majorAxis, minorAxis);
			}else {
				StdDraw.rectangle(x, y, majorAxis, minorAxis);
			}
		}
		
		if (type.equals("triangle")) {
			double halfWidth = in.nextDouble();
			double halfHeight = in.nextDouble();
			double [] triangleX = {x,majorAxis,halfWidth};
			double [] triangleY = {y,minorAxis,halfHeight};
			if (filled == true) {
				StdDraw.filledPolygon(triangleX,triangleY);
			}else {
				StdDraw.polygon(triangleX,triangleY);
			}
		}
		
		StdDraw.show();
		
	}
}
