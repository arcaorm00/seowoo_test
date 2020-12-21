package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JDBCConnectionTest {
	
	public static Connection getConnection(){
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521/XE";
		String username = "kwak";
		String password = "arm";
		
		Connection conn = null;
		
		try{
			Class.forName(driver);
			conn = DriverManager.getConnection(url, username, password);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return conn;
	}
	
	public static List<FreeboardVo> getFreeboard(){
		List<FreeboardVo> list = new ArrayList<FreeboardVo>();
		String sql = "select * from FREEBOARD";
		
		try{
			Connection conn = getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				FreeboardVo fv = new FreeboardVo();
				fv.setCode_type(rs.getString(1));
				fv.setNum(rs.getInt(2));
				fv.setName(rs.getString(3));
				fv.setTitle(rs.getString(4));
				fv.setContent(rs.getString(5));
				fv.setRegdate(rs.getDate(6));
				list.add(fv);
			}
			rs.close();
			stmt.close();
			conn.close();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return list;
	}

	public static void main(String[] args) {
		List<FreeboardVo> list = getFreeboard();
		
		for (int i = 0; i < list.size(); i++){
			FreeboardVo fv = list.get(i);
			System.out.println(fv.toString());
		}
	}
}
