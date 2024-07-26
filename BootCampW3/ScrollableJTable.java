import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import java.awt.BorderLayout;
import java.awt.Dimension;

public class ScrollableJTable extends JPanel {
 public ScrollableJTable(String s) {
         JPanel panel = new ScrollableJTable();

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("Song List");
        frame.setContentPane(panel);
        frame.pack();
        frame.setVisible(true);
        }
    public ScrollableJTable() {
         setLayout(new BorderLayout());
        setPreferredSize(new Dimension(500, 250));

        JTable table = new JTable(10,6);


        // Turn off JTable's auto resize so that JScrollPane will show a horizontal
        // scroll bar.
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        JScrollPane pane = new JScrollPane(table);
        add(pane, BorderLayout.CENTER);
    }
}

