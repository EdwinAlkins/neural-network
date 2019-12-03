package fr.edwinalkins.neural.network.builder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReadDataFactory {

	private static final String COMMA_DELIMITER = ";";
	private static final String DIRECTORY = "resources";
	private String pathData;
	private String pathConfig;
	private ArrayList<ArrayList<Double>> dataInput;
	private ArrayList<ArrayList<Double>> dataOutput;
	private ArrayList<Integer> configNetwork;

	public ReadDataFactory(String data, String config) {
		this.pathData = System.getProperty("user.dir")+File.separator+DIRECTORY+File.separator+data; 
		this.pathConfig = System.getProperty("user.dir")+File.separator+DIRECTORY+File.separator+config;
		buildRecords();
		buildConfigNetwork();
	}
	
	private List<List<String>> getRecords() throws IOException{
		List<List<String>> records = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(new File(pathData)))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		        String[] values = line.split(COMMA_DELIMITER);
		        records.add(Arrays.asList(values));
		    }
		}
		return records;
	}
	
	private ArrayList<Integer> getConfig() throws IOException{
		ArrayList<Integer> conf = new ArrayList<Integer>();
		try (BufferedReader br = new BufferedReader(new FileReader(new File(pathConfig)))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		        conf.add(Integer.valueOf(line));
		    }
		}
		return conf;
	}
	
	private void buildRecords() {
		try {
			dataInput = new ArrayList<ArrayList<Double>>();
			dataOutput = new ArrayList<ArrayList<Double>>();
			List<List<String>> data = getRecords();
			List<String> tmp = data.get(0);
			final String tag_input = tmp.get(1);
			final String tag_output = tmp.get(3);
			for (int l = 1; l < data.size(); l++) {
				List<String> line = data.get(l);
				String typeData = line.get(0);
				ArrayList<Double> linedata = new ArrayList<Double>();
				for (int c = 1; c < line.size(); c++) {
					linedata.add(Double.valueOf(line.get(c)));
				}
				if(typeData.equals(tag_input)) dataInput.add(linedata);
				else if(typeData.equals(tag_output)) dataOutput.add(linedata);
				else System.err.println("tag inexistant : "+typeData);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void buildConfigNetwork() {
		try {
			this.configNetwork = getConfig();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<ArrayList<Double>> getDataInput() {
		return dataInput;
	}

	public ArrayList<ArrayList<Double>> getDataOutput() {
		return dataOutput;
	}

	public ArrayList<Integer> getConfigNetwork() {
		return configNetwork;
	}
}
