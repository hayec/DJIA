package problem1;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.chart.Axis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DJIAView
{
	//Load GUI Components
	NumberAxis xAxis = new NumberAxis(2005, 2018, 1);
	NumberAxis yAxis = new NumberAxis(0, 20000, 1000);
	LineChart<Number, Number> chart = new LineChart<Number, Number>(xAxis, yAxis);
	ListView list = new ListView();
	ObservableList<String> items = FXCollections.observableArrayList();
	XYChart.Series<Number, Number> series = new XYChart.Series<Number, Number>();
	VBox pane = new VBox();
	InputButtonListener listener;
	public void start(Stage primaryStage)
	{
		//Set Chart Settings
		list.setItems(items);
		xAxis.setLabel("Year");
		yAxis.setLabel("Value");
		chart.setTitle("Dow Jones Industrial Average Historical Data");
		chart.setCreateSymbols(false);
		pane.getChildren().addAll(chart, list);
		chart.getData().add(series);
		Scene scene = new Scene(pane, 1280, 720);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public void addPoint(double x, double y, String date)
	{
		//Add data to chart
		list.getItems().add("Value : " + y + "    Date : " + date);
		chart.getData().get(0).getData().add(new XYChart.Data<Number, Number>(x, y));
	}
	public void inputDisplay(Stage stage)
	{
		//Create Secondary Input Display
		Label lblInput = new Label("Value : ");
		Button btnInput = new Button("Add Data Point");
		TextField txtInput = new TextField();
		txtInput.setMaxWidth(75);
		HBox inputPane = new HBox();
		inputPane.getChildren().addAll(lblInput, txtInput, btnInput);
		inputPane.setAlignment(Pos.CENTER);
		inputPane.setSpacing(10);
		btnInput.setOnAction(e -> {
			InputButtonEventObject ev = new InputButtonEventObject(this, Double.parseDouble(txtInput.getText()));
			if(listener != null)
				listener.inputButtonClicked(ev);
		});
		Scene inputScene = new Scene(inputPane, 300, 100);
		stage.setScene(inputScene);
		stage.show();
	}
	public void setInputButtonListener(InputButtonListener listener)
	{
		this.listener = listener;
	}
}
