package controllers;

import models.Person;
import views.ShowConsole;

public class MetodoDeBusquedaBinario {
    private Person[] people;
    private ShowConsole pantalla;

    public MetodoDeBusquedaBinario(Person[] people) {
        this.people = people;
        this.pantalla = new ShowConsole();
        pantalla.showMessage("*** Metodo de busqueda binario ***");
    }

    private void ordenarPorNombre() {
        for (int i = 0; i < people.length - 1; i++) {
            for (int j = 0; j < people.length - 1 - i; j++) {
                if (people[j].getName().compareToIgnoreCase(people[j + 1].getName()) > 0) {
                    Person temp = people[j];
                    people[j] = people[j + 1];
                    people[j + 1] = temp;
                }
            }
        }

    }

    public void mostrarNombresOrdenados() {
        ordenarPorNombre(); 
        pantalla.showMessage("Lista de nombres ordenados alfabéticamente:");
        for (Person person : people) {
            pantalla.showMessage(person.getName());
        }
    }
    

    private int findPersonByName(String name) {
        int bajo = 0;
        int alto = people.length - 1;

        while (bajo <= alto) {
            int central = (bajo + alto) / 2;
            int comparacion = people[central].getName().compareToIgnoreCase(name);

            if (comparacion == 0) {
                return central;
            } else if (comparacion > 0) {
                alto = central - 1;
            } else {
                bajo = central + 1;
            }
        }
        return -1;
    }

    private int findPersonByCode(int code) {
        int bajo = 0;
        int alto = people.length - 1;

        while (bajo <= alto) {
            int central = (bajo + alto) / 2;

            if (people[central].getCode() == code) {
                return central;
            }
            if (people[central].getCode() > code) {
                alto = central - 1; // izq
            } else {
                bajo = central + 1; // der
            }
        }
        return -1;
    }

    public void showPersonByCode() {
        int codeToFind = pantalla.inputCode();
        int indexPerson = findPersonByCode(codeToFind);
        if (indexPerson >= 0) {
            pantalla.showMessage("Persona con código " + codeToFind + " encontrada");
            pantalla.showMessage(people[indexPerson].toString());
        } else {
            pantalla.showMessage("Persona con código " + codeToFind + " no encontrada");
        }
    }

    public void showPersonByName() {
        ordenarPorNombre(); 
        String nameToFind = pantalla.inputName();
        int indexPerson = findPersonByName(nameToFind);
        if (indexPerson >= 0) {
            pantalla.showMessage("Persona con nombre \"" + nameToFind + "\" encontrada");
            pantalla.showMessage(people[indexPerson].toString());
        } else {
            pantalla.showMessage("Persona con nombre \"" + nameToFind + "\" no encontrada");
        }
    }
}
