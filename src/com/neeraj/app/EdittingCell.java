/**
 * com.neeraj.app EdittingCell.java
 * @author Neeraj Kumar
 * @since Nov 24, 201812:57:24 PM	
 */
package com.neeraj.app;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TableCell;
import javafx.scene.control.TextField;
import sun.font.CreatedFontTracker;

/**
 * Copyright Holiday-Factory
 * com.neeraj.app 
 * EdittingCell.java
 * @author Neeraj Kumar
 * @since Nov 24, 2018 12:57:24 PM	
 */
public class EdittingCell extends TableCell<Person, String> {
	private TextField textfield;
	
	@Override
	public void startEdit(){
		if(!isEmpty()){
			super.startEdit();
			createTextField();
			setText(null);
			setGraphic(textfield);
			textfield.selectAll();
			
		}
	}

	@Override
	public void cancelEdit(){
		super.cancelEdit();
		setText((String)getItem());
		setGraphic(null);
	}
	
	
	
	
	
	private void createTextField(){
		textfield=new TextField(getString());
		textfield.setMinWidth(this.getWidth()-this.getGraphicTextGap()*2);
		
		textfield.focusedProperty().addListener(new ChangeListener<Boolean>() {

			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				if(!newValue){
					commitEdit(textfield.getText());
				}
				
			}
			
		});
	}
	private String getString(){
		return getItem()==null?"":getItem().toString();
	}
}
