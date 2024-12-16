package employee;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.MessageFormat;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
public class Employee {

	private JFrame frame;
	private JTextField textField;
	private JTable table;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	
	DefaultTableModel model = new DefaultTableModel();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Employee window = new Employee();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public void updateTable() {
		conn = EmployeeData.ConnectDB();
		if(conn != null) {
			String sql = "Select EmpID, Number, FirstName, SurName, Gender, DOB, Age, Salary";
			
			try {
				pst = conn.prepareStatement(sql);
				rs = pst.executeQuery();
				Object[] columnData = new Object[8];
				
				while(rs.next()) {
					columnData [0] = rs.getString("EmpID");
					columnData [1] = rs.getString("Number");
					columnData [2] = rs.getString("FirstName");
					columnData [3] = rs.getString("SurName");
					columnData [4] = rs.getString("Gender");
					columnData [5] = rs.getString("DOB");
					columnData [6] = rs.getString("Age");
					columnData [7] = rs.getString("Salary");
					
					model.addRow(columnData);
				}
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		}
	}
	public Employee() {
		initialize();
		
		conn = EmployeeData.ConnectDB();
		Object col[] = {"EmpID", "Number", "FirstName", "SurName", "Gender", "DOB", "Age", "Salary"};
		model.setColumnIdentifiers(col);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 1450, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(727, 99, 604, 365);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"EmpID", "Number", "FirstName", "SurName", "Gender", "DOB", "Age", "Salary"
			}
		));
		table.setFont(new Font("Tahoma", Font.BOLD, 14));
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("Employee Management System");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel.setBounds(625, 25, 238, 25);
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Set Employee", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(39, 101, 644, 342);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(545, 297, 89, 34);
		panel.add(btnExit);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame = new JFrame("Exit");
				if(JOptionPane.showConfirmDialog(frame, "Confirm IF You Want To Exit", null, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
				
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblEmployee = new JLabel("Employee ID");
		lblEmployee.setBounds(10, 38, 111, 14);
		panel.add(lblEmployee);
		lblEmployee.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		textField = new JTextField();
		textField.setBounds(115, 37, 170, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNumber = new JLabel("Number");
		lblNumber.setBounds(10, 69, 111, 14);
		panel.add(lblNumber);
		lblNumber.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		textField_1 = new JTextField();
		textField_1.setBounds(115, 68, 170, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(10, 95, 111, 14);
		panel.add(lblFirstName);
		lblFirstName.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		textField_2 = new JTextField();
		textField_2.setBounds(115, 94, 170, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblSurname = new JLabel("SurName");
		lblSurname.setBounds(10, 121, 111, 14);
		panel.add(lblSurname);
		lblSurname.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		textField_3 = new JTextField();
		textField_3.setBounds(115, 120, 170, 20);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(10, 147, 111, 14);
		panel.add(lblGender);
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		textField_4 = new JTextField();
		textField_4.setBounds(115, 146, 170, 20);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblDOB = new JLabel("DOB");
		lblDOB.setBounds(10, 173, 111, 14);
		panel.add(lblDOB);
		lblDOB.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		textField_5 = new JTextField();
		textField_5.setBounds(115, 172, 170, 20);
		panel.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setBounds(10, 199, 111, 19);
		panel.add(lblAge);
		lblAge.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		textField_6 = new JTextField();
		textField_6.setBounds(115, 198, 170, 20);
		panel.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblSalary = new JLabel("Salary");
		lblSalary.setBounds(10, 225, 111, 19);
		panel.add(lblSalary);
		lblSalary.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		textField_7 = new JTextField();
		textField_7.setBounds(115, 224, 170, 20);
		panel.add(textField_7);
		textField_7.setColumns(10);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBounds(446, 297, 89, 34);
		panel.add(btnReset);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(null);
				textField_1.setText(null);
				textField_2.setText(null);
				textField_3.setText(null);
				textField_4.setText(null);
				textField_5.setText(null);
				textField_6.setText(null);
				textField_7.setText(null);
				
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JButton btnPrint = new JButton("Print");
		btnPrint.setBounds(347, 297, 89, 34);
		panel.add(btnPrint);
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MessageFormat header = new MessageFormat("Printing...");
				MessageFormat footer = new MessageFormat("Page {0, number, integer}");
				
				try {
					table.print();
				}catch(java.awt.print.PrinterException ev){
					System.err.format("No Printer Found", ev.getMessage());
				}
			}
		});
		btnPrint.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(248, 297, 89, 34);
		panel.add(btnAdd);
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql = "INSERT INTO employee(EmpID, Number, FirstName, SurName, Gender, DOB, Age, Salary) VALUES(?,?,?,?,?,?,?,?)";
				try {
					pst = conn.prepareStatement(sql);
					pst.setString(1, textField.getText());
					pst.setString(2, textField_1.getText());
					pst.setString(3, textField_2.getText());
					pst.setString(4, textField_3.getText());
					pst.setString(5, textField_4.getText());
					pst.setString(6, textField_5.getText());
					pst.setString(7, textField_6.getText());
					pst.setString(8, textField_7.getText());
					
					pst.execute();
					
					rs.close();
					pst.close();
				}catch(Exception ev){
					JOptionPane.showMessageDialog(null, "Added");
				}
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(new Object[] {
						 textField.getText(),
						 textField_1.getText(),
						 textField_2.getText(),
						 textField_3.getText(),
						 textField_4.getText(),
						 textField_5.getText(),
						 textField_6.getText(),
						 textField_7.getText(),
				});
				if(table.getSelectedRow() == -1) {
					if(table.getRowCount() == 0) {
						JOptionPane.showMessageDialog(null, "Update Confirmed", null, JOptionPane.OK_OPTION);
					}
				}
			}
		});
	}
}
