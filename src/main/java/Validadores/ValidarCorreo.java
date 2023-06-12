package Validadores;

public class ValidarCorreo {


    public static boolean validar(String correo) {
        // Patrón de expresión regular para validar el formato del correo electrónico
        String patron = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";

        // Verificar si el correo coincide con el patrón
        return correo.matches(patron);
    }
}
