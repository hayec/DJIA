package problem1;
import java.util.ArrayList;

public class Data 
{
	ArrayList<DataPoint> dataPoints = new ArrayList<DataPoint>();
	public void addDataPoint(double value, double date)
	{
		dataPoints.add(new DataPoint(value, date));
	}
	
}
