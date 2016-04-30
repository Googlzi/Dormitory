package com.wlzx.beans;

public class StudentDetail {

	private String Situation;
	private int Score;
	private String DormitoryScoreStateCode;

	public String getSituation() {
		return Situation;
	}

	public void setSituation(String situation) {
		Situation = situation;
	}

	public int getScore() {
		return Score;
	}

	public void setScore(int score) {
		Score = score;
	}

	public String getDormitoryScoreStateCode() {
		return DormitoryScoreStateCode;
	}

	public void setDormitoryScoreStateCode(String dormitoryScoreStateCode) {
		DormitoryScoreStateCode = dormitoryScoreStateCode;
	}

	public StudentDetail(String situation, int score,
			String dormitoryScoreStateCode) {
		super();
		Situation = situation;
		Score = score;
		DormitoryScoreStateCode = dormitoryScoreStateCode;
	}

	public StudentDetail() {
		super();
	}

	@Override
	public String toString() {
		return "StudentDetail [Situation=" + Situation + ", Score=" + Score
				+ ", DormitoryScoreStateCode=" + DormitoryScoreStateCode + "]";
	}

}
