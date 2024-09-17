import java.io.Serializable;

public class Cancion implements Serializable{
	private static final long serialVersionUID = -1;
	private String ID="";
	private String nombre="";
	private String grupo="";
	private String anio;
	private String reproducciones;
	
	public Cancion(String ID,String nombre, String grupo, String anio, String reproducciones) {
		
		this.ID=ID;
		this.nombre = nombre;
		this.grupo = grupo;
		this.anio = anio;
		this.reproducciones = reproducciones;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public String getAnio() {
		return anio;
	}

	public void setAnio(String anio) {
		this.anio = anio;
	}

	public String getReprodrucciones() {
		return reproducciones;
	}

	public void setReproducciones(String reproducciones) {
		this.reproducciones = reproducciones;
	}

	@Override
	public String toString() {
		return "ID: "+ID+"\nNombre: " + nombre + "\nGrupo: " + grupo + "\nAño: " + anio + "\nReproducciones: "
				+ reproducciones;
	}
	
	
	
}
