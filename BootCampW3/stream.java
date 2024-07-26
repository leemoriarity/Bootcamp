import java.net.*;
import java.io.*;
import java.util.*;
public class stream {
    public static void main(String[] args) throws MalformedURLException, IOException {
    
        ArrayList<String> songTitle = new ArrayList<>();
        ArrayList<String> songDuration = new ArrayList<>();
        ArrayList<String> artist = new ArrayList<>();
        ArrayList<String> kbps = new ArrayList<>();
        ArrayList<String> album = new ArrayList<>();
        ArrayList<String> genre = new ArrayList<>();
        
        String[] split;
        
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("PopSongs.csv")))) {
            for (String line; (line = reader.readLine()) != null;) {
               System.out.println(line);
                split = line.split(",");
                songTitle.add(split[0]);
                songDuration.add(split[1]);
                artist.add(split[2]);
                kbps.add(split[3]);
                album.add(split[4]);
                if (split.length == 6)
                genre.add(split[5]);
                
            }
        }
                        System.out.println( artist.get(101) + " - " + songTitle.get(101) + " - " + album.get(101) + "geenre: " + genre.get(100));
    }
}