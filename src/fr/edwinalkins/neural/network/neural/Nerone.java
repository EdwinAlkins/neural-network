package fr.edwinalkins.neural.network.neural;
/**
 * @author william
 *
 */

import java.util.ArrayList;

public abstract class Nerone {

	protected ArrayList<Link> linkD;

	protected ArrayList<Link> linkG;
	
	/**
	 * le potentiel du nerone
	 */
	protected double p;
	/**
	 * le signal du nerone
	 * la valeur d'entrer pour les nerones inpute
	 */
	protected double s;
	/**
	 * l'erreur du nerone
	 */
	protected double e;
	
	public Nerone(double p, double s, double e) {
		this.p = p;
		this.s = s;
		this.e = e;
		this.linkD = new ArrayList<Link>();
		this.linkG = new ArrayList<Link>();
	}
	
	public abstract void calculPotentiel(double val);
	
	protected void calculSignal() {
		this.s = this.signal(this.p);
	}
	
	public void calculErreur() {
		this.e = this.s * (1 - this.s);
	}
	
	public abstract void correction();
	
	protected double signal(double v) {
		return 1d/(1d+Math.exp(-v));
	}
	
	public ArrayList<Link> getLinkD() {
		return linkD;
	}

	public ArrayList<Link> getLinkG() {
		return linkG;
	}

	public double getP() {
		return p;
	}

	public double getS() {
		return s;
	}

	public double getE() {
		return e;
	}

	public void setS(Double data) {
		this.s = data;
	}
	
}
