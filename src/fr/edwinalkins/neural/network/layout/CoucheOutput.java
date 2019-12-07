package fr.edwinalkins.neural.network.layout;

import java.util.ArrayList;
import java.util.List;

import fr.edwinalkins.neural.network.neural.Nerone;
import fr.edwinalkins.neural.network.neural.NeroneOutput;

public class CoucheOutput extends Couche{

	private double err;
	
	public CoucheOutput(ArrayList<NeroneOutput> nerones) {
		this.nerones = nerones;
		this.err = 0;
	}
	
	public void calculErreurLearning() {
		this.err = 0.5;
		double tmpErr = 0;
		for(NeroneOutput nerone : this.getNeronesOutput()) {
			tmpErr += Math.pow(nerone.getE(),2);
		}
		this.err *= tmpErr;
	}
	
	public double getErreurLearning() {
		return this.err;
	}

	@SuppressWarnings("unchecked")
	public List<NeroneOutput> getNeronesOutput() {
		return (List<NeroneOutput>) this.nerones;
	}
	
	public void setData(int i, Double data) {
		if(i < this.nerones.size()) this.getNeronesOutput().get(i).setOutput(data);
		else System.err.println("dépacement");
	}
	
	@Override
	public String toString() {
		StringBuffer buff = new StringBuffer();
		buff.append("-------Output---------\n");
		for(Nerone n : nerones) {
			buff.append("[p:"+n.getP()).append(",s:"+n.getS())
			.append(",e:"+n.getE()).append(",o:"+((NeroneOutput)n).getOutput())
			.append(",d:"+((NeroneOutput)n).getE()+"]\n");
		}
		return buff.toString();
	}
}
