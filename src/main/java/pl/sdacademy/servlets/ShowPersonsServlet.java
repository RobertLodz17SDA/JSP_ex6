package pl.sdacademy.servlets;

import pl.sdacademy.model.Person;
import pl.sdacademy.model.enums.Sex;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

@WebServlet(name = "ShowPersonsServlet", value = "/showPersons")
public class ShowPersonsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection connection = null;
        PreparedStatement select = null;
        ResultSet results = null;

        ArrayList<Person> people = new ArrayList<>();

        try {
            // Inicjalizacja sterownika JDBC do bazy danych SQLite
            Class.forName("org.sqlite.JDBC");

            // podlaczenie do bazy danych SQLite znajdujacej sie na dysku E w pliku peopleDatabase.db
            connection = DriverManager.getConnection("jdbc:sqlite://E:/peopleDatabase.db");

            // przygotowanie zapytania SQL typu SELECT - pobranie wszystkich rekordow z tabeli people
            select = connection.prepareStatement("SELECT * FROM people;");

            // wykonanie polecenia SQL SELECT i przypisanie do obiektu typu ResultSet,
            // ktory przechowuje zwrocone rekordy
            results = select.executeQuery();

            while (results.next()) {
                String name = results.getString(1);
                String lastName = results.getString(2);
                int year = results.getInt(3);
                int phone = results.getInt(4);
                String sexString = results.getString(5);
                Sex sex = null;
                if (sexString.equals("MALE")) {
                    sex = Sex.MALE;
                } else if (sexString.equals("FEMALE")) {
                    sex = Sex.FEMALE;
                }
                Person person = new Person(name, lastName, year, phone, sex);
                people.add(person);
            }

        } catch (SQLException | ClassNotFoundException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                results.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        request.setAttribute("people", people);
        request.getRequestDispatcher("persons/showPersons.jsp").forward(request, response);
    }
}
