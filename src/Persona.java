import java.util.List;
import java.util.ArrayList;

public class Persona {
    private String nombre;
    private String apellido;
    private int edad;
    private String documento;

    private List<Perro> listaPerros;

    public Persona() {
        this.listaPerros = new ArrayList<>();
    }

    public Persona(String nombre, String apellido, int edad, String documento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.documento = documento;
        this.listaPerros = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public Persona setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public String getApellido() {
        return apellido;
    }

    public Persona setApellido(String apellido) {
        this.apellido = apellido;
        return this;
    }

    public int getEdad() {
        return edad;
    }

    public Persona setEdad(int edad) {
        this.edad = edad;
        return this;
    }

    public String getDocumento() {
        return documento;
    }

    public Persona setDocumento(String documento) {
        this.documento = documento;
        return this;
    }

    public List<Perro> getListaPerros() {
        return listaPerros;
    }

    public Persona setListaPerros(List<Perro> listaPerros) {
        this.listaPerros = listaPerros;
        return this;
    }

    public boolean adoptarPerro(Perro perro) {
        if (listaPerros.size() < 3) {
            listaPerros.add(perro);
            return true;
        }
        return false;
    }

    public Perro perroMasGrande() {
        if (listaPerros.isEmpty()) {
            return null;
        }

        Perro masViejo = listaPerros.get(0);
        for (Perro perro : listaPerros) {
            if (perro.getEdad() > masViejo.getEdad()) {
                masViejo = perro;
            }
        }
        return masViejo;
    }

    @Override
    public String toString() {
        return "nombre= " + nombre + " " + apellido +
                ", Edad= " + edad +
                ", Documento= " + documento +
                ", ListaPerros= " + listaPerros;
    }
}