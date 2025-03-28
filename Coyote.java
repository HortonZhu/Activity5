import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;
import java.awt.Color;

import java.util.ArrayList;

public class Coyote extends Critter
{
	public Coyote()
	{
		setColor(null);
		ArrayList<int> directions = new ArrayList<int>();
		for (int i = 0; i < 8; i++)
		{
			directions.add( i * 45 );
		}
		setDirection(directions[(int)(Math.random() * directions.size())]);
	}
	
	public void makeMove()
	{
		
	}
}
