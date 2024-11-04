//PagoT = pago tarjeta

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.ButtonGroup;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class pagoT extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tarjetaTF;
	private JTextField cvvTF;
	
	

private fichasP fp;
private main m;
private pagoT pt;
public void setPagoT(pagoT pt) {
	this.pt = pt;
}
public void setmain(main m) {
	this.m = m;
}
public void setFichasP(fichasP fp) {
	this.fp = fp;
}
private void regresarBtn(java.awt.event.ActionEvent avt) {
	fp.setVisible(true);
	this.setVisible(false);
}
private void continuarBtn(java.awt.event.ActionEvent avt) {
	main m = new main();
	m.main(null);
	this.setVisible(false);
}
	
	/**
	* Launch the application.
	*/
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
				pagoT frame = new pagoT();
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

@SuppressWarnings({ "removal", "deprecation"})
public pagoT() {
	
	
	super();

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
	
	JButton btnNewButton = new JButton("Regresar");
	btnNewButton.setBounds(10, 327, 89, 23);
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			regresarBtn(e);
		}
	});
	btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
	contentPane.add(btnNewButton);
	
	JLabel lblPagoConTarjeta = new JLabel("Pago con tarjeta");
	lblPagoConTarjeta.setHorizontalAlignment(SwingConstants.LEFT);
	lblPagoConTarjeta.setForeground(Color.WHITE);
	lblPagoConTarjeta.setFont(new Font("Calisto MT", Font.BOLD, 25));
	lblPagoConTarjeta.setBounds(91, 26, 300, 30);
	contentPane.add(lblPagoConTarjeta);
	
	JLabel lblNumDeTarjeta = new JLabel("Num. de tarjeta:");
	lblNumDeTarjeta.setHorizontalAlignment(SwingConstants.LEFT);
	lblNumDeTarjeta.setForeground(Color.WHITE);
	lblNumDeTarjeta.setFont(new Font("Calisto MT", Font.BOLD, 18));
	lblNumDeTarjeta.setBounds(10, 120, 145, 30);
	contentPane.add(lblNumDeTarjeta);
	
	JLabel lblTarjeta = new JLabel("Tarjeta");
	lblTarjeta.setHorizontalAlignment(SwingConstants.LEFT);
	lblTarjeta.setForeground(Color.WHITE);
	lblTarjeta.setFont(new Font("Calisto MT", Font.BOLD, 18));
	lblTarjeta.setBounds(10, 79, 145, 30);
	contentPane.add(lblTarjeta);
	
	JRadioButton rdbtnMasterCard = new JRadioButton("Mastercard");
	rdbtnMasterCard.setFont(new Font("Tahoma", Font.PLAIN, 13));
	rdbtnMasterCard.setForeground(new Color(255, 255, 255));
	rdbtnMasterCard.setBackground(new Color(0, 128, 64));
	rdbtnMasterCard.setBounds(143, 82, 109, 23);
	contentPane.add(rdbtnMasterCard);
	
	JRadioButton rdbtnVisa = new JRadioButton("Visa");
	rdbtnVisa.setFont(new Font("Tahoma", Font.PLAIN, 13));
	rdbtnVisa.setForeground(new Color(255, 255, 255));
	rdbtnVisa.setBackground(new Color(0, 128, 64));
	rdbtnVisa.setBounds(268, 82, 109, 23);
	contentPane.add(rdbtnVisa);
	
	ButtonGroup g = new ButtonGroup();
	g.add(rdbtnVisa);
	g.add(rdbtnMasterCard);
	
	tarjetaTF = new JTextField();
	tarjetaTF.setHorizontalAlignment(SwingConstants.LEFT);
	tarjetaTF.addKeyListener(new KeyAdapter() {
		public void keyTyped(KeyEvent e) {
			int caracter = e.getKeyChar();
			
			// Verificar si la tecla pulsada no es un digito
			if((caracter < '0') ||(caracter > '9') && (caracter !='\b')) {
				e.consume(); // ignorar el evento de teclado
			}
			if(tarjetaTF.getText().length()>15) {
				e.consume();
			}
		}
	});
	
	tarjetaTF.setText("Num Tarjeta (16 digts)");
	tarjetaTF.setForeground(Color.GRAY);
	tarjetaTF.addFocusListener(new FocusListener() {
		@Override
		public void focusGained(FocusEvent e) {
			if (tarjetaTF.getText().equals("Num Tarjeta (16 digts)")) {
				tarjetaTF.setText("");
				tarjetaTF.setForeground(Color.BLACK);
				tarjetaTF.setHorizontalAlignment(SwingConstants.LEFT);
			}
		}
		@Override
		public void focusLost(FocusEvent e) {
			if (tarjetaTF.getText().isEmpty()) {
				tarjetaTF.setForeground(Color.GRAY);
				tarjetaTF.setText("Num Tarjeta (16 digts)");
				tarjetaTF.setHorizontalAlignment(SwingConstants.LEFT);
			}
		}
	});
	
	tarjetaTF.setForeground(new Color(180, 180, 180));
	tarjetaTF.setText("Num Tarjeta (16 digts)");
	tarjetaTF.setFont(new Font("Tahoma", Font.PLAIN, 16));
	tarjetaTF.setBounds(153, 124, 183, 26);
	contentPane.add(tarjetaTF);
	tarjetaTF.setColumns(10);
	
	JLabel lblCvv = new JLabel("CVV");
	lblCvv.setHorizontalAlignment(SwingConstants.LEFT);
	lblCvv.setForeground(Color.WHITE);
	lblCvv.setFont(new Font("Calisto MT", Font.BOLD, 18));
	lblCvv.setBounds(10, 161, 50, 30);
	contentPane.add(lblCvv);
	
	JLabel lblFechaDeCaduciad = new JLabel("Fecha de caducidad");
	lblFechaDeCaduciad.setHorizontalAlignment(SwingConstants.LEFT);
	lblFechaDeCaduciad.setForeground(Color.WHITE);
	lblFechaDeCaduciad.setFont(new Font("Calisto MT", Font.BOLD, 18));
	lblFechaDeCaduciad.setBounds(10, 202, 173, 30);
	contentPane.add(lblFechaDeCaduciad);
	
	cvvTF = new JTextField();
	cvvTF.setHorizontalAlignment(SwingConstants.LEFT);
	cvvTF.setForeground(Color.GRAY);
	cvvTF.setFont(new Font("Tahoma", Font.PLAIN, 16));
	cvvTF.setColumns(10);
	cvvTF.setBounds(153, 161, 76, 26);
	contentPane.add(cvvTF);
	cvvTF.addKeyListener(new KeyAdapter() {
		public void keyTyped(KeyEvent e) {
			int caracter = e.getKeyChar();
			// Verificar si la tecla pulsada no es un digito
			if((caracter < '0') ||(caracter > '9') &&(caracter != '\b')) {
				e.consume(); // ignorar el evento de teclado
			}
			if(cvvTF.getText().length()>2) {
				e.consume();
			}
		}
	});
	
	cvvTF.setText("Ej. 123");
	cvvTF.setForeground(Color.GRAY);
	cvvTF.addFocusListener(new FocusListener() {
		@Override
		public void focusGained(FocusEvent e) {
			if (cvvTF.getText().equals("Ej. 123")) {
				cvvTF.setText("");
				cvvTF.setForeground(Color.BLACK);
				tarjetaTF.setHorizontalAlignment(SwingConstants.LEFT);
			}
		}
		@Override
		public void focusLost(FocusEvent e) {
			if (cvvTF.getText().isEmpty()) {
				cvvTF.setForeground(Color.GRAY);
				cvvTF.setText("Ej. 123");
				tarjetaTF.setHorizontalAlignment(SwingConstants.LEFT);
			}
		}
	});
	
	JButton btnContinuar = new JButton("Continuar");
	btnContinuar.setEnabled(false);
	btnContinuar.setBounds(385, 327, 89, 23);
	btnContinuar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			setState(JFrame.ICONIFIED);
			if(tarjetaTF.getText().equals("")||tarjetaTF.getText().equals("Num Tarjeta (16 digts)") ||tarjetaTF.getText().length()<16||cvvTF.getText().equals("")||cvvTF.getText().equals("Ej. 123") ||cvvTF.getText().length()<3) {
				JOptionPane.showMessageDialog(null,"Numero de tarjeta o CVV invalidos","Error",JOptionPane.ERROR_MESSAGE);
				//pt.setVisible(true);
			} else {
				continuarBtn(e);
				main.pagado=true;
				main.totalFichas=fichasM.cantidadF;
			}
		}
	});
	btnContinuar.setFont(new Font("Tahoma", Font.PLAIN, 13));
	contentPane.add(btnContinuar);
	
	JComboBox fcAnoCmbx = new JComboBox();
	JComboBox fcMesCmbx = new JComboBox();
	fcMesCmbx.setOpaque(true);
	fcMesCmbx.setFocusable(false);
	fcMesCmbx.setForeground(Color.gray);
	fcMesCmbx.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(fcMesCmbx.getSelectedIndex()==0||fcAnoCmbx.getSelectedIndex()==0) {
				btnContinuar.setEnabled(false);
			} else {
				btnContinuar.setEnabled(true);
				fcMesCmbx.setForeground(Color.black);
			}
		}
	});
	fcMesCmbx.setFont(new Font("Tahoma", Font.PLAIN, 17));
	fcMesCmbx.setModel(new DefaultComboBoxModel(new String[] {"Mes", "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Octubre", "Noviembre", "Diciembre"}));
	fcMesCmbx.setBounds(20, 242, 100, 21);
	contentPane.add(fcMesCmbx);
	
	
	fcAnoCmbx.setOpaque(true);
	fcAnoCmbx.setFocusable(false);
	fcAnoCmbx.setForeground(Color.gray);
	fcAnoCmbx.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(fcAnoCmbx.getSelectedIndex()==0) {
				btnContinuar.setEnabled(false);
			} else {
				btnContinuar.setEnabled(true);
				fcAnoCmbx.setForeground(Color.black);
			}
		}
	});
	fcAnoCmbx.setFont(new Font("Tahoma", Font.PLAIN, 17));
	fcAnoCmbx.setModel(new DefaultComboBoxModel(new String[] {"Año", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032"}));
	fcAnoCmbx.setBounds(130, 242, 76, 21);
	contentPane.add(fcAnoCmbx);
	
	rdbtnMasterCard.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(rdbtnMasterCard.isSelected()==true || rdbtnVisa.isSelected()==true) {
				btnContinuar.setEnabled(true);
			}
		}
	});

}
}