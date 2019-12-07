package fr.edwinalkins.ihm.component;

import java.awt.Graphics;
import java.util.Objects;

import fr.edwinalkins.ihm.util.MarginDouble;
import fr.edwinalkins.neural.network.neural.NeroneHidden;

public class JNeuralHidden extends JNeural<NeroneHidden>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1661182678994179145L;
	
	private NeroneHidden neural;

	public JNeuralHidden() {
		super(new MarginDouble(0.3, 0, 0.15, 0.15));
		setData(new NeroneHidden(0, 0, 0));
	}
	
	public JNeuralHidden(NeroneHidden nh) {
		this();
		setData(nh);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
	}
	
	protected void updateSizeText(int width) {
		int w = (int) lblData.getFontMetrics(lblData.getFont()).stringWidth(numberFormat.format(neural.getS()));
		int we = (int) lblw.getFontMetrics(lblw.getFont()).stringWidth(numberFormat.format(neural.getE()));
		if(w > width) this.sizeFontData = (double)width/(double)w;
		else this.sizeFontData = 1;
		if(we > super.getWidth()-width) this.sizeFontW = (double)(super.getWidth()-width)/(double)we;
		else this.sizeFontW = 1;
	}
	
	public void setData(NeroneHidden neural) {
		this.neural = neural;
		this.updateUI();
	}
	
	@Override
	public void updateUI() {
		super.updateUI();
		if(Objects.nonNull(neural)) {
			String strS = new StringBuffer().append("<html><p style='font-size:").append((int)(this.sizeFontData*100)).append("%;'>").append(numberFormat.format(neural.getS())).append("</p></html>").toString();
			lblData.setText(strS);
			String strW = new StringBuffer().append("<html><p style='font-size:").append((int)(this.sizeFontW*100)).append("%;'>").append(numberFormat.format(neural.getE())).append("</p></html>").toString();
			lblw.setText(strW);
		}
	}

}
