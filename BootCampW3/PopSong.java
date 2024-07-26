import java.util.*;
import java.io.*;
public class PopSong {

    static ArrayList<String> songTitle = new ArrayList<>();
    static ArrayList<String> duration = new ArrayList<>();
    static ArrayList<String> artist = new ArrayList<>();
    static ArrayList<String> kbps = new ArrayList<>();
    static ArrayList<String> album = new ArrayList<>();
    static ArrayList<String> genre = new ArrayList<>();
    static ArrayList<String> year = new ArrayList<>();
    static String output, out;


    public PopSong() throws IOException {
        DB();
    }

    public static void DB() throws IOException {
        String[] split;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("music.csv")))) {
            for (String line;
                (line = reader.readLine()) != null;) {
                split = line.split(",");
                songTitle.add(split[0]);
                duration.add(split[1]);
                artist.add(split[2]);
                kbps.add(split[3]);
                album.add(split[4]);
                try {
                    genre.add(split[5]);
                } catch (IndexOutOfBoundsException e) {
                    genre.add("N/A");
                }
                if (split.length == 7)
                    year.add(split[6]);
                else year.add("N/A");
            }
        }
    }
    public static void getArtist(String artistName) throws IOException {
        out = "";
        for (int i = 0; i < artist.size(); i++) {
            if (artist.get(i).toLowerCase().contains(artistName.toLowerCase())) {
                output = artist.get(i) + "," + album.get(i) + "," + songTitle.get(i) + "," + duration.get(i) + "," + kbps.get(i) + "," + genre.get(i) + "," + year.get(i) + "\n";
                out += output;
            }
        }
    }
    public static void getAlbum(String albumName) throws IOException {
        out = "";
        for (int i = 0; i < album.size(); i++) {
            if (album.get(i).toLowerCase().contains(albumName.toLowerCase())) {
                output = artist.get(i) + "," + album.get(i) + "," + songTitle.get(i) + "," + duration.get(i) + "," + kbps.get(i) + "," + genre.get(i) + "," + year.get(i) + "\n";
                out += output;
            }
        }
    }
    public static void getYear(String albumYear) throws IOException {
        out = "";
        for (int i = 0; i < year.size(); i++) {
            if (year.get(i).equalsIgnoreCase(albumYear)) {
                output = artist.get(i) + "," + album.get(i) + "," + songTitle.get(i) + "," + duration.get(i) + "," + kbps.get(i) + "," + genre.get(i) + "," + year.get(i) + "\n";
                out += output;
            }
        }
    }
    public static void getGenre(String albumGenre) throws IOException {
        out = "";
        for (int i = 0; i < genre.size(); i++) {
            if (genre.get(i).toLowerCase().contains(albumGenre.toLowerCase())) {
                output = artist.get(i) + "," + album.get(i) + "," + songTitle.get(i) + "," + duration.get(i) + "," + kbps.get(i) + "," + genre.get(i) + "," + year.get(i) + "\n";
                out += output;
            }
        }
    }
    public static void getDuration(String songDuration) throws IOException {
        out = "";
        for (int i = 0; i < duration.size(); i++) {
            if (duration.get(i).equalsIgnoreCase(songDuration)) {
                output = artist.get(i) + "," + album.get(i) + "," + songTitle.get(i) + "," + duration.get(i) + "," + kbps.get(i) + "," + genre.get(i) + "," + year.get(i) + "\n";
                out += output;
            }
        }
    }
    public static void getBitrate(String songBitrate) throws IOException {
        out = "";
        for (int i = 0; i < duration.size(); i++) {
            if (kbps.get(i).toLowerCase().contains(songBitrate.toLowerCase())) {
                output = artist.get(i) + "," + album.get(i) + "," + songTitle.get(i) + "," + duration.get(i) + "," + kbps.get(i) + "," + genre.get(i) + "," + year.get(i) + "\n";
                out += output;
            }
        }
    }
    public static void getTitle(String title) throws IOException {
        out = "";
        for (int i = 0; i < songTitle.size(); i++) {
            if (songTitle.get(i).toLowerCase().contains(title.toLowerCase())) {
                output = artist.get(i) + "," + album.get(i) + "," + songTitle.get(i) + "," + duration.get(i) + "," + kbps.get(i) + "," + genre.get(i) + "," + year.get(i) + "\n";
                out += output;
            }
        }
    }
    public String toString() {
        return out;
    }
}