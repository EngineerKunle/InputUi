package com.app.InputUI;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

public class Frame extends JFrame { 
	
	private int width = 500;
	private int height = 200;
	private JTextField jField = new JTextField(20);
	private JLabel jLable = new JLabel();
	private JButton clickMe;
	private String data;
	private Action enterAction;

	
	public Frame(String title){
		super(title);
		setSize( width, height );
	    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	    setPanel();
	    add(setPanel());
	}
	
	//initialize the text area
	private JTextField initTextArea(){

		//jField.setText("test");
		jField.setBounds(150,100,100,10);
		jField.setVisible(true);
		data = jField.getText();
		return jField;
	}
	
	
	//call to create Panel
	private JPanel setPanel(){
		JPanel jpanel = new JPanel(new GridBagLayout());
		jpanel.setBackground(Color.GRAY);
		clickMe = new JButton("Update Text");
		
		clickMe.setBackground(Color.GREEN);
		//this.getRootPane().setDefaultButton(clickMe);
		GridBagConstraints cts = new GridBagConstraints();
		cts.anchor = GridBagConstraints.WEST;
		cts.gridx = 1;
		cts.gridy = 0;
		jpanel.add(initTextArea(), cts);
		
		GridBagConstraints c = new GridBagConstraints();
		c.anchor = GridBagConstraints.EAST;
		c.gridx = 0;
		c.gridy = 0;
		jpanel.add(clickMe, c);
		
		GridBagConstraints labelPlace = new GridBagConstraints();
		labelPlace.anchor = GridBagConstraints.WEST;
		labelPlace.gridx = 1;
		labelPlace.gridy = 1;
		jpanel.add(jLable, labelPlace);
		
		//event listener
		clickMe.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				data = jField.getText();
				//System.out.println(data);
				jLable.setText(data);
			}	
		});
		
		enterAction = new AbstractAction() {
			
			public void actionPerformed(ActionEvent e) {
				data = jField.getText();
				//System.out.println(data);
				jLable.setText(data);
		    }
		};
		
		jpanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enterAction");
		jpanel.getActionMap().put("someAction", enterAction);
		
		jpanel.setVisible(true);
		return jpanel;
	}
	
}
