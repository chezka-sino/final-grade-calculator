import java.awt.Dimension;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class GradesGUI extends JFrame {
	
	public GradesGUI(ArrayList<Student> roster) {
		
		JFrame frame = new JFrame("Final Grades");

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setMaximumSize(new Dimension(350,500));
		
		JPanel testJPanel = new JPanel();
		testJPanel.setLayout(new BoxLayout(testJPanel, BoxLayout.PAGE_AXIS));
		
		String[] colnames = new String[] {
				"Name", "Final Grade"
		};
		String[] countColnames = new String[] {
				"Final Grade", "Count"
		};
		
		HashMap<Character, Integer> gradeCounts = new HashMap<Character, Integer>();
		
		Object[][]data = new Object[roster.size()][2];
		
		int counter = 0;
		
		for (Student s:roster) {
			data[counter][0] = s.getName();
			data[counter][1] = s.getLetterGrade();
			counter++;
			
			if (!gradeCounts.containsKey(s.getLetterGrade())) {
				gradeCounts.put(s.getLetterGrade(), 1);
			}
			else {
				gradeCounts.put(s.getLetterGrade(), gradeCounts.get(s.getLetterGrade()) + 1);
			}
			
		}
		
		Object[][]counts = new Object[gradeCounts.size()][2];
		
		counter = 0;
		
		for (char c:gradeCounts.keySet()) {
			counts[counter][0] = c;
			counts[counter][1] = gradeCounts.get(c);
			counter++;
		}
		
		JTable gradeTable = new JTable(data, colnames);
		JTable finalGradeCount = new JTable(counts, countColnames);
		
		
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
		
		// TODO remove extra white space bottom of the tables
		JLabel label1 = new JLabel("Student Final Grades");
		testJPanel.add(label1);
		
		JScrollPane scrollPane1 = new JScrollPane(gradeTable);
		testJPanel.add(scrollPane1);
		
		JLabel label2 = new JLabel("Final Grade Counts");
		testJPanel.add(label2);
		
		
		JScrollPane scrollPane2 = new JScrollPane(finalGradeCount);
		testJPanel.add(scrollPane2);
		
		frame.add(testJPanel);
		
		frame.pack();
		frame.setVisible(true);
		
	}

}
