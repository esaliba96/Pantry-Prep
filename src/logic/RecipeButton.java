package logic;

import javafx.event.EventHandler;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class RecipeButton {
	
	Text recipeButton;
	
	public RecipeButton(Recipe r, MealSlotButton m){
		recipeButton = new Text(r.getName());

		recipeButton.setOnDragDetected(new EventHandler <MouseEvent>() {
            public void handle(MouseEvent event) {
                /* drag was detected, start drag-and-drop gesture*/
                /* allow any transfer mode */
                Dragboard db = recipeButton.startDragAndDrop(TransferMode.ANY);
                
                /* put a string on dragboard */
                ClipboardContent content = new ClipboardContent();
                content.putString(recipeButton.getText());
                db.setContent(content);
                
                event.consume();
            }
        });

        m.text.setOnDragOver(new EventHandler <DragEvent>() {
            public void handle(DragEvent event) {
                /* data is dragged over the m.text */
                /* accept it only if it is  not dragged from the same node 
                 * and if it has a string data */
                if (event.getGestureSource() != m.text &&
                        event.getDragboard().hasString()) {
                    /* allow for both copying and moving, whatever user chooses */
                    event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                }
                
                event.consume();
            }
        });

        m.text.setOnDragEntered(new EventHandler <DragEvent>() {
            public void handle(DragEvent event) {
                /* the drag-and-drop gesture entered the m.text */
                /* show to the user that it is an actual gesture m.text */
                if (event.getGestureSource() != m.text &&
                        event.getDragboard().hasString()) {
                    m.text.setFill(Color.GREEN);
                }
                
                event.consume();
            }
        });

        m.text.setOnDragExited(new EventHandler <DragEvent>() {
            public void handle(DragEvent event) {
                /* mouse moved away, remove the graphical cues */
                m.text.setFill(Color.BLACK);
                
                event.consume();
            }
        });
        
        m.text.setOnDragDropped(new EventHandler <DragEvent>() {
            public void handle(DragEvent event) {
                /* data dropped */
                /* if there is a string data on dragboard, read it and use it */
                Dragboard db = event.getDragboard();
                boolean success = false;
                if (db.hasString()) {
                    m.text.setText(db.getString());
                    success = true;
                }
                /* let the recipeButton know whether the string was successfully 
                 * transferred and used */
                event.setDropCompleted(success);
                
                event.consume();
            }
        });

        recipeButton.setOnDragDone(new EventHandler <DragEvent>() {
            public void handle(DragEvent event) {
                /* the drag-and-drop gesture ended */
                /* if the data was successfully moved, clear it */
                if (event.getTransferMode() == TransferMode.MOVE) {
                    recipeButton.setText(recipeButton.getText());
                }              
                event.consume();
            }
        });
        
        recipeButton.setOnMouseClicked(new EventHandler <MouseEvent>(){
        	public void handle(MouseEvent event) {
        		PantryPrep.stage.setScene(RecipeViewScene.getScene(r));
        		event.consume();
        	}
        });
	}
		
}

