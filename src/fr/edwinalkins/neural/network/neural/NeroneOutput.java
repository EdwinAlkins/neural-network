package fr.edwinalkins.neural.network.neural;

public class NeroneOutput extends Nerone {
	
	/**
	 * la valeur desiree
	 */
	private double output;
	/**
	 * la difference entrer desiree et actuelle
	 */
	protected double d;
	
	
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
			this.p += link.getCurrent().getS()*link.getW();
			//this.p += val*link.getW();
		}
		calculSignal();
	}
	
	public void calculErreur() {
		//this.e = this.d * (1 - this.d);	
		//this.e = (this.s - this.output)/((Math.abs(this.output) + Math.abs(this.s))/2d	);
		//this.d = this.output - this.s;
		//this.e = this.d * (1 - this.d);
		
		
		this.d = this.output - this.s;
		this.e = (this.output - this.s)*(1-this.s);
		//this.e = 0.5*Math.pow(this.output - this.s, 2);
	}
	
	public void correction() {
		for(Link link : this.linkG) {
			link.setW(link.getW()+this.e*link.getCurrent().s);
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
	
	public double getdistance() {
		return this.d;
	}
}
