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
		ArrayList<Integer> directions = new ArrayList<Integer>();
		for (int i = 0; i < 8; i++)
		{
			directions.add( i * 45 );
		}
		setDirection(directions.get((int)(Math.random() * directions.size())));
	}
	
	public void processActors(ArrayList<Actor> actors)
	{
		return;
	}
	public ArrayList<Location> getMoveLocations()
	{
		ArrayList<Location> moveLocations = new ArrayList<Location>();
		if ( getGrid().isValid(getLocation().getAdjacentLocation(getDirection()) )
		{
			moveLocations.add(getLocation().getAdjacentLocation(getDirection()));
		}
		return moveLocations;
	}
	public void makeMove(Location loc)
	{
		//if blocked in front
		if ( loc.equals(getLocation()) )
		{
		}
		if ( getGrid().isValid(loc) );
			moveTo(loc);
	}
}
