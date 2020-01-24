package com.techelevator;

public class HomeworkAssignment {
		
	private int totalMarks;
	
	private int possibleMarks;
	
	private String submitterName;

	public HomeworkAssignment(int possibleMarks) {
		this.possibleMarks = possibleMarks;
	}
	
	public String getLetterGrade() {
			if ((((double)totalMarks/possibleMarks)*100.0) >= 90.0) {
				return "A";
			}
			if ((((double)totalMarks/possibleMarks)*100.0) >= 80.0) {
				return "B";
			}
			if ((((double)totalMarks/possibleMarks)*100.0) >= 70.0) {
				return "C";
			}
			if ((((double)totalMarks/possibleMarks)*100.0) >= 60.0) {
				return "D";
			} else {
				return "F";
			}
		}
	
	//if >= 90 return A
	//if >=80 && < 90 return B
	//if >=70 && <80 return C
	//if >=60 && <70 return D
	//if <60 return F
	//will come back as doubles	
	
	public int getTotalMarks() {
		return totalMarks;
	}
	public void setTotalMarks(int totalMarks) {
		this.totalMarks = totalMarks;
	}
	public String getSubmitterName() {
		return submitterName;
	}
	public void setSubmitterName(String submitterName) {
		this.submitterName = submitterName;
	}
	public int getPossibleMarks() {
		return possibleMarks;
	}
	

}
