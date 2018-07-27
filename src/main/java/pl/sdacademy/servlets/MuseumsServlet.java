package pl.sdacademy.servlets;

import pl.sdacademy.model.Museum;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

@WebServlet(name = "MuseumsServlet", value = "/museums")
public class MuseumsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String searchBy = request.getParameter("searchBy");
        String searchValue = request.getParameter("searchValue");

        Connection connection = null;
        PreparedStatement select = null;
        ResultSet results = null;
        ArrayList<Museum> museums = new ArrayList<>();

        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:///home/robert-dell/museumSQLite.db");
            String sql = "SELECT * FROM museum WHERE " + searchBy + " LIKE " + "'%" + searchValue + "%' COLLATE NOCASE;";
            System.out.println(sql);
            select = connection.prepareStatement(sql);
            results = select.executeQuery();

            while (results.next()) {
                String id = results.getString(1);
                String name = results.getString(2);
                String postalCode = results.getString(3);
                String city = results.getString(4);
                String streetPrefix = results.getString(5);
                String street = results.getString(6);
                String houseNumber = results.getString(7);
                String flatNumber = results.getString(8);
                String organizer = results.getString(9);
                String entryDate = results.getString(10);
                String status = results.getString(11);

                Museum museum = new Museum(id,
                        name,
                        postalCode,
                        city,
                        streetPrefix,
                        street,
                        houseNumber,
                        flatNumber,
                        organizer,
                        entryDate,
                        status);
                museums.add(museum);
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

        request.setAttribute("museums", museums);
        request.getRequestDispatcher("museums/museums.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("museums/museums.jsp");
    }
}
