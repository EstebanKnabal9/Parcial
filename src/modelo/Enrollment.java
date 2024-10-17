package modelo;

import db.connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Enrollment {
    private int id;
    private String student_id;
    private String course_id;

    public Enrollment(int id, String student_id, String course_id) {
        this.id = id;
        this.student_id = student_id;
        this.course_id = course_id;
    }

    public int getId() { return id; }

    public String getStudent_id() { return student_id; }

    public String getCourse_id() { return course_id; }

    public static void insertEnrollment(Enrollment enrollment) {
        Connection con = connection.getConnection();
        String sql = "INSERT INTO enrollment (id, student_id, course_id) VALUES (?, ?, ?)";

        try (PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setInt(1, enrollment.getId());
            statement.setString(2, enrollment.getStudent_id());
            statement.setString(3, enrollment.getCourse_id());

            statement.executeUpdate();
            System.out.println("Inscripción guardada correctamente!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Enrollment> getAllEnrollment() {
        Connection con = connection.getConnection();
        List<Enrollment> enrollments = new ArrayList<>();

        String sql = "SELECT * FROM enrollment";

        try (PreparedStatement statement = con.prepareStatement(sql)) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Enrollment enrollment = new Enrollment(
                        rs.getInt("id"),
                        rs.getString("student_id"),
                        rs.getString("course_id")
                );
                enrollments.add(enrollment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return enrollments;
    }
}
