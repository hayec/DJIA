package problem1;
import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.stage.Stage;
import java.util.Calendar;
public class Demo extends Application 
{
	@Override
	public void start(Stage primaryStage) throws FileNotFoundException
	{
		//Load controller
		DJIAController control = new DJIAController(primaryStage);
		DataInput input = new DataInput();
		input.register(control);
		control.display();
		control.loadData();
		control.inputDisplay(new Stage());
		control.view.setInputButtonListener(new InputButtonListener()
		{
			@Override
			public void inputButtonClicked(InputButtonEventObject ev)
			{
				input.setDataPoint(ev.getData(), getCurrentDate());//Use current date to add point
				input.notifyObserver();
			}
		});
	}
	public double getCurrentDate()
	{	
		double date = 0;
		date = Calendar.getInstance().get(Calendar.YEAR);
		if(date%4 == 0)
			date += Calendar.getInstance().get(Calendar.DAY_OF_YEAR) / 366.0;//Account for Leap Years
		else
			date += Calendar.getInstance().get(Calendar.DAY_OF_YEAR) / 365.0;//Account for Leap Years
		return date;
	}
}
