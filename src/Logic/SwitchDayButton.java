package Logic;

import java.util.Calendar;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class SwitchDayButton {
	public Button switchButton;
	public SwitchDayButton(int offset,boolean isPrev,boolean isEnd,String text,UpdateFrame uf,MyCalendar c){
		switchButton = new Button("" + text);
		switchButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				c.SetDay(offset,isPrev,isEnd);
				uf.update(c);
			}
		});
	}
}
