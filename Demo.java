package problem1;
import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.stage.Stage;
public class Demo extends Application 
{
	@Override
	public void start(Stage primaryStage) throws FileNotFoundException
	{
		//Load controller
		DJIAController control = new DJIAController(primaryStage);
		//Load Observer Components
		DataInput input = new DataInput();
		ModelInput inputM = new ModelInput();
		input.register(control);
		inputM.register(control);
		//Open the three display windows
		control.display();
		//Set model listener
		control.setModelListener(new ModelListener()
		{
			@Override
			public void modelUpdated(ModelEventObject ev)
			{
				inputM.setDataPoint(ev.getDate());
				inputM.notifyObserver();
			}
		});
		//Load Local Data from File
		control.loadData();
		//Set Input Listener
		control.setInputButtonListener(new InputButtonListener()
		{
			@Override
			public void inputButtonClicked(InputButtonEventObject ev)
			{
				input.setDataPoint(ev.getData(), ev.getDate());
				input.notifyObserver();
			}
		});
		
	}
}
