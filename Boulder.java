/**
 * @author Horton Zhu, created March 26th, 2025 
 */
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import info.gridworld.actor.Actor;
import java.awt.Color;

public class Boulder extends Actor
{
	private int lifeTime;
	public static final int THRESHOLD = 3;
	public Boulder()
	{
		setColor(null);
		lifeTime = (int)(Math.random() * 200 + 1);
	}
	
	public Boulder(int lifeTimeIn)
	{
		setColor(null);
		lifeTime = lifeTimeIn;
	}
	
	public void act()
	{
		if ( lifeTime <= THRESHOLD )
		{
			setColor(Color.RED);
		}
		if ( lifeTime <= 0 )
		{
			Location currentLoc = getLocation();
			Grid<Actor> gr = getGrid();
			Kaboom kaboom = new Kaboom();
			kaboom.putSelfInGrid(gr, currentLoc);
		}
		lifeTime--;
	}
}
