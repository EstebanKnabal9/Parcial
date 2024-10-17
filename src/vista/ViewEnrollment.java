package vista;

import interfaces.IMostrarMensaje;
import modelo.Enrollment;

import java.util.List;

public class ViewEnrollment implements IMostrarMensaje {

    public void displayListEnrollment(List<Enrollment> enrollments) {
        System.out.println(" == Lista de Matrículas == ");
        for (Enrollment enrollment : enrollments) {
            System.out.println("Id Matrícula: " + enrollment.getId() + ", Estudiante ID: " + enrollment.getStudent_id() + ", Curso ID: " + enrollment.getCourse_id());
        }
    }
}
