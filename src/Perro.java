public class Perro{
    private String placa;
    private String nombre;
    private String raza;
    private int edad;
    private String tamanio;

    public Perro(String placa, String nombre, String raza, int edad, String tamanio) {
        this.placa = placa;
        this.nombre = nombre;
        this.raza = raza;
        this.edad = edad;
        this.tamanio = tamanio;
    }

    public String getPlaca() {
        return placa;
    }

    public Perro setPlaca(String placa) {
        this.placa = placa;
        return this;
    }

    public String getNombre() {
        return nombre;
    }

    public Perro setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public String getRaza() {
        return raza;
    }

    public Perro setRaza(String raza) {
        this.raza = raza;
        return this;
    }

    public int getEdad() {
        return edad;
    }

    public Perro setEdad(int edad) {
        this.edad = edad;
        return this;
    }

    public String getTamanio() {
        return tamanio;
    }

    public Perro setTamanio(String tamanio) {
        this.tamanio = tamanio;
        return this;
    }

    @Override
    public String toString() {
        return "placa= " + placa +
                ", nombre= " + nombre +
                ", raza= " + raza +
                ", edad= " + edad +
                ", tamaño= " + tamanio;
    }
}
