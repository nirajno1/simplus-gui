package com.neeraj.app;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainApp extends Application {
	private TableView<Person> table = new TableView<>();

	final ObservableList<Person> data = FXCollections.observableArrayList(
			new Person("Jacob", "Smith", "jacob.smith@example.com"),
			new Person("Isabella", "Johnson", "isabella.johnson@example.com"),
			new Person("Ethan", "Williams", "ethan.williams@example.com"),
			new Person("Emma", "Jones", "emma.jones@example.com"),
			new Person("Michael", "Brown", "michael.brown@example.com"));

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {

		VBox v = new VBox();
		Text text = new Text("Hello");
		v.getChildren().add(text);
		v.setSpacing(5);
		v.setPadding(new Insets(10, 0, 0, 10));
		table.setEditable(true);

		TableColumn<Person, String> t1 = new TableColumn<>("FName");
		TableColumn<Person, String> t2 = new TableColumn<>("LName");
		TableColumn<Person, String> t3 = new TableColumn<>("Email");
		// TableColumn e1 = new TableColumn<>("Primary");
		// TableColumn e2 = new TableColumn<>("Secondary");
		// t3.getColumns().addAll(e1, e2);

		t1.setCellValueFactory(new PropertyValueFactory<Person, String>("firstName"));
		t1.setMinWidth(100);
		t2.setCellValueFactory(new PropertyValueFactory<Person, String>("lastName"));
		t2.setMinWidth(100);
		t3.setCellValueFactory(new PropertyValueFactory<Person, String>("email"));
		t3.setMinWidth(100);
		
		t1.setCellFactory(TextFieldTableCell.forTableColumn());
		t1.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Person,String>>() {
			@Override
			public void handle(CellEditEvent<Person, String> event) {
				((Person)event.getTableView().getItems().get(
					event.getTablePosition().getRow())).setFirstName(event.getNewValue());
			}
		});
		
		t2.setCellFactory(TextFieldTableCell.forTableColumn());
		t2.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Person,String>>() {
			@Override
			public void handle(CellEditEvent<Person, String> event) {
				((Person)event.getTableView().getItems().get(
					event.getTablePosition().getRow())).setLastName(event.getNewValue());
			}
		});
		
		t3.setCellFactory(TextFieldTableCell.forTableColumn());
		t3.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Person,String>>() {
			@Override
			public void handle(CellEditEvent<Person, String> event) {
				((Person)event.getTableView().getItems().get(
					event.getTablePosition().getRow())).setEmail(event.getNewValue());
			}
		});
		
		
		
		
		table.getColumns().addAll(t1, t2, t3);
		table.setItems(data);
		v.getChildren().add(table);

		final TextField addFirstName = new TextField();
		addFirstName.setPromptText("First Name");
		addFirstName.setMaxWidth(t1.getPrefWidth());
		
		final TextField addLastName = new TextField();
		addLastName.setPromptText("Last Name");
		addLastName.setMaxWidth(t2.getPrefWidth());
		
		final TextField addEmail = new TextField();
		addEmail.setPromptText("Email");
		addEmail.setMaxWidth(t3.getPrefWidth());
		
		final Button addButton=new Button("Add");
		addButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				data.add(new Person(addFirstName.getText(),
						addLastName.getText(),
						addEmail.getText()));
			addFirstName.clear();
			addLastName.clear();
			addEmail.clear();
			
			}
			
		});
		table.setPrefHeight(200);
		table.setPrefWidth(300);
		final HBox hb = new HBox();
		hb.setSpacing(3);
		hb.getChildren().addAll(addFirstName,addLastName,addEmail,addButton);
		v.getChildren().add(hb);
		Scene scene = new Scene(v);
		stage.setTitle("Cloud Simulation");
		stage.setScene(scene);
		stage.setWidth(500);
		stage.setHeight(400);
		stage.show();

	}
}
