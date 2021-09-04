package presentacion.vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;

public class Registracion {

	private JFrame frame;
	private JTextField usuario;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registracion window = new Registracion();
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
	public Registracion() {
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
		
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setBounds(45, 47, 66, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Contraseña");
		lblPassword.setBounds(45, 111, 82, 14);
		frame.getContentPane().add(lblPassword);
		
		usuario = new JTextField();
		usuario.setBounds(144, 41, 229, 27);
		frame.getContentPane().add(usuario);
		usuario.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(144, 105, 229, 27);
		frame.getContentPane().add(passwordField);
		
		JButton iniciar = new JButton("INICIAR");
		iniciar.setForeground(Color.BLACK);
		iniciar.setBackground(Color.WHITE);
		iniciar.setBounds(167, 203, 111, 27);
		frame.getContentPane().add(iniciar);
	}
}
