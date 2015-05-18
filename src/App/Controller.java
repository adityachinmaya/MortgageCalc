package App;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class Controller {
	
	//The following is for the scenebuilder buttons and text fields
	@FXML
	TextField TotalGrossIncome;
	@FXML
	TextField TotalMonthlyDebt;
	@FXML
	TextField MortgageInterestRate;
	@FXML
	TextField DownPayment;
	@FXML
	ComboBox<Integer> Term;
	ObservableList<Integer> TermInfo = FXCollections.observableArrayList();
	@FXML
	Button Calc;
	Alert alert = new Alert(AlertType.INFORMATION);
	public Controller() {
		TermInfo.add(30);
		TermInfo.add(15);
		TermInfo.add(10);
	}
	@FXML
	private void initialize() {
		Term.setItems(TermInfo);
	}
	//The following is what does all the calculations
	@FXML
	private void HandleCalc() {
		double TotalgrossIncome = Double.parseDouble(TotalGrossIncome.getText());
		double JustHousing = (TotalgrossIncome / 12) * 0.18;
		double OtherObligations = ((TotalgrossIncome / 12) * 0.36) - (Double.parseDouble(TotalMonthlyDebt.getText()));
		double maxPaymentAllowed = Math.min(JustHousing, OtherObligations);
		
		double TotalmonthlyInterest = (Double.parseDouble(MortgageInterestRate.getText()) / 100) / 12;
		double NumOfPayments = Term.getValue() * 12;
		double Financed = (maxPaymentAllowed * (Math.pow(1 + TotalmonthlyInterest, NumOfPayments) - 1) / (TotalmonthlyInterest * Math.pow(1+ TotalmonthlyInterest, NumOfPayments)));
		alert.setHeaderText(" You can Finance this much: ");
		alert.setContentText(" $" + Double.toString(Financed));
		alert.showAndWait();
	}
}
