package com.sis.gui;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MainGUI {

	protected Shell shlStudentInformationSystem;
	private Text txtName;
	private Text txtAge;
	private Text txtCourse;
	private Text txtID;
	private Text txtAddress;
	private Button btnReset;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
            // connect method #1 - embedded driver
            String dbURL = "jdbc:derby:db/Student;create=true";
            Connection conn = DriverManager.getConnection(dbURL);
            if (conn != null) {
                System.out.println("Connected to database #1");
            }
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		try {
			MainGUI window = new MainGUI();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlStudentInformationSystem.open();
		shlStudentInformationSystem.layout();
		while (!shlStudentInformationSystem.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlStudentInformationSystem = new Shell();
		shlStudentInformationSystem.setSize(319, 300);
		shlStudentInformationSystem.setText("Student Information System");
		
		Label lblAge = new Label(shlStudentInformationSystem, SWT.NONE);
		lblAge.setBounds(10, 45, 71, 17);
		lblAge.setText("Age:");
		
		txtName = new Text(shlStudentInformationSystem, SWT.BORDER);
		txtName.setBounds(87, 10, 198, 25);
		
		Label lblName = new Label(shlStudentInformationSystem, SWT.NONE);
		lblName.setText("Name:");
		lblName.setBounds(10, 13, 71, 17);
		
		txtAge = new Text(shlStudentInformationSystem, SWT.BORDER);
		txtAge.setBounds(87, 41, 198, 25);
		
		Label lblCourse = new Label(shlStudentInformationSystem, SWT.NONE);
		lblCourse.setText("Course:");
		lblCourse.setBounds(10, 76, 71, 17);
		
		txtCourse = new Text(shlStudentInformationSystem, SWT.BORDER);
		txtCourse.setBounds(87, 72, 198, 25);
		
		Label lblId = new Label(shlStudentInformationSystem, SWT.NONE);
		lblId.setText("ID:");
		lblId.setBounds(10, 106, 71, 17);
		
		txtID = new Text(shlStudentInformationSystem, SWT.BORDER);
		txtID.setBounds(87, 103, 198, 25);
		
		Label lblAddress = new Label(shlStudentInformationSystem, SWT.NONE);
		lblAddress.setText("Address:");
		lblAddress.setBounds(10, 133, 71, 17);
		
		txtAddress = new Text(shlStudentInformationSystem, SWT.BORDER | SWT.MULTI);
		txtAddress.setBounds(87, 134, 198, 75);
		
		Button btnSubmit = new Button(shlStudentInformationSystem, SWT.NONE);
		btnSubmit.setBounds(53, 222, 97, 29);
		btnSubmit.setText("Submit");
		
		btnReset = new Button(shlStudentInformationSystem, SWT.NONE);
		btnReset.setBounds(156, 222, 97, 29);
		btnReset.setText("Reset");
		btnReset.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				txtName.setText("");
			}
		});

	}
}
