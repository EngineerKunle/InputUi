package com.app.InputUI;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Frame extends JFrame{
	
	private int width = 500;
	private int height = 200;
	private JTextField jField;
	private JButton clickMe;
	
	public Frame(String title){
		super(title);
		setSize( width, height );
	    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	    setPanel();
	    add(setPanel());
	}
	//initialize the text area
	private JTextField initTextArea(){
		
		jField = new JTextField(20);
		jField.setText("test");
		jField.setBounds(150,100,100,10);
		jField.setVisible(true);
		return jField;
	}
	
	//click event for us 
	ActionListener clickEvent = new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("we have been clicked");
		}	
	};
	
	//call to create Panel
	private JPanel setPanel(){
		
		JPanel jpanel = new JPanel(new GridBagLayout());
		clickMe = new JButton("Update Text");
		clickMe.addActionListener(clickEvent);
		GridBagConstraints cts = new GridBagConstraints();
		cts.anchor = GridBagConstraints.WEST;
		cts.gridx = 1000;
		cts.gridy = 0;
		jpanel.setBackground(Color.GRAY);
		jpanel.add(clickMe);
		jpanel.add(initTextArea(), cts);
		jpanel.setVisible(true);
		return jpanel;
	}
	
}
