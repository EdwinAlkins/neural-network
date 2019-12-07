package fr.edwinalkins.neural.network.neural;

public class NeroneOutput extends Nerone {
	
	/**
	 * la valeur desiree
	 */
	private double output;
	
	
	public NeroneOutput(double p, double s, double e) {
		super(p, s, e);
	}
	
	public NeroneOutput(double p, double s, double e, double output) {
		super(p, s, e);
		this.output = output;
	}

	@Override
	public void calculPotentiel(double val) {
		this.p = 0d;
		for(Link link : this.linkG) {
			this.p += link.getCurrent().getP()*link.getW();
		}
		calculSignal();
	}
	
	public void calculErreur() {
		this.e = this.output - this.s;
	}
	
	public void correction() {
		for(Link link : this.linkG) {
			link.setW(link.getW()+this.e*link.getCurrent().getS());
		}
	}
	
	public double getOutput() {
		return output;
	}
	
	@Override
	public void setS(Double data) {
		setOutput(data);
	}

	public void setOutput(double output) {
		this.output = output;
	}
}
