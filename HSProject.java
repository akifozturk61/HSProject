import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.SpringLayout;

public class HSProject {
    static ArrayList<String> DeckListsPlayerOne = new ArrayList<>();
    static ArrayList<String> DeckListsPlayerTwo = new ArrayList<>();

    public static void main(String[] args) {

        //Gui setup
        JFrame frame = new JFrame("Heartstone Deck Loader");
        JPanel panel = new JPanel();
        JButton playerOne = new JButton("Player One");
        JButton playerTwo = new JButton("Player Two");
        JButton test = new JButton(("test"));
        JLabel label = new JLabel();

        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Test to check whats in the arraylists after text input and pressing confirm
        panel.add(test);
        test.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                for (int i = 0; i < DeckListsPlayerOne.size() ; i++) {
//                    System.out.println("This is player 1 decks: ");
//                    System.out.println(DeckListsPlayerOne.get(i));
//                }
//                for (int i = 0; i < DeckListsPlayerTwo.size() ; i++) {
//                    System.out.println("This is player 2 decks: ");
//                    System.out.println(DeckListsPlayerTwo.get(i));
//
//                }
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        JFrame frametest = new JFrame("Test");
                        frametest.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        JPanel panel = new JPanel();
                        panel.setLayout(new BorderLayout());
                        JTextArea textOne = new JTextArea();
                        JTextArea textTwo = new JTextArea();
                        textOne.append("Player One Decks: " + System.getProperty("line.separator"));
                        textTwo.append("Player One Decks: " + System.getProperty("line.separator"));
                        for (String s : DeckListsPlayerOne){
                            textOne.append(s + System.getProperty("line.separator"));
                        }
                        for(String s: DeckListsPlayerTwo){
                            textTwo.append(s + System.getProperty("line.separator"));
                        }
                        panel.add(textOne, BorderLayout.NORTH);
                        panel.add(textTwo, BorderLayout.SOUTH);
                        frametest.add(panel);
                        frametest.pack();
                        frametest.setLocationByPlatform(true);
                        frametest.setVisible(true);

                    }
                });

            }
        });

        //Both buttons get actionlisteners and executes createInputFrame which creates a new frame
        panel.setBackground(Color.gray);
        panel.add(playerOne);
        playerOne.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createInputFrame(1);
            }
        });
        panel.add(playerTwo);
        playerTwo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createInputFrame(2);
            }
        });
        frame.add(panel);
    }


    public static void createInputFrame(int player){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                //Basic setup
                JFrame frames = new JFrame("Player" + player );
                frames.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                JPanel panel = new JPanel();
                panel.setLayout(new SpringLayout());

                // Create 5 lines of label + input text + confirm button
                for (int i = 0; i < 5 ; i++) {
                    JLabel l = new JLabel(("Deck " + (i+1)), JLabel.TRAILING);
                    panel.add(l);
                    JTextField textField = new JTextField(10);
                    l.setLabelFor(textField);
                    panel.add(textField);
                    JButton b = new JButton("Confirm");

                    // When the confirm button is pressed the current text in Textfield is being send to the
                    // Arraylist of desired player. !!! Still have to figure out how to link textfield 1 with arratlist
                    // index 1. Getting errors when I try .add(i, textField.getText()). !!!
                    b.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if(player == 1) {
                                DeckListsPlayerOne.add(textField.getText());
                            }
                            else{
                                DeckListsPlayerTwo.add(textField.getText());
                            }

                        }
                    });
                    panel.add(b);
                }

                // Java provided methods to make the gridlayout
                SpringUtilities.makeCompactGrid(panel,
                        5, 3, //rows, cols
                        6, 6,        //initX, initY
                        6, 6);       //xPad, yPad
                frames.add(panel);
                frames.pack();
                frames.setLocationByPlatform(true);
                frames.setVisible(true);
            }
        });

    }


}
