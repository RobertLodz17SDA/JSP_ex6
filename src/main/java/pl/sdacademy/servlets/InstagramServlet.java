package pl.sdacademy.servlets;

import pl.sdacademy.model.Gallery;
import pl.sdacademy.utils.InstagramDownloader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "InstagramServlet", value = "/instagram")
public class InstagramServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("user");
        String number = request.getParameter("number");
        int intNumber = Integer.parseInt(number);

        InstagramDownloader instagramDownloader = new InstagramDownloader(user, intNumber);
        instagramDownloader.connectToInstagram();

        Gallery instagramGallery = new Gallery("Instagram photos by: " + user);
        instagramGallery.setImages(instagramDownloader.getUserImages());

        request.setAttribute("instagramGallery", instagramGallery);
        request.getRequestDispatcher("instagram.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("instagram.jsp");
    }
}
