package pl.sdacademy.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(name = "AddPersonServlet", value = "/addPerson")
public class AddPersonServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String yearFromField = request.getParameter("year");
        int year = Integer.parseInt(yearFromField);
        String phoneFromField = request.getParameter("phone");
        int phone = Integer.parseInt(phoneFromField);

        String sex = request.getParameter("sex");

        Connection connection = null;
        PreparedStatement insert = null;
        try {
            Class.forName("org.sqlite.JDBC");

            // podlaczenie do bazy danych SQLite znajdujacej sie na dysku E w pliku peopleDatabase.db
            connection = DriverManager.getConnection("jdbc:sqlite://E:/peopleDatabase.db");

            // przygotowanie zapytania SQL typu INSERT - dodanie rekordu do tabeli people
            insert = connection.prepareStatement("INSERT INTO people VALUES(?,?,?,?,?);");

            // ustawienie odpowiednich elementow zapytania z utworzonego obiektu Person
            insert.setString(1, name);
            insert.setString(2, surname);
            insert.setInt(3, year);
            insert.setInt(4, phone);
            insert.setString(5, sex);

            // wykonanie polecenia INSERT
            insert.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                insert.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        // przekierowanie po stronie serwera do strony addPerson.jsp,
        // aby po dodaniu kolejnej osoby mozna dodac nastepna osobe (wyswietlenie ponowne formularza)
        request.getRequestDispatcher("persons/addPerson.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("persons/addPerson.jsp");
    }
}
