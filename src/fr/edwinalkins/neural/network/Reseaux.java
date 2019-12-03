package fr.edwinalkins.neural.network;

import java.util.ArrayList;
import java.util.List;

import fr.edwinalkins.neural.network.layout.Couche;
import fr.edwinalkins.neural.network.layout.CoucheHidden;
import fr.edwinalkins.neural.network.layout.CoucheInput;
import fr.edwinalkins.neural.network.layout.CoucheOutput;
import fr.edwinalkins.neural.network.neural.Nerone;
import fr.edwinalkins.neural.network.neural.NeroneInput;
import fr.edwinalkins.neural.network.neural.NeroneOutput;

public class Reseaux {

	private CoucheInput inputs;
	private ArrayList<Couche> hiddens;
	private CoucheOutput outputs;
	private ArrayList<ArrayList<Double>> dataInput;
	private ArrayList<ArrayList<Double>> dataOutput;
	
	public Reseaux() {
		this.hiddens = new ArrayList<Couche>();
		this.dataInput = new ArrayList<ArrayList<Double>>();
		this.dataOutput = new ArrayList<ArrayList<Double>>();
	}
	
	public double learnAll() {
		for (int i = 0; i < dataInput.size(); i++) {
			for (int j = 0; j < dataInput.get(i).size(); j++) {
				inputs.setData(j,dataInput.get(i).get(j));
			}
			for (int j = 0; j < dataOutput.get(i).size(); j++) {
				outputs.setData(j,dataOutput.get(i).get(j));
			}
			learn();
		}
		return learn();
	}
	
	public double learn() {
		propagation();
		err();
		backpropagation();
		outputs.calculErreurLearning();
		return outputs.getErreurLearning();
	}
	
	public List<Double> propagation(List<Double> input) {
		for (int j = 0; j < input.size(); j++) {
			inputs.setData(j,input.get(j));
		}
		inputs.propagation();
		for(Couche hidden : this.hiddens) {
			hidden.propagation();
		}
		outputs.propagation();
		return this.getDataOutput();
	}
	
	public void propagation() {
		inputs.propagation();
		for(Couche hidden : this.hiddens) {
			hidden.propagation();
		}
		outputs.propagation();
	}
	
	public void err() {
		outputs.calculErr();
		for (int i = hiddens.size()-1; i >= 0; i--) {
			hiddens.get(i).calculErr();
		}
	}
	
	public double getError() {
		double err = 0d;
		for(Nerone out:outputs.getNerone()) err += out.getE();
		return err/outputs.getNerone().size();
	}
	
	public void backpropagation() {
		outputs.backPropagation();
		for (int i = hiddens.size()-1; i >= 0; i--) {
			hiddens.get(i).backPropagation();
		}
		inputs.backPropagation();
	}
	
	public List<Double> getDataOutput(){
		List<Double> dataOutputs = new ArrayList<Double>();
		for(NeroneOutput output: this.outputs.getNeronesOutput()) dataOutputs.add(output.getS());
		return dataOutputs;
	}
	
	public List<Double> getDataInput(){
		List<Double> dataIntput = new ArrayList<Double>();
		for(NeroneInput input: this.inputs.getNeronesInput()) dataIntput.add(input.getInput());
		return dataIntput;
	}
	
	public void setCoucheInput(CoucheInput c) {
		this.inputs = c;
	}
	
	public void setCoucheHidden(CoucheHidden c) {
		this.hiddens.add(c);
	}
	
	public void setCoucheHidden(ArrayList<CoucheHidden> c) {
		for(Couche current: c) this.hiddens.add(current);
	}
	
	public void setCoucheOuput(CoucheOutput c) {
		this.outputs = c;
	}
	
	public void join() {
		this.inputs.join(this.hiddens.get(0));
		if(this.hiddens.size() > 1) {
			for (int i = 1; i < this.hiddens.size(); i++) {
				this.hiddens.get(i-1).join(this.hiddens.get(i));
			}
		}
		this.hiddens.get(this.hiddens.size()-1).join(outputs);
	}
	
	public void setDataInput(ArrayList<ArrayList<Double>> dataInput) {
		this.dataInput = dataInput;
	}

	public void setDataOutput(ArrayList<ArrayList<Double>> dataOutput) {
		this.dataOutput = dataOutput;
	}

	@Override
	public String toString() {
		StringBuffer buff = new StringBuffer();
		buff.append(this.inputs);
		for(Couche hidden: this.hiddens) buff.append(hidden);
		buff.append(this.outputs);
		return buff.toString();
	}
}
