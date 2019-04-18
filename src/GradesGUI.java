import java.awt.Dimension;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import org.omg.CORBA.PRIVATE_MEMBER;

/**
 * Generates a GUI showing the final letter grades of students
 * 
 * @author Chezka Sino
 *
 */
public class GradesGUI extends JFrame {
	
	private final char[] LETTER_GRADES = {'A', 'B', 'C', 'D', 'F'};
	/**
	 * GUI constructor
	 * 
	 * @param roster
	 * 		ArrayList containing the roster of the students with grades as 
	 * 		Student objects
	 * 
	 */
	public GradesGUI(ArrayList<Student> roster) {
		
		JFrame frame = new JFrame("Final Grades");

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setMaximumSize(new Dimension(350,500));
		
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		
		// Column names for the final letter grades
		String[] colnames = new String[] {
				"Name", "Final Grade"
		};
		
		// Column names for the count of final letter grades for the class
		String[] countColnames = new String[] {
				"Final Grade", "Count"
		};
		
		// Contains the students letter grades
		Object[][]data = new Object[roster.size()][2];
		// Contains the counts of letter grades for the class
		HashMap<Character, Integer> gradeCounts = new HashMap<Character, Integer>();
		
		// Initializes letter grade counts
		for (char c:LETTER_GRADES) {
			gradeCounts.put(c, 0);
		}
		
		int counter = 0;
		
		// Populates the data containers for the grades
		for (Student s:roster) {
			data[counter][0] = s.getName();
			data[counter][1] = s.getLetterGrade();
			counter++;
						
			gradeCounts.put(s.getLetterGrade(), gradeCounts.get(s.getLetterGrade()) + 1);
			
		}
		
		// Converts the hashmap for grade counts to an array for the table
		Object[][]counts = new Object[gradeCounts.size()][2];		
		counter = 0;
		for (char c:gradeCounts.keySet()) {
			counts[counter][0] = c;
			counts[counter][1] = gradeCounts.get(c);
			counter++;
		}
		
		// Creates the table GUI
		JTable gradeTable = new JTable(data, colnames);
		JTable finalGradeCount = new JTable(counts, countColnames);
		
		// Sets the column widths of the tables
		for (int i = 0; i < 2; i++) {
			if (i == 0) {
				gradeTable.getColumnModel().getColumn(i).setMaxWidth(250);
				finalGradeCount.getColumnModel().getColumn(i).setMaxWidth(250);
			}
			else {
				gradeTable.getColumnModel().getColumn(i).setMaxWidth(100);
				finalGradeCount.getColumnModel().getColumn(i).setMaxWidth(100);
			}
			
			
		}
		
		// Final Grade roster
		JLabel label1 = new JLabel("Student Final Grades");
		panel.add(label1);
		
		JScrollPane scrollPane1 = new JScrollPane(gradeTable);
		panel.add(scrollPane1);
		
		// Final grade counts
		JLabel label2 = new JLabel("Final Grade Counts");
		panel.add(label2);
		
		
		JScrollPane scrollPane2 = new JScrollPane(finalGradeCount);
		panel.add(scrollPane2);
		
		frame.add(panel);
		
		frame.pack();
		frame.setVisible(true);
		
	}

}
