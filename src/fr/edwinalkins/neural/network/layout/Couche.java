package fr.edwinalkins.neural.network.layout;

import java.util.List;
import java.util.Random;

import fr.edwinalkins.neural.network.neural.Link;
import fr.edwinalkins.neural.network.neural.Nerone;

public abstract class Couche {

	protected List<? extends Nerone> nerones;
	
	public void propagation() {
		for(Nerone n : this.nerones) {
			n.calculPotentiel(n.getS());
		}
	}
	
	public void calculErr() {
		for(Nerone n : this.nerones) {
			n.calculErreur();
		}
	}
	
	public void backPropagation() {
		for(Nerone n : this.nerones) {
			n.correction();
		}
	}

	public void setData(List<Double> data) {
		for (int i = 0; i < data.size(); i++) {
			setData(i, data.get(i));
		}
	}
	
	public void setData(int i, Double data) {
		if(i < this.nerones.size()) this.nerones.get(i).setS(data);
		else System.err.println("dépacement");
	}
	
	public void join(Couche c) {
		Random rand = new Random();
		for (int i = 0; i < nerones.size(); i++) {
			for (int j = 0; j < c.getNerone().size(); j++) {
				double w = 0d + (rand.nextDouble() * (1d - 0d));
				Link link = new Link(nerones.get(i), c.getNerone().get(j), w);
				nerones.get(i).getLinkD().add(link);
				c.getNerone().get(j).getLinkG().add(link);
			}
		}
	}
	
	public List<? extends Nerone> getNerone(){
		return this.nerones;
	}
}
