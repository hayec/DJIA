package problem1;

import java.time.LocalDate;

public class DataPoint 
{
	private double value;
	private LocalDate date;
	DataPoint(double value, LocalDate date)
	{
		this.value = value;
		this.date = date;
	}
	public double getValue()
	{
		return value;
	}
	public LocalDate getDate()
	{
		return date;
	}
}
