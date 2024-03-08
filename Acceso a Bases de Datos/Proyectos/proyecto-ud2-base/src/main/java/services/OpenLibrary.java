package services;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.net.URI;
import java.nio.charset.Charset;
import java.util.ArrayList;
import model.entity.Book;
import org.apache.commons.io.IOUtils;

public class OpenLibrary {
    public static ArrayList<Book> getTrending() throws Exception {
        URI url = URI.create("https://openlibrary.org/trending/now.json");
        String jsonString = IOUtils.toString(url, Charset.forName("UTF-8"));
        JsonObject jsonObject = JsonParser.parseString(jsonString).getAsJsonObject();
        JsonArray books = jsonObject.getAsJsonArray("works");
        ArrayList<Book> booksList = new ArrayList<>();
        for (JsonElement bookElement : books) {
            try {
                JsonObject book = bookElement.getAsJsonObject();
                String title = book.get("title").getAsString();
                String author = book.get("author_name").getAsJsonArray().get(0).getAsString();
                booksList.add(new Book(title, author));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return booksList;
    }
}

