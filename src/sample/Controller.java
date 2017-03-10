package sample;

import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.*;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
//import org.python.util.PythonInterpreter;

public class Controller {
	public Button closeButton;
	File file;
	Writer writer = null;
	StringBuffer sb = new StringBuffer();
	StringBuffer tra  = new StringBuffer();
	StringBuffer val  = new StringBuffer();
	StringBuffer tes  = new StringBuffer();

	// static String WIN_PROGRAMFILES = System.getenv("programfiles");
	// static String FILE_SEPARATOR = System.getProperty("file.separator");

	public Controller() {

	}

	public void LoadDirectory() {
		final Label labelFile = new Label();

		System.out.println("button clicked");
		FileChooser fileChooser = new FileChooser();

		// Set extension filter
		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("arff files (*.arff)", "*.arff");
		fileChooser.getExtensionFilters().add(extFilter);

		// Show open file dialog
		file = fileChooser.showOpenDialog(null);

		labelFile.setText(file.getPath());
		System.out.println(labelFile.getText());
	}

	public void RunScript() throws Exception {

		Process p = Runtime.getRuntime().exec("python test.py");
		BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
		String ret = new String(in.readLine());
		System.out.println("output : " + ret);
	}

	public void RunShell() throws Exception {

		String target = new String("bash /home/rabvieira/workspace/ScriptClass/test.sh");
		// String target = new String(".
		// /home/rabvieira/workspace/GUI/test.sh");

		Runtime rt = Runtime.getRuntime();
		Process proc = rt.exec(target);
		BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
		String ret = new String(in.readLine());
		System.out.println("output : " + ret);
	}

	public void LoadWindow() throws Exception {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/sample/A.fxml"));
			Parent root1 = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setScene(new Scene(root1));
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// http://weka.sourceforge.net/doc.dev/weka/classifiers/Classifier.html
	public void check_KNN() {
		System.out.println("DT");
		sb.append("weka.classifiers.lazy.IBk\n");
	}

	public void check_DesicionTree() {
		System.out.println("KNN");
		sb.append("weka.classifiers.trees.DecisionStump\n");
	}

	public void Done() throws IOException {
		System.out.println("Done");
		try {
			PrintWriter writer = new PrintWriter("classifiers.txt", "UTF-8");
			writer.println(sb.toString());
			writer.close();
		} catch (IOException e) {
			// do something
		}
	}

	public void Selecting() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/sample/B.fxml"));
			Parent root1 = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setScene(new Scene(root1));
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public void LoadTrain() {
		final Label labelFile = new Label();

		System.out.println("button clicked");
		FileChooser fileChooser = new FileChooser();

		// Set extension filter
		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("arff files (*.arff)", "*.arff");
		fileChooser.getExtensionFilters().add(extFilter);

		// Show open file dialog
		file = fileChooser.showOpenDialog(null);

		labelFile.setText(file.getPath());
		System.out.println(labelFile.getText());
		
		tra.append(labelFile.getText());
		System.out.println(tra);
	}
	
	public void LoadValidation() {
		final Label labelFile = new Label();

		System.out.println("button clicked");
		FileChooser fileChooser = new FileChooser();

		// Set extension filter
		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("arff files (*.arff)", "*.arff");
		fileChooser.getExtensionFilters().add(extFilter);

		// Show open file dialog
		file = fileChooser.showOpenDialog(null);

		labelFile.setText(file.getPath());
		System.out.println(labelFile.getText());
		
		val.append(labelFile.getText());
		System.out.println(val);
	}
	
	public void LoadTest() {
		final Label labelFile = new Label();

		System.out.println("button clicked");
		FileChooser fileChooser = new FileChooser();

		// Set extension filter
		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("arff files (*.arff)", "*.arff");
		fileChooser.getExtensionFilters().add(extFilter);

		// Show open file dialog
		file = fileChooser.showOpenDialog(null);

		labelFile.setText(file.getPath());
		System.out.println(labelFile.getText());
		
		tes.append(labelFile.getText());
		System.out.println(tes);
	}
	
	public void ButtonOk() {
		
		Stage stage = (Stage) closeButton.getScene().getWindow();
	    stage.close();
	}
	
}
