package com.wlzx.daoimpl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.sf.json.JSONArray;

import com.alibaba.fastjson.JSONObject;
import com.wlzx.beans.StudentDetail;
import com.wlzx.beans.StudentDormitory;
import com.wlzx.dao.SelectStudentDao;
import com.wlzx.util.DB;
import com.wlzx.util.Tools;

public class SelectStudentDaoImpl implements SelectStudentDao {

	DB db = new DB();

	@Override
	public JSONArray selectStudent(String studentNu, int week) {
		JSONObject object11 = new JSONObject();
		JSONArray array12 = new JSONArray();
		JSONObject object21 = new JSONObject();
		JSONArray array22 = new JSONArray();
		JSONArray array = new JSONArray();
		List<StudentDormitory> list11 = new ArrayList<StudentDormitory>();
		List<StudentDetail> list12 = new ArrayList<StudentDetail>();
		List<StudentDormitory> list21 = new ArrayList<StudentDormitory>();
		List<StudentDetail> list22 = new ArrayList<StudentDetail>();
		String sql11 = "SELECT dbo.T_Dic_DormitoryBuilding.Description,"
				+ " "
				+ "dbo.T_DormitoryScore.DormitoryNo,"
				+ " "
				+ "dbo.T_DormitoryScore.ScoreTimeYear,"
				+ " "
				+ "dbo.T_DormitoryScore.ScoreTimeMonth,"
				+ " "
				+ "dbo.T_DormitoryScore.ScoreTimeDay,"
				+ " "
				+ "dbo.T_DormitoryScore.WeekCode,"
				+ " "
				+ "dbo.T_DormitoryScore.TotalScore,"
				+ " "
				+ "dbo.T_DormitoryScore.Photos,"
				+ " "
				+ "dbo.T_Dic_CheckType.Description AS CheckType"
				+ " "
				+ "FROM      dbo.T_DormitoryScore LEFT OUTER JOIN"
				+ " "
				+ "dbo.T_Dic_CheckType ON"
				+ " "
				+ "dbo.T_DormitoryScore.CheckType = dbo.T_Dic_CheckType.Code LEFT OUTER JOIN"
				+ " "
				+ "dbo.T_Dic_DormitoryBuilding ON"
				+ " "
				+ "dbo.T_DormitoryScore.DormitoryBuildingCode = dbo.T_Dic_DormitoryBuilding.Code"
				+ " "
				+

				"WHERE DormitoryBuildingCode=(select DormitoryBuildingCode from T_DormitoryMassage where StudentNu="
				+ "'"
				+ studentNu
				+ "'"
				+ ")"
				+ " "
				+ "AND DormitoryNo=(select DormitoryNo from T_DormitoryMassage where StudentNu="
				+ "'" + studentNu + "'" + ")" + " " + "AND WeekCode=" + week
				+ " " + "AND CheckType=1";

		String sql12 = "SELECT   dbo.T_Dic_DormitoryScore.Description,"
				+ " "
				+ "dbo.T_Dic_DormitoryScore.Score,"
				+ " "
				+ "dbo.T_DormitorySocreDetail.DormitoryScoreStateCode"
				+ " "
				+ "FROM      dbo.T_Dic_DormitoryBuilding RIGHT OUTER JOIN"
				+ " "
				+ "dbo.T_DormitorySocreDetail RIGHT OUTER JOIN"
				+ " "
				+ "dbo.T_Dic_DormitoryScore ON"
				+ " "
				+ "dbo.T_DormitorySocreDetail.DormitoryScoreCode = dbo.T_Dic_DormitoryScore.Code RIGHT OUTER JOIN"
				+ " "
				+ "dbo.CheckType INNER JOIN"
				+ " "
				+ "dbo.T_DormitoryScore ON"
				+ " "
				+ "dbo.CheckType.Code = dbo.T_DormitoryScore.CheckType ON"
				+ " "
				+ "dbo.T_DormitorySocreDetail.DormitoryScoreRecordId = dbo.T_DormitoryScore.Nid ON"
				+ " "
				+ "dbo.T_Dic_DormitoryBuilding.Code = dbo.T_DormitoryScore.DormitoryBuildingCode"
				+ " "
				+

				"WHERE DormitoryBuildingCode=(select DormitoryBuildingCode from T_DormitoryMassage where StudentNu="
				+ "'"
				+ studentNu
				+ "'"
				+ ")"
				+ " "
				+ "AND DormitoryNo=(select DormitoryNo from T_DormitoryMassage where StudentNu="
				+ "'" + studentNu + "'" + ")" + " " + "AND WeekCode=" + week
				+ " " + "AND CheckType=1";
		// System.out.println(sql11);
		// System.out.println(sql12);

		String sql21 = "SELECT   dbo.T_Dic_DormitoryBuilding.Description,"
				+ " "
				+ "dbo.T_DormitoryScore.DormitoryNo,"
				+ " "
				+ "dbo.T_DormitoryScore.ScoreTimeYear,"
				+ " "
				+ "dbo.T_DormitoryScore.ScoreTimeMonth,"
				+ " "
				+ "dbo.T_DormitoryScore.ScoreTimeDay,"
				+ " "
				+ "dbo.T_DormitoryScore.WeekCode,"
				+ " "
				+ "dbo.T_DormitoryScore.TotalScore,"
				+ " "
				+ "dbo.T_DormitoryScore.Photos,"
				+ " "
				+ "dbo.T_Dic_CheckType.Description AS CheckType"
				+ " "
				+ "FROM      dbo.T_DormitoryScore LEFT OUTER JOIN"
				+ " "
				+ "dbo.T_Dic_CheckType ON"
				+ " "
				+ "dbo.T_DormitoryScore.CheckType = dbo.T_Dic_CheckType.Code LEFT OUTER JOIN"
				+ " "
				+ "dbo.T_Dic_DormitoryBuilding ON"
				+ " "
				+ "dbo.T_DormitoryScore.DormitoryBuildingCode = dbo.T_Dic_DormitoryBuilding.Code"
				+ " "
				+ "WHERE DormitoryBuildingCode=(select DormitoryBuildingCode from T_DormitoryMassage where StudentNu="
				+ "'"
				+ studentNu
				+ "'"
				+ ")"
				+ " "
				+ "AND DormitoryNo=(select DormitoryNo from T_DormitoryMassage where StudentNu="
				+ "'" + studentNu + "'" + ")" + " " + "AND WeekCode=" + week
				+ " " + "AND CheckType=2";

		String sql22 = "SELECT   dbo.T_Dic_DormitoryScore.Description,"
				+ " "
				+ "dbo.T_Dic_DormitoryScore.Score,"
				+ " "
				+ "dbo.T_DormitorySocreDetail.DormitoryScoreStateCode"
				+ " "
				+ "FROM      dbo.T_Dic_DormitoryBuilding RIGHT OUTER JOIN"
				+ " "
				+ "dbo.T_DormitorySocreDetail RIGHT OUTER JOIN"
				+ " "
				+ "dbo.T_Dic_DormitoryScore ON"
				+ " "
				+ "dbo.T_DormitorySocreDetail.DormitoryScoreCode = dbo.T_Dic_DormitoryScore.Code RIGHT OUTER JOIN"
				+ " "
				+ "dbo.CheckType INNER JOIN"
				+ " "
				+ "dbo.T_DormitoryScore ON"
				+ " "
				+ "dbo.CheckType.Code = dbo.T_DormitoryScore.CheckType ON"
				+ " "
				+ "dbo.T_DormitorySocreDetail.DormitoryScoreRecordId = dbo.T_DormitoryScore.Nid ON"
				+ " "
				+ "dbo.T_Dic_DormitoryBuilding.Code = dbo.T_DormitoryScore.DormitoryBuildingCode"
				+ " "
				+

				"WHERE DormitoryBuildingCode=(select DormitoryBuildingCode from T_DormitoryMassage where StudentNu="
				+ "'"
				+ studentNu
				+ "'"
				+ ")"
				+ " "
				+ "AND DormitoryNo=(select DormitoryNo from T_DormitoryMassage where StudentNu="
				+ "'" + studentNu + "'" + ")" + " " + "AND WeekCode=" + week
				+ " " + "AND CheckType=2";

		try {
			ResultSet rs11 = db.executeQuery(sql11);
			System.out.println(rs11);
			/*
			 * while (rs11.next()) { StudentDormitory dormitory = new
			 * StudentDormitory(); dormitory.setBuliding(rs11.getString(1));
			 * dormitory.setDormitoryNo(rs11.getInt(2));
			 * dormitory.setTotleScore(rs11.getInt(7));
			 * dormitory.setYear(rs11.getInt(3));
			 * dormitory.setMonth(rs11.getInt(4));
			 * dormitory.setDay(rs11.getInt(5));
			 * dormitory.setWeek(rs11.getInt(6));
			 * dormitory.setPhotos(rs11.getString(8));
			 * dormitory.setCheckType(rs11.getString(9)); list11.add(dormitory);
			 * }
			 */

			ResultSet rs12 = db.executeQuery(sql12);
			while (rs12.next()) {
				StudentDetail detail = new StudentDetail();
				detail.setSituation(rs12.getString(1));
				detail.setScore(rs12.getInt(2));
				detail.setDormitoryScoreStateCode(rs12.getString(3));
				list12.add(detail);
			}

			for (StudentDetail s : list12) {
				if ("0".equals(s.getDormitoryScoreStateCode())) {
					s.setScore(0);
				}
			}

			ResultSet rs21 = db.executeQuery(sql21);
			System.out.println(rs21);
			/*
			 * while (rs21.next()) { StudentDormitory dormitory = new
			 * StudentDormitory(); dormitory.setBuliding(rs21.getString(1));
			 * dormitory.setDormitoryNo(rs21.getInt(2));
			 * dormitory.setTotleScore(rs21.getInt(7));
			 * dormitory.setYear(rs21.getInt(3));
			 * dormitory.setMonth(rs21.getInt(4));
			 * dormitory.setDay(rs21.getInt(5));
			 * dormitory.setWeek(rs21.getInt(6));
			 * dormitory.setPhotos(rs21.getString(8));
			 * dormitory.setCheckType(rs21.getString(9)); list21.add(dormitory);
			 * }
			 */

			ResultSet rs22 = db.executeQuery(sql22);
			while (rs22.next()) {
				StudentDetail detail = new StudentDetail();
				detail.setSituation(rs22.getString(1));
				detail.setScore(rs22.getInt(2));
				detail.setDormitoryScoreStateCode(rs22.getString(3));
				list22.add(detail);
			}

			for (StudentDetail s : list22) {
				if ("0".equals(s.getDormitoryScoreStateCode())) {
					s.setScore(0);
				}
			}

			// 将list11中的对象循环放入JSONObject中
			/*
			 * for (StudentDormitory s : list11) { object11.put("building",
			 * s.getBuliding()); object11.put("CheckType", s.getCheckType());
			 * object11.put("week", s.getWeek()); object11.put("month",
			 * s.getMonth()); object11.put("year", s.getYear());
			 * object11.put("totleScore", s.getTotleScore());
			 * object11.put("day", s.getDay()); object11.put("photos",
			 * s.getPhotos()); object11.put("dormitoryNo", s.getDormitoryNo());
			 * }
			 */
			while (rs11.next()) {
				object11.put("building", rs11.getString(1));
				object11.put("dormitoryNo", rs11.getInt(2));
				object11.put("totleScore", rs11.getInt(7));
				object11.put("year", rs11.getInt(3));
				object11.put("month", rs11.getInt(4));
				object11.put("day", rs11.getInt(5));
				object11.put("week", rs11.getInt(6));
				object11.put("photos", rs11.getString(8));
				object11.put("CheckType", rs11.getString(9));
			
			object11.put("detail", list12);
			}

			// 将list21中的对象循环放入JSONObject中
			/*
			 * for (StudentDormitory s : list21) { object21.put("building",
			 * s.getBuliding()); object21.put("CheckType", s.getCheckType());
			 * object21.put("week", s.getWeek()); object21.put("month",
			 * s.getMonth()); object21.put("year", s.getYear());
			 * object21.put("totleScore", s.getTotleScore());
			 * object21.put("day", s.getDay()); object21.put("photos",
			 * s.getPhotos()); object21.put("dormitoryNo", s.getDormitoryNo());
			 * }
			 */
			while (rs21.next()) {
				object21.put("building", rs21.getString(1));
				object21.put("dormitoryNo", rs21.getInt(2));
				object21.put("totleScore", rs21.getInt(7));
				object21.put("year", rs21.getInt(3));
				object21.put("month", rs21.getInt(4));
				object21.put("day", rs21.getInt(5));
				object21.put("week", rs21.getInt(6));
				object21.put("photos", rs21.getString(8));
				object21.put("CheckType", rs21.getString(9));
			
			object21.put("detail", list22);
			}

			array.add(object11);
			array.add(object21);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return array;
	}
}
