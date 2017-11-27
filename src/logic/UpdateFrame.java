package logic;

import java.util.ArrayList;

class UpdateFrame {
	private ArrayList<ButtonFactory> facts;
	UpdateFrame(){
		facts = new ArrayList<>();
	}
	void addFactory(ButtonFactory fact){
		facts.add(fact);
	}
	void update(MyCalendar c) {
		for (ButtonFactory i : facts){
			i.write(c);
		}
	}
}
