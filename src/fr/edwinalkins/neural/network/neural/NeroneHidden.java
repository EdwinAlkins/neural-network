package fr.edwinalkins.neural.network.neural;

public class NeroneHidden extends Nerone{
	

	public NeroneHidden(double p, double s, double e) {
		super(p, s, e);
	}

	@Override
	public void calculPotentiel(double val) {
		this.p = 0d;
		for(Link link : this.linkG) {
			this.p += link.getCurrent().getS()*link.getW();
		}
		calculSignal();
	}
	
	@Override
	public void calculErreur() {
		super.calculErreur();
		double tmpErr = 0d;
		for(Link link : this.linkD) {
			tmpErr += link.getNext().getE() * link.getW();
		}
		this.e *= tmpErr;
	}
	
	public void correction() {
		for(Link link : this.linkG) {
			link.setW(link.getW()+this.e*link.getCurrent().getS());
		}
	}
}
