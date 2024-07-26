import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

class driver extends JFrame {
    
    // JFrame
    static JFrame f;
    static JTextField t1;
    static JRadioButton b, b1, b2, b3, b4, b5, b6;
    static JButton s;
    
    // Main class
    public static void main(String[] args) throws IOException {
    
        //JPanel
        JPanel p = new JPanel();
        FlowLayout flow = new FlowLayout();
        p.setLayout(flow);
        p.setBackground(Color.gray);
        
        //JFrame
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setTitle("PopSong");
        f.setContentPane(p);
        f.setVisible(true);
        f.setSize(470, 545);
        f.setResizable(false);
        
        //JTable
        DefaultTableModel tableModel = new DefaultTableModel();
        JTable table = new JTable(tableModel);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        
        //Add columns
        tableModel.addColumn("Artist");
        tableModel.addColumn("Album");
        tableModel.addColumn("Title");
        tableModel.addColumn("Duration");
        tableModel.addColumn("Bitrate");
        tableModel.addColumn("Genre");
        tableModel.addColumn("Year");
        
        //Text field, Radio buttons, search button
        t1 = new JTextField(25);
        b = new JRadioButton("artist");
        b1 = new JRadioButton("album");
        b2 = new JRadioButton("title");
        b3 = new JRadioButton("duration");
        b4 = new JRadioButton("bitrate");
        b5 = new JRadioButton("genre");
        b6 = new JRadioButton("year");
        s = new JButton("search");

        //Add elements to JPanel
        p.add(t1);
        p.add(b);
        p.add(b1);
        p.add(b2);
        p.add(b3);
        p.add(b4);
        p.add(b5);
        p.add(b6);
        p.add(s);
        p.add(new JScrollPane(table));
        
        //Add radio buttons to group
        ButtonGroup group = new ButtonGroup();
        group.add(b);
        group.add(b1);
        group.add(b2);
        group.add(b3);
        group.add(b4);
        group.add(b5);
        group.add(b6);
        
        //Show JFrame
        f.show();
        
        //When search button is pressed
        s.addActionListener(new ActionListener() {
            PopSong p = new PopSong();
            public void actionPerformed(ActionEvent e) {
                if (b.isSelected()) { //if artist is selected
                    try {
                        p.getArtist(t1.getText());
                    } catch (IOException ex) {}
                } else if (b1.isSelected()) { //if album is selected
                    try {
                        p.getAlbum(t1.getText());
                    } catch (IOException ex) {}
                } else if (b2.isSelected()) { //if title is selected
                    try {
                        p.getTitle(t1.getText());
                    } catch (IOException ex) {}
                } else if (b3.isSelected()) { //if duration is selected
                    try {
                        p.getDuration(t1.getText());
                    } catch (IOException ex) {}
                } else if (b4.isSelected()) { //if bitrate is selected
                    try {
                        p.getBitrate(t1.getText());
                    } catch (IOException ex) {}
                } else if (b5.isSelected()) { //if genre is selected
                    try {
                        p.getGenre(t1.getText());
                    } catch (IOException ex) {}
                } else if (b6.isSelected()) { //if year is selected
                    try {
                        p.getYear(t1.getText());
                    } catch (IOException ex) {}
                }
                tableModel.setRowCount(0); //reset table
                String[] split; //declare split array
                String line; //declare line string
                String a = p.toString(); //get data returned from PopSong();
                Scanner scan = new Scanner(a); //scan data
                scan.useLocale(Locale.US);
                while (scan.hasNextLine()) {
                    line = scan.nextLine();
                    split = line.split(",");
                    tableModel.insertRow(0, new Object[] { //insert data into table
                        split[0], split[1], split[2], split[3], split[4], split[5], split[6]
                    });

                }
            }

        });

    }
}