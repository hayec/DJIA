package problem1;
import java.util.Scanner;
import java.io.*;
import java.text.DecimalFormat;
import java.util.Calendar;
import javafx.stage.*;
public class DJIAController implements Observer 
{
	DJIAView view = new DJIAView();
	Data model = new Data();
	Stage primaryStage;
	String strDate;
	DecimalFormat format = new DecimalFormat("00");
	public DJIAController(Stage stage)
	{
		primaryStage = stage;
	}
	public void update(double data, double date)
	{
		model.addDataPoint(data, date);
		view.addPoint(date, data, Calendar.getInstance().get(Calendar.YEAR) + "-" + format.format(Calendar.getInstance().get(Calendar.MONTH) + 1) + "-" + format.format(Calendar.getInstance().get(Calendar.DAY_OF_MONTH)));
	}
	public void loadData() throws FileNotFoundException
	{
		String input = new String();
		double date;
		double data;
		boolean loop = true;
		Scanner fileIn = new Scanner(new File("DJIA.txt"));
		while(loop)
		{
			date = data = 0;
			try
			{
				input = fileIn.nextLine();
				date = Double.parseDouble(input.substring(0, 4));
				strDate = input.substring(0, 10);
				if(date%4 == 0)
					date += (getDayLeap(Double.parseDouble(input.substring(5, 7))) + Double.parseDouble(input.substring(8, 10))) / 366.0;//Account for Leap Years
				else
					date += (getDay(Double.parseDouble(input.substring(5, 7))) + Double.parseDouble(input.substring(8, 10))) / 365.0;
				
				input = input.substring(12);
				if(input.charAt(1) != ' ')//Check that data is there
				{
					data = Double.parseDouble(input);
					model.addDataPoint(data, date);
					view.addPoint(date, data, strDate);
				}
			}
			catch(Exception e) {}
			if(!fileIn.hasNextLine())
				loop = false;
		}
	}
	public void display()
	{
		view.start(primaryStage);
	}
	public void inputDisplay(Stage stage)
	{
		view.inputDisplay(stage);
	}
	public double getDay(double month)
	{
		if(month == 1)
			return 0;
		else if(month == 2)
			return 31;
		else if(month == 3)
			return 59;
		else if(month == 4)
			return 90;
		else if(month == 5)
			return 120;
		else if(month == 6)
			return 151;
		else if(month == 7)
			return 181;
		else if(month == 8)
			return 212;
		else if(month == 9)
			return 243;
		else if(month == 10)
			return 273;
		else if(month == 11)
			return 304;
		else if(month == 12)
			return 334;
		else
			return 0;//In case of unexpected value
	}
	public double getDayLeap(double month)
	{
		if(month == 1)
			return 0;
		else if(month == 2)
			return 31;
		else if(month == 3)
			return 60;
		else if(month == 4)
			return 91;
		else if(month == 5)
			return 121;
		else if(month == 6)
			return 152;
		else if(month == 7)
			return 182;
		else if(month == 8)
			return 213;
		else if(month == 9)
			return 244;
		else if(month == 10)
			return 274;
		else if(month == 11)
			return 305;
		else if(month == 12)
			return 335;
		else
			return 0;//In case of unexpected value
	}
}
