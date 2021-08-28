package dto;

public class PersonaDTO {
	
	private int idPersona;
	private String nombre;
	private String telefono;
	private int tipo_contacto_id;
	private String tipo_contacto;
	private int localidad_id;
	private String Localidad;
	private String Provincia;
	private String Pais;
	private String mascota_preferida;
	private String calle;
	private String altura;
	private String piso;
	private String depto;
	private String email;
	private String cumpleanio;

	public PersonaDTO(int idPersona, String nombre, String telefono) {
		this.idPersona = idPersona;
		this.nombre = nombre;
		this.telefono = telefono;
	}
	

	public String getCumpleanio() {
		return cumpleanio;
	}

	public void setDepto(String depto) {
		this.depto = depto;
	}

	public int getIdPersona() {
		return this.idPersona;
	}

	public String getNombre() {
		return this.nombre;
	}
	public String getTelefono() {
		return this.telefono;
	}
	
	public void setTelefono(String numero) {
		this.telefono = numero;
	}
	public String getPiso() {
		return this.piso;
	}

	public int getTipo_contacto_id() {
		return this.tipo_contacto_id;
	}
	
	public int getLocalidad_id() {
		return this.localidad_id;
	}
	
	
	public String getCalle() {
		return this.calle;
	}

	public String getAltura() {
		return this.altura;
	}

	public String getDepto() {
		return this.depto;
	}

	public String getEmail() {
		return this.email;
	}

	public String getCumple() {
		return this.cumpleanio;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

	public void setTipo_contacto_id(int tipo_contacto_id) {
		this.tipo_contacto_id = tipo_contacto_id;
	}
	

	public void setLocalidad_id(int localidad_id) {
		this.localidad_id = localidad_id;
	}
	
	
	public void setCalle(String calle) {
		this.calle = calle;
	}
	
	public void setAltura(String altura) {
		this.altura = altura;
	}
	
	public void setPiso(String piso) {
		this.piso = piso;
	}
	
	public void setdepto(String depto) {
		this.depto = depto;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setCumpleanio(String nacimiento) {
		this.cumpleanio = nacimiento;
	}


	public String getMascota_preferida() {
		return mascota_preferida;
	}

	public void setMascota_preferida(String mascota_preferida) {
		this.mascota_preferida = mascota_preferida;
	}

	public String getPais() {
		return Pais;
	}

	public void setPais(String pais) {
		Pais = pais;
	}

	public String getProvincia() {
		return Provincia;
	}

	public void setProvincia(String provincia) {
		Provincia = provincia;
	}

	public String getLocalidad() {
		return Localidad;
	}

	public void setLocalidad(String localidad) {
		Localidad = localidad;
	}


	public String getTipo_contacto() {
		return tipo_contacto;
	}


	public void setTipo_contacto(String tipo_contacto) {
		this.tipo_contacto = tipo_contacto;
	}
	
	
}

