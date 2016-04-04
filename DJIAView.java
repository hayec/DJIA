package problem1;
import javafx.scene.*;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DJIAView
{
	//Load GUI Components
	NumberAxis xAxis = new NumberAxis(2005, 2018, 1);
	NumberAxis yAxis = new NumberAxis(0, 20000, 1000);
	LineChart<Number, Number> chart = new LineChart<Number, Number>(xAxis, yAxis);
	XYChart.Series<Number, Number> series = new XYChart.Series<Number, Number>();
	VBox pane = new VBox();
	public void start(Stage primaryStage)
	{
		//Set Chart Settings
		xAxis.setLabel("Year");
		yAxis.setLabel("Value");
		chart.setTitle("Dow Jones Industrial Average Historical Data");
		chart.setCreateSymbols(false);
		pane.getChildren().addAll(chart);
		chart.getData().add(series);
		Scene scene = new Scene(pane, 1280, 720);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public void addPoint(double x, double y)
	{
		boolean exists = false;//Check to make sure that a value for this date has not already been plotted
		int index2 = 0;
		for(int i = 0; i < series.getData().size(); i++)
		{
				String item = series.getData().get(i).getYValue().toString();
				if(item.equals(y))
				{
					index2 = i;
					exists = true;
				}
		}
		if(exists)//If so, delete the old one 
		{	
			//AutoScale Series if Necessary
			series.getData().remove(index2);
			if(x < xAxis.getLowerBound())
				xAxis.setLowerBound(Math.floor(x));
			if(x > xAxis.getUpperBound())
				xAxis.setUpperBound(Math.ceil(x));
			if(y < yAxis.getLowerBound())
				yAxis.setLowerBound((Math.floor(y / 1000) * 1000));
			if(y > yAxis.getUpperBound())
				yAxis.setUpperBound((Math.ceil(y / 1000) * 1000));
			//Add Data
			chart.getData().get(0).getData().add(new XYChart.Data<Number, Number>(x, y));
		}
		else
		{
			//AutoScale Series if Necessary
			if(x < xAxis.getLowerBound())
				xAxis.setLowerBound(Math.floor(x));
			if(x > xAxis.getUpperBound())
				xAxis.setUpperBound(Math.ceil(x));
			if(y < yAxis.getLowerBound())
				yAxis.setLowerBound((Math.floor(y / 1000) * 1000));
			if(y > yAxis.getUpperBound())
				yAxis.setUpperBound((Math.ceil(y / 1000) * 1000));
			//Add Data
			chart.getData().get(0).getData().add(new XYChart.Data<Number, Number>(x, y));
		}
	}
}
