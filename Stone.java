/**
 * @author Horton Zhu, created March 26th, 2025 
 */
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import info.gridworld.actor.Actor;
import info.gridworld.actor.Rock;
import java.awt.Color;

public class Stone extends Rock
{
	private int lifeTime;
	public static final int THRESHOLD = 3;
	public Stone()
	{
		setColor(null);
		lifeTime = (int)(Math.random() * 200 + 1);
	}
	
	public Stone(int lifeTimeIn)
	{
		setColor(null);
		lifeTime = lifeTimeIn;
	}
	
	public void act()
	{
		if ( lifeTime <= THRESHOLD )
		{
			setColor(Color.GREEN);
		}
		if ( lifeTime <= 0 )
		{
			Location currentLoc = getLocation();
			Grid<Actor> gr = getGrid();
			Boulder boulder = new Boulder();
			boulder.putSelfInGrid(gr, currentLoc);
		}
		lifeTime--;
	}
}
