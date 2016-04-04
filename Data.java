package problem1;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Data 
{
	ArrayList<DataPoint> dataPoints = new ArrayList<DataPoint>();
	ModelListener listener;
	DataPoint point;
	public void addDataPoint(double value, LocalDate date)
	{
		boolean exists = false;//Check to make sure that a value for this date has not already been plotted
		for(int i = 0; i < dataPoints.size(); i++)
		{
				LocalDate item = dataPoints.get(i).getDate();
				if(item.equals(date))
				{
					exists = true;
					point = dataPoints.get(i);
				}
		}
		if(exists)
		{
			int dialogButton = JOptionPane.YES_NO_OPTION;
			int dialogResult = JOptionPane.showConfirmDialog (null, "A data point at the same date already exists, with value : " + getData(date) + "\nAre you sure you would like to replace this point with : " + value + "?", "Data Point Already Exists", dialogButton);
			if(dialogResult == JOptionPane.YES_OPTION)
			{
				dataPoints.remove(point);
				dataPoints.add(new DataPoint(value, date));
				ModelEventObject ev = new ModelEventObject(this, date);
				if(listener != null)
					listener.modelUpdated(ev);
			}
		}
		else
		{
			dataPoints.add(new DataPoint(value, date));
			ModelEventObject ev = new ModelEventObject(this, date);
			if(listener != null)
				listener.modelUpdated(ev);
		}
	}
	public double getData(LocalDate date)
	{
		for(DataPoint dp : dataPoints)
		{
			if(dp.getDate().equals(date)) return dp.getValue();
		}
		return 0;//Return a 0 if no date is found
	}
	public void setModelListener(ModelListener listener)
	{
		this.listener = listener;
	}
}
