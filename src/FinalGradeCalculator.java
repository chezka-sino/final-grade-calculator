import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Main driver for the Final Grade Calculator
 * 
 * @author Chezka Sino
 *
 */
public class FinalGradeCalculator {

	public static void main(String[] args) {
		 
		// Will contain list of Student objects from the input file
		ArrayList<Student> roster = new ArrayList<>();

		// TODO argument file name input instead
		Path inputFile = Paths.get("student_grades_input.txt");
		
		// Reads the file input
		try (BufferedReader reader = Files.newBufferedReader(inputFile)) {
			
			// Reads the header line
			String headers = reader.readLine();
			
			String line;
			
			// Reads each line of the file
			while ((line = reader.readLine()) != null) {
				
				String[] grades = line.split(",");
				
				// Stores each element of the array and converts type as needed
				String name = grades[0];
				int hw1 = Integer.parseInt(grades[1]);
				int hw2 = Integer.parseInt(grades[2]);
				int hw3 = Integer.parseInt(grades[3]);
				int midterm = Integer.parseInt(grades[4]);
				int project = Integer.parseInt(grades[5]);
				int finals = Integer.parseInt(grades[6]);
				
				// Creates a Student object
				Student student = new Student(name, hw1, hw2, hw3, midterm, project, finals);
				roster.add(student);
				
			}
			
		} catch (IOException e) {
			System.err.println("Unable to read file: " + inputFile.toString());
		}

		// Initializes the GUI
		GradesGUI myGradesGUI = new GradesGUI(roster);
		
	}

}
