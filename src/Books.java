import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

//import java.awt.BorderLayout;

//import com.jgoodies.forms.layout.FormLayout;
//import com.jgoodies.forms.layout.ColumnSpec;
//import com.jgoodies.forms.layout.RowSpec;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;

//import com.jgoodies.forms.layout.FormSpecs;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.JComboBox;





//import java.awt.Window.Type;
//import java.awt.GridLayout;
//import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;

import java.util.*;

import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;

public class Books {

	private JFrame frame;
	private JTextField bookid_textField;
	private JTextField title_textField;
	private JTextField authorname_textField;
	private JTable table;
	private JTextField loansbookid_textField;
	private JTextField loansbranch_textField;
	private JTextField loanscardno_textField;
	private JTextField borrower_textField;
	private JTextField lname_textField;
	private JTextField address_textField;
	private JTextField phone_textField;
	private JTextField textField_checkinbook;
	private JTextField textField_checkincard;
	private JTextField textField_checkinname;
	private JTable table_1;
	private JTable table_fines;
	private JTextField textField_loanID_fines;
	private JTextField txtErrorPleaseEnter;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Books window = new Books();
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
	public Books() {
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
//******************************book search****************************************
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 477, 312);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 774, 550);
		frame.getContentPane().add(tabbedPane);
		frame.setSize(800, 600);
		
		JPanel panel_5 = new JPanel();
		tabbedPane.addTab("Main Page", null, panel_5, null);
		panel_5.setLayout(null);
		
		JButton btnNewButton_2 = new JButton("Books Checkout");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			tabbedPane.setSelectedIndex(2);
			}
		});
		btnNewButton_2.setBounds(90, 206, 170, 39);
		panel_5.add(btnNewButton_2);
		
		JLabel lblNewLabel_4 = new JLabel("LIBRARY MANAGEMENT SYSTEM");
		lblNewLabel_4.setFont(new Font("Sitka Text", Font.PLAIN, 25));
		lblNewLabel_4.setBounds(161, 32, 454, 81);
		panel_5.add(lblNewLabel_4);
		
		JButton btnNewButton_3 = new JButton("Book Search");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(1);
			}
		});
		btnNewButton_3.setBounds(90, 129, 170, 39);
		panel_5.add(btnNewButton_3);
		
		JButton btnBooksCheckIn = new JButton("Books Check in");
		btnBooksCheckIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(3);
			}
		});
		btnBooksCheckIn.setBounds(90, 278, 170, 39);
		panel_5.add(btnBooksCheckIn);
		
		JButton btnNewUser = new JButton("New User/Borrower");
		btnNewUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(4);
			}
		});
		btnNewUser.setBounds(90, 357, 170, 39);
		panel_5.add(btnNewUser);
		
		JButton btnFines = new JButton("Fines");
		btnFines.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(5);
			}
		});
		btnFines.setBounds(90, 433, 170, 39);
		panel_5.add(btnFines);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Book Search", null, panel, null);
		panel.setLayout(null);
		panel.setPreferredSize(new Dimension(550, 500));
		
		
		JLabel panel_Bookid = new JLabel("Book_id");
		panel_Bookid.setBounds(6, 9, 80, 14);
		panel.add(panel_Bookid);
		
		bookid_textField = new JTextField();
		bookid_textField.setBounds(117, 6, 86, 20);
		panel.add(bookid_textField);
		bookid_textField.setColumns(10);
		
		JLabel panel_title = new JLabel("Title");
		panel_title.setBounds(6, 35, 80, 14);
		panel.add(panel_title);
		
		title_textField = new JTextField();
		title_textField.setBounds(117, 32, 86, 20);
		panel.add(title_textField);
		title_textField.setColumns(10);
		
		JLabel panel_AuthorName = new JLabel("Author name");
		panel_AuthorName.setBounds(6, 61, 80, 14);
		panel.add(panel_AuthorName);
		
		authorname_textField = new JTextField();
		authorname_textField.setBounds(117, 58, 86, 20);
		panel.add(authorname_textField);
		authorname_textField.setColumns(10);
		
		JLabel label = new JLabel("Please provide a valid entry.");
		label.setBounds(117, 138, 312, 14);
		panel.add(label);
		label.setVisible(false);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 158, 753, 336);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Book_ID", "Title", "Author", "Branch_ID", "# Copies", "# Available Copies"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(90);
		table.getColumnModel().getColumn(0).setMinWidth(30);
		table.getColumnModel().getColumn(1).setPreferredWidth(238);
		table.getColumnModel().getColumn(1).setMaxWidth(2147483610);
		table.getColumnModel().getColumn(2).setPreferredWidth(167);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		table.getColumnModel().getColumn(5).setPreferredWidth(103);
		scrollPane.setViewportView(table);
		
		JButton btnSubmit = new JButton("SEARCH");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
					try{
					
						String Book_ID= bookid_textField.getText();//store input from text box
						bookid_textField.setText("");
						System.out.println(Book_ID);
						String Title= title_textField.getText();//store input from text box
						title_textField.setText("");
						System.out.println(Title);
						String Author_name= authorname_textField.getText();//store input from text box
						authorname_textField.setText("");
						System.out.println(Author_name);
						
						Connect C= new Connect();
						ConnectQuery CQ=new ConnectQuery();
						if(!Book_ID.isEmpty() && !Title.isEmpty() && !Author_name.isEmpty()){
							DefaultTableModel model = (DefaultTableModel) table.getModel();
							model.setRowCount(0);
							String query0="SELECT A.BOOK_ID,B.TITLE,A.AUTHOR_NAME,C.BRANCH_ID,C.NO_OF_COPIES,(C.no_of_copies-t1.count) AS AVAILABLE_COPIES FROM ((BOOK B NATURAL JOIN BOOK_AUTHORS A) NATURAL JOIN BOOK_COPIES C) LEFT JOIN ((select count(*)as count,book_id,branch_id  from Book_loans where date_in is null group by book_id,branch_id) as t1) ON (t1.BOOK_ID = B.BOOK_ID AND t1.branch_id=C.BRANCH_ID) where a.book_id='"+Book_ID+"' or b.title like '%"+Title+"%' or a.author_name like '%"+Author_name+"%';";
							//System.out.println("query is executed"); 
							ResultSet rs0=CQ.connection(query0);//storing result set
							 while(rs0.next()){//displaying result set0
								 label.setVisible(false);
				    	//   System.out.println("temp2");
				    		   String s1=rs0.getString("A.BOOK_ID");
					    	   String s2=rs0.getString("B.TITLE");
					    	   String s3=rs0.getString("A.AUTHOR_NAME");
					    	   String s4=rs0.getString("C.BRANCH_ID");
					    	   String s5=rs0.getString("C.NO_OF_COPIES");
					    	   String temp1=rs0.getString("AVAILABLE_COPIES");
					    	   System.out.println(s1);System.out.println(s2);System.out.println(s3);System.out.println(s4);
					    
					    	//   System.out.println("temp1");
					    	   String s6;
					    	   if(temp1==null){
					    		   System.out.println("yes");
					    		   s6=rs0.getString("C.NO_OF_COPIES");
					    	   }
					    	   else{
					    		   s6=rs0.getString("AVAILABLE_COPIES");
					    	   }
					    	   
					    	   model.addRow(new Object[]{s1,s2,s3,s4,s5,s6});//adding a row to jtable
							 }   
						 }			
						 else if(Book_ID.isEmpty()&& !Title.isEmpty() && !Author_name.isEmpty()){
							 DefaultTableModel model = (DefaultTableModel) table.getModel();
								model.setRowCount(0);
							 Book_ID="@ ";
							 
								String query0="SELECT B.TITLE,A.BOOK_ID,A.AUTHOR_NAME,C.BRANCH_ID,C.NO_OF_COPIES,(C.no_of_copies-t1.count) AS AVAILABLE_COPIES FROM ((BOOK B NATURAL JOIN BOOK_AUTHORS A) NATURAL JOIN BOOK_COPIES C) LEFT JOIN ((select count(*)as count,book_id,branch_id  from Book_loans where date_in is null group by book_id,branch_id) as t1) ON (t1.BOOK_ID = B.BOOK_ID AND t1.branch_id=C.BRANCH_ID) where b.title like '%"+Title+"%' or a.author_name like '%"+Author_name+"%';";
								//System.out.println("query is executed"); 
								ResultSet rs0=CQ.connection(query0);//storing result set
								 while(rs0.next()){//displaying result set0
									 label.setVisible(false);
						    		   System.out.println("temp2");
						    		   String s1=rs0.getString("A.BOOK_ID");
							    	   String s2=rs0.getString("B.TITLE");
							    	   String s3=rs0.getString("A.AUTHOR_NAME");
							    	   String s4=rs0.getString("C.BRANCH_ID");
							    	   String s5=rs0.getString("C.NO_OF_COPIES");
							    	   String temp1=rs0.getString("AVAILABLE_COPIES");
							    
							    	   System.out.println(temp1);
							    	   String s6;
							    	   if(temp1==null){
							    		   System.out.println("yes");
							    		   s6=rs0.getString("C.NO_OF_COPIES");
							    	   }
							    	   else{
							    		   s6=rs0.getString("AVAILABLE_COPIES");
							    	   }
							    	   
							    	   model.addRow(new Object[]{s1,s2,s3,s4,s5,s6});//adding a row to jtable
							    	   				 }			
						}
						 else if(!Book_ID.isEmpty()&& Title.isEmpty() && !Author_name.isEmpty()){
							 DefaultTableModel model = (DefaultTableModel) table.getModel();
								model.setRowCount(0);
								label.setVisible(false);
							 
								String query0="SELECT B.TITLE,A.BOOK_ID,A.AUTHOR_NAME,C.BRANCH_ID,C.NO_OF_COPIES,(C.no_of_copies-t1.count) AS AVAILABLE_COPIES FROM ((BOOK B NATURAL JOIN BOOK_AUTHORS A) NATURAL JOIN BOOK_COPIES C) LEFT JOIN ((select count(*)as count,book_id,branch_id  from Book_loans where date_in is null group by book_id,branch_id) as t1) ON (t1.BOOK_ID = B.BOOK_ID AND t1.branch_id=C.BRANCH_ID) where a.book_id='"+Book_ID+"' or a.author_name like '%"+Author_name+"%';";
								//System.out.println("query is executed"); 
								ResultSet rs0=CQ.connection(query0);//storing result set
								 while(rs0.next()){//displaying result set0
						    		
						    		   System.out.println("temp2");
						    		   String s1=rs0.getString("A.BOOK_ID");
							    	   String s2=rs0.getString("B.TITLE");
							    	   String s3=rs0.getString("A.AUTHOR_NAME");
							    	   String s4=rs0.getString("C.BRANCH_ID");
							    	   String s5=rs0.getString("C.NO_OF_COPIES");
							    	   String temp1=rs0.getString("AVAILABLE_COPIES");
							    
							    	   System.out.println(temp1);
							    	   String s6;
							    	   if(temp1==null){
							    		   System.out.println("yes");
							    		   s6=rs0.getString("C.NO_OF_COPIES");
							    	   }
							    	   else{
							    		   s6=rs0.getString("AVAILABLE_COPIES");
							    	   }
							    	   
							    	   model.addRow(new Object[]{s1,s2,s3,s4,s5,s6});//adding a row to jtable
							    	   
								 }			
						}
						 else if(!Book_ID.isEmpty()&& !Title.isEmpty() && Author_name.isEmpty()){
							 DefaultTableModel model = (DefaultTableModel) table.getModel();
								model.setRowCount(0);
								label.setVisible(false);
							 String query0="SELECT B.TITLE,A.BOOK_ID,A.AUTHOR_NAME,C.BRANCH_ID,C.NO_OF_COPIES,(C.no_of_copies-t1.count) AS AVAILABLE_COPIES FROM ((BOOK B NATURAL JOIN BOOK_AUTHORS A) NATURAL JOIN BOOK_COPIES C) LEFT JOIN ((select count(*)as count,book_id,branch_id  from Book_loans where date_in is null group by book_id,branch_id) as t1) ON (t1.BOOK_ID = B.BOOK_ID AND t1.branch_id=C.BRANCH_ID) where a.book_id='"+Book_ID+"' or b.title like '%"+Title+"%';";
								//System.out.println("query is executed"); 
								ResultSet rs0=CQ.connection(query0);//storing result set
								 while(rs0.next()){//displaying result set0
						    		
						    		   System.out.println("temp2");
						    		   String s1=rs0.getString("A.BOOK_ID");
							    	   String s2=rs0.getString("B.TITLE");
							    	   String s3=rs0.getString("A.AUTHOR_NAME");
							    	   String s4=rs0.getString("C.BRANCH_ID");
							    	   String s5=rs0.getString("C.NO_OF_COPIES");
							    	   String temp1=rs0.getString("AVAILABLE_COPIES");
							    
							    	   System.out.println(temp1);
							    	   String s6;
							    	   if(temp1==null){
							    		   System.out.println("yes");
							    		   s6=rs0.getString("C.NO_OF_COPIES");
							    	   }
							    	   else{
							    		   s6=rs0.getString("AVAILABLE_COPIES");
							    	   }
							    	   
							    	   model.addRow(new Object[]{s1,s2,s3,s4,s5,s6});//adding a row to jtable
							    	   
								 }			
						}
						 else if(Book_ID.isEmpty()&& Title.isEmpty() && !Author_name.isEmpty()){
							 DefaultTableModel model = (DefaultTableModel) table.getModel();
								model.setRowCount(0);
								label.setVisible(false);
								String query0="SELECT B.TITLE,A.BOOK_ID,A.AUTHOR_NAME,C.BRANCH_ID,C.NO_OF_COPIES,(C.no_of_copies-t1.count) AS AVAILABLE_COPIES FROM ((BOOK B NATURAL JOIN BOOK_AUTHORS A) NATURAL JOIN BOOK_COPIES C) LEFT JOIN ((select count(*)as count,book_id,branch_id  from Book_loans where date_in is null group by book_id,branch_id) as t1) ON (t1.BOOK_ID = B.BOOK_ID AND t1.branch_id=C.BRANCH_ID) where a.author_name like '%"+Author_name+"%';";
								//System.out.println("query is executed"); 
								ResultSet rs0=CQ.connection(query0);//storing result set
								 while(rs0.next()){//displaying result set0
						    		
						    		   System.out.println("temp2");
						    		   String s1=rs0.getString("A.BOOK_ID");
							    	   String s2=rs0.getString("B.TITLE");
							    	   String s3=rs0.getString("A.AUTHOR_NAME");
							    	   String s4=rs0.getString("C.BRANCH_ID");
							    	   String s5=rs0.getString("C.NO_OF_COPIES");
							    	   String temp1=rs0.getString("AVAILABLE_COPIES");
							    
							    	   System.out.println(temp1);
							    	   String s6;
							    	   if(temp1==null){
							    		   System.out.println("yes");
							    		   s6=rs0.getString("C.NO_OF_COPIES");
							    	   }
							    	   else{
							    		   s6=rs0.getString("AVAILABLE_COPIES");
							    	   }
							    	   
							    	   model.addRow(new Object[]{s1,s2,s3,s4,s5,s6});//adding a row to jtable
							    	   
								 }			
						}
						 else if(Book_ID.isEmpty()&& !Title.isEmpty() && Author_name.isEmpty()){
							 DefaultTableModel model = (DefaultTableModel) table.getModel();
								model.setRowCount(0);
								label.setVisible(false);
							 String query0="SELECT B.TITLE,A.BOOK_ID,A.AUTHOR_NAME,C.BRANCH_ID,C.NO_OF_COPIES,(C.no_of_copies-t1.count) AS AVAILABLE_COPIES FROM ((BOOK B NATURAL JOIN BOOK_AUTHORS A) NATURAL JOIN BOOK_COPIES C) LEFT JOIN ((select count(*)as count,book_id,branch_id  from Book_loans where date_in is null group by book_id,branch_id) as t1) ON (t1.BOOK_ID = B.BOOK_ID AND t1.branch_id=C.BRANCH_ID) where b.title like '%"+Title+"%';";
								//System.out.println("query is executed"); 
								ResultSet rs0=CQ.connection(query0);//storing result set
								 while(rs0.next()){//displaying result set0
						    		
						    		   System.out.println("temp2");
						    		   String s1=rs0.getString("A.BOOK_ID");
							    	   String s2=rs0.getString("B.TITLE");
							    	   String s3=rs0.getString("A.AUTHOR_NAME");
							    	   String s4=rs0.getString("C.BRANCH_ID");
							    	   String s5=rs0.getString("C.NO_OF_COPIES");
							    	   String temp1=rs0.getString("AVAILABLE_COPIES");
							    
							    	   System.out.println(temp1);
							    	   String s6;
							    	   if(temp1==null){
							    		   System.out.println("yes");
							    		   s6=rs0.getString("C.NO_OF_COPIES");
							    	   }
							    	   else{
							    		   s6=rs0.getString("AVAILABLE_COPIES");
							    	   }
							    	   
							    	   model.addRow(new Object[]{s1,s2,s3,s4,s5,s6});//adding a row to jtable
							    	   
								 }			
						}
						 else if(!Book_ID.isEmpty()&& Title.isEmpty() && Author_name.isEmpty()){
							 DefaultTableModel model = (DefaultTableModel) table.getModel();
								model.setRowCount(0);
								label.setVisible(false);
							 String query0="SELECT B.TITLE,A.BOOK_ID,A.AUTHOR_NAME,C.BRANCH_ID,C.NO_OF_COPIES,(C.no_of_copies-t1.count) AS AVAILABLE_COPIES FROM ((BOOK B NATURAL JOIN BOOK_AUTHORS A) NATURAL JOIN BOOK_COPIES C) LEFT JOIN ((select count(*)as count,book_id,branch_id  from Book_loans where date_in is null group by book_id,branch_id) as t1) ON (t1.BOOK_ID = B.BOOK_ID AND t1.branch_id=C.BRANCH_ID) where a.book_id='"+Book_ID+"';";
								//System.out.println("query is executed"); 
								ResultSet rs0=CQ.connection(query0);//storing result set
								 while(rs0.next()){//displaying result set0
						    		
						    		   System.out.println("temp2");
						    		   String s1=rs0.getString("A.BOOK_ID");
							    	   String s2=rs0.getString("B.TITLE");
							    	   String s3=rs0.getString("A.AUTHOR_NAME");
							    	   String s4=rs0.getString("C.BRANCH_ID");
							    	   String s5=rs0.getString("C.NO_OF_COPIES");
							    	   String temp1=rs0.getString("AVAILABLE_COPIES");
							    
							    	   System.out.println(temp1);
							    	   String s6;
							    	   if(temp1==null){
							    		   System.out.println("yes");
							    		   s6=rs0.getString("C.NO_OF_COPIES");
							    	   }
							    	   else{
							    		   s6=rs0.getString("AVAILABLE_COPIES");
							    	   }
							    	   
							    	   model.addRow(new Object[]{s1,s2,s3,s4,s5,s6});//adding a row to jtable
							    	   
								 }			
						}
						 else if(Book_ID.isEmpty()&& Title.isEmpty() && Author_name.isEmpty()){
							 DefaultTableModel model = (DefaultTableModel) table.getModel();
								model.setRowCount(0);
							 Book_ID="@"; Title="@"; Author_name="@";
							 label.setVisible(true);
							 System.out.println("empty");
								 }			
						}
						
						
						
						 catch(SQLException ex) {
								System.out.println("Error in connection: " + ex.getMessage());
								
							}
			}
			
		});
		btnSubmit.setBounds(117, 109, 101, 23);
		panel.add(btnSubmit);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(0);
			}
		});
		btnBack.setBounds(447, 5, 89, 23);
		panel.add(btnBack);
		
		//*******************************checkout************************************
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Books Check out", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel loans_Bookid = new JLabel("Book_ID");
		loans_Bookid.setBounds(0, 9, 86, 14);
		panel_1.add(loans_Bookid);
		
		loansbookid_textField = new JTextField();
		loansbookid_textField.setBounds(115, 6, 86, 20);
		panel_1.add(loansbookid_textField);
		loansbookid_textField.setColumns(10);
		
		JLabel loans_Branchid = new JLabel("Branch_ID");
		loans_Branchid.setBounds(0, 35, 86, 14);
		panel_1.add(loans_Branchid);
		
		loansbranch_textField = new JTextField();
		loansbranch_textField.setBounds(115, 32, 86, 20);
		panel_1.add(loansbranch_textField);
		loansbranch_textField.setColumns(10);
		
		JLabel loans_Cardno = new JLabel("Card_no");
		loans_Cardno.setBounds(0, 61, 86, 14);
		panel_1.add(loans_Cardno);
		
		loanscardno_textField = new JTextField();
		loanscardno_textField.setBounds(115, 58, 86, 20);
		panel_1.add(loanscardno_textField);
		loanscardno_textField.setColumns(10);
		
		JLabel errormsg = new JLabel("Error: Cannot have more than 3 book loans");
		errormsg.setBounds(108, 113, 285, 14);
		panel_1.add(errormsg);
		errormsg.setVisible(false);
		
		JLabel errormsg2 = new JLabel("Number of copies are zero.");
		errormsg2.setBounds(108, 167, 238, 14);
		panel_1.add(errormsg2);
		errormsg2.setVisible(false);
		
		JLabel errormsg3 = new JLabel("No available copies");
		errormsg3.setBounds(109, 208, 211, 14);
		panel_1.add(errormsg3);
		errormsg3.setVisible(false);
		
		JLabel errormsg4 = new JLabel("Please provide a valid entry.");
		errormsg4.setBounds(106, 257, 201, 14);
		panel_1.add(errormsg4);
		errormsg4.setVisible(false);
		
		JLabel successful_label = new JLabel("Book successfully checkedout!!");
		successful_label.setBounds(115, 167, 267, 14);
		panel_1.add(successful_label);
		successful_label.setVisible(false);
		
		JButton loans_NewButton = new JButton("Checkout");
		loans_NewButton.setBounds(119, 84, 146, 23);
		loans_NewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//try{
				
					String Book_ID= loansbookid_textField.getText();//store input from text box
					loansbookid_textField.setText("");
					System.out.println(Book_ID);
					String Branch_ID= loansbranch_textField.getText();//store input from text box
					loansbranch_textField.setText("");
					System.out.println(Branch_ID);
					String Card_no= loanscardno_textField.getText();//store input from text box
					loanscardno_textField.setText("");
					System.out.println(Card_no);
					DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
					
					
					
				//	int loan_number=0; //random loan number
					if(!Book_ID.isEmpty() && !Branch_ID.isEmpty() && !Card_no.isEmpty())
					{
					successful_label.setVisible(false);
					errormsg.setVisible(false);
					errormsg2.setVisible(false);
					errormsg3.setVisible(false);
					errormsg4.setVisible(false);
					Calendar cal = Calendar.getInstance();
					Calendar cal1 = Calendar.getInstance();
					Connect C1= new Connect();
					ConnectQuery CQ1=new ConnectQuery();
					cal1.add(Calendar.DATE, 14); // Adding 14 days
					try{
						System.out.println("step1");
						String query1="select count(*) as bookloans_count from book_loans where date_in is null group by card_no having card_no='"+Card_no+"';";
						
						 ResultSet rs1=CQ1.connection(query1);//storing result set
//						 int count1=0;
						 if(rs1.next()){

						 int one=rs1.getInt("bookloans_count");
						 System.out.println(one);
						 //int c=0; //count errors
						 	if(one>=3) // more than 3 copies checkedout
							{
						 		errormsg3.setVisible(false);
								errormsg2.setVisible(false);
								errormsg4.setVisible(false);
								successful_label.setVisible(false);
								errormsg.setVisible(true);
								
							}
							else
							 {
								 String query2="select No_of_copies from book_copies where book_id='"+Book_ID+"' and Branch_id='"+Branch_ID+"';";
								 ResultSet rs2=CQ1.connection(query2);//storing result set
								 System.out.println("print 2");
								int two=0;
								 while(rs2.next()){
									 two=Integer.parseInt(rs2.getString(1));
									 System.out.println(two); 	 
								 }
								 
								 //System.out.println(rs2.getInt("No_of_copies")); 
								 
								 String query3="select count(*) as c2 from book_loans where branch_id='"+Branch_ID+"' and date_in is null group by book_id having book_id='"+Book_ID+"';";
								 // String query3="select count(*) as c2 from book_loans where branch_id='"+Branch_ID+"' and date_in is null group by book_id having book_id='"+Book_ID+"';";
								 ResultSet rs3=CQ1.connection(query3);//storing result set
								 int three=0;
								 successful_label.setVisible(false);
								 errormsg.setVisible(false);
									errormsg3.setVisible(false);
									errormsg2.setVisible(false);
									errormsg4.setVisible(false);
									
								 System.out.println("print 4");
								 while(rs3.next())
								 {
									 three=rs3.getInt("c2");
									 System.out.println(rs3.getInt("c2"));
									 }
									 if(two-three<=0)
									 {
										 successful_label.setVisible(false);
											errormsg.setVisible(false);
											errormsg2.setVisible(false);
											errormsg4.setVisible(false);
											errormsg3.setVisible(true);
										
									 }
									 else
									 {
										//Query to retrieve result set
										 System.out.println("print 5");
											String endquery="insert into book_loans(book_id,branch_id,card_no,date_out,date_due) values('"+Book_ID+"','"+Branch_ID+"','"+Card_no+"','"+dateFormat.format(cal.getTime())+"','"+dateFormat.format(cal1.getTime())+"');";
											System.out.println("print 6");
									    	   int rs4=C1.connection(endquery);//storing result set
									    	   if(rs4!=0){
									    		   errormsg.setVisible(false);
													errormsg2.setVisible(false);
													errormsg3.setVisible(false);
													errormsg4.setVisible(false);
									    		   successful_label.setVisible(true);
									    		   
													}
									  }
								    	   
								 }
							 }
							 
						 
						 
						 
						 else{
							 String query2="select No_of_copies from book_copies where book_id='"+Book_ID+"' and Branch_id='"+Branch_ID+"';";
							 ResultSet rs2=CQ1.connection(query2);//storing result set
							 int two=0;
							 successful_label.setVisible(false);
				    		   errormsg.setVisible(false);
								errormsg2.setVisible(false);
								errormsg3.setVisible(false);
								errormsg4.setVisible(false);
							 while(rs2.next()){
								 two=rs2.getInt("No_of_copies");
								 System.out.println(rs2.getInt("No_of_copies"));
							 }
							
							 
							 String query3="select count(*) as c2 from book_loans where branch_id='"+Branch_ID+"' and date_in is null group by book_id having book_id='"+Book_ID+"';";
							
							 ResultSet rs3=CQ1.connection(query3);//storing result set
							 int three=0;
							 while(rs3.next()){
								 three=rs3.getInt("c2");
								 System.out.println(rs3.getInt("c2"));
							 }
							 
							 if(two-three<=0)
							 {
								 successful_label.setVisible(false);
								 errormsg.setVisible(false);
									errormsg2.setVisible(false);
									errormsg4.setVisible(false);
									errormsg3.setVisible(true);
									
									
							 }
							 else{
							 System.out.println("elsestatement");
							 String endquery="insert into book_loans(book_id,branch_id,card_no,date_out,date_due) values('"+Book_ID+"','"+Branch_ID+"','"+Card_no+"','"+dateFormat.format(cal.getTime())+"','"+dateFormat.format(cal1.getTime())+"');";
							
					    	   int rs4=C1.connection(endquery);//storing result set
					    	   if(rs4!=0){
					    		   errormsg3.setVisible(false);
									errormsg.setVisible(false);
									errormsg2.setVisible(false);
									errormsg4.setVisible(false);
					    		   successful_label.setVisible(true);
					    		  
					    	   }
					    	   
							 }
						 	}
						 }
			    	 
				
					catch(SQLException ex) {
						System.out.println("Error in connection: " + ex.getMessage());
						//return 0;
					}
			}
		else
		{
			errormsg4.setVisible(true);
			errormsg2.setVisible(false);
			errormsg3.setVisible(false);
			errormsg.setVisible(false);
		}}
		});
		panel_1.add(loans_NewButton);
		
		JButton btnBack_1 = new JButton("Back");
		btnBack_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(0);
			}
		});
		btnBack_1.setBounds(409, 5, 89, 23);
		panel_1.add(btnBack_1);
		
		
			
		//***********************************check in**********************************
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Books Check in", null, panel_3, null);
		panel_3.setLayout(null);
		
		JLabel lblBookId = new JLabel("Book ID");
		lblBookId.setBounds(10, 26, 64, 14);
		panel_3.add(lblBookId);
		
		textField_checkinbook = new JTextField();
		textField_checkinbook.setBounds(86, 23, 116, 20);
		panel_3.add(textField_checkinbook);
		textField_checkinbook.setColumns(10);
		
		JLabel lblCardNo = new JLabel("Card No");
		lblCardNo.setBounds(10, 51, 74, 14);
		panel_3.add(lblCardNo);
		
		textField_checkincard = new JTextField();
		textField_checkincard.setBounds(86, 48, 116, 20);
		panel_3.add(textField_checkincard);
		textField_checkincard.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(10, 76, 64, 14);
		panel_3.add(lblName);
		
		textField_checkinname = new JTextField();
		textField_checkinname.setBounds(86, 73, 116, 20);
		panel_3.add(textField_checkinname);
		textField_checkinname.setColumns(10);
		
		table_1 = new JTable();
		/*table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Loan_id", "Book_id", "Branch_Id", "Card_no", "Date_out", "Date_due", "Date_in","check"
			}
		));*/
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 149, 706, 320);
		panel_3.add(scrollPane_1);
		
		JLabel lblNoBookBorrowed = new JLabel("No book borrowed by that card holder.");
		lblNoBookBorrowed.setBounds(309, 73, 322, 17);
		panel_3.add(lblNoBookBorrowed);
		lblNoBookBorrowed.setVisible(false);
		
		JLabel lblNewLabel_3 = new JLabel("Entry is invalid.");
		lblNewLabel_3.setBounds(302, 40, 205, 14);
		panel_3.add(lblNewLabel_3);
		lblNewLabel_3.setVisible(false);
		
		JLabel lblCheckInSuccessful = new JLabel("Check in successful");
		lblCheckInSuccessful.setBounds(515, 118, 192, 14);
		panel_3.add(lblCheckInSuccessful);
		lblCheckInSuccessful.setVisible(false);
		
		JButton btnCheckIn = new JButton("Get details");
		btnCheckIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNoBookBorrowed.setVisible(false);
				lblNewLabel_3.setVisible(false);
				lblCheckInSuccessful.setVisible(false);
				try{
				String Book_ID= textField_checkinbook.getText();//store input from text box
				textField_checkinbook.setText("");
				System.out.println(Book_ID);
				String card_no= textField_checkincard.getText();//store input from text box
				textField_checkincard.setText("");
				System.out.println(card_no);
				String name= textField_checkinname.getText();//store input from text box
				textField_checkinname.setText("");
				System.out.println(name);
		
				lblNoBookBorrowed.setVisible(false);
				lblNewLabel_3.setVisible(false);
				lblCheckInSuccessful.setVisible(false);
				//DefaultTableModel model = (DefaultTableModel) table_1.getModel();
				//model.setRowCount(0);
				 
				DefaultTableModel model = new DefaultTableModel(){
					public Class<?> getColumnClass(int column){
						switch(column){
						case 0:
							return String.class;
						case 1:
							return String.class;
						case 2:
							return String.class;
						case 3:
							return String.class;
						case 4:
							return String.class;
						case 5:
							return String.class;
						case 6:
							return String.class;
						case 7:
							return Boolean.class;
						default:
							return String.class;
						}
					}};
					
					model.addColumn("Loan_id");
					model.addColumn("Book_ID");
					model.addColumn("Branch_Id");
					model.addColumn("Card_no");
					model.addColumn("Date_out");
					model.addColumn("Date_due");
					model.addColumn("Date_in"); 
					model.addColumn("check");
					table_1.setModel(model);
	    	   	ConnectQuery CQ2=new ConnectQuery();
	    	   	ResultSet rs4=null;
	    	   	if(!Book_ID.isEmpty() && !card_no.isEmpty() && !name.isEmpty())
	    	   	{
	    	   		lblNoBookBorrowed.setVisible(false);
					lblNewLabel_3.setVisible(false);
					lblCheckInSuccessful.setVisible(false);
	    	   		String query4="select distinct loan_id,book_id,branch_id,book_loans.card_no,date_out,date_due,date_in from book_loans join borrower on book_loans.card_no=borrower.card_no where date_in is null and (book_id='"+Book_ID+"' or book_loans.card_no='"+card_no+"' or borrower.fname like'%"+name+"%' or borrower.lname like '%"+name+"%');";
	    	   		 rs4=CQ2.connection(query4);//storing result set
					System.out.println("temp2");	
					
					while(rs4.next()){
					   String s1=rs4.getString("loan_id");
			    	   String s2=rs4.getString("book_id");
			    	   String s3=rs4.getString("branch_id");
			    	   String s4=rs4.getString("book_loans.card_no");
			    	   String s5=rs4.getString("date_out");
			    	   String s6=rs4.getString("date_due");
			    	   String s7=rs4.getString("date_in");
			    	   
			    	  // System.out.println("works");		    	
			    	   model.addRow(new Object[]{s1,s2,s3,s4,s5,s6,s7,false});//adding a row to jtable
			    	  // System.out.println("displays table");
					}
	    	   	}
	    	   	else if(Book_ID.isEmpty() && !card_no.isEmpty() && !name.isEmpty())
	    	   	{
	    	   		lblCheckInSuccessful.setVisible(false);
	    	   		lblNoBookBorrowed.setVisible(false);
					lblNewLabel_3.setVisible(false);
	    	   		String query4="select distinct loan_id,book_id,branch_id,book_loans.card_no,date_out,date_due,date_in from book_loans join borrower on book_loans.card_no=borrower.card_no where date_in is null and (book_loans.card_no='"+card_no+"' or borrower.fname like'%"+name+"%' or borrower.lname like '%"+name+"%');";
	    	   		 rs4=CQ2.connection(query4);//storing result set
					System.out.println("temp2");
					
					while(rs4.next()){
					   String s1=rs4.getString("loan_id");
			    	   String s2=rs4.getString("book_id");
			    	   String s3=rs4.getString("branch_id");
			    	   String s4=rs4.getString("book_loans.card_no");
			    	   String s5=rs4.getString("date_out");
			    	   String s6=rs4.getString("date_due");
			    	   String s7=rs4.getString("date_in");
			    	   
			    	  // System.out.println("works");		    	
			    	   model.addRow(new Object[]{s1,s2,s3,s4,s5,s6,s7,false});//adding a row to jtable
			    	  // System.out.println("displays table");
					}
	    	   	}
	    	   	else if(!Book_ID.isEmpty() && card_no.isEmpty() && !name.isEmpty())
	    	   	{
	    	   		lblCheckInSuccessful.setVisible(false);
	    	   		lblNoBookBorrowed.setVisible(false);
					lblNewLabel_3.setVisible(false);
	    	   		String query4="select distinct loan_id,book_id,branch_id,book_loans.card_no,date_out,date_due,date_in from book_loans join borrower on book_loans.card_no=borrower.card_no where date_in is null and (book_id='"+Book_ID+"' or borrower.fname like'%"+name+"%' or borrower.lname like '%"+name+"%');";
	    	   		 rs4=CQ2.connection(query4);//storing result set
					System.out.println("temp2");	
					
					while(rs4.next()){
					   String s1=rs4.getString("loan_id");
			    	   String s2=rs4.getString("book_id");
			    	   String s3=rs4.getString("branch_id");
			    	   String s4=rs4.getString("book_loans.card_no");
			    	   String s5=rs4.getString("date_out");
			    	   String s6=rs4.getString("date_due");
			    	   String s7=rs4.getString("date_in");
			    	   
			    	  // System.out.println("works");		    	
			    	   model.addRow(new Object[]{s1,s2,s3,s4,s5,s6,s7,false});//adding a row to jtable
			    	  // System.out.println("displays table");
					}
	    	   	}
	    	   	else if(!Book_ID.isEmpty() && !card_no.isEmpty() && name.isEmpty())
	    	   	{
	    	   		lblCheckInSuccessful.setVisible(false);
	    	   		lblNoBookBorrowed.setVisible(false);
					lblNewLabel_3.setVisible(false);
	    	   		String query4="select distinct loan_id,book_id,branch_id,book_loans.card_no,date_out,date_due,date_in from book_loans join borrower on book_loans.card_no=borrower.card_no where date_in is null and (book_id='"+Book_ID+"' or book_loans.card_no='"+card_no+"');";
	    	   		 rs4=CQ2.connection(query4);//storing result set
					System.out.println("temp2");	
					
					while(rs4.next()){
					   String s1=rs4.getString("loan_id");
			    	   String s2=rs4.getString("book_id");
			    	   String s3=rs4.getString("branch_id");
			    	   String s4=rs4.getString("book_loans.card_no");
			    	   String s5=rs4.getString("date_out");
			    	   String s6=rs4.getString("date_due");
			    	   String s7=rs4.getString("date_in");
			    	   
			    	  // System.out.println("works");		    	
			    	   model.addRow(new Object[]{s1,s2,s3,s4,s5,s6,s7,false});//adding a row to jtable
			    	  // System.out.println("displays table");
					}
	    	   	}
	    	   	else if(Book_ID.isEmpty() && card_no.isEmpty() && !name.isEmpty())
	    	   	{
	    	   		lblNoBookBorrowed.setVisible(false);
					lblNewLabel_3.setVisible(false);
					lblCheckInSuccessful.setVisible(false);
	    	   		String query4="select distinct loan_id,book_id,branch_id,book_loans.card_no,date_out,date_due,date_in from book_loans join borrower on book_loans.card_no=borrower.card_no where date_in is null and (borrower.fname like'%"+name+"%' or borrower.lname like '%"+name+"%');";
	    	   		 rs4=CQ2.connection(query4);//storing result set
					System.out.println("temp2");	
					
					while(rs4.next()){
					   String s1=rs4.getString("loan_id");
			    	   String s2=rs4.getString("book_id");
			    	   String s3=rs4.getString("branch_id");
			    	   String s4=rs4.getString("book_loans.card_no");
			    	   String s5=rs4.getString("date_out");
			    	   String s6=rs4.getString("date_due");
			    	   String s7=rs4.getString("date_in");
			    	   
			    	  // System.out.println("works");		    	
			    	   model.addRow(new Object[]{s1,s2,s3,s4,s5,s6,s7,false});//adding a row to jtable
			    	  // System.out.println("displays table");
					}
	    	   	}
	    	   	else if(Book_ID.isEmpty() && !card_no.isEmpty() && name.isEmpty())
	    	   	{
	    	   		lblNoBookBorrowed.setVisible(false);
					lblNewLabel_3.setVisible(false);
					lblCheckInSuccessful.setVisible(false);
	    	   		String query4="select distinct loan_id,book_id,branch_id,book_loans.card_no,date_out,date_due,date_in from book_loans join borrower on book_loans.card_no=borrower.card_no where date_in is null and (book_loans.card_no='"+card_no+"');";
	    	   		 rs4=CQ2.connection(query4);//storing result set
					System.out.println("temp2");	
					
					while(rs4.next()){
					   String s1=rs4.getString("loan_id");
			    	   String s2=rs4.getString("book_id");
			    	   String s3=rs4.getString("branch_id");
			    	   String s4=rs4.getString("book_loans.card_no");
			    	   String s5=rs4.getString("date_out");
			    	   String s6=rs4.getString("date_due");
			    	   String s7=rs4.getString("date_in");
			    	   
			    	  // System.out.println("works");		    	
			    	   model.addRow(new Object[]{s1,s2,s3,s4,s5,s6,s7,false});//adding a row to jtable
			    	  // System.out.println("displays table");
					}
	    	   	}
	    	   	else if(!Book_ID.isEmpty() && card_no.isEmpty() && name.isEmpty())
	    	   	{
	    	   		lblNoBookBorrowed.setVisible(false);
					lblNewLabel_3.setVisible(false);
					lblCheckInSuccessful.setVisible(false);
	    	   		String query4="select distinct loan_id,book_id,branch_id,book_loans.card_no,date_out,date_due,date_in from book_loans join borrower on book_loans.card_no=borrower.card_no where date_in is null and (book_id='"+Book_ID+"');";
	    	   		 rs4=CQ2.connection(query4);//storing result set
					System.out.println("temp2");	
					
					while(rs4.next()){
					   String s1=rs4.getString("loan_id");
			    	   String s2=rs4.getString("book_id");
			    	   String s3=rs4.getString("branch_id");
			    	   String s4=rs4.getString("book_loans.card_no");
			    	   String s5=rs4.getString("date_out");
			    	   String s6=rs4.getString("date_due");
			    	   String s7=rs4.getString("date_in");
			    	   
			    	  // System.out.println("works");		    	
			    	   model.addRow(new Object[]{s1,s2,s3,s4,s5,s6,s7,false});//adding a row to jtable
			    	  // System.out.println("displays table");
					}
	    	   	}
	    	   	else
	    	   	{
	    	   		lblNoBookBorrowed.setVisible(false);
	    	   		lblNewLabel_3.setVisible(true);
	    	   		lblCheckInSuccessful.setVisible(false);
	    	   	}
	    	   	
	    	   		if(!rs4.next())
	    	   		{
	    	   			lblNoBookBorrowed.setVisible(true);
	    	   			lblNewLabel_3.setVisible(false);
	    	   			lblCheckInSuccessful.setVisible(false);	
	    	   		}
	    	   		
			}
			
			catch(SQLException ex) {
				System.out.println("Error in connection: " + ex.getMessage());
				
				
			}}
		});
		btnCheckIn.setBounds(66, 114, 116, 23);
		panel_3.add(btnCheckIn);
		
		
		
		scrollPane_1.setViewportView(table_1);
		
		JButton btnNewButton_1 = new JButton("Check In confirmation");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblNoBookBorrowed.setVisible(false);
				lblNewLabel_3.setVisible(false);
				Connect C2=new Connect();
				for(int i=0;i<table_1.getRowCount();i++){
					Boolean checked = Boolean.valueOf(table_1.getValueAt(i, 7).toString());
					String col=(String) table_1.getValueAt(i,0);
					if(checked){
						String q="update book_loans set date_in=curdate() where loan_id='"+col+"';";
						int r4=C2.connection(q);//storing result set
						lblNoBookBorrowed.setVisible(false);
						lblNewLabel_3.setVisible(false);
						lblCheckInSuccessful.setVisible(true);
					}
				}}
		});
		btnNewButton_1.setBounds(272, 114, 192, 23);
		panel_3.add(btnNewButton_1);
		
		JButton btnBack_2 = new JButton("Back");
		btnBack_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(0);
			}
		});
		btnBack_2.setBounds(417, 22, 89, 23);
		panel_3.add(btnBack_2);
		
		
		
		
		
		
		//*******************************************borrower management***********************************************
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Borrower", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel borrower_fname = new JLabel("First name");
		borrower_fname.setBounds(6, 9, 100, 14);
		panel_2.add(borrower_fname);
		
		borrower_textField = new JTextField();
		borrower_textField.setBounds(104, 6, 100, 20);
		panel_2.add(borrower_textField);
		borrower_textField.setColumns(10);
		
		JLabel borrower_lname = new JLabel("Last name");
		borrower_lname.setBounds(7, 35, 99, 14);
		panel_2.add(borrower_lname);
		
		lname_textField = new JTextField();
		lname_textField.setBounds(104, 32, 100, 20);
		panel_2.add(lname_textField);
		lname_textField.setColumns(10);
		
		JLabel Address = new JLabel("Address");
		Address.setBounds(6, 61, 100, 14);
		panel_2.add(Address);
		
		address_textField = new JTextField();
		address_textField.setBounds(104, 58, 325, 20);
		panel_2.add(address_textField);
		address_textField.setColumns(10);
		
		JLabel borrower_Phone = new JLabel("Phone #");
		borrower_Phone.setBounds(6, 87, 90, 14);
		panel_2.add(borrower_Phone);
		
		phone_textField = new JTextField();
		phone_textField.setBounds(104, 84, 100, 20);
		panel_2.add(phone_textField);
		phone_textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Added successfully!");
		lblNewLabel_1.setBounds(29, 180, 455, 14);
		panel_2.add(lblNewLabel_1);
		lblNewLabel_1.setVisible(false);
		
		JLabel lblNewLabel = new JLabel("ERROR: Person with same name and address already exists.");
		lblNewLabel.setBounds(10, 135, 419, 14);
		panel_2.add(lblNewLabel);
		lblNewLabel.setVisible(false);
		
		JLabel lblNewLabel_2 = new JLabel("Please provide the required details!");
		lblNewLabel_2.setBounds(29, 218, 274, 14);
		panel_2.add(lblNewLabel_2);	
		lblNewLabel_2.setVisible(false);
		
		JButton btnSubmit_borrower = new JButton("Submit");
		btnSubmit_borrower.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					try{
				String Fname= borrower_textField.getText();//store input from text box
				borrower_textField.setText("");
				System.out.println(Fname);
				String Lname= lname_textField.getText();//store input from text box
				lname_textField.setText("");
				System.out.println(Lname);
				String Address= address_textField.getText();//store input from text box
				address_textField.setText("");
				System.out.println(Address);
				String PhoneNo= phone_textField.getText();//store input from text box
				phone_textField.setText("");
				System.out.println(PhoneNo);
				
				Connect C=new Connect();
				ConnectQuery CQ2=new ConnectQuery();
				if(!Fname.isEmpty() && !Lname.isEmpty() && !Address.isEmpty()){
					String q="select * from borrower where borrower.fname='"+Fname+"' and borrower.lname='"+Lname+"' and borrower.Address='"+Address+"';";
					ResultSet rs=CQ2.connection(q);
					if(rs.next())
					{
						lblNewLabel.setVisible(true);
						lblNewLabel_1.setVisible(false);
						lblNewLabel_2.setVisible(false);
					}
					else
					{
					lblNewLabel.setVisible(false);
					String query5="insert into borrower(Fname,Lname,Address,Phone) values('"+Fname+"','"+Lname+"','"+Address+"','"+PhoneNo+"');";
					lblNewLabel_1.setVisible(true);
					int rs6=C.connection(query5);//storing result set
					lblNewLabel_2.setVisible(false);
					}
				}
				
				else{
					
					lblNewLabel_2.setVisible(true);	
					lblNewLabel.setVisible(false);
					lblNewLabel_1.setVisible(false);
				}
				
				
			}
			
			catch(SQLException ex) {
				System.out.println("Error in connection: " + ex.getMessage());
				
			}
			}});
		btnSubmit_borrower.setBounds(90, 111, 114, 23);
		panel_2.add(btnSubmit_borrower);
		
		JButton btnBack_3 = new JButton("Back");
		btnBack_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(0);
			}
		});
		btnBack_3.setBounds(498, 5, 89, 23);
		panel_2.add(btnBack_3);
		
		
		//**********************************fines table************************************************************
		//*********************************************************************************************************
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Fines", null, panel_4, null);
		panel_4.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(20, 82, 341, 327);
		panel_4.add(scrollPane_2);
		
		table_fines = new JTable();
		table_fines.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Card_no", "Fine Amount", "Fine Paid"
			}
		));
		scrollPane_2.setViewportView(table_fines);
		DefaultTableModel model1 = (DefaultTableModel) table_fines.getModel();
		model1.setRowCount(0);
		JButton btnNewButton = new JButton("Fines Update");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
				ConnectQuery CQ1=new ConnectQuery();
				Connect c=new Connect();
				
	//			String query0="select * from fines;";
	//			ResultSet rs0=CQ1.connection(query0);
				
				String query1="select loan_id from book_loans where date_in is null;";
				ResultSet rs1=CQ1.connection(query1);
				
				//System.out.println(rs1.getString(1));
				//*****************************************************************************
				while(rs1.next())
				{
					//System.out.println("1");
					
					String s1=rs1.getString("loan_id");
					System.out.println(s1);
					String query2="select curdate()-date_due as difference from book_loans where loan_id='"+s1+"';";
					ResultSet rs2=CQ1.connection(query2);
					
					//System.out.println("query2 success");
					int noOfDays=0;
						if(rs2.next())
						{
							System.out.println(rs2.getString(1));
							noOfDays= Integer.parseInt(rs2.getString(1));
						}
					float loan_amt=0;
						if(noOfDays>0)
						{
							loan_amt=(float) (noOfDays*0.25);
						}
						else
						{
							System.out.println("No fine.");
						}
					String query3="select loan_id from fines where loan_id='"+s1+"';";
					ResultSet rs3=CQ1.connection(query3);
					
						if(rs3.next())
						{
							String loan=rs3.getString(1);
							System.out.println(loan);
							String query4="update fines set fine_amt='"+loan_amt+"' where loan_id='"+loan+"';";
							int rs4=c.connection(query4);
							
						}
						else
						{
							String query5="insert into fines values('"+s1+"','"+loan_amt+"',0);";
							int rs5=c.connection(query5);
						}

					//	model1.addRow(new Object[]{s1,loan_amt,0});//adding a row to jtable
				}
					//********************************************date_in not null(returned books)*******************************************
						
						String query6="select loan_id from book_loans where date_in is not null;";
						ResultSet rs6=CQ1.connection(query6);
						
						while(rs6.next())
						{
							//System.out.println("entered while loop");
							String s6=rs6.getString("loan_id");
							System.out.println(s6);
							String query7="select date_in-date_due as difference from book_loans where loan_id='"+s6+"';";
							ResultSet rs7=CQ1.connection(query7);
							//System.out.println("query7 success");
							int noOfDays1=0;
								if(rs7.next())
								{
									System.out.println(rs7.getString(1));
									noOfDays1= Integer.parseInt(rs7.getString(1));
								}
							float loan_amt1=0;
								if(noOfDays1>0)
								{
									loan_amt1=(float) (noOfDays1*0.25);
								}
								else
								{
									System.out.println("No fine.");
								}
							/*String query8="select loan_id from fines where loan_id='"+s6+"';";
								//String query8="select * from fines where loan_id='"+s6+"';";
							ResultSet rs8=CQ1.connection(query8);
							
								if(rs8.next())
								{
									String loan=rs8.getString(1);
									System.out.println(loan);
									*/
									//String query10="select loan_id from fines where loan_id='"+s6+"' and paid='No';";
									String query10="select * from fines where loan_id='"+s6+"';";
									ResultSet rs10=CQ1.connection(query10);
									int count=0;
									while(rs10.next()){

										count++;
									}
									System.out.println(count);
									if(count>0)
									{
										System.out.println("check");
									//	String ss=rs10.getString(1);
										
										String query9="update fines set fine_amt='"+loan_amt1+"' where loan_id='"+s6+"';";
										int rs9=c.connection(query9);	
										//model1.addRow(new Object[]{ss,loan_amt,"no"});//adding a row to jtable
										if(rs9!=0)
										{
											System.out.println("table has been updated");
										}
										else
										{
											System.out.println("table has not been updated");
										}
									}
									/*else
									{
										System.out.println("everyone has paid the fine");
									}
									
								}*/
								else
								{
									
									String query11="insert into fines values('"+s6+"','"+loan_amt1+"',0);";
									int rs11=c.connection(query11);
									while(rs11!=0){
									//model1.addRow(new Object[]{s6,loan_amt,"no"});//adding a row to jtable
								}
								String query12="select paid from fines where loan_id='"+s6+"';";
								ResultSet rs12=CQ1.connection(query12);
								
								//model1.addRow(new Object[]{s6,loan_amt1,"No"});//adding a row to jtable
								
								if(rs12.next()){
									String a=rs12.getString(1);
						//			model1.addRow(new Object[]{s6,loan_amt1,a});
								}}
									
								
				
			
						}}
				catch(SQLException ex) {
					System.out.println("Error in connection: " + ex.getMessage());
					}
				ConnectQuery CQ1= new ConnectQuery();
				String q="select distinct card_no,sum(fine_amt),paid from book_loans join fines on book_loans.loan_id=fines.loan_id where paid=0 group by card_no,paid;";
				
				ResultSet r=CQ1.connection(q);	
				try {
					while(r.next()){
					String card=r.getString("card_no");
					String fine=r.getString("sum(fine_amt)");
					String paid=r.getString("paid");
					model1.addRow(new Object[]{card,fine,paid});
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		
	
		btnNewButton.setBounds(137, 40, 152, 23);
		panel_4.add(btnNewButton);
		
		JLabel lblLoanid = new JLabel("Loan_ID");
		lblLoanid.setBounds(516, 25, 108, 23);
		panel_4.add(lblLoanid);
		
		textField_loanID_fines = new JTextField();
		textField_loanID_fines.setBounds(609, 26, 150, 20);
		panel_4.add(textField_loanID_fines);
		textField_loanID_fines.setColumns(10);
		
		
		JLabel lblPaid = new JLabel("Paid");
		lblPaid.setBounds(516, 59, 95, 14);
		panel_4.add(lblPaid);
		
		JComboBox comboBox_paid_fines = new JComboBox();
		comboBox_paid_fines.setModel(new DefaultComboBoxModel(new String[] {"Yes", "No"}));
		comboBox_paid_fines.setBounds(607, 56, 89, 20);
		panel_4.add(comboBox_paid_fines);
		
		JLabel fines_errormsg = new JLabel("Cannot be marked as paid until the book is checked in.");
		fines_errormsg.setBounds(385, 157, 384, 39);
		panel_4.add(fines_errormsg);
		fines_errormsg.setVisible(false);
		
		JLabel fines_errormsg2 = new JLabel("Please provide a valid Loan ID.");
		fines_errormsg2.setBounds(385, 221, 264, 14);
		panel_4.add(fines_errormsg2);
		fines_errormsg2.setVisible(false);
		
		JLabel lblNewLabel_5 = new JLabel("Database has been updated.");
		lblNewLabel_5.setBounds(516, 258, 192, 14);
		panel_4.add(lblNewLabel_5);
		lblNewLabel_5.setVisible(false);
		
		JButton btnLibrarianUpdate = new JButton("Librarian Update");
		btnLibrarianUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					lblNewLabel_5.setVisible(false);
					ConnectQuery C5=new ConnectQuery();
					Connect con = new Connect();
					String loan_id= textField_loanID_fines.getText();//store input from text box
					textField_loanID_fines.setText("");
					System.out.println(loan_id);
					String paid= (String) comboBox_paid_fines.getSelectedItem();
					
						
					
					int paid_boo=0;
					if(!loan_id.isEmpty()){
					String query0="select * from book_loans where loan_id='"+loan_id+"' and date_in is not null;"; 
					ResultSet rs0=C5.connection(query0);
					lblNewLabel_5.setVisible(false);
					if(rs0.next()){
						if(paid=="Yes")
						{
							paid_boo=1;
							System.out.println("paid is 1");
							fines_errormsg.setVisible(false);
							fines_errormsg2.setVisible(false);
							lblNewLabel_5.setVisible(true);
						}
						else
						{
							paid_boo=0;
							System.out.println("paid is 0");
							fines_errormsg.setVisible(false);
							fines_errormsg2.setVisible(false);
							lblNewLabel_5.setVisible(true);
						}
						String query15="update fines set paid='"+paid_boo+"' where loan_id='"+loan_id+"';";
						//	ResultSet rs15=C5.connection(query15);
						int rs67 = con.connection(query15);

						if(rs67 != 0)
						{
							System.out.println(" entered into loop");
							fines_errormsg.setVisible(false);
							fines_errormsg2.setVisible(false);
							lblNewLabel_5.setVisible(true);
						}
						
						}
						else
						{
						fines_errormsg2.setVisible(false);
						lblNewLabel_5.setVisible(false);
						fines_errormsg.setVisible(true);
						}
					}
				
				else
				{
					System.out.println("entered into this loop");
					fines_errormsg.setVisible(false);
					lblNewLabel_5.setVisible(false);
				fines_errormsg2.setVisible(true);
				
				} 
				}
				catch (SQLException e) {
						// TODO Auto-generated catch block
						System.out.println("Error in connection: " + e.getMessage());
					}

			}
		});
		btnLibrarianUpdate.setBounds(535, 104, 161, 23);
		panel_4.add(btnLibrarianUpdate);
		
		JButton btnBack_4 = new JButton("Back");
		btnBack_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(0);
			}
		});
		btnBack_4.setBounds(398, 11, 89, 23);
		panel_4.add(btnBack_4);
		
	
		
		
		
	
		
	}
}