import acm.program.*;
import acm.graphics.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

//Note
//I don't know if I missed it somewhere in Mehrans lectures, but I couldn't find him mentioning the mouse listener stuff.
//although he did talk about all the getX and getY stuff
//I ended up just googling the methods inside of awt and doing it that way.

public class LineCreator extends GraphicsProgram
{
	GLine line;
	
	 public void run() 
	 {
		 //since the mouse events are already functions in awt, all the main has to do is add the mouse listeners
		 addMouseListeners();	
	 }
	 
	 //when the mouse is pressed down, it gets the x and y values of the click and makes a line starting there
	 public void mousePressed(MouseEvent click)
	 {
		 double xPos = click.getX();
		 double yPos = click.getY();
		 line = new GLine(xPos, yPos, xPos, yPos);
		 add(line);
	 }

	 //as soon as that mouse is clicked above, it moves to mouseDragged and constantly redraws the line ending at wherever the
	 //mouse is dragged too, ending when the mouse is no longer being dragged IE. click is released
	 public void mouseDragged(MouseEvent release)
	 {
		 double x = release.getX();
		 double y = release.getY();
		 line.setEndPoint(x, y);
	 }
}
