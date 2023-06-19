package Validadores;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidarCorreo {


    public static boolean validarCorreo(String correo) {
        // Expresión regular para validar el formato del correo electrónico
        String patronCorreo = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern pattern = Pattern.compile(patronCorreo);
        Matcher matcher = pattern.matcher(correo);
        return matcher.matches();
    }
}
