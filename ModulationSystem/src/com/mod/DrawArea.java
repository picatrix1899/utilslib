package com.mod;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

import cmn.utilslib.math.Maths;

public class DrawArea extends JPanel implements MouseMotionListener, MouseListener
{
	private static final long serialVersionUID = 1L;
	
	public Dock startSelected;
	
	public Dock endSelected;
	
	private int MouseX = 0;
	private int MouseY = 0;
	
	public void addDragable(DragableElement e)
	{
		e.parent = this;

		add(e.c);
		addMouseMotionListener(this);
		addMouseListener(this);
	}

	public void mouseDragged(MouseEvent e)
	{
	}

	public void mouseMoved(MouseEvent e)
	{
		if(this.startSelected != null)
		{
			int posX = e.getXOnScreen() - getLocation().x;
			int posY = e.getYOnScreen() - getLocation().y;
			
			MouseX = Maths.clamp(posX, getLocation().x, getLocation().x + getSize().width);
			MouseY = Maths.clamp(posY, getLocation().y, getLocation().y + getSize().height);
			repaint();
		}
		
	}
	
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		if(startSelected != null)
		{
			
			g.drawLine(startSelected.getCenterLocationX(), startSelected.getCenterLocationY(), MouseX, MouseY);			
		}

	}

	public void mouseClicked(MouseEvent e)
	{
		
		if(this.startSelected != null)
		{
			if(e.getButton() == MouseEvent.BUTTON3)
			{
				this.startSelected = null;
				repaint();
			}			
		}

	}

	public void mouseEntered(MouseEvent e)
	{
	}

	public void mouseExited(MouseEvent e)
	{
	}

	public void mousePressed(MouseEvent e)
	{
	}

	public void mouseReleased(MouseEvent e)
	{
	}
}
