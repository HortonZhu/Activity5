import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;
import java.awt.Color;

import java.util.ArrayList;

public class Coyote extends Critter
{
	private int consecutiveSteps;
	private int waitCount;
	public Coyote()
	{
		consecutiveSteps = 0;
		waitCount = 0;
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
		//if blocked
		if ( loc.equals(getLocation()) )
		{
			//blocked by edge of grid
			if ( !getGrid().isValid(loc.getAdjacentLocation(getDirection())) )
			{
				//wait 5 
				waitCount++;
				if ( waitCount > 5 )
				{
					//choose random new direction (must be empty and valid)
					waitCount = 0;
					setDirection( getDirectionToward( getGrid().getEmptyAdjacentLocations(loc)
						[Math.random() * getGrid().getEmptyAdjacentLocations(loc).size()] ));
				}
			}
			//blocked by actor
			else
			{
				//blocked by boulder
				if ( getGrid().get(loc.getAdjacentLocation(getDirection())) instanceof Boulder )
				{
					Kaboom kaboom = new Kaboom();
					kaboom.putSelfInGrid( loc.getAdjacentLocation(getDirection()) );
					removeSelfFromGrid();
					return;
				} 
				else
				{
				waitCount++;
					if ( waitCount > 5 )
					{
						//INCOMPLETE ADD ROCK
						waitCount = 0;
						setDirection( getDirectionToward( getGrid().getEmptyAdjacentLocations(loc)
							[Math.random() * getGrid().getEmptyAdjacentLocations(loc).size()] ));
					}
				}
			}
			//blocked by another actor
			else
			{
				
			}
		}
	}
}
