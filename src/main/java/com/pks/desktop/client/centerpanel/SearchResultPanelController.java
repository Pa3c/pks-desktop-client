package com.pks.desktop.client.centerpanel;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.pks.desktop.client.application.DataStorage;
import com.pks.desktop.client.model.Ticket;
import com.pks.desktop.client.model.User;
import com.pks.desktop.client.service.BusCourseService;
import com.pks.desktop.client.service.TicketService;
import com.pks.desktop.client.table.model.BusCourseTableModel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

@Controller
@Scope("singleton")
public class SearchResultPanelController {

	@Autowired
	private BusCourseService busCourseService;
	@Autowired
	private TicketService ticketService;
	@FXML
	private TableView<BusCourseTableModel> tableCourses;
	@FXML
	private DatePicker datePicker;
	@FXML
	private Button buyButton;
	private TableColumn<BusCourseTableModel, String> fromCol, toCol, beginCol, endCol, driverCol, busCol, priceCol;

	private ObservableList<BusCourseTableModel> busCoursesListAdapter;
	private User loggedUser;

	@FXML
	private void initialize() {
		loggedUser = DataStorage.getUser();
		initDatePicker();
		initColumns();
		initBuyButton();

	}

	private void initBuyButton() {
		if (loggedUser == null) {
			buyButton.setDisable(true);
			return;
		}
		buyButton.setOnAction(x -> buyTicket());

	}

	private void buyTicket() {
		BusCourseTableModel selectedItem = tableCourses.getSelectionModel().getSelectedItem();
		if (selectedItem == null)
			return;
		if(datePicker.getValue().isBefore(LocalDate.now())) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Niepoprawna data");
			alert.setHeaderText(null);
			alert.setContentText("Nie można kupic biletu z przeszłości !");
			alert.showAndWait();
			return;
		}
			
		generateAlert(selectedItem);
	}

	private void generateAlert(BusCourseTableModel model) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Buying confirmation");
		alert.setHeaderText("Are you sure to buy this ticket ?");
		alert.setContentText(initTextForTicketAlert(model));

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() != ButtonType.OK)
			return;
		saveTicket(model);
	}

	private void saveTicket(BusCourseTableModel model) {
		Ticket t = new Ticket();
		t.setDate(Date.valueOf(datePicker.getValue()));
		t.setPrice(Double.valueOf(model.getPrice()));
		t.setBusCourse(busCourseService.findBusCourseById(model.getId()));
		t.setUser(loggedUser);
		ticketService.saveTicket(t);
	}

	private String initTextForTicketAlert(BusCourseTableModel model) {
		StringBuilder sb = new StringBuilder("Bilet:\n").append("Kierunek: " + model.getFrom() + "-" + model.getTo())
				.append("\n").append("Godz:" + model.getBegin() + "-" + model.getEnd()).append("\n")
				.append("Dnia: " + datePicker.getValue().toString()).append("\n").append("Cena: " + model.getPrice());

		return sb.toString();
	}

	private void initColumns() {
		fromCol = generateColumn("From", "from", 100);
		toCol = generateColumn("To", "to", 100);
		beginCol = generateColumn("Begin", "begin", 100);
		endCol = generateColumn("End", "end", 100);
		driverCol = generateColumn("Driver", "driver", 100);
		busCol = generateColumn("Bus", "bus", 100);
		priceCol = generateColumn("Price", "price", 100);
	}

	private void initDatePicker() {
		LocalDate date = LocalDate.now();
		datePicker.setValue(date);
	}

	@SuppressWarnings("unchecked")
	public void showAvailableCourses(String startStopCity, String endStopCity) {
		busCoursesListAdapter = FXCollections.observableArrayList();
		busCoursesListAdapter.addAll(busCourseService.getBusCourseTableModelListByCities(startStopCity, endStopCity));
		tableCourses.setItems(busCoursesListAdapter);
		tableCourses.getColumns().setAll(fromCol, toCol, beginCol, endCol, driverCol, busCol, priceCol);
	}

	private TableColumn<BusCourseTableModel, String> generateColumn(String name, String property, double width) {
		TableColumn<BusCourseTableModel, String> column = new TableColumn<>(name);
		column.setMinWidth(width);
		column.setCellValueFactory(new PropertyValueFactory<BusCourseTableModel, String>(property));
		return column;
	}

}