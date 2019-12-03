package fr.edwinalkins.neural.network.neural;

public class NeroneInput extends Nerone {

	public NeroneInput(double p, double s, double e) {
		super(p, s, e);
	}

	@Override
	public void calculPotentiel(double val) {
		for(Link link : this.linkD) {
			link.getNext().calculPotentiel(this.s);
		}
	}
	@Override
	public void setS(Double data) {
		setInput(data);
	}
	public void setInput(double v) {
		this.s = v;
	}
	public double getInput() {
		return this.s;
	}

	@Override
	public void calculErreur() {}

	@Override
	public void correction() {}

}
