package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Information {

	private JFrame frmCompleteTheInformation;
	JPanel panel;
	public Information() {
		initialize();
	}

	private void initialize() {
		frmCompleteTheInformation = new JFrame();
		frmCompleteTheInformation.setTitle("Complete the information");
		frmCompleteTheInformation.setBounds(100, 100, 340, 190);
		frmCompleteTheInformation.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCompleteTheInformation.setVisible(true);
	}
	
	public void setPanel(JPanel panel){
		frmCompleteTheInformation.getContentPane().add(panel);
		this.panel = panel;
	}
	
	public JPanel getPanel(){
		return panel;
	}
	
	public void afisare() {
		this.frmCompleteTheInformation.setVisible(true);
	}

	public void exit() {
		this.frmCompleteTheInformation.dispose();
	}


}
