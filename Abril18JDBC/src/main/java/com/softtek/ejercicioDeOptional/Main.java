package com.softtek.ejercicioDeOptional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        String nombreUsuario = null;
        List<Integer> numeros = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        int posicion = 4;

        System.out.println("Ejercicio 1");
        Optional<String> usuario = Optional.ofNullable(nombreUsuario);
        usuario.ifPresentOrElse(
                usurioPresente -> System.out.println("Nombre de usuario: " + usurioPresente),
                () -> System.out.println("Nombre de usuario invalido")
        );

        System.out.println("Ejercicio 2");
        Optional<Integer> numero = numeros.isEmpty() || posicion < 0 || posicion >= numeros.size() ?
                Optional.empty() : Optional.of(numeros.get(posicion));
        System.out.println("Numero: " +  numero.orElse(0));
    }
}
