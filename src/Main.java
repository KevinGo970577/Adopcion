import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String nombreH, apellidoH, documentoH, placaM, nombreM, razaM, tamanioM, documentoR, placaR;
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

            switch (opc1) {
                case 1 -> {
                    System.out.println("REGISTRAR UNA PERSONA");
                    System.out.println("Nombre");
                    nombreH = teclado.next();
                    System.out.println();
                    System.out.println("Apellido");
                    apellidoH = teclado.next();
                    System.out.println();
                    System.out.println("Edad");
                    edadH = teclado.nextInt();
                    System.out.println();
                    System.out.println("Documento");
                    documentoH = teclado.next();
                    System.out.println();
                    listaPersonas.add(new Persona(nombreH, apellidoH, edadH, documentoH));
                }case 2 -> {
                    System.out.println("REGISTRAR UN PERRO");
                    System.out.println("Placa");
                    placaM = teclado.next();
                    System.out.println();
                    System.out.println("Nombre");
                    nombreM = teclado.next();
                    System.out.println();
                    System.out.println("Raza");
                    razaM = teclado.next();
                    System.out.println();
                    System.out.println("Edad");
                    edadM = teclado.nextInt();
                    System.out.println();
                    System.out.println("Tamaño");
                    tamanioM = teclado.next();
                    System.out.println();
                    listaPerros.add(new Perro(placaM, nombreM, razaM, edadM, tamanioM));
                }case 3 -> {
                    System.out.println("Lista de Personas:");
                    if (listaPersonas.isEmpty()) {
                        System.out.println("No hay personas registradas.");
                    } else {
                        i = 0;
                        while (i < listaPersonas.size()) {
                            System.out.println(listaPersonas.get(i));
                            i++;
                        }
                    }
                }case 4 -> {
                    System.out.println("Lista de Perros disponibles:");
                    if (listaPerros.isEmpty()) {
                        System.out.println("No hay perros disponibles para adopción.");
                    } else {
                        i = 0;
                        while (i < listaPerros.size()) {
                            System.out.println(listaPerros.get(i));
                            i++;
                        }
                    }
                }case 5 -> {
                    System.out.println("ADOPTAR UN PERRITO");
                    System.out.println("Digite el documento con el que se registró");
                    documentoR = teclado.next();

                    Persona personaAdoptante = null;
                    for (Persona p : listaPersonas) {
                        if (p.getDocumento().equals(documentoR)) {
                            personaAdoptante = p;
                            break;
                        }
                    }if (personaAdoptante == null) {
                        System.out.println("No se encontró una persona con ese documento.");
                        break;
                    }if (personaAdoptante.getListaPerros() != null && personaAdoptante.getListaPerros().size() >= 3) {
                        System.out.println("Esta persona ya ha adoptado el máximo de 3 perros permitidos.");
                        break;
                    }System.out.println("Digite la placa del perro que desea adoptar");
                    placaR = teclado.next();

                    Perro perroAdoptar = null;
                    int indicePerro = -1;

                    for (i = 0; i < listaPerros.size(); i++) {
                        if (listaPerros.get(i).getPlaca().equals(placaR)) {
                            perroAdoptar = listaPerros.get(i);
                            indicePerro = i;
                            break;
                        }
                    }if (perroAdoptar == null) {
                        System.out.println("No se encontró un perro con esa placa.");
                        break;
                    }
                    personaAdoptante.adoptarPerro(perroAdoptar);
                    listaPerros.remove(indicePerro);
                    System.out.println("¡Adopción realizada con éxito!");
                }case 6 -> {
                    System.out.println("CONSULTAR PERRO MÁS VIEJO ADOPTADO");
                    System.out.println("Digite el documento de la persona");
                    documentoR = teclado.next();
                    boolean personaEncontrada = false;
                    for (Persona p : listaPersonas) {
                        if (p.getDocumento().equals(documentoR)) {
                            personaEncontrada = true;
                            Perro perroMasViejo = p.perroMasGrande();

                            if (perroMasViejo == null) {
                                System.out.println("Esta persona no ha adoptado ningún perro.");
                            } else {
                                System.out.println("El perro más viejo adoptado por " + p.getNombre() + " " + p.getApellido() + " es:");
                                System.out.println(perroMasViejo);
                            }break;
                        }
                    }if (!personaEncontrada) {
                        System.out.println("No se encontró una persona con ese documento.");
                    }
                }case 7 -> {
                    System.out.println("Gracias por utilizar el sistema de adopción UNIMINUTO.");
                    menu = false;
                    return;
                }
                default -> System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (menu);
    }
}