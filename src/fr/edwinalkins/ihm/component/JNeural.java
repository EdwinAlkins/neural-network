package fr.edwinalkins.ihm.component;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.text.NumberFormat;

import javax.swing.JComponent;

import fr.edwinalkins.ihm.util.MarginDouble;
import fr.edwinalkins.neural.network.neural.Nerone;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public abstract class JNeural<T extends Nerone> extends JComponent implements MouseListener, MouseWheelListener, MouseMotionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1661182678994179145L;
	
	protected MarginDouble margin;
	private Point start;

	protected JLabel lblData;
	protected double sizeFontData;
	protected JLabel lblw;
	protected double sizeFontW;
	
	protected MigLayout mgr;

	protected NumberFormat numberFormat;

	public JNeural() {
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		this.addMouseWheelListener(this);
		mgr = new MigLayout("", "[0.0%][fill][0.0%]", "[0.0%][fill][0.0%]");
		setLayout(mgr);
		
		lblw = new JLabel("", SwingConstants.CENTER);
		add(lblw, "cell 0 1");
		lblData = new JLabel("", SwingConstants.CENTER);
		add(lblData, "cell 1 1,alignx center,aligny center");
		this.sizeFontData = 1;
		this.sizeFontW = 1;
		numberFormat = NumberFormat.getInstance();
		numberFormat.setMaximumFractionDigits(3);
		
		this.setMargin(new MarginDouble(0, 0, 0, 0));
	}
	
	public JNeural(MarginDouble md) {
		this();
		this.setMargin(md);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		int x = (int)(super.getWidth()*margin.left);
		int y = (int)(super.getHeight()*margin.up);
		int width = super.getWidth()-((int)(super.getWidth()*margin.right)+x);
		int height = super.getHeight()-((int)(super.getHeight()*margin.bottom)+y);
		
		lblData.setBounds(x,y,width,height);
		lblw.setBounds(0, super.getHeight()/2-lblw.getHeight()/2, super.getWidth()-width, lblw.getHeight());
		
		g.setColor(Color.white);
		g.fillRect(0, super.getHeight()/2-lblw.getHeight()/2, super.getWidth()-width, lblw.getHeight());
		g.setColor(Color.black);
		g.drawRect(0, super.getHeight()/2-lblw.getHeight()/2, super.getWidth()-width, lblw.getHeight());
		
		g.setColor(Color.white);
		g.fillOval(x, y, width, height);
		g.setColor(Color.black);
		g.drawOval(x, y, width, height);
		
		g.drawRect(0, 0, super.getWidth()-1, super.getHeight()-1);
		
		updateSizeText(width);
		updateUI();
	}
	
	protected abstract void updateSizeText(int width);
	
	public MarginDouble getMargin() {
		return margin;
	}

	public void setMargin(MarginDouble margin) {
		this.margin = margin;
		
		String colConst = new StringBuilder().append("[").append(this.margin.left*10).append("%][fill][").append(this.margin.right*10).append("%]").toString();
		String rowConst =  new StringBuilder().append("[").append(this.margin.up*10).append("%][fill][").append(this.margin.bottom*10).append("%]").toString();
		
		mgr.setColumnConstraints(colConst);
		mgr.setRowConstraints(rowConst);
		
		int x = (int)(super.getWidth()*margin.left);
		int y = (int)(super.getHeight()*margin.up);
		int width = super.getWidth()-((int)(super.getWidth()*margin.right)+x);
		int height = super.getHeight()-((int)(super.getHeight()*margin.bottom)+y);
		
		lblData.setBounds(x,y,width,height);
		
		this.repaint();
	}
	
	public abstract void setData(T neural);

	@Override
	public void mouseDragged(MouseEvent e) {
		super.setLocation((int)(super.getLocation().x+e.getX()-start.getX()),(int)(super.getLocation().y+e.getY()-start.getY()));
	}

	@Override
	public void mouseMoved(MouseEvent e) {
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		double sl = margin.left+(double)e.getWheelRotation()*0.01d;
		if(sl >= 1) sl = 1;
		else if(sl <= 0) sl = 0;
		double su = margin.up+(double)e.getWheelRotation()*0.005d;
		if(su >= 1) su = 1;
		else if(su <= 0) su = 0;
		setMargin(new MarginDouble(sl, margin.right, su, su));
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent me) {
		start = me.getPoint();
	}
	
	@Override
	public void mouseReleased(MouseEvent me) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		super.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		super.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}
}
