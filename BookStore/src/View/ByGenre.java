package View;

import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class ByGenre extends JPanel {

	public ByGenre() {
		setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Title", "Author", "Genre"}));
		comboBox.setBounds(80, 43, 139, 27);
		add(comboBox);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(90, 106, 117, 29);
		add(btnSearch);
	}
}
