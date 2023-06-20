package Validadores;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidarRut {


        public static boolean validarRut(String rut) {
            rut = rut.replace(".", ""); // Eliminar puntos
            rut = rut.replace("-", ""); // Eliminar guiones
            String rutNumeros = rut.substring(0, rut.length() - 1); // Obtener solo los dígitos del RUT
            String verificador = rut.substring(rut.length() - 1); // Obtener el dígito verificador

            // Verificar si el RUT tiene el formato correcto
            if (!rutNumeros.matches("\\d+") || !verificador.matches("\\d+")) {
                return false;
            }

            // Calcular el dígito verificador esperado
            int suma = 0;
            int multiplicador = 2;
            for (int i = rutNumeros.length() - 1; i >= 0; i--) {
                int digito = Integer.parseInt(String.valueOf(rutNumeros.charAt(i)));
                suma += digito * multiplicador;
                multiplicador++;
                if (multiplicador > 7) {
                    multiplicador = 2;
                }
            }
            int resto = suma % 11;
            String digitoVerificadorEsperado = String.valueOf(11 - resto);
            if (resto == 1) {
                digitoVerificadorEsperado = "K";
            } else if (resto == 0) {
                digitoVerificadorEsperado = "0";
            }

            // Comparar el dígito verificador obtenido con el esperado
            return digitoVerificadorEsperado.equals(verificador);
        }
}
