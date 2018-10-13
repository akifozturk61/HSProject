import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.SpringLayout;

public class HSProject {
//    static ArrayList<String> DeckListsPlayerOne = new ArrayList<>();
////    static ArrayList<String> DeckListsPlayerTwo = new ArrayList<>();
    static String[] DeckListsPlayerOne = new String[5];
    static String[] DeckListsPlayerTwo = new String[5];
    static int tester = 0;

    public static void main(String[] args) {

        //Gui setup
        JFrame frame = new JFrame("Heartstone Deck Loader");
        JPanel panel = new JPanel();
        JButton playerOne = new JButton("Player One");
        JButton playerTwo = new JButton("Player Two");
        JButton test = new JButton(("test"));
        JButton display = new JButton("Display Decks");
        JLabel label = new JLabel();

        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setBackground(Color.gray);

        panel.add(display);
        display.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        boolean checker = false;
                        for (int i = 0; i < DeckListsPlayerOne.length ; i++) {
                            if(DeckListsPlayerOne[i] != null){
                                checker = true;
                            }
                            else {
                                checker = false;
                            }
                        }
                        for (int i = 0; i < DeckListsPlayerTwo.length ; i++) {
                            if(DeckListsPlayerTwo[i] != null){
                                checker = true;
                            }
                            else {
                                checker = false;
                            }
                        }
                        JFrame frameDeckLists = new JFrame("Decklists");
                        frameDeckLists.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        JPanel panel = new JPanel();
                        panel.setLayout(new BorderLayout());
                        if (checker == false){
                            JLabel label = new JLabel("Decks are not fully uploaded yet");
                            panel.add(label, BorderLayout.CENTER);
                            frameDeckLists.add(panel);
                            frameDeckLists.setSize(300,150);
                            frameDeckLists.setLocationRelativeTo(null);
                            frameDeckLists.setVisible(true);
                        } else {
                            JTextArea textOne = new JTextArea();
                            JTextArea textTwo = new JTextArea();
                            textOne.append("Player One Decks: " + System.getProperty("line.separator"));
                            textTwo.append("Player Two Decks: " + System.getProperty("line.separator"));
                            for (String s : DeckListsPlayerOne){
                                textOne.append(s + System.getProperty("line.separator"));
                            }
                            for(String s: DeckListsPlayerTwo){
                                textTwo.append(s + System.getProperty("line.separator"));
                            }
                            panel.add(textOne, BorderLayout.NORTH);
                            panel.add(textTwo, BorderLayout.SOUTH);
                            frameDeckLists.add(panel);
                            frameDeckLists.pack();
                            frameDeckLists.setLocationRelativeTo(null);
                            frameDeckLists.setVisible(true);
                        }
                    }
                });
            }
        });

        //Test to check whats in the arraylists after text input and pressing confirm
        panel.add(test);
        test.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
                        textTwo.append("Player Two Decks: " + System.getProperty("line.separator"));
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
                        frametest.setLocationRelativeTo(null);
                        frametest.setVisible(true);

                    }
                });

            }
        });

        //Both buttons get actionlisteners and executes createInputFrame which creates a new frame

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

                JLabel DeckOne = new JLabel("Deck 1");
                panel.add(DeckOne);
                JTextField textFieldOne = new JTextField(10);
                DeckOne.setLabelFor(textFieldOne);
                panel.add(textFieldOne);
                JButton b1 = new JButton("Confirm");
                b1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(player == 1) {
                            DeckListsPlayerOne[0] = textFieldOne.getText();
                        }
                        else{
                            DeckListsPlayerTwo[0] = textFieldOne.getText();
                        }

                    }
                });
                panel.add(b1);

                JLabel DeckTwo = new JLabel("Deck 2");
                panel.add(DeckTwo);
                JTextField textFieldTwo = new JTextField(10);
                DeckTwo.setLabelFor(textFieldTwo);
                panel.add(textFieldTwo);
                JButton b2 = new JButton("Confirm");
                b2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(player == 1) {
                            DeckListsPlayerOne[1] = textFieldTwo.getText();
                        }
                        else{
                            DeckListsPlayerTwo[1] = textFieldTwo.getText();
                        }

                    }
                });
                panel.add(b2);

                JLabel DeckThree = new JLabel("Deck 3");
                panel.add(DeckThree);
                JTextField textFieldThree = new JTextField(10);
                DeckThree.setLabelFor(textFieldThree);
                panel.add(textFieldThree);
                JButton b3 = new JButton("Confirm");
                b3.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(player == 1) {
                            DeckListsPlayerOne[2] = textFieldThree.getText();
                        }
                        else{
                            DeckListsPlayerTwo[2] = textFieldThree.getText();
                        }

                    }
                });
                panel.add(b3);


                JLabel DeckFour = new JLabel("Deck 4");
                panel.add(DeckFour);
                JTextField textFieldFour = new JTextField(10);
                DeckFour.setLabelFor(textFieldFour);
                panel.add(textFieldFour);
                JButton b4 = new JButton("Confirm");
                b4.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(player == 1) {
                            DeckListsPlayerOne[3] = textFieldFour.getText();
                        }
                        else{
                            DeckListsPlayerTwo[3] = textFieldFour.getText();
                        }

                    }
                });
                panel.add(b4);

                JLabel DeckFive = new JLabel("Deck 5");
                panel.add(DeckFive);
                JTextField textFieldFive = new JTextField(10);
                DeckFive.setLabelFor(textFieldFive);
                panel.add(textFieldFive);
                JButton b5 = new JButton("Confirm");
                b5.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(player == 1) {
                            DeckListsPlayerOne[4] = textFieldFive.getText();
                        }
                        else{
                            DeckListsPlayerTwo[4] = textFieldFive.getText();
                        }

                    }
                });
                panel.add(b5);



                // Create 5 lines of label + input text + confirm button
//                for (int i = 0; i < 5 ; i++) {
//                    JLabel l = new JLabel(("Deck " + (i+1)), JLabel.TRAILING);
//                    panel.add(l);
//                    JTextField textField = new JTextField(10);
//                    l.setLabelFor(textField);
//                    panel.add(textField);
//                    JButton b = new JButton("Confirm");
//                    tester = i;
//
//                    // When the confirm button is pressed the current text in Textfield is being send to the
//                    // Arraylist of desired player. !!! Still have to figure out how to link textfield 1 with arratlist
//                    // index 1. Getting errors when I try .add(i, textField.getText()). !!!
//                    b.addActionListener(new ActionListener() {
//                        @Override
//                        public void actionPerformed(ActionEvent e) {
//                            if(player == 1) {
//                                DeckListsPlayerOne[tester] = textField.getText();
//                            }
//                            else{
//                                DeckListsPlayerTwo[tester] = textField.getText();
//                            }
//
//                        }
//                    });
//                    panel.add(b);
//                }

                // Java provided methods to make the gridlayout
                SpringUtilities.makeCompactGrid(panel,
                        5, 3, //rows, cols
                        6, 6,        //initX, initY
                        6, 6);       //xPad, yPad
                frames.add(panel);
                frames.pack();
                frames.setLocationRelativeTo(null);
                frames.setVisible(true);
            }
        });

    }


}
