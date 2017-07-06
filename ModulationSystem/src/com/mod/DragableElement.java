package com.mod;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import cmn.utilslib.math.Maths;

public class DragableElement implements MouseListener, MouseMotionListener
{
	public int MouseOffsetX = 0;
	public int MouseOffsetY = 0;
	
	public Component c;
	
	public DrawArea parent;
	
	public DragableElement(Component c)
	{
		this.c = c;
		this.c.addMouseListener(this);
		this.c.addMouseMotionListener(this);
	}
	
	public void mouseDragged(MouseEvent e)
	{
		int posX = e.getXOnScreen() - this.parent.getLocation().x - this.MouseOffsetX;
		int posY = e.getYOnScreen() - this.parent.getLocation().y - this.MouseOffsetY;
		
		posX = Maths.clamp(posX, this.parent.getLocation().x, this.parent.getLocation().x + this.parent.getSize().width - this.c.getSize().width);
		posY = Maths.clamp(posY, this.parent.getLocation().y, this.parent.getLocation().y + this.parent.getSize().height- this.c.getSize().height);
		this.c.setLocation(posX, posY);
	}

	public void mouseMoved(MouseEvent e)
	{
	}

	public void mouseClicked(MouseEvent e)
	{
	}

	public void mouseEntered(MouseEvent e)
	{
	}

	public void mouseExited(MouseEvent e)
	{
	}

	public void mousePressed(MouseEvent e)
	{
		this.MouseOffsetX = e.getXOnScreen() - this.parent.getLocation().x - this.c.getLocation().x;
		this.MouseOffsetY = e.getYOnScreen() - this.parent.getLocation().y - this.c.getLocation().y;
	}

	public void mouseReleased(MouseEvent e)
	{
	}
}
