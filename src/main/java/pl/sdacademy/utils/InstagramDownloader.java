package pl.sdacademy.utils;

import org.json.JSONArray;
import org.json.JSONObject;
import pl.sdacademy.model.Image;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.LinkedList;

public class InstagramDownloader {

    private String user;
    private int numberOfImages;
    private LinkedList<Image> images;
    private StringBuilder responseBuilder;

    private HttpURLConnection connection;
    private PrintWriter writer;
    private BufferedReader reader;

    public InstagramDownloader(String user, int number) {
        this.user = user;
        this.numberOfImages = number;
        this.images = new LinkedList<>();
        this.responseBuilder = new StringBuilder();
    }

    public void connectToInstagram() throws IOException {
        URL url = new URL("https://www.instagram.com/" + this.user + "/");
        connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        String line = "";
        while ((line = reader.readLine()) != null) {
            responseBuilder.append(line);
        }
    }

    public LinkedList<Image> getUserImages() {
        int currentImageCount = 0;
        String response = responseBuilder.toString();
        String fromScriptTag = response.split("window._sharedData =")[1];
        String pageSource = fromScriptTag.split(";</script>")[0];

        JSONObject mainJson = new JSONObject(pageSource);
        JSONArray edges = mainJson.getJSONObject("entry_data")
                .getJSONArray("ProfilePage")
                .getJSONObject(0)
                .getJSONObject("graphql")
                .getJSONObject("user")
                .getJSONObject("edge_owner_to_timeline_media")
                .getJSONArray("edges");

        for (int i = 0; i < edges.length(); i++) {
            JSONObject jsonObject = edges.getJSONObject(i);
            String link = jsonObject.getJSONObject("node")
                    .getString("display_url");
            currentImageCount++;
            if (currentImageCount <= numberOfImages) {
                Image image = new Image(link, user + currentImageCount);
                images.add(image);
            }
        }
        return images;
    }
}
