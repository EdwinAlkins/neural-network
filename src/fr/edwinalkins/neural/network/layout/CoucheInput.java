package fr.edwinalkins.neural.network.layout;

import java.util.ArrayList;
import java.util.List;

import fr.edwinalkins.neural.network.neural.Nerone;
import fr.edwinalkins.neural.network.neural.NeroneInput;

public class CoucheInput extends Couche{

	public CoucheInput(ArrayList<NeroneInput> nerones) {
		this.nerones = nerones;
	}

	@SuppressWarnings("unchecked")
	public List<NeroneInput> getNeronesInput() {
		return (List<NeroneInput>) this.nerones;
	}
	
	
	@Override
	public String toString() {
		StringBuffer buff = new StringBuffer();
		buff.append("-------Input---------\n");
		for(Nerone n : nerones) buff.append("[p:"+n.getP()).append(",i:"+n.getS()).append(",e:"+n.getE()+"]\n");
		return buff.toString();
	}
}
