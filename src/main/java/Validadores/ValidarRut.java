package Validadores;

public class ValidarRut {

    public static boolean validar(String rut) {
        // Eliminar puntos y guiones, y convertir a mayúsculas
        rut = rut.toUpperCase().replaceAll("[.-]", "");

        // Verificar que el RUT contenga solo dígitos y opcionalmente una letra 'K'
        if (!rut.matches("[0-9]+[K]{0,1}")) {
            return false;
        }

        // Extraer el número del RUT y el dígito verificador
        int rutNumerico = Integer.parseInt(rut.substring(0, rut.length() - 1));
        char dv = rut.charAt(rut.length() - 1);

        int m = 0;
        int s = 1;

        // Calcular el dígito verificador utilizando el algoritmo del Módulo 11
        for (; rutNumerico != 0; rutNumerico /= 10) {
            s = (s + rutNumerico % 10 * (9 - m++ % 6)) % 11;
        }

        // Comparar el dígito verificador calculado con el dígito verificador original
        return dv == (char) (s != 0 ? s + 47 : 75);
    }
}
