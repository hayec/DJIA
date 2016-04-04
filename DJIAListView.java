package problem1;

import java.time.LocalDate;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class DJIAListView 
{
	ListView list = new ListView();
	ObservableList<String> items = FXCollections.observableArrayList();
	public void start(Stage stage)
	{
		list.setItems(items);
		Scene scene = new Scene(list, 1280, 720);
		stage.setScene(scene);
		stage.show();
	}
	public void addPoint(LocalDate date, double data)
	{
		int index = -1;
		for(int i = 0; i < list.getItems().size(); i++)
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
				list.getItems().add(index, "Value : " + data + "    Date : " + date.toString());
			else
				list.getItems().add("Value : " + data + "    Date : " + date.toString());
			list.getItems().remove(index2);
		}
		else
		{
			if(index != -1)
				list.getItems().add(index, "Value : " + data + "    Date : " + date.toString());
			else
				list.getItems().add("Value : " + data + "    Date : " + date.toString());
		}
	}
}
