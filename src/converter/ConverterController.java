package converter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

/**
 * Controller of ConverterUI.
 * @author Charin Tantrakul
 *
 */
public class ConverterController {
	@FXML
	TextField textfield1;
	@FXML
	TextField textfield2;
	@FXML
	Button convertButton;
	@FXML
	ComboBox<Length> unitbox1;
	@FXML
	ComboBox<Length> unitbox2;

	/**
	 * Initialize all Length in ComboBox 
	 */
	@FXML
	public void initialize() {
		if (unitbox1 != null) {
			unitbox1.getItems().addAll(Length.values());
			unitbox1.getSelectionModel().select(0);
		}
		if (unitbox2 != null) {
			unitbox2.getItems().addAll(Length.values());
			unitbox2.getSelectionModel().select(0);
		}
	}

	/**
	 * Handle Convert button.
	 * Convert user's input Length to other Length unit.
	 * @param event that you want to handle it.
	 */
	public void handleConvert(ActionEvent event) {
		String text1 = textfield1.getText().trim();
		String text2 = textfield2.getText().trim();
		Length unit1 = unitbox1.getValue();
		Length unit2 = unitbox2.getValue();
		double valueTF;
		double result;
		try {
			if (textfield1.getText().isEmpty() && !textfield2.getText().isEmpty()||textfield2.isFocused()) {
				valueTF = Double.parseDouble(text2);
				result = valueTF * unit2.getValue();
				textfield1.setText(String.format("%.4g", result / unit1.getValue()));
			} else if (!textfield1.getText().isEmpty() && textfield2.getText().isEmpty()||textfield1.isFocused()) {
				valueTF = Double.parseDouble(text1);
				result = valueTF * unit1.getValue();
				textfield2.setText(String.format("%.4g", result / unit2.getValue()));
			}
		} catch (Exception e) {
			textfield1.setText("INVALID NUMBER");
			textfield2.setText("INVALID NUMBER");
		}
	}

	/**
	 * Clear every text in Textfields.
	 * @param event that you want to handle it.
	 */
	public void handleClear(ActionEvent event) {
		textfield1.clear();
		textfield2.clear();
	}

}
