package fr.edwinalkins.ihm.test;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import fr.edwinalkins.ihm.component.JNeural;
import fr.edwinalkins.ihm.component.JNeuralHidden;
import fr.edwinalkins.ihm.component.JNeuralInput;
import fr.edwinalkins.neural.network.neural.NeroneHidden;
import fr.edwinalkins.neural.network.neural.NeroneInput;

public class FirstTestFrame {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e1) {
			e1.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FirstTestFrame window = new FirstTestFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FirstTestFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JNeural<NeroneInput> neuralInput0 = new JNeuralInput(new NeroneInput(0d, 0.321d, 0.456d));
		neuralInput0.setBounds(135, 94, 50, 50);
		frame.getContentPane().add(neuralInput0);
		
		JNeural<NeroneHidden> neuralHidden0 = new JNeuralHidden(new NeroneHidden(0d, 0.123d, 0.654d));
		neuralHidden0.setBounds(10, 94, 100, 100);
		frame.getContentPane().add(neuralHidden0);
	}
}
