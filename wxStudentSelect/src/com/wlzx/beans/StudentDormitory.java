package com.wlzx.beans;

public class StudentDormitory {
	private String Buliding;
	private int DormitoryNo;
	private int TotleScore;
	private int Year;
	private int Month;
	private int Day;
	private int Week;
	private String Photos;
	private String CheckType;
	public String getBuliding() {
		return Buliding;
	}
	public void setBuliding(String buliding) {
		Buliding = buliding;
	}
	public int getDormitoryNo() {
		return DormitoryNo;
	}
	public void setDormitoryNo(int dormitoryNo) {
		DormitoryNo = dormitoryNo;
	}
	public int getTotleScore() {
		return TotleScore;
	}
	public void setTotleScore(int totleScore) {
		TotleScore = totleScore;
	}
	public int getYear() {
		return Year;
	}
	public void setYear(int year) {
		Year = year;
	}
	public int getMonth() {
		return Month;
	}
	public void setMonth(int month) {
		Month = month;
	}
	public int getDay() {
		return Day;
	}
	public void setDay(int day) {
		Day = day;
	}
	public int getWeek() {
		return Week;
	}
	public void setWeek(int week) {
		Week = week;
	}
	public String getPhotos() {
		return Photos;
	}
	public void setPhotos(String photos) {
		Photos = photos;
	}
	public String getCheckType() {
		return CheckType;
	}
	public void setCheckType(String checkType) {
		CheckType = checkType;
	}
	public StudentDormitory(String buliding, int dormitoryNo, int totleScore,
			int year, int month, int day, int week, String photos,
			String checkType) {
		super();
		Buliding = buliding;
		DormitoryNo = dormitoryNo;
		TotleScore = totleScore;
		Year = year;
		Month = month;
		Day = day;
		Week = week;
		Photos = photos;
		CheckType = checkType;
	}
	public StudentDormitory() {
		super();
	}
	@Override
	public String toString() {
		return "StudentDormitory [Buliding=" + Buliding + ", DormitoryNo="
				+ DormitoryNo + ", TotleScore=" + TotleScore + ", Year=" + Year
				+ ", Month=" + Month + ", Day=" + Day + ", Week=" + Week
				+ ", Photos=" + Photos + ", CheckType=" + CheckType + "]";
	}
	
	
	
}
