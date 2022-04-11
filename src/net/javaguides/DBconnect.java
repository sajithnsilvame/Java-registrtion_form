	package net.javaguides;
	
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.SQLException;
	
	
	
	
	
	public class DBconnect {
		
		Connection con;
		PreparedStatement pst;
		
		public void ConnectDB() {
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection
						("jdbc:mysql://localhost/student_registration_db",
						 "root", "");
				
				// System.out.print("DB connect successful");
			}
			catch(ClassNotFoundException e) {
				
			}
			catch(SQLException e) {
				
			}
		}
		
		public static void main(String [] args) {
			
			/* DBconnect connection = new DBconnect();
			
			connection.ConnectDB(); */
		}
	
	}
