package controllers;

import models.Person;
import views.ShowConsole;

public class MetodosBusqueda {

    private ShowConsole showConsole;
    private Person[] people;

    public MetodosBusqueda(Person[] persons) {
        showConsole = new ShowConsole();
        this.people = persons;

        int opcion;
        do {
            opcion = showConsole.inputOption();
            switch (opcion) {
                case 1:
                    showPersonByCode();
                    break;
                case 2:
                    showPersonByName();
                    break;
                case 3:
                    showConsole.showMessage("Adios");
                    break;
                default:
                    showConsole.showMessage("Opción inválida.");
            }
        } while (opcion != 3);
    }

    public int findPersonByCode(int code) {
        for (int i = 0; i < people.length; i++) {
            if (people[i].getCode() == code) {
                return i;
            }
        }
        return -1;
    }

    public void showPersonByCode() {
        int codeToFind = showConsole.inputCode();
        int indexPerson = findPersonByCode(codeToFind);

        if (indexPerson >= 0) {
            showConsole.showMessage("Persona con código '" + codeToFind + "' encontrada:");
            showConsole.showMessage(people[indexPerson].toString());
        } else {
            showConsole.showMessage("Persona no encontrada");
        }
    }

    public int findPersonByName(String name) {
        for (int i = 0; i < people.length; i++) {
            if (people[i].getName().equalsIgnoreCase(name)) {
                return i;
            }
        }
        return -1;
    }

    public void showPersonByName() {
        String nameToFind = showConsole.inputName();
        int indexPerson = findPersonByName(nameToFind);

        if (indexPerson >= 0) {
            showConsole.showMessage("Persona con nombre '" + nameToFind + "' encontrada:");
            showConsole.showMessage(people[indexPerson].toString());
        } else {
            showConsole.showMessage("Persona no encontrada");
        }
    }
}
