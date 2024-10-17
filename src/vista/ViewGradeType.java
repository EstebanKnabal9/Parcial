package vista;

import modelo.GradeType;

import java.util.List;

public class ViewGradeType {

    public void displayListGradeTypes(List<GradeType> gradeTypes) {
        System.out.println(" == Lista de Tipos de Calificación == ");
        for (GradeType gradeType : gradeTypes) {
            System.out.println("Id: " + gradeType.getId() +
                    ", Nombre: " + gradeType.getName() +
                    ", Peso: " + gradeType.getWeight());
        }
    }

    public void mostrarMensaje(String message) {
        System.out.println(message);
    }
}