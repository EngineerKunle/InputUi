package com.app.InputUI;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Frame extends JFrame{
	
	private int width = 300;
	private int height = 200;
	private JTextField jField;
	
	public Frame(String title){
		super(title);
		setSize( width, height );
	    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	    setPanel();
	    add(setPanel());
	    setVisible(true);
	}
	//initialize the text area
	private JTextField initTextArea(){
		System.out.println("Jtextfield called and init");
		jField = new JTextField(20);
		jField.setText("test");
		//jField.setBounds(150,100,100,10);
		jField.setVisible(true);
		return jField;
	}
	
	//call to create Panel
	private JPanel setPanel(){
		System.out.println("setpanel called and init");
		JPanel jpanel = new JPanel(new GridBagLayout());
		GridBagConstraints cts = new GridBagConstraints();
		cts.anchor = GridBagConstraints.WEST;
		cts.gridx = 0;
		cts.gridy = 0;
		jpanel.setBackground(Color.blue);
		jpanel.add(initTextArea(), cts);
		jpanel.setVisible(true);
		return jpanel;
	}
	
}
