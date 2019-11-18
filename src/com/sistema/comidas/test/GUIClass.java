package com.sistema.comidas.test;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 * 
 * @author Kravtsov Ivan Alexandrovich
 * @version 1.0
 * @
 */
public class GUIClass extends JFrame {
	
	static private JButton btnOpen = new JButton("Open");
	static private JButton btnConvert = new JButton("Convert");
	
	public GUIClass(){
		super("Bin reader V1.0");
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setResizable(false);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
	    
	    JPanel container = new JPanel ();//контейнер дл€ панели управлени€
	    container.setLayout(new GridBagLayout());
	    container.setBackground(new Color(48,185,192));
	    add(container, BorderLayout.SOUTH);
	    
	    /**
	     * Ќастройка разметки по умолчанию
	     * ѕо умолчанию натуральна€ высота и максимальна€ ширина
	     */
	    GridBagConstraints constraints = new GridBagConstraints();
	    constraints.fill = GridBagConstraints.HORIZONTAL;
	    constraints.weightx = 0.5;
	    constraints.gridy = 0; //нулев€ €чейка таблицы по вертикали
	    
	    constraints.gridx = 0;
	    constraints.gridy = 0;
	    container.add(btnOpen, constraints);
	    btnOpen.addActionListener(new ButtonEventListener());
	    
	    constraints.gridx = 0;
	    constraints.gridy = 1;
	    container.add(btnConvert, constraints);
	    btnConvert.addActionListener(new ButtonEventListener());
	}
	
	  class ButtonEventListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			switch(event.getActionCommand()){
			  case "Open":
				  try {
					ImgBin.OpenFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
				  break;
			  case "Convert":
				  try {
					  ImgBin.ConvertFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
				  break;
			  }
			
		}
	  }
}