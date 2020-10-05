import acm.graphics.*;
import acm.program.*;
import acm.util.*;

public class RandomCircles extends GraphicsProgram
{
	public void run()
	{
		//gives us the ability to use random variables
		RandomGenerator rando = RandomGenerator.getInstance();
		
		//for loop that runs 10 times for 10 circles
		for (int x = 0; x < 10; x++) 
		{
			//creates random radius, x position, y position and color before creating a circle 10 times
			double radius = rando.nextDouble(5, 50);
			double diameter = 2*radius;
			double xPos = rando.nextDouble(0, getWidth() - diameter);
			double yPos = rando.nextDouble(0, getHeight() - diameter);
			GOval circle = new GOval(xPos, yPos, radius * 2, radius *2);
			circle.setFilled(true);;
			circle.setFillColor(rando.nextColor());
			add(circle);
		}
	}
	
}
