package pl.sdacademy.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

@WebServlet(name = "MuseumsAdderServlet", value = "/add")
public class MuseumsAdderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //request.setCharacterEncoding("UTF-8");
        File file = new File("/home/robert-dell/museums.csv");
        FileReader reader = new FileReader(file);
        Scanner scanner = new Scanner(reader);

        Connection connection = null;
        PreparedStatement insert = null;

        String headers = scanner.nextLine();
        int count = 1;

        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:///home/robert-dell/museumSQLite.db");
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] columns = line.split(";");
                insert = connection.prepareStatement("INSERT INTO museums VALUES(?,?,?,?,?,?,?,?,?,?,?);");
                insert.setString(1, columns[0]); // id
                insert.setString(2, columns[1]); // name
                insert.setString(3, columns[2]); // postalCode
                insert.setString(4, columns[3]); // city
                insert.setString(5, columns[4]); // streetPrefix
                insert.setString(6, columns[5]); // street
                insert.setString(7, columns[6]); // houseNumber
                insert.setString(8, columns[7]); // flatNumber
                insert.setString(9, columns[8]); // organizer
                insert.setString(10, columns[9]); // entryDate
                insert.setString(11, columns[10]); // status
                insert.executeUpdate();
                System.out.println("ADDED next row (" + count + "/676): " + columns);
                count++;
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
