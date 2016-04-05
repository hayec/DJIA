package problem1;

import java.time.LocalDate;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DJIAListView 
{
	ListView list = new ListView();
	ObservableList<String> items = FXCollections.observableArrayList();
	public void start(Stage stage)
	{
		list.setItems(items);
		Label lblTitle = new Label("Dow Jones Industrial Average");
		lblTitle.setAlignment(Pos.CENTER);
		VBox pane = new VBox();
		pane.setAlignment(Pos.CENTER);
		pane.getChildren().addAll(lblTitle, list);
		Scene scene = new Scene(pane, 1280, 500);
		stage.setScene(scene);
		stage.show();
	}
	public void addPoint(LocalDate date, double data)
	{
		int index = -1;
		for(int i = 0; i < list.getItems().size(); i++)//Check for where in the list the new item should be placed
		{
			if(index == -1)
			{	
				String item = list.getItems().get(i).toString();
				if(LocalDate.parse(item.substring(item.indexOf("Date : ") + 7)).isAfter(date))
					index = i;
			}
		}
		boolean exists = false;//Check to make sure that a value for this date has not already been plotted
		int index2 = 0;
		for(int i = 0; i < list.getItems().size(); i++)
		{
				String item = list.getItems().get(i).toString();
				if(LocalDate.parse(item.substring(item.indexOf("Date : ") + 7)).equals(date))
				{
					index2 = i;
					exists = true;
				}
		}
		if(exists)//If so, delete the old one 
		{	
			if(index != -1)
				list.getItems().add(index, "Value : " + data + "    Date : " + date.toString());//If an index was found, add the item there
			else
				list.getItems().add("Value : " + data + "    Date : " + date.toString());//Otherwise, add the item at the end
			list.getItems().remove(index2);
		}
		else//Otherwise proceed as normal
		{
			if(index != -1)
				list.getItems().add(index, "Value : " + data + "    Date : " + date.toString());//If an index was found, add the item there
			else
				list.getItems().add("Value : " + data + "    Date : " + date.toString());//Otherwise, add the item at the end
		}
	}
}
