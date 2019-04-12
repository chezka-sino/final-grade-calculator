/**
 * This class creates Student objects
 * 
 * @author Chezka Sino
 *
 */
public class Student {
	
	private String name;
	private int hw1;
	private int hw2;
	private int hw3;
	private int midterm;
	private int project;
	private int finals;
	private double finalGrade;
	private char letterGrade;
	
	/**
	 * Class constructor
	 * 
	 * @param name
	 * 		Student's name
	 * @param hw1
	 * 		HW1 grade
	 * @param hw2
	 * 		HW2 grade
	 * @param hw3
	 * 		HW3 grade
	 * @param midterm
	 * 		Midterm grade
	 * @param project
	 * 		Project grade
	 * @param finals
	 * 		Final exam grade
	 */
	public Student(String name, int hw1, int hw2, int hw3, int midterm, int project, int finals) {
		this.name = name;
		this.hw1 = hw1;
		this.hw2 = hw2;
		this.hw3 = hw3;
		this.midterm = midterm;
		this.project = project;
		this.finals = finals;
		
		// Final grade is automatically calculated in the constructor
		setFinalGrade();
	}

	/**
	 * Gets the student's name
	 * 
	 * @return
	 * 		Student object name
	 * 
	 */
	public String getName() {
		return name;
	}

	/**
	 * Updates the Student object's name
	 * 
	 * @param name
	 * 		new Student name
	 * 
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the student's HW1 grade
	 * 
	 * @return
	 * 		Student object hw1
	 * 
	 */
	public int getHw1() {
		return hw1;
	}

	/**
	 * Updates the Student object's hw1
	 * 
	 * @param name
	 * 		new Student hw1
	 * 
	 */
	public void setHw1(int hw1) {
		this.hw1 = hw1;
	}

	/**
	 * Gets the student's HW2 grade
	 * 
	 * @return
	 * 		Student object hw2
	 * 
	 */
	public int getHw2() {
		return hw2;
	}

	/**
	 * Updates the Student object's hw2
	 * 
	 * @param name
	 * 		new Student hw2
	 * 
	 */
	public void setHw2(int hw2) {
		this.hw2 = hw2;
	}

	/**
	 * Gets the student's HW3 grade
	 * 
	 * @return
	 * 		Student object hw3
	 * 
	 */
	public int getHw3() {
		return hw3;
	}

	/**
	 * Updates the Student object's hw3
	 * 
	 * @param name
	 * 		new Student hw3
	 * 
	 */
	public void setHw3(int hw3) {
		this.hw3 = hw3;
	}

	/**
	 * Gets the student's Midterm grade
	 * 
	 * @return
	 * 		Student object midterm
	 * 
	 */
	public int getMidterm() {
		return midterm;
	}

	/**
	 * Updates the Student object's midterm
	 * 
	 * @param name
	 * 		new Student midterm
	 * 
	 */
	public void setMidterm(int midterm) {
		this.midterm = midterm;
	}

	/**
	 * Gets the student's Project grade
	 * 
	 * @return
	 * 		Student object project
	 * 
	 */
	public int getProject() {
		return project;
	}

	/**
	 * Updates the Student object's project
	 * 
	 * @param name
	 * 		new Student project
	 * 
	 */
	public void setProject(int project) {
		this.project = project;
	}

	/**
	 * Gets the student's Final exam grade
	 * 
	 * @return
	 * 		Student object finals
	 * 
	 */
	public int getFinals() {
		return finals;
	}

	/**
	 * Updates the Student object's finals
	 * 
	 * @param name
	 * 		new Student finals
	 * 
	 */
	public void setFinals(int finals) {
		this.finals = finals;
	}
	
	/**
	 * Gets the student's Final grade
	 * 
	 * @return
	 * 		Student object finalGrade
	 * 
	 */
	public double getFinalGrade() {
		return finalGrade;
	}
	
	/**
	 * Calculates Student's Final grade based on the grades
	 * 
	 */
	public void setFinalGrade() {
		this.finalGrade = (0.45 * ((this.hw1+this.hw2+this.hw3)/3)) + 
				(0.25 * this.project) + 
				(0.3 * ((this.midterm + this.finals)/2));
	}
	
	/**
	 * Get the letter grade equivalent of the final grade
	 * 
	 * @return
	 * 		Student object letterGrade
	 * 
	 */
	public char getLetterGrade() {
		if (finalGrade <= 100 & finalGrade >= 90) {
			this.letterGrade = 'A';
		}
		else if (finalGrade < 90 & finalGrade >= 80) {
			this.letterGrade = 'B';
		}
		else if (finalGrade < 80 & finalGrade >= 70) {
			this.letterGrade = 'C';
		}
		else if (finalGrade < 70 & finalGrade >= 60) {
			this.letterGrade = 'D';
		}
		else {
			this.letterGrade = 'F';
		}
		
		return letterGrade;
			
	}
	
	/**
	 * Custom toString() method for debugging
	 * 
	 */
	public String toString() {
		
		String outputString = "";
		
		outputString += "Name: " + this.name + "\n";
		outputString += "HW1: " + this.hw1 + "\n";
		outputString += "HW2: " + this.hw2 + "\n";
		outputString += "HW3: " + this.hw3 + "\n";
		outputString += "Midterm: " + this.midterm + "\n";
		outputString += "Project: " + this.project + "\n";
		outputString += "Final: " + this.finals + "\n";
		outputString += "=============================\n";
		outputString += "Final Grade: " + this.getLetterGrade() + " - " + 
				this.finalGrade + "\n";
		
		return outputString;
		
	}

}
