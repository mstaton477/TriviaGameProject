
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class API {
    String _categoryName;
    int _category;

    public static int category(String _categoryName, int _category) {
        if (_categoryName == "General Knowledge") {
            _category = 9;
        }
        if (_categoryName == "Entertainment: Music"){
            _category = 12;
        }
        if (_categoryName == "Entertainment: Video Games")
            _category = 15;
        if (_categoryName == "Science & Nature"){
            _category = 17;
        }
        if (_categoryName == "Science: Computers"){
            _category = 18;
        }
        if (_categoryName == "Science: Mathematics"){
            _category = 19;
        }
        if (_categoryName == "Entertainment: Japanese Anime & Manga"){
            _category = 31;
        }
        return _category;
    }
}
