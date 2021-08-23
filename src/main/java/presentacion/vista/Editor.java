package presentacion.vista;

import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.protocol.x.SyncFlushDeflaterOutputStream;

import dto.PersonaDTO;
import dto.Trupla;
import dto.Tupla;
import dto.UbicacionDTO;
import persistencia.conexion.Conexion;
import java.awt.Window.Type;
import javax.swing.JToggleButton;
import javax.swing.JSpinner;
import java.awt.Color;
import javax.swing.JPasswordField;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Editor extends JFrame {

	JFrame frame;
	private JButton btnGuardar;
	private DefaultTableModel modelPersonas;
	private  String[] nombreColumnas = {"Nombre y apellido","Telefono"};
	private JTextField NombreApellido;
	private JTextField Telefono;
	private JTextField Email;
	private JTextField cumpleanio;
	private JTextField calle;
	private JTextField altura;
	private JTextField piso;
	private JTextField depto;
	private JComboBox pais;
	private JComboBox provincia;
	private JComboBox localidad;
	private JComboBox tipo_contacto;
	private int id_pais;
	private int id_prov;
	private int id_localidad;
	List<Trupla> localidades;
	UbicacionDTO U = UbicacionDTO.constructor();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Editor window = new Editor();
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
	public Editor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setAlwaysOnTop(true);
		frame.setResizable(false);
		frame.setBounds(100, 100, 451, 508);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 438, 455);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		modelPersonas = new DefaultTableModel(null,nombreColumnas);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnGuardar.setBounds(179, 427, 114, 29);
		panel.add(btnGuardar);
		
		NombreApellido = new JTextField();
		NombreApellido.setBounds(153, 27, 258, 23);
		panel.add(NombreApellido);
		NombreApellido.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nombre y Apellido");
		lblNewLabel.setBounds(29, 29, 114, 19);
		panel.add(lblNewLabel);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(29, 97, 100, 19);
		panel.add(lblEmail);
		
		JLabel sadfasdf = new JLabel("Telefono");
		sadfasdf.setBounds(29, 63, 100, 19);
		panel.add(sadfasdf);
		
		JLabel lblFechaNacimiento = new JLabel("Fecha Nacimiento");
		lblFechaNacimiento.setBounds(29, 131, 114, 19);
		panel.add(lblFechaNacimiento);
		
		JLabel lblDatosDeDomicilio = new JLabel("Datos de Domicilio");
		lblDatosDeDomicilio.setBounds(29, 192, 114, 19);
		panel.add(lblDatosDeDomicilio);
		
		Telefono = new JTextField();
		Telefono.setColumns(10);
		Telefono.setBounds(153, 61, 162, 23);
		panel.add(Telefono);
		
		Email = new JTextField();
		Email.setColumns(10);
		Email.setBounds(153, 95, 258, 23);
		panel.add(Email);
		
		cumpleanio = new JTextField();
		cumpleanio.setColumns(10);
		cumpleanio.setBounds(153, 129, 86, 23);
		panel.add(cumpleanio);
		
		JLabel lblMmdd = new JLabel("MM/DD");
		lblMmdd.setBounds(249, 133, 100, 19);
		panel.add(lblMmdd);
		
		calle = new JTextField();
		calle.setColumns(10);
		calle.setBounds(153, 221, 258, 23);
		panel.add(calle);
		
		altura = new JTextField();
		altura.setColumns(10);
		altura.setBounds(153, 255, 66, 23);
		panel.add(altura);
		
		piso = new JTextField();
		piso.setColumns(10);
		piso.setBounds(264, 255, 51, 23);
		panel.add(piso);
		
		depto = new JTextField();
		depto.setColumns(10);
		depto.setBounds(360, 255, 51, 23);
		panel.add(depto);
		
		JLabel lblPiso = new JLabel("Piso");
		lblPiso.setBounds(229, 257, 25, 19);
		panel.add(lblPiso);
		
		JLabel lblDepto = new JLabel("Depto");
		lblDepto.setBounds(325, 257, 36, 19);
		panel.add(lblDepto);
		
		JLabel lblCalle = new JLabel("Calle");
		lblCalle.setBounds(29, 222, 100, 19);
		panel.add(lblCalle);
		
		JLabel lblAltura = new JLabel("Altura");
		lblAltura.setBounds(29, 257, 100, 19);
		panel.add(lblAltura);
		
		pais = new JComboBox();
		pais.setBounds(153, 293, 258, 23);
		panel.add(pais);
		
		provincia = new JComboBox();
		provincia.setBounds(153, 327, 258, 23);
		panel.add(provincia);
		
		localidad = new JComboBox();
		localidad.setBounds(153, 361, 258, 23);
		panel.add(localidad);
		
		tipo_contacto = new JComboBox();
		tipo_contacto.setBounds(325, 61, 86, 22);
		panel.add(tipo_contacto);
		
		JLabel lblPais = new JLabel("Pais");
		lblPais.setBounds(29, 297, 100, 19);
		panel.add(lblPais);
		
		JLabel lblProvincia = new JLabel("Provincia");
		lblProvincia.setBounds(29, 331, 100, 19);
		panel.add(lblProvincia);
		
		JLabel lblLocalidad = new JLabel("Localidad");
		lblLocalidad.setBounds(29, 365, 100, 19);
		panel.add(lblLocalidad);
		
		
		
		
		// ACTIONS
		
		
		this.setVisible(false);
	}
	
	
	public void mostrar(PersonaDTO P) {
		this.frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.frame.addWindowListener(new WindowAdapter() {
			@Override
		    public void windowClosing(WindowEvent e) {
		        e.getWindow().dispose();
		    }
		});
		
		this.NombreApellido.setText(P.getNombre());
		this.Telefono.setText(P.getTelefono());
		this.Email.setText(P.getEmail());
		this.cumpleanio.setText(P.getCumple());
		this.depto.setText(P.getDepto());
		this.calle.setText(P.getCalle());
		this.piso.setText(P.getPiso());
		this.altura.setText(P.getAltura());
		this.tipo_contacto.removeAllItems();
		
		for(Tupla t: U.getTipoContactos()) {
			this.tipo_contacto.addItem(t.getId()+"."+t.getValor());
		}
		
		//this.pais.add(Email)
		
		//provincias = U.getProvincias(paises.get(0).getId());
		cargarPaises();
		cargarProvincias();
		cargarLocalidades();

		
		this.pais.addActionListener(e -> cargarProvincias());
		this.provincia.addActionListener(x -> cargarLocalidades());
		this.frame.setVisible(true);
		
	} 
	
	private void cargarPaises() {
		this.pais.removeAllItems();
		for(Tupla p: U.getPaises()) {
			//this.pais.add(p.getValor(), p.getId());
			String item = p.getId()+"."+p.getValor();
			this.pais.addItem(item);
		}
	}
	
	private void cargarProvincias() {
		this.provincia.removeAllItems();
		int fk = getPK(this.pais.getSelectedItem().toString());
		List<Trupla> prov = U.getProvincias(fk);
		if(!prov.isEmpty()) {
			for(Trupla p : prov) {
				this.provincia.addItem(p.getId()+"."+p.getId_2()+"."+p.getValor());
			}
		}
	}
	
	private void cargarLocalidades() {
		this.localidad.removeAllItems();
		if(this.provincia.getSelectedItem() != null) {
			int fk = getPK(this.provincia.getSelectedItem().toString());
			List<Trupla> loc = U.getLocalidades(fk);
			if(!loc.isEmpty()) {
				for(Trupla p : loc) {
					this.localidad.addItem(p.getId()+"."+p.getId_2()+"."+p.getValor());	
				}
			}
		}
	}
	
	public int getFK(String S) {
		String ret = "";
		int i = S.indexOf('.')+1;
		 while(S.charAt(i) != '.'){
			ret += S.charAt(i);
			i++;
		}
		return Integer.parseInt(ret);
	}
	
	public int getPK(String S) {
		String ret = "";
		int i = 0;
		 while(S.charAt(i) != '.' && i<S.length()){
			ret += S.charAt(i);
			i++;
		}
		return Integer.parseInt(ret);
	}
	
	
	public void cerrar(WindowEvent e) {
		this.frame.dispose();
	}

	public JButton getBtnGuardar() {
		return btnGuardar;
	}

	public void setBtnGuardar(JButton btnGuardar) {
		this.btnGuardar = btnGuardar;
	}

	public JTextField getNombreApellido() {
		return NombreApellido;
	}

	public void setNombreApellido(JTextField nombreApellido) {
		NombreApellido = nombreApellido;
	}

	public JTextField getTelefono() {
		return Telefono;
	}

	public void setTelefono(JTextField telefono) {
		Telefono = telefono;
	}

	public JTextField getEmail() {
		return Email;
	}

	public void setEmail(JTextField email) {
		Email = email;
	}

	public JTextField getCumpleanio() {
		return cumpleanio;
	}

	public void setCumpleanio(JTextField cumpleanio) {
		this.cumpleanio = cumpleanio;
	}

	public JTextField getCalle() {
		return calle;
	}

	public void setCalle(JTextField calle) {
		this.calle = calle;
	}

	public JTextField getAltura() {
		return altura;
	}

	public void setAltura(JTextField altura) {
		this.altura = altura;
	}

	public JTextField getPiso() {
		return piso;
	}

	public void setPiso(JTextField piso) {
		this.piso = piso;
	}

	public JTextField getDepto() {
		return depto;
	}

	public void setDepto(JTextField depto) {
		this.depto = depto;
	}

	public JComboBox getPais() {
		return pais;
	}

	public void setPais(JComboBox pais) {
		this.pais = pais;
	}

	public JComboBox getProvincia() {
		return provincia;
	}

	public void setProvincia(JComboBox provincia) {
		this.provincia = provincia;
	}

	public JComboBox getLocalidad() {
		return localidad;
	}

	public void setLocalidad(JComboBox localidad) {
		this.localidad = localidad;
	}
	public JComboBox getTipoContacto() {
		return this.tipo_contacto;
	}
	
}
