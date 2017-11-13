package Logic;

import java.util.ArrayList;

public class UpdateFrame {
	private ArrayList<ButtonFactory> facts;
	public UpdateFrame(){
		facts = new ArrayList<ButtonFactory>();
	}
	public void addFactory(ButtonFactory fact){
		facts.add(fact);
	}
	public void update(MyCalendar c){
		for (int i = 0; i < facts.size();i++){
			facts.get(i).write(c);
		}
	}
}
