import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JFrame;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;

///fichasP = fichas pago, esta ventana se encarga de hacer el pago por las fichas//////

public class fichasP extends JFrame {

private static final long serialVersionUID = 1L;
private JPanel contentPane;


private fichasM fm;
public void setFichasM(fichasM fm) {
	this.fm = fm;
}
private void regresarBtn(java.awt.event.ActionEvent avt) {
	fm.setVisible(true);
	this.setVisible(false);
}
private void continuarBtn(java.awt.event.ActionEvent avt) {
	pagoT pt = new pagoT();
	pt.setFichasP(this);
	pt.setVisible(true);
	this.setVisible(false);
}
/**
* Launch the application.
*/
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				fichasP frame = new fichasP();
				frame.setVisible(true);
				} catch (Exception e) {
				e.printStackTrace();
				}
			}
		});
	}

/**
* Create the frame.
*/
	public fichasP() {
		
	main.pagado=false;
	
	setResizable(false);
	setTitle("Casino KaS");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(500, 100, 500, 400);
	contentPane = new JPanel();
	contentPane.setBackground(new Color(0, 128, 64));
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	JLabel lblNewLabel1 = new JLabel("Fichas totales: "+fichasM.cantidadF);
	lblNewLabel1.setBounds(121, 56, 231, 50);
	lblNewLabel1.setForeground(new Color(255, 255, 255));
	lblNewLabel1.setFont(new Font("Calisto MT", Font.BOLD, 20));
	lblNewLabel1.setHorizontalAlignment(SwingConstants.CENTER);
	contentPane.add(lblNewLabel1);
	JButton btnNewButton = new JButton("Regresar");
	btnNewButton.setBounds(10, 327, 89, 23);
	btnNewButton.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		regresarBtn(e);
		}
	});
	btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
	contentPane.add(btnNewButton);
	
	JLabel lblNewLabel = new JLabel("Metodo de pago\r\n");
	lblNewLabel.setFont(new Font("Calisto MT", Font.BOLD, 20));
	lblNewLabel.setBounds(158, 117, 155, 34);
	contentPane.add(lblNewLabel);
	
	JComboBox comboBox = new JComboBox();
	comboBox.setBackground(new Color(0, 91, 46));
	comboBox.setFont(new Font("Calisto MT", Font.PLAIN, 15));
	comboBox.setModel(new DefaultComboBoxModel(new String[] {"Tarjeta","Paypal"}));
	
	comboBox.setBounds(158, 146, 149, 22);
	comboBox.setForeground(Color.white);
	contentPane.add(comboBox);
	JButton btnContinuar = new JButton("Continuar");
	btnContinuar.setEnabled(false);
	btnContinuar.setBounds(385, 327, 89, 23);
	btnContinuar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(comboBox.getSelectedIndex()==0) {
				continuarBtn(e);
			} else {
				setState(JFrame.ICONIFIED);
				//LoginPage loginPage = new LoginPage();
				//loginPage.setVisible(true);
			}
		}
	});
	btnContinuar.setFont(new Font("Tahoma", Font.PLAIN, 13));
	contentPane.add(btnContinuar);
	
	JCheckBox chckbxNewCheckBox = new JCheckBox("Acepto terninos y condiciones");
	
	chckbxNewCheckBox.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(chckbxNewCheckBox.isSelected()==true) {
				btnContinuar.setEnabled(true);
			
			}
		}
	});
	chckbxNewCheckBox.setBackground(new Color(0, 128, 64));
	chckbxNewCheckBox.setBounds(134, 175, 213, 23);
	chckbxNewCheckBox.setForeground(Color.white);
	contentPane.add(chckbxNewCheckBox);
}
}