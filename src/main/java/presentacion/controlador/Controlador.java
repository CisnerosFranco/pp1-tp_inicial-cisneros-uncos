package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import modelo.Agenda;
import presentacion.reportes.ReporteAgenda;
import presentacion.vista.VentanaPersona;
import presentacion.vista.Vista;
import dto.PersonaDTO;
import presentacion.vista.Editor;

public class Controlador implements ActionListener {
		private Vista vista;
		private List<PersonaDTO> personasEnTabla;
		private VentanaPersona ventanaPersona; 
		private Agenda agenda;
		private Editor editor;
		private int id_selecionado;
		
		
		public Controlador(Vista vista, Agenda agenda) {
			this.vista = vista;
			this.editor = new Editor();
			this.vista.getBtnAgregar().addActionListener(a->ventanaAgregarPersona(a));
			this.vista.getBtnBorrar().addActionListener(s->borrarPersona(s));
			this.vista.getBtnReporte().addActionListener(r->mostrarReporte(r));
			this.vista.getBtnEditar().addActionListener(p -> editarPersona(p));
			this.editor.getBtnGuardar().addActionListener(p -> guardarCambios(p));
			this.ventanaPersona = VentanaPersona.getInstance();
			this.ventanaPersona.getBtnAgregarPersona().addActionListener(p->guardarPersona(p));
			this.agenda = agenda;
		}
		

		

		private void guardarCambios(ActionEvent e) {
				
			for(PersonaDTO p : this.personasEnTabla) {
				if(p.getIdPersona() == this.id_selecionado) {
					p.setNombre(this.editor.getNombreApellido().getText());
					p.setTelefono(this.editor.getTelefono().getText());
					p.setEmail(this.editor.getEmail().getText());
					p.setCalle(this.editor.getCalle().getText());
					p.setAltura(this.editor.getAltura().getText());
					p.setPiso(this.editor.getPiso().getText());
					p.setdepto(this.editor.getDepto().getText());
					p.setCumpleanio(this.editor.getCumpleanio().getText());
					p.setTipo_contacto_id(this.editor.getTipoContacto().getSelectedItem() == null ? -1 : (this.editor.getPK(this.editor.getTipoContacto().getSelectedItem().toString())));
					p.setLocalidad_id(this.editor.getLocalidad().getSelectedItem() == null ? -1 : this.editor.getPK(this.editor.getLocalidad().getSelectedItem().toString()));
					p.setMascota_preferida(this.editor.getMascotaPreferida().getText());
					
					
					
				}
			}
			this.editor.cerrar(e);
			this.refrescarTabla(); 
		}

		public void borrarPersona(ActionEvent s) {
			int[] filasSeleccionadas = this.vista.getTablaPersonas().getSelectedRows();
			for (int fila : filasSeleccionadas) {
				this.agenda.borrarPersona(this.personasEnTabla.get(fila));
			}
			this.refrescarTabla();
		}
		
		
		private void editarPersona(ActionEvent p) {
			int[] filasSeleccionadas = this.vista.getTablaPersonas().getSelectedRows();
			for (int fila : filasSeleccionadas) {
				this.id_selecionado = this.personasEnTabla.get(fila).getIdPersona();
				this.editor.mostrar(this.personasEnTabla.get(fila));
			}
			this.refrescarTabla();
		}

		private void ventanaAgregarPersona(ActionEvent a) {
			this.ventanaPersona.mostrarVentana();
		}

		private void guardarPersona(ActionEvent p) {
			String nombre = this.ventanaPersona.getTxtNombre().getText();
			String tel = ventanaPersona.getTxtTelefono().getText();
			PersonaDTO nuevaPersona = new PersonaDTO(0, nombre, tel);
			this.agenda.agregarPersona(nuevaPersona);
			this.refrescarTabla();
			this.ventanaPersona.cerrar();
		}
		
		

		private void mostrarReporte(ActionEvent r) {
			ReporteAgenda reporte = new ReporteAgenda(agenda.obtenerPersonas());
			reporte.mostrar();	
		}

		
		public void inicializar() {
			this.refrescarTabla();
			this.vista.show();
		}
		
		private void refrescarTabla() {
			this.personasEnTabla = agenda.obtenerPersonas();
			this.editor.setVisible(false);;
			this.vista.llenarTabla(this.personasEnTabla);
		}

		@Override
		public void actionPerformed(ActionEvent e) { }
		
}
