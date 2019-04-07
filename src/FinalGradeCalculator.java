import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

public class FinalGradeCalculator {

	public static void main(String[] args) {
		 
		// Will contain list of Student objects from the input file
		ArrayList<Student> roster = new ArrayList<>();
		
		HashMap<Character, Integer> gradeCounts = new HashMap<Character, Integer>();

		Path inputFile = Paths.get("student_grades_input.txt");
		
		try (BufferedReader reader = Files.newBufferedReader(inputFile)) {
			
			// Reads the header line
			String headers = reader.readLine();
			
			String line;
			
			while ((line = reader.readLine()) != null) {
				
				String[] grades = line.split(",");
				
				String name = grades[0];
				int hw1 = Integer.parseInt(grades[1]);
				int hw2 = Integer.parseInt(grades[2]);
				int hw3 = Integer.parseInt(grades[3]);
				int midterm = Integer.parseInt(grades[4]);
				int project = Integer.parseInt(grades[5]);
				int finals = Integer.parseInt(grades[6]);
				
				Student student = new Student(name, hw1, hw2, hw3, midterm, project, finals);
				roster.add(student);
				
			}
			
		} catch (IOException e) {
			System.err.println("Unable to read file: " + inputFile.toString());
		}
		
		for (Student s:roster) {
			System.out.println(s.toString());
			if (!gradeCounts.containsKey(s.getLetterGrade())) {
				gradeCounts.put(s.getLetterGrade(), 1);
			}
			else {
				gradeCounts.put(s.getLetterGrade(), gradeCounts.get(s.getLetterGrade()) + 1);
			}
		}

		/**
		 * TODO GUI
		 */
		
	}

}
