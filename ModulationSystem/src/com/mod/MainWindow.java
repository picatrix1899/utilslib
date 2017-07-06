package com.mod;

import java.awt.Color;

import javax.swing.JFrame;

public class MainWindow extends JFrame
{

	private static final long serialVersionUID = 1L;

	private DrawArea drawArea = new DrawArea();	
	
	private Test test = new Test(0, drawArea, 1, 4);
	private Test test2 = new Test(1, drawArea, 4, 2);
	
	public MainWindow()
	{
		setSize(200, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setVisible(true);

		this.test.setVisible(true);
		
		
		this.drawArea.setLayout(null);
		this.drawArea.setLocation(0, 0);
		this.drawArea.setSize(400,400);
		this.drawArea.setBackground(Color.CYAN);
		this.drawArea.addDragable(new DragableElement(this.test));
		this.drawArea.addDragable(new DragableElement(this.test2));
		this.drawArea.setVisible(true);
		
		add(this.drawArea);
	}
}
