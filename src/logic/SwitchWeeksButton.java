package logic;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class SwitchWeeksButton {
	Button switchButton;
	public SwitchWeeksButton(int offset, MyCalendar c,String text,UpdateFrame uf){
		switchButton = new Button("" + text);
		switchButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				if (offset < 0){
					for (int i = 0; i < (offset * -1); i++){
						c.prevWeek();
					}
				}
				else if (offset > 0){
					for (int i= 0; i < offset; i++){
						c.nextWeek();
					}
				}
				uf.update(c);
			}
		});
	}
	
}
