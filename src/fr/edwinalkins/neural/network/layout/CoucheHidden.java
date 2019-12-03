package fr.edwinalkins.neural.network.layout;

import java.util.ArrayList;
import java.util.List;

import fr.edwinalkins.neural.network.neural.Nerone;
import fr.edwinalkins.neural.network.neural.NeroneHidden;

public class CoucheHidden extends Couche {

	public CoucheHidden(ArrayList<NeroneHidden> nerones) {
		this.nerones = nerones;
	}
	
	@SuppressWarnings("unchecked")
	public List<NeroneHidden> getNeronesHidden() {
		return (List<NeroneHidden>) this.nerones;
	}
	
	@Override
	public List<Nerone> getNerone() {
		ArrayList<Nerone> tmp = new ArrayList<Nerone>();
		for(Nerone n : nerones) tmp.add(n);
		return tmp;
	}
	
	@Override
	public void setData(int i, Double data) {
		if(i < this.nerones.size()) this.nerones.get(i).setS(data);
		else System.err.println("dépacement");
	}
	
	@Override
	public String toString() {
		StringBuffer buff = new StringBuffer();
		buff.append("-------Hidden---------\n");
		for(Nerone n : nerones) buff.append("[p:"+n.getP()).append(",s:"+n.getS()).append(",e:"+n.getE()+"]\n");
		return buff.toString();
	}
}
