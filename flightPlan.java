import acm.program.*;
import acm.util.*;
import java.io.*;
import java.util.*;

public class flightPlan extends ConsoleProgram {
	

	
	public void run()
	{
		//A hashMap that holds our available flight plans
		HashMap<String, ArrayList<String>> flights = new HashMap<String, ArrayList<String>>();
		//ArrayList that holds all cities
		ArrayList<String> cities = new ArrayList<String>();
		Scanner input = new Scanner(System.in);
		ArrayList<String> plan = new ArrayList<String>();
		
		System.out.println("Welcome to Flight Planner");
		//reads our data from the file
		try
		{
			BufferedReader br = new BufferedReader(new FileReader("flights.txt"));
			while (true)
			{
				String line = br.readLine();
				//reads until file ends
				if (line == null) break;
				// gives us the number index of the point in the line where our divider is
				int divider = line.indexOf("->");
				//first city is our departure city
				String departure = line.substring(0, divider).trim();
				//if the city doesn't exist in our arraylist yet, add its
				if (!cities.contains(departure))
				{
					cities.add(departure);
					flights.put(departure, new ArrayList<String>());
				}
				//second city is our reception city
				String reception = line.substring(divider + 2).trim();
				//adds the two cities together as an available flight plan
				flights.get(departure).add(reception);
			}
			br.close();
		}
		catch (IOException e)
		{
			System.out.println("bad file");
		}
		
		System.out.println("Here's a list of all the cities in our database");
		for (int x = 0; x < cities.size(); x++)
		{
			System.out.println(cities.get(x));
		}
		
		System.out.println("Let's plan a round-trip route!");
		System.out.println("Please enter the starting city :");
		String initialCity = input.nextLine();
		plan.add(initialCity);
		String currentCity = initialCity;
		while (true)
		{
			ArrayList<String> destinations = flights.get(currentCity);
			String nextCity = null;
			while (true)
			{
				System.out.println("From " + currentCity + " you can fly to:");
				for (int x = 0; x < destinations.size(); x++)
				{
						System.out.println(destinations.get(x));
				}
				System.out.println("Where do you want to go?");
				nextCity = input.nextLine();
				if (destinations.contains(nextCity)) break;
				else
				{
					System.out.println("That's not a valid city, buster");
				}
			}
			plan.add(nextCity);
			if (nextCity.equals(initialCity)) break;
			currentCity = nextCity;
		}
		
		System.out.println("The route you have chosen is: ");
		for (int x = 0; x < plan.size(); x++)
		{
			System.out.print(plan.get(x) + " -> ");
		}
	}
	
	

}
