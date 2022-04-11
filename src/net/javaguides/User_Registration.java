	package net.javaguides;
	
	import java.awt.EventQueue;
	
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JOptionPane;
	
	import java.awt.Font;
	import javax.swing.JTextField;
	import javax.swing.JButton;
	import java.awt.event.ActionListener;
	import java.sql.SQLException;
	import java.awt.event.ActionEvent;
	import javax.swing.JPasswordField;
	
	
	
	public class User_Registration extends DBconnect {
	
		private JFrame frame;
		private JTextField txtF_name;
		private JTextField txtU_name;
		private JTextField txtM_num;
		private JTextField txtL_name;
		private JTextField txtEmail;
		private JPasswordField passwordField;
	
	
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						User_Registration window = new User_Registration();
						window.frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
	
		
		public User_Registration() {
			initialize();
			ConnectDB();
		}
		
		
		private void initialize() {
			frame = new JFrame();
			frame.setBounds(100, 100, 779, 431);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);
			
			JLabel lblNewLabel = new JLabel("User Registration");
			lblNewLabel.setFont(new Font("Segoe UI Symbol", Font.BOLD, 30));
			lblNewLabel.setBounds(213, 28, 257, 66);
			frame.getContentPane().add(lblNewLabel);
			
			txtF_name = new JTextField();
			txtF_name.setBounds(148, 136, 169, 30);
			frame.getContentPane().add(txtF_name);
			txtF_name.setColumns(10);
			
			JLabel lblNewLabel_1 = new JLabel("First Name");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblNewLabel_1.setBounds(38, 131, 110, 36);
			frame.getContentPane().add(lblNewLabel_1);
			
			JLabel lblNewLabel_1_1 = new JLabel("Last Name");
			lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblNewLabel_1_1.setBounds(38, 187, 110, 36);
			frame.getContentPane().add(lblNewLabel_1_1);
			
			JLabel lblNewLabel_1_2 = new JLabel("Email address");
			lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblNewLabel_1_2.setBounds(38, 245, 110, 36);
			frame.getContentPane().add(lblNewLabel_1_2);
			
			JLabel lblNewLabel_1_3 = new JLabel("Username");
			lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblNewLabel_1_3.setBounds(412, 131, 110, 36);
			frame.getContentPane().add(lblNewLabel_1_3);
			
			JLabel lblNewLabel_1_4 = new JLabel("Password");
			lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblNewLabel_1_4.setBounds(412, 192, 110, 36);
			frame.getContentPane().add(lblNewLabel_1_4);
			
			JLabel lblNewLabel_1_5 = new JLabel("Mobile number");
			lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblNewLabel_1_5.setBounds(412, 250, 110, 36);
			frame.getContentPane().add(lblNewLabel_1_5);
			
			txtU_name = new JTextField();
			txtU_name.setColumns(10);
			txtU_name.setBounds(539, 136, 169, 30);
			frame.getContentPane().add(txtU_name);
			
			txtM_num = new JTextField();
			txtM_num.setColumns(10);
			txtM_num.setBounds(539, 255, 169, 30);
			frame.getContentPane().add(txtM_num);
			
			txtL_name = new JTextField();
			txtL_name.setColumns(10);
			txtL_name.setBounds(148, 192, 169, 30);
			frame.getContentPane().add(txtL_name);
			
			txtEmail = new JTextField();
			txtEmail.setColumns(10);
			txtEmail.setBounds(148, 250, 169, 30);
			frame.getContentPane().add(txtEmail);
			
			passwordField = new JPasswordField();
			passwordField.setBounds(539, 197, 169, 30);
			frame.getContentPane().add(passwordField);
			
			JButton RegisterBtn = new JButton("Register");
			RegisterBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
			RegisterBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					
					String firstName = txtF_name.getText();
					String lastName = txtL_name.getText();
					String emailId = txtEmail.getText();
					String userName = txtU_name.getText();
					String mobileNumber = txtM_num.getText();
					int len = mobileNumber.length();
					
					@SuppressWarnings("deprecation")
					String password = passwordField.getText();
					
					String msg = "" + firstName;
		            msg += " \n";
		            
		            if(len != 10) {
		            	JOptionPane.showMessageDialog
		            	(RegisterBtn, "Enter a valid mobile number");
		            }
		            
		            try {
		            	pst = con.prepareStatement
		            			("INSERT INTO user_info (first_name, last_name, "
		            			+ "user_name, password, email_id, mobile_number)"
		            			+ "values(?,?,?,?,?,?)");
		            	
		            	pst.setString(1, firstName);
		            	pst.setString(2, lastName);
		            	pst.setString(3, userName);
		            	pst.setString(4, password);
		            	pst.setString(5, emailId);
		            	pst.setString(6, mobileNumber);
		            	
		            	int x = pst.executeUpdate();
		            	
		            	if(x == 0) {
		            		JOptionPane.showMessageDialog
		            		(RegisterBtn, "This is alredy exist");
		            	}
		            	else {
		            		JOptionPane.showMessageDialog
		            		(RegisterBtn,"Welcome, " + msg + "Registration sucessfully");
		            		
		            	}
		            	
		            	txtF_name.setText("");
		            	txtL_name.setText("");
		            	txtEmail.setText("");
		            	txtU_name.setText("");
		            	txtM_num.setText("");
		            	passwordField.setText("");
		            	
		            	txtF_name.requestFocus();
		            	
		            	con.close();
		            }
		            catch(SQLException ex) {
		            	
		            }
				}
			});
			RegisterBtn.setBounds(324, 334, 126, 36);
			frame.getContentPane().add(RegisterBtn);
			
			
		}
	}
