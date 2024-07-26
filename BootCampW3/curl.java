import java.net.*;
import java.io.*;
import java.security.cert.Certificate;
import java.io.*;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;
public class curl {
    public static void main(String[] args) throws MalformedURLException, IOException {
       URL url = new URL("https://api.spotify.com/v1/search");
    HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
    conn.setRequestMethod("POST");

    conn.setDoOutput(true);
    conn.setDoInput(true);

    conn.setRequestProperty("User-Agent", "Mozilla/5.0");
    conn.setRequestProperty("Authorization", "Basic MDg4ZDc=");
    conn.setRequestProperty("Content-Type","application/x-www-form-urlencoded");    }
}