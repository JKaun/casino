import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class fichasM extends JFrame {
	
	private main m;
	public void setmain(main m) {
		this.m = m;
	}
	public void regresarBtn(java.awt.event.ActionEvent avt) {
		m.setVisible(true);
		this.setVisible(false);
	}
	private void continuarBtn(java.awt.event.ActionEvent avt) {
		fichasP fp  = new fichasP();
		fp.setFichasM(this);
		fp.setVisible(true);
		this.setVisible(false);
	}
	
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	
	public static int cantidadF=0;
	public static Object spinner;
	
	/**
	* Launch the application.
	*/
	public static void main(String[] args) {
	
	EventQueue.invokeLater(new Runnable() {
	public void run() {
		try {
			fichasM frame = new fichasM();
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
	
	public fichasM() {
		
	main.pagado=false;
	
	setResizable(false);
	setTitle("Casino KaS");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(500, 100, 500, 400);
	contentPane = new JPanel();
	contentPane.setBackground(new Color(0, 128, 64));
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));;
	
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	JSpinner spinner = new JSpinner();
	spinner.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(10)));
	
	spinner.setFont(new Font("Tahoma", Font.PLAIN, 15));
	spinner.setBounds(184, 52, 100, 30);
	contentPane.add(spinner);
	
	
	JButton btnNewButton = new JButton("Regresar");
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			regresarBtn(e);
		}
	
	});
	btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
	btnNewButton.setBounds(10, 327, 89, 23);
	contentPane.add(btnNewButton);
	
	JLabel lblCantidadDeFichas = new JLabel("Cantidad de fichas");
	lblCantidadDeFichas.setHorizontalAlignment(SwingConstants.CENTER);
	lblCantidadDeFichas.setForeground(Color.WHITE);
	lblCantidadDeFichas.setFont(new Font("Calisto MT", Font.BOLD, 25));
	lblCantidadDeFichas.setBounds(87, 11, 300, 30);
	contentPane.add(lblCantidadDeFichas);
	
	JLabel lblTipoDeCambio = new JLabel("Tipo de cambio");
	lblTipoDeCambio.setHorizontalAlignment(SwingConstants.CENTER);
	lblTipoDeCambio.setForeground(Color.WHITE);
	lblTipoDeCambio.setFont(new Font("Calisto MT", Font.BOLD, 20));
	lblTipoDeCambio.setBounds(87, 134, 300, 30);
	contentPane.add(lblTipoDeCambio);
	
	JLabel lblFicha = new JLabel("1 Ficha: 20.00 MXN");
	lblFicha.setHorizontalAlignment(SwingConstants.CENTER);
	lblFicha.setForeground(Color.WHITE);
	lblFicha.setFont(new Font("Calisto MT", Font.BOLD, 15));
	lblFicha.setBounds(87, 163, 300, 30);
	contentPane.add(lblFicha);
	
	JLabel lblCantidadDeFichas_1 = new JLabel();
	
	lblCantidadDeFichas_1.setHorizontalAlignment(SwingConstants.CENTER);
	lblCantidadDeFichas_1.setForeground(Color.WHITE);
	lblCantidadDeFichas_1.setFont(new Font("Calisto MT", Font.BOLD, 25));
	lblCantidadDeFichas_1.setBounds(87, 93, 300, 30);
	contentPane.add(lblCantidadDeFichas_1);
	

	JButton btnContinuar = new JButton("Continuar");
	btnContinuar.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
	// cantidadF = (Integer)spinner.getValue();
			fichas(spinner);
			continuarBtn(e);
		}
	});
	btnContinuar.setFont(new Font("Tahoma", Font.PLAIN, 13));
	btnContinuar.setBounds(385, 327, 89, 23);
	contentPane.add(btnContinuar);
	btnContinuar.setEnabled(false);
	
	JButton btnNewButton_1 = new JButton("Confirmar");
	btnNewButton_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			fichas(spinner);
			lblCantidadDeFichas_1.setText(main.pago+" MXN");
			if((Integer)spinner.getValue()>0) {
			btnContinuar.setEnabled(true);
				} else {
			btnContinuar.setEnabled(false);
				}
		}
	});
	contentPane.add(btnNewButton_1);
	btnNewButton_1.setBounds(312, 57, 126, 23);

}
	public int fichas(JSpinner spinner) {
		cantidadF = (Integer)spinner.getValue();
		main.pago = cantidadF*20;
		
		return cantidadF;
	}
}