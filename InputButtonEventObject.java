package problem1;

import java.time.LocalDate;
import java.util.EventObject;

public class InputButtonEventObject extends EventObject 
{
	private double data;
	private LocalDate date;
	public InputButtonEventObject(Object source)
	{
		super(source);//Default Constructor
	}
	public InputButtonEventObject(Object source, double data, LocalDate date)
	{
		super(source);
		this.data = data;//Pass data and date along with default constructor
		this.date = date;
	}
	public double getData()
	{
		return data;
	}
	public LocalDate getDate()
	{
		return date;
	}
}
