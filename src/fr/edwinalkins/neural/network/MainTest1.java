package fr.edwinalkins.neural.network;

import java.util.ArrayList;

import fr.edwinalkins.neural.network.builder.BuildNetwork;
import fr.edwinalkins.neural.network.builder.ReadDataFactory;

public class MainTest1 {

	public static void main(String[] args) {
		System.out.println(System.getProperty("user.dir"));
		ReadDataFactory b = new ReadDataFactory("data2.csv","config2.csv");
		
		BuildNetwork bn = new BuildNetwork(b.getConfigNetwork());
		Reseaux r = bn.getNetwork();
		r.setDataInput(b.getDataInput());
		r.setDataOutput(b.getDataOutput());
		
		for (int i = 0; i < 80000; i++) {
			r.learnAll();
		}
		for(ArrayList<Double> input:b.getDataInput()) {
			System.out.println("===============");
			System.out.println(input.toString());
			System.out.println(r.propagation(input));
		}
	}
}
