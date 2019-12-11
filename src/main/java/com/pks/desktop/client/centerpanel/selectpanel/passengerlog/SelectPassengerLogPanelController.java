package com.pks.desktop.client.centerpanel.selectpanel.passengerlog;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.pks.desktop.client.centerpanel.selectpanel.DeleteConfirmationAlert;
import com.pks.desktop.client.service.EquipmentService;
import com.pks.desktop.client.service.PassengerLogService;
import com.pks.desktop.client.table.model.EquipmentTableModel;
import com.pks.desktop.client.table.model.PassengerLogTableModel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

@Controller
@Scope("singleton")
public class SelectPassengerLogPanelController {

	@Autowired
	private PassengerLogService service;
	@FXML
	private TableView<PassengerLogTableModel> table;
	@FXML
	private Button deleteButton;

	private ObservableList<PassengerLogTableModel> listAdapter;

	@FXML
	private void initialize() {
		initData();
		initDeleteButton();
	}

	private void initDeleteButton() {
		deleteButton.setOnAction(x -> delete());
	}

	private void delete() {
		PassengerLogTableModel selectedItem = table.getSelectionModel().getSelectedItem();
		if (selectedItem == null)
			return;
		generateAlert();
	}

	private void generateAlert() {
		Optional<ButtonType> result = new DeleteConfirmationAlert().getAlert().showAndWait();
		if (result.get() != ButtonType.OK)
			return;
		service.delete(table.getSelectionModel().getSelectedItem().getId());
	}

	public void initData() {
		listAdapter = FXCollections.observableArrayList();
		listAdapter.setAll(service.getTableModels());
		table.setItems(listAdapter);
		initColumns();
	}

	private void initColumns() {
		Field[] fields = PassengerLogTableModel.class.getFields();
		List<TableColumn<PassengerLogTableModel, String>> columns = new ArrayList<>();
		for (Field f : fields) {
			columns.add(generateColumn(f.getName().toUpperCase(), f.getName(), 100));
		}
		table.getColumns().setAll(columns);
	}

	private TableColumn<PassengerLogTableModel, String> generateColumn(String name, String property, double width) {
		TableColumn<PassengerLogTableModel, String> column = new TableColumn<>(name);
		column.setMinWidth(width);
		column.setCellValueFactory(new PropertyValueFactory<PassengerLogTableModel, String>(property));
		return column;
	}



}