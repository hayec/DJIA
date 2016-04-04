package problem1;

import java.util.EventObject;

public class InputButtonEventObject extends EventObject 
{
	private double data;
	private double date;
	public InputButtonEventObject(Object source)
	{
		super(source);
	}
	public InputButtonEventObject(Object source, double data, double date)
	{
		super(source);
		this.data = data;
		this.date = date;
	}
	public InputButtonEventObject(Object source, double data)
	{
		super(source);
		this.data = data;
	}
	public double getData()
	{
		return data;
	}
	public double getDate()
	{
		return date;
	}
}
