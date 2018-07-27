package pl.sdacademy.servlets;

import pl.sdacademy.model.Person;
import pl.sdacademy.model.enums.Sex;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

@WebServlet(name = "RegistrationServlet", value = "/rejestracja")
public class RegistrationServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        Boolean userIdentified = false;

        Connection connection = null;
        PreparedStatement select = null;
        ResultSet results = null;

        try {
            // Inicjalizacja sterownika JDBC do bazy danych SQLite
            Class.forName("org.sqlite.JDBC");

            // podlaczenie do bazy danych SQLite znajdujacej sie na dysku E w pliku peopleDatabase.db
            connection = DriverManager.getConnection("jdbc:sqlite:/home/robert-dell/peoplePWDDatabase.db");

            // przygotowanie zapytania SQL typu SELECT - pobranie wszystkich rekordow z tabeli people
            select = connection.prepareStatement("INSERT INTO peoplePWD VALUES (?,?);");
            select.setString(1,login);
            select.setString(2,password);

            // wykonanie polecenia SQL SELECT i przypisanie do obiektu typu ResultSet,
            // ktory przechowuje zwrocone rekordy
            select.executeUpdate();

        } catch (SQLException | ClassNotFoundException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                select.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
            HttpSession session = request.getSession();
            session.setMaxInactiveInterval(60);
            session.setAttribute("name",login);
            response.sendRedirect("/index.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/login/rejestracja.jsp");
    }
}
