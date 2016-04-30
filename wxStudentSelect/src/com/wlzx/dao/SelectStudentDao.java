package com.wlzx.dao;

import net.sf.json.JSONArray;

public interface SelectStudentDao {
	
	public JSONArray selectStudent(String studentNu, int week);
}
