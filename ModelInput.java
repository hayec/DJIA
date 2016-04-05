package problem1;

import java.time.LocalDate;
import java.util.ArrayList;

public class ModelInput implements PlotPoint 
{
	private ArrayList<ModelObserver> observers;//List of Input Observers
	private LocalDate date;//Transmit new data value, the data can be derived from the date by accessing the model
	public ModelInput()
	{
		observers = new ArrayList<ModelObserver>();
	}
	public void register(ModelObserver o)
	{
		observers.add(o);
	}
	public void unregister(ModelObserver o)
	{
		observers.remove(o);
	}
	public void notifyObserver()
	{
		for(ModelObserver o : observers)
			o.displayPoint(date);
	}
	public void setDataPoint(LocalDate date)
	{
		this.date = date;
	}
}
