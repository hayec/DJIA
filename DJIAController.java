package problem1;
import java.util.Scanner;
import java.io.*;
import java.text.DecimalFormat;
import java.time.LocalDate;
import javafx.stage.*;
public class DJIAController implements Observer, ModelObserver
{
	//Create new classes
	DJIAView view = new DJIAView();
	DJIAInputView inputView = new DJIAInputView();
	DJIAListView listView = new DJIAListView();
	Data model = new Data();
	Stage primaryStage;
	String strDate;
	DecimalFormat format = new DecimalFormat("00");
	public DJIAController(Stage stage)
	{
		primaryStage = stage;//Get default stage from Demo.java
	}
	public void update(double data, LocalDate date)
	{
		model.addDataPoint(data, date);//Update the model, InputButtonActionEvent
	}
	public void displayPoint(LocalDate date)
	{
		view.addPoint(getChartDate(date), model.getData(date));//Update the GUI, ModelChangedActionEvent
		listView.addPoint(date, model.getData(date));
	}
	public void loadData() throws FileNotFoundException
	{
		//Load data from file
		String input = new String();
		int year, month, day;
		double data;
		boolean loop = true;
		Scanner fileIn = new Scanner(new File("DJIA.txt"));
		while(loop)
		{
			data = year = month = day = 0;
			try
			{
				input = fileIn.nextLine();
				year = Integer.parseInt(input.substring(0, 4));//Parse the data into three integers, and the associate DJIA value
				month = Integer.parseInt(input.substring(5, 7));
				day = Integer.parseInt(input.substring(8, 10));
				input = input.substring(12);
				if(input.charAt(1) != ' ')//Check that data is there
				{
					data = Double.parseDouble(input);
					model.addDataPoint(data, LocalDate.of(year, month, day));
				}
			}
			catch(Exception e) {}
			if(!fileIn.hasNextLine())
				loop = false;
		}
	}
	public void display()
	{
		//Open all three GUIs
		view.start(primaryStage);
		listView.start(new Stage());
		inputView.start(new Stage());
	}
	public void setInputButtonListener(InputButtonListener listener)
	{
		//Set Listener
		inputView.setInputButtonListener(listener);
	}
	public void setModelListener(ModelListener listener)
	{
		//Set Listener
		model.setModelListener(listener);
	}
	public double getChartDate(LocalDate date)
	{
		//Get current progress through year in a 0-1 form for the line chart
		double chartDate = date.getYear();
		if(chartDate%4 == 0)
			chartDate += date.getDayOfYear() / 366.0;//Prevent integer parsing
		else
			chartDate += date.getDayOfYear() / 365.0;//Prevent integer parsing
		return chartDate;
	}
}