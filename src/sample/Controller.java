package sample;

import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.*;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
//import org.python.util.PythonInterpreter;

public class Controller {
	File file;
	Writer writer = null;
	 StringBuffer sb = new StringBuffer();

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
		// String[] cmd = {"/bin/sh", "-c", "ls > hello"};
		// Process p = Runtime.getRuntime().exec("notepad.exe test.txt");
		// Process p = Runtime.getRuntime().exec("python.exe print('hello')");
		// Process p = Runtime.getRuntime().exec("rundll32
		// url.dll,FileProtocolHandler
		// C:/Users/rvieira/Desktop/Cursos/DesignPatterns.pdf");

		/*
		 * String[] commands = {"cmd.exe", "/c", WIN_PROGRAMFILES +
		 * FILE_SEPARATOR + "Notepad++" + FILE_SEPARATOR + "notepad++.exe"};
		 * 
		 * Process p = Runtime.getRuntime().exec("cmd.exe");
		 * 
		 * p.waitFor();
		 */
		/*
		 * String command = "C:/Python27/python.exe print('hello')"; //String
		 * command = "C:/Program Files (x86)/Notepad++/notepad++.exe";
		 * ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/c", command);
		 * Process p = pb.start();
		 * 
		 * int returnCode = p.waitFor(); System.out.println("Return code = " +
		 * returnCode);
		 *
		 * 
		 * /* String prg =
		 * "import sys\nprint int(sys.argv[1])+int(sys.argv[2])\n";
		 * BufferedWriter out = new BufferedWriter(new FileWriter("test1.py"));
		 * out.write(prg); out.close(); int number1 = 10; int number2 = 32;
		 * Process p =
		 * Runtime.getRuntime().exec("python test1.py "+number1+" "+number2);
		 * BufferedReader in = new BufferedReader(new
		 * InputStreamReader(p.getInputStream())); int ret = new
		 * Integer(in.readLine()).intValue();
		 * System.out.println("value is : "+ret);
		 */
		Process p = Runtime.getRuntime().exec("python test.py");
		BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
		String ret = new String(in.readLine());
		System.out.println("output : " + ret);
	}

	public void RunShell() throws Exception {

		// Process p = Runtime.getRuntime().exec("terminal.lnk");
		/*
		 * ProcessBuilder pb = new ProcessBuilder("cmd", "/c",
		 * "C:\\Users\\rvieira\\IdeaProjects\\GUI\\terminal.lnk"); Process p =
		 * pb.start(); //p.waitFor();
		 */

		/*
		 * try { Process proc = Runtime.getRuntime().exec("test.sh /");
		 * //Whatever you want to execute BufferedReader read = new
		 * BufferedReader(new InputStreamReader( proc.getInputStream())); try {
		 * proc.waitFor(); } catch (InterruptedException e) {
		 * System.out.println(e.getMessage()); } while (read.ready()) {
		 * System.out.println(read.readLine()); } } catch (IOException e) {
		 * System.out.println(e.getMessage()); }
		 */

		// Process p = Runtime.getRuntime().exec("test.sh");

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
		try{
		    PrintWriter writer = new PrintWriter("classifiers.txt", "UTF-8");
		    writer.println(sb.toString());
		    writer.close();
		} catch (IOException e) {
		   // do something
		}
	}
	
	public void Selecting(){
		
		
		
	}
}


