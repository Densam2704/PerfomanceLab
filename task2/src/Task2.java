import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Task2 {
  static Circle c;
  
  public static void main(String[] args) throws IOException {
	if (args.length < 2) {
	  System.out.println("Not enough arguments");
	  return;
	}
	FileReader frForCircle = new FileReader(args[0]);
	Scanner scannerForCircle = new Scanner(frForCircle);
	c = new Circle(new Point(scannerForCircle.nextFloat(), scannerForCircle.nextFloat()), scannerForCircle.nextFloat());
	scannerForCircle.close();
	frForCircle.close();
 
	FileReader frForPoint = new FileReader(args[1]);
	Scanner scannerForPoints = new Scanner(frForPoint);
	while (scannerForPoints.hasNext()){
	  float x = scannerForPoints.nextFloat();
	  float y = scannerForPoints.nextFloat();
	  System.out.println(c.pointPosition(new Point(x,y)));
	}
  }
}
