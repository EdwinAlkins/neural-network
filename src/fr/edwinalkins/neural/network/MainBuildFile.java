package fr.edwinalkins.neural.network;

public class MainBuildFile {

	public static void main(String[] args) {
		StringBuffer buffin = new StringBuffer();
		StringBuffer buffout = new StringBuffer();
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				double id = ((double)i);
				double jd = ((double)j);
				buffin.append("i;").append(id*0.1).append(";").append(jd*0.1).append('\n');
				buffout.append("o;").append((id*jd)*0.01).append('\n');
			}
		}
		System.out.print("tag_input;i;tag_output;o\n");
		System.out.print(buffin.toString());
		System.out.print(buffout.toString());
	}
}
