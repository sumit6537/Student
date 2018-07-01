package org.student;

public class StudentDetails {
	String name;
	int rollNo,PhyMarks,ChmMarks,MathsMarks;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public int getPhyMarks() {
		return PhyMarks;
	}
	public void setPhyMarks(int phyMarks) {
		PhyMarks = phyMarks;
	}
	public int getChmMarks() {
		return ChmMarks;
	}
	public void setChmMarks(int chmMarks) {
		ChmMarks = chmMarks;
	}
	public int getMathsMarks() {
		return MathsMarks;
	}
	public void setMathsMarks(int mathsMarks) {
		MathsMarks = mathsMarks;
	}
	public String toString()
	{
		String data=""+name +rollNo+PhyMarks+ChmMarks+MathsMarks;
		return data;
	
	}

}
