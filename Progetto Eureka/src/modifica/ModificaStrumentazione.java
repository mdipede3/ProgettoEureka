package modifica;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import support.DBManager;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.Action;

/**
 * The Class ModificaStrumentazione.
 */
public class ModificaStrumentazione extends JFrame {

	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The content pane. */
	private JPanel contentPane;
	
	/** The text field. */
	private JTextField textField;
	
	/** The text field 1. */
	private JTextField textField_1;
	
	/** The text field 2. */
	private JTextField textField_2;
	
	/** The text field 3. */
	private JTextField textField_3;
	
	/** The text field 4. */
	private JTextField textField_4;
	
	/** The text field 5. */
	private JTextField textField_5;
	
	/** The text field 6. */
	private JTextField textField_6;
	
	/** The action. */
	private final Action action = new SwingAction();

	/** The text field 7. */
	private JTextField textField_7;
	


	/**
	 * Create the frame.
	 */
	public ModificaStrumentazione() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = sett1();
		
		JButton btnOk = sett2(panel);
		btnOk.addActionListener(new ActionListener() {
			/**
			 * @actionPerformed
			 */
			public void actionPerformed(ActionEvent e) {
				String id = textField_7.getText();
				String query = "SELECT * FROM mystrumentazione WHERE ID_Strumento = ?";
				DBManager mysql = DBManager.getInstance();
				ResultSet rs = mysql.querySelect(query, id);
				try {
					
				      if(rs.next()){
				       
				       
				       int id1= rs.getInt("ID_Strumento");
				       String marca= rs.getString("Marca");
				       String modello= rs.getString("Modello");
				       String nome=rs.getString("Nome");
				       String tipologia=rs.getString("Tipologia");
				       int unita=rs.getInt("NrUnitaPossedute");
				       Date data= rs.getDate("AnnoAcquisto");
				       
				       textField.setText(""+id1);
				       textField_1.setText(marca);
				       textField_2.setText(modello);
				       textField_6.setText(nome);
				       textField_3.setText(tipologia);
				       textField_4.setText(""+unita);
				       textField_5.setText(""+data);
				       
				       
				      }
				      else{
				    	  JOptionPane.showMessageDialog(null, "Errore");
				      }
				      

				    
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Errore");;
				}
			}
		});
		btnOk.setBounds(321, 7, 89, 23);
		panel.add(btnOk);
		
		
		
		
		
	
	}

	private JButton sett2(JPanel panel) {
		JLabel lblTipologia = new JLabel("Tipologia");
		lblTipologia.setBounds(201, 70, 64, 14);
		panel.add(lblTipologia);
		
		JLabel lblNunit = new JLabel("NUnit\u00E0");
		lblNunit.setBounds(201, 108, 49, 20);
		panel.add(lblNunit);
		
		JLabel lblAnnoAcquisto = new JLabel("Anno acquisto");
		lblAnnoAcquisto.setBounds(201, 149, 87, 14);
		panel.add(lblAnnoAcquisto);
		
		JLabel lblRicercaPerId = new JLabel("Ricerca per ID:");
		lblRicercaPerId.setBounds(160, 11, 101, 14);
		panel.add(lblRicercaPerId);
		
		textField_7 = new JTextField();
		textField_7.setBounds(242, 8, 64, 20);
		panel.add(textField_7);
		textField_7.setColumns(10);
		
		JButton btnOk = new JButton("Ok");
		return btnOk;
	}

	private JPanel sett1() {
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBounds(0, 0, 434, 261);
		contentPane.add(panel);
		
		JLabel lblModificaStrumentazione = new JLabel("Modifica Strumentazione");
		lblModificaStrumentazione.setBounds(10, 11, 139, 14);
		panel.add(lblModificaStrumentazione);
		
		JLabel label_1 = new JLabel("ID");
		label_1.setBounds(25, 70, 18, 14);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("Nome");
		label_2.setBounds(25, 163, 36, 14);
		panel.add(label_2);
		
		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setBounds(25, 101, 64, 14);
		panel.add(lblMarca);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(92, 67, 86, 20);
		panel.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(92, 98, 86, 20);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(92, 129, 86, 20);
		panel.add(textField_2);
		
		wowo(panel);
		return panel;
	}

	private void wowo(JPanel panel) {
		JButton button = new JButton("Modifica");
		button.setAction(action);
		button.setFont(new Font("Tahoma", Font.PLAIN, 24));
		button.setBounds(146, 205, 162, 45);
		panel.add(button);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(285, 67, 86, 20);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(285, 108, 86, 20);
		panel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(285, 146, 86, 20);
		panel.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(92, 160, 86, 20);
		panel.add(textField_6);
		
		JLabel lblModello = new JLabel("Modello");
		lblModello.setBounds(25, 126, 57, 26);
		panel.add(lblModello);
	}
	
	/**
	 * The Class SwingAction.
	 *
	 * @SwingAction 
	 */
	private class SwingAction extends AbstractAction {
		
		/** The Constant serialVersionUID. */
		private static final long serialVersionUID = 1L;
		
		/**
		 * Instantiates a new swing action.
		 *
		 * @SwingAction 
		 */
		public SwingAction() {
			putValue(NAME, "Modifica");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		
		/**
		 * Action performed.
		 *
		 * @param e the e
		 * @actionPerformed 
		 */
		public void actionPerformed(ActionEvent e) {
			ArrayList<JTextField> textList = new ArrayList<>();
			textList.add(textField);
			textList.add(textField_1);
			textList.add(textField_2);
			textList.add(textField_6);
			textList.add(textField_3);
			textList.add(textField_4);
			textList.add(textField_5);
			if(hasEmpty5(textList)){
				
				JLabel lblSpazioAggiuntoCon = new JLabel("Strumentazione modificata con successo");
				lblSpazioAggiuntoCon.setBounds(48, 188, 278, 14);
				contentPane.add(lblSpazioAggiuntoCon);
				
				String query = "UPDATE mystrumentazione SET ID_Strumento= ? AND"
						+ "Marca= ? AND Modello= ? AND Nome = ? ,Tipologia = ? "
						+ "AND NrUnitaPossedute = ? AND AnnoAcquisto = ? "
						+ " WHERE ID_Strumento = ? ;";
				
				
				DBManager mysql = DBManager.getInstance();
				mysql.query(query,textField.getText(), textField_1.getText(), textField_2.getText(), 
						textField_6.getText(), textField_3.getText(), textField_4.getText(),
						textField_5.getText(), textField_7.getText());

			}
		}
	}
	
	/**
	 * Checks for empty 5.
	 *
	 * @param textField the text field
	 * @return true, if successful
	 * @hasEmpty 
	 */
	public boolean hasEmpty5( ArrayList<JTextField> textField1) {
		textField1.iterator();
		int conta = 0;
		for(JTextField sixth : textField1) {
			if(sixth.getText().compareTo("")==0) {
				conta++;
			}
		}
		boolean temp = conta == 0;
		return temp;
	}
}
