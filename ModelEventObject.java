package problem1;

import java.time.LocalDate;
import java.util.EventObject;

public class ModelEventObject extends EventObject
{
	private LocalDate date;
	public ModelEventObject(Object source)
	{
		super(source);
	}
	public ModelEventObject(Object source, LocalDate date)
	{
		super(source);
		this.date = date;
	}
	public LocalDate getDate()
	{
		return date;
	}
}
