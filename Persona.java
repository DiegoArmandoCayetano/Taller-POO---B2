/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.taller_poo_b2;

import java.util.Random;

/**
 *
 * @author Armando Bautista
 */
public class Persona {
    
     private String nombre;
        private int edad;
        private String cedula;
    private char sexo;
    private double peso;
    private double altura;
    
    public static final char SEXO_HOMBRE = 'H';
    public static final char SEXO_MUJER = 'M';

    public Persona() {
        this.nombre = "";
        this.edad = 0;
        this.sexo = SEXO_HOMBRE;
        this.peso = 0;
        this.altura = 0;
        this.cedula = generaCedula();
    }

    public Persona(String nombre, int edad, char sexo) {
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = comprobarSexo(sexo);
        this.peso = 0;
        this.altura = 0;
        this.cedula = generaCedula();
    }

    public Persona(String nombre, int edad, String cedula, char sexo, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.cedula = cedula;
        this.sexo = comprobarSexo(sexo);
        this.peso = peso;
        this.altura = altura;
    }

    public int calcularIMC() {
        double imc = peso / Math.pow(altura, 2);
        if (imc < 20) {
            return -1;
        } else if (imc >= 20 && imc <= 25) {
            return 0;
        } else {
            return 1;
        }
    }

    public boolean esMayorDeEdad() {
        return edad >= 18;
    }

    public char comprobarSexo(char sexo) {
        if (sexo == SEXO_HOMBRE || sexo == SEXO_MUJER) {
            return sexo;
        } else {
            return SEXO_HOMBRE;
        }
    }

    public String toString() {
        return "Nombre: " + nombre + "\n" +
                "Edad: " + edad + "\n" +
                "Cedula: " + cedula + "\n" +
                "Sexo: " + sexo + "\n" +
                "Peso: " + peso + "\n" +
                "Altura: " + altura;
    }

    public String generaCedula() {
        Random rand = new Random();
        StringBuilder cedulaBuilder = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            cedulaBuilder.append(rand.nextInt(10));
        }
        return cedulaBuilder.toString();
    }

    // Métodos get y set de cada atributo
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
    
    
    
    
    public static void main(String[] args) {  
    
        
         // Crear una instancia de Persona utilizando el constructor por defecto
        Persona persona1 = new Persona();
        // Mostrar información de la persona
        System.out.println("Persona 1:");
        System.out.println(persona1.toString());
        // Calcular el IMC de la persona
        int imcPersona1 = persona1.calcularIMC();
        System.out.println("IMC Persona 1: " + imcToString(imcPersona1));

        // Crear una instancia de Persona utilizando el constructor con nombre, edad y sexo
        Persona persona2 = new Persona("Juan", 25, 'M');
        // Mostrar información de la persona
        System.out.println("\nPersona 2:");
        System.out.println(persona2.toString());
        // Calcular el IMC de la persona
        int imcPersona2 = persona2.calcularIMC();
        System.out.println("IMC Persona 2: " + imcToString(imcPersona2));

        // Crear una instancia de Persona utilizando el constructor con todos los atributos
        Persona persona3 = new Persona("María", 30, "1234567890", 'F', 65, 1.70);
        // Mostrar información de la persona
        System.out.println("\nPersona 3:");
        System.out.println(persona3.toString());
        // Calcular el IMC de la persona
        int imcPersona3 = persona3.calcularIMC();
        System.out.println("IMC Persona 3: " + imcToString(imcPersona3));

        // Comprobar si las personas son mayores de edad
        System.out.println("\n¿Es Persona 1 mayor de edad? " + (persona1.esMayorDeEdad() ? "Sí" : "No"));
        System.out.println("¿Es Persona 2 mayor de edad? " + (persona2.esMayorDeEdad() ? "Sí" : "No"));
        System.out.println("¿Es Persona 3 mayor de edad? " + (persona3.esMayorDeEdad() ? "Sí" : "No"));
    }

    // Método para convertir el valor de IMC a una cadena legible
    public static String imcToString(int imc) {
        if (imc == -1) {
            return "Bajo peso";
        } else if (imc == 0) {
            return "Peso normal";
        } else if (imc == 1) {
            return "Sobrepeso";
        } else {
            return "IMC no calculado";
        }
    }
        
        
    }
    
