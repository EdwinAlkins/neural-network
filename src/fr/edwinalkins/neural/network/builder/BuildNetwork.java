package fr.edwinalkins.neural.network.builder;

import java.util.ArrayList;

import fr.edwinalkins.neural.network.Reseaux;
import fr.edwinalkins.neural.network.layout.CoucheHidden;
import fr.edwinalkins.neural.network.layout.CoucheInput;
import fr.edwinalkins.neural.network.layout.CoucheOutput;
import fr.edwinalkins.neural.network.neural.NeroneHidden;
import fr.edwinalkins.neural.network.neural.NeroneInput;
import fr.edwinalkins.neural.network.neural.NeroneOutput;

public class BuildNetwork {
	
	private Reseaux network;

	public BuildNetwork(ArrayList<Integer> conf) {
		this.network = new Reseaux();
		build(conf);
	}

	private void build(ArrayList<Integer> conf) {
		ArrayList<NeroneInput> inputs = new ArrayList<NeroneInput>();
		ArrayList<ArrayList<NeroneHidden>> hiddens = new ArrayList<ArrayList<NeroneHidden>>();
		ArrayList<NeroneOutput> outputs = new ArrayList<NeroneOutput>();
		int len = conf.get(0);
		for (int i = 0; i < len; i++) {
			inputs.add(new NeroneInput(0,0.0,0));
		}
		for (int iNeural = 1; iNeural < conf.size()-1; iNeural++) {
			ArrayList<NeroneHidden> hidden = new ArrayList<NeroneHidden>();
			for (int j = 0; j < conf.get(iNeural); j++) {
				hidden.add(new NeroneHidden(0,0,0));
			}
			hiddens.add(hidden);
		}
		len = conf.get(conf.size()-1);
		for (int i = 0; i < len; i++) {
			outputs.add(new NeroneOutput(0,0.0,0));
		}
		
		this.network.setCoucheInput(new CoucheInput(inputs));
		for(ArrayList<NeroneHidden> hidden:hiddens) this.network.setCoucheHidden(new CoucheHidden(hidden));
		this.network.setCoucheOuput(new CoucheOutput(outputs));
		this.network.join();
	}

	public Reseaux getNetwork() {
		return network;
	}
}
