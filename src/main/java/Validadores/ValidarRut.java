package Validadores;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidarRut {
    public static boolean validarRut(String rut) {
        // Expresión regular para validar el formato del rut
        String patronRut = "^[0-9]{1,2}\\.[0-9]{3}\\.[0-9]{3}-[0-9kK]{1}$";
        Pattern pattern = Pattern.compile(patronRut);
        Matcher matcher = pattern.matcher(rut);
        if (!matcher.matches()) {
            return false;
        }

        // Validar dígito verificador del rut
        rut = rut.replace(".", "").replace("-", "");
        int rutNumerico = Integer.parseInt(rut.substring(0, rut.length() - 1));
        char dv = rut.charAt(rut.length() - 1);

        int m = 0;
        int s = 1;
        for (; rutNumerico != 0; rutNumerico /= 10) {
            s = (s + rutNumerico % 10 * (9 - m++ % 6)) % 11;
        }
        char dvCalculado = (char) (s != 0 ? s + 47 : 75);

        return Character.toUpperCase(dv) == dvCalculado;
    }

}
