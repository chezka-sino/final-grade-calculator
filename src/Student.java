
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
	
	public Student(String name, int hw1, int hw2, int hw3, int midterm, int project, int finals) {
		this.name = name;
		this.hw1 = hw1;
		this.hw2 = hw2;
		this.hw3 = hw3;
		this.midterm = midterm;
		this.project = project;
		this.finals = finals;
		this.finalGrade = (0.45 * ((hw1+hw2+hw3)/3)) + 
				(0.25 * project) + 
				(0.3 * ((midterm + finals)/2));
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHw1() {
		return hw1;
	}

	public void setHw1(int hw1) {
		this.hw1 = hw1;
	}

	public int getHw2() {
		return hw2;
	}

	public void setHw2(int hw2) {
		this.hw2 = hw2;
	}

	public int getHw3() {
		return hw3;
	}

	public void setHw3(int hw3) {
		this.hw3 = hw3;
	}

	public int getMidterm() {
		return midterm;
	}

	public void setMidterm(int midterm) {
		this.midterm = midterm;
	}

	public int getProject() {
		return project;
	}

	public void setProject(int project) {
		this.project = project;
	}

	public int getFinals() {
		return finals;
	}

	public void setFinals(int finals) {
		this.finals = finals;
	}
	
	public double getFinalGrade() {
		return finalGrade;
	}
	
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
