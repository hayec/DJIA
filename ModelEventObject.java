package problem1;

import java.time.LocalDate;
import java.util.EventObject;

public class ModelEventObject extends EventObject
{
	private LocalDate date;
	public ModelEventObject(Object source)
	{
		super(source);//Default constructor
	}
	public ModelEventObject(Object source, LocalDate date)
	{
		super(source);
		this.date = date;//Pass date along with default constructor
	}
	public LocalDate getDate()
	{
		return date;
	}
}
