package problem1;
import java.util.ArrayList;

public class DataInput implements AddPoint 
{
	private ArrayList<Observer> observers;
	private double data, date;
	public DataInput()
	{
		observers = new ArrayList<Observer>();
	}
	public void register(Observer o)
	{
		observers.add(o);
	}
	public void unregister(Observer o)
	{
		observers.remove(o);
	}
	public void notifyObserver()
	{
		for(Observer o : observers)
			o.update(data, date);
	}
	public void setDataPoint(double data, double date)
	{
		this.data = data;
		this.date = date;
	}
}
