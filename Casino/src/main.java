import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class main extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	public static boolean loged = false;
	public static boolean pagado=false;
	public static int pago = 0;
	public static int totalFichas=0;
	
/*	private pagoT pt;
	public void setPagoT(pagoT pt) {
		this.pt = pt;
	}*/
	private void continuarBtn(java.awt.event.ActionEvent avt) {
		fichasM fm  = new fichasM();
		fm.setmain(this);
		fm.setVisible(true);
		this.setVisible(false);
	}
	
	public static void main(String[] args) {
	//
	//Credenciales credenciales = new Credenciales();
	//LoginPage loginPage = new LoginPage(credenciales.getLoginInfo());
	
	EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
				main frame = new main();
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
public main() {
	setResizable(false);
	setTitle("Casino KaS");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(500, 100, 500, 400);
	contentPane = new JPanel();
	contentPane.setBackground(new Color(0, 128, 64));
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

	setContentPane(contentPane);
	contentPane.setLayout(null);

	JButton btnBJ = new JButton("BLACKJACK");
	btnBJ.setFont(new Font("Tahoma", Font.PLAIN, 15));
	
	btnBJ.setBounds(171, 94, 120, 50);
	contentPane.add(btnBJ);
	
	JButton btnFichas = new JButton("FICHAS");
	btnFichas.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		continuarBtn(e);
	}
});
btnFichas.setFont(new Font("Tahoma", Font.PLAIN, 15));
btnFichas.setBounds(171, 204, 120, 50);
contentPane.add(btnFichas);

JLabel lblNewLabel = new JLabel("SELECCIONE OPCION");
lblNewLabel.setForeground(new Color(255, 255, 255));
lblNewLabel.setFont(new Font("Calisto MT", Font.BOLD, 25));
lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
lblNewLabel.setBounds(80, 11, 300, 30);
contentPane.add(lblNewLabel);

if(pagado==false) { ////////////////////TODAVIA ESTA EN PROCESO
		totalFichas=0;
	} else if(pagado!=false) {
		totalFichas = fichasM.cantidadF;
		System.out.println("HOAL");
	}

JLabel lblNewLabel1 = new JLabel("Cantidad de fichas: "+totalFichas);

lblNewLabel1.setForeground(new Color(255, 255, 255));
lblNewLabel1.setFont(new Font("Calisto MT", Font.BOLD, 20));
lblNewLabel1.setHorizontalAlignment(SwingConstants.CENTER);
lblNewLabel1.setBounds(243, 311, 231, 50);
contentPane.add(lblNewLabel1);

}
}