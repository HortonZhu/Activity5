import info.gridworld.actor.Actor;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import java.awt.Color;

public class Kaboom extends Actor
{
	private int lifeTime;
	public static final int THRESHOLD = 3;
	public Kaboom()
	{
		lifeTime = THRESHOLD;
		setColor(null);
	}
	
	public void act()
	{
		if ( lifeTime <= 0 )
		{
			removeSelfFromGrid();
		}
		lifeTime--;
	}
}
