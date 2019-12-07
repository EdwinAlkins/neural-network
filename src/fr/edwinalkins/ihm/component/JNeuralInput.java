package fr.edwinalkins.ihm.component;

import java.awt.Graphics;
import java.text.NumberFormat;
import java.util.Objects;

import fr.edwinalkins.ihm.util.MarginDouble;
import fr.edwinalkins.neural.network.neural.NeroneInput;

public class JNeuralInput extends JNeural<NeroneInput>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1661182678994179145L;
	
	private NeroneInput neural;

	public JNeuralInput() {
		super(new MarginDouble(0, 0, 0, 0));
		setData(new NeroneInput(0, 0, 0));
	}
	
	public JNeuralInput(NeroneInput ni) {
		this();
		setData(ni);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
	}
	
	protected void updateSizeText(int width) {
		int w = (int) lblData.getFontMetrics(lblData.getFont()).stringWidth(numberFormat.format(neural.getS()));
		if(w > width) this.sizeFontData = (double)width/(double)w;
		else this.sizeFontData = 1;
		this.sizeFontW = 0;
	}
	
	public void setData(NeroneInput neural) {
		this.neural = neural;
		this.updateUI();
	}
	
	@Override
	public void updateUI() {
		super.updateUI();
		if(Objects.nonNull(neural)) {
			NumberFormat nf = NumberFormat.getInstance();
	        nf.setMaximumFractionDigits(3);
	        String strS = new StringBuffer().append("<html><p style='font-size:").append((int)(this.sizeFontData*100)).append("%;'>").append(numberFormat.format(neural.getS())).append("</p></html>").toString();
			lblData.setText(strS);
		}
	}

}
