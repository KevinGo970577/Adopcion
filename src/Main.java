import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String nombreH, apellidoH, documentoH, placaM, nombreM, razaM, tamanioM;
        int opc1, edadH, edadM, i;
        boolean menu = true;
        List<Persona> listaPersonas = new ArrayList<>();
        List<Perro> listaPerros = new ArrayList<>();


        do {
            System.out.println("        ADOPCION UNIMINUTO");
            System.out.println("            MENÚ");
            System.out.println("1. Registrar persona.");
            System.out.println("2. Registrar perros.");
            System.out.println("3. Ver personas registradas.");
            System.out.println("4. Ver perros registrados.");
            System.out.println("5. Adoptar perro.");
            System.out.println("6. Consulta perro mas viejo adoptado por una persona.");
            System.out.println("7. Salir");
            System.out.print("Opción: ");
            opc1 = teclado.nextInt();

            switch (opc1){
                case 1 -> {
                    System.out.println("REGISTRAR UNA PERSONA");
                    System.out.println("Nombre");
                    nombreH = teclado.nextLine();
                    System.out.println("Apellido");
                    apellidoH = teclado.nextLine();
                    System.out.println("Edad");
                    edadH = teclado.nextInt();
                    System.out.println("Documento");
                    documentoH = teclado.nextLine();
                    listaPersonas.add(new Persona(nombreH,apellidoH,edadH,documentoH));
                }
                case 2 -> {
                    System.out.println("REGISTRAR UN PERRO");
                    System.out.println("Placa");
                    placaM = teclado.nextLine();
                    System.out.println("Nombre");
                    nombreM = teclado.nextLine();
                    System.out.println("Raza");
                    razaM = teclado.nextLine();
                    System.out.println("Edad");
                    edadM = teclado.nextInt();
                    System.out.println("Tamaño");
                    tamanioM = teclado.nextLine();
                    listaPerros.add(new Perro(placaM, nombreM, razaM, edadM, tamanioM));
                }
                case 3 -> {
                    System.out.println("Lista de Personas:");
                    i = 0;
                    while (i < listaPersonas.size()) {
                        System.out.println(listaPersonas.get(i));
                        i++;
                    }
                }
                case 4 -> {
                    System.out.println("Lista de Perros:");
                    i = 0;
                    while (i < listaPerros.size()) {
                        System.out.println(listaPerros.get(i));
                        i++;
                    }
                }
            }
        }while (menu);

    }
}