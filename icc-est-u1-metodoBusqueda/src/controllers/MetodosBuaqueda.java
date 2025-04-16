package controllers;

import models.Person;
import views.ShowConsole;

public class MetodosBuaqueda {

    private ShowConsole showConsole;
    private  Person [] people;

    public MetodosBuaqueda(Person[] persons) {
        showConsole = new ShowConsole();
        this.people = persons;
        showPerson();
    }

    public int busquedaLineal(int[] arreglo, int valorBuscar) {
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] == valorBuscar) {
                return i; 
            }
        }
        return -1;

    }
    public int findPersonaByCode(int code) {
        for(int i = 0; i < people.length; i++) {
            if(people[i].getCode() == code) {
                return i;
            }
        }
        return -1;

    }

    public void showPerson() {
        int codeToFind = showConsole.inputCode();
        int indexPerson = findPersonaByCode(codeToFind);
        if(indexPerson >= 0) {
            showConsole.showMessage("Persona con codigo" + codeToFind + " encontrada");
            showConsole.showMessage(people[indexPerson].toString());
            showConsole.showMessage( people[indexPerson] + "" );

        }else{
            showConsole.showMessage("Persona no encontrada");
        }
    }

}
    
    



