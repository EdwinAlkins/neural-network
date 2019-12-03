package fr.edwinalkins.neural.network.neural;

public class Link {

	private Nerone current;
	private Nerone next;
	private double w;
	
	public Link(Nerone c, Nerone n, double w) {
		this.current = c;
		this.next = n;
		this.w = w;
	}

	public double getW() {
		return w;
	}

	public void setW(double w) {
		this.w = w;
	}

	public Nerone getCurrent() {
		return current;
	}

	public Nerone getNext() {
		return next;
	}
}
