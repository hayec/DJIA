package problem1;

import java.time.LocalDate;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.DatePicker;

public class DJIAInputView 
{
	InputButtonListener listener;
	public void start(Stage stage)
	{
		//Create Secondary Input Display
		Label lblInput = new Label("Value : ");
		Button btnInput = new Button("Add Data Point");
		TextField txtInput = new TextField();
		txtInput.setMaxWidth(75);
		HBox inputPane = new HBox();
		DatePicker datePic = new DatePicker();
		inputPane.getChildren().addAll(lblInput, txtInput, btnInput);
		inputPane.setAlignment(Pos.CENTER);
		inputPane.setSpacing(10);
		HBox datePane = new HBox();
		datePane.getChildren().addAll(datePic);
		datePane.setAlignment(Pos.CENTER);
		VBox pane = new VBox();
		pane.getChildren().addAll(inputPane, datePane);
		pane.setAlignment(Pos.CENTER);
		pane.setSpacing(50);
		datePic.setValue(LocalDate.now());//Set Default Time to the Current Date
		btnInput.setOnAction(e -> {
			InputButtonEventObject ev = new InputButtonEventObject(this, Double.parseDouble(txtInput.getText()), datePic.getValue());
			if(listener != null)
				listener.inputButtonClicked(ev);
		});
		Scene inputScene = new Scene(pane, 500, 400);
		stage.setScene(inputScene);
		stage.show();
	}
	public void setInputButtonListener(InputButtonListener listener)
	{
		this.listener = listener;
	}
}
