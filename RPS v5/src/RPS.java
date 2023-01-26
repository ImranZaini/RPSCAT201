import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Random;

public class RPS implements ActionListener {

    JFrame frame;              // components declaration
    JFrame frame2;
    JPanel panel;
    JButton buttonR;
    JButton buttonP;
    JButton buttonS;
    JLabel title;
    JLabel comChoice;
    JLabel result;
    ImageIcon img;
    JLabel image;
    JTextField name;
    JButton buttonL;

    int userPoints = 0;
    int compPoints = 0;
    String userInput;
    String rand1;


    JLabel ps;
    JLabel cs;


    public RPS() {
        frame = new JFrame();                                            // components definition
        frame2 = new JFrame();
        panel = new JPanel(new GridBagLayout());
        buttonR = new JButton("ROCK");
        buttonP = new JButton("PAPER");
        buttonS = new JButton("SCISSORS");
        buttonL = new JButton("Leaderboard Table");
        title = new JLabel("ROCK vs PAPER vs SCISSORS");
        ps = new JLabel("Player Score : 0");
        cs = new JLabel("Computer Score : 0");
        comChoice = new JLabel("Computer choice : ");
        result = new JLabel("");
        name = new JTextField("Enter your name");
        name.setPreferredSize(new Dimension(250, 40));


        GridBagConstraints c = new GridBagConstraints();             //ADDING THE COMPONENTS
        c.insets = new Insets(30, 30, 30, 30);
        c.gridx = 3;
        c.gridy = 0;
        title.setFont(new Font("Rockwell Condensed", Font.BOLD, 40));
        panel.add(title, c);
        c.gridx = 3;
        c.gridy = 1;
        panel.add(result, c);
        c.gridx = 3;
        c.gridy = 1;
        panel.add(name, c);
        c.insets = new Insets(10, 10, 10, 10);
        c.gridx = 4;
        c.gridy = 2;
        panel.add(buttonR, c);
        c.gridx = 3;
        c.gridy = 2;
        panel.add(buttonP, c);
        c.gridx = 2;
        c.gridy = 2;
        panel.add(buttonS, c);
        c.gridx = 2;
        c.gridy = 1;
        panel.add(buttonL, c);
        c.insets = new Insets(15, 15, 15, 15);
        c.gridx = 2;
        c.gridy = 3;
        panel.add(ps, c);
        c.gridx = 4;
        c.gridy = 3;
        panel.add(cs, c);
        c.insets = new Insets(15, 15, 15, 15);
        c.gridx = 3;
        c.gridy = 3;
        panel.add(comChoice, c);


        buttonR.addActionListener(this);    // button action addition
        buttonP.addActionListener(this);
        buttonS.addActionListener(this);
        buttonL.addActionListener(this);


        frame.add(panel, BorderLayout.CENTER);                        // main page setup
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(540, 399);
        frame.setTitle("Rock Paper Scissors");
        frame.pack();
        frame.setVisible(true);


    }


    public static void main(String[] args) {          // execution code
        new RPS();


    }


    private String computerChoice() {        // randomizing computer choice
        Random rand = new Random();
        String compGuess[] = {"ROCK", "PAPER", "SCISSORS"};
        String rand1 = compGuess[rand.nextInt(3)];
        comChoice.setText("Computer choice : " + rand1);
        return rand1;
    }

    @Override
    public void actionPerformed(ActionEvent e) {               // button action and logic
        if (e.getSource() == buttonR) {
            userInput = "ROCK";
            computerChoice();
            rand1 = computerChoice();
            compare();
            name.setVisible(false);

        }
        if (e.getSource() == buttonP) {
            userInput = "PAPER";
            computerChoice();
            rand1 = computerChoice();
            compare();
            name.setVisible(false);

        }
        if (e.getSource() == buttonS) {
            userInput = "SCISSORS";
            rand1 = computerChoice();
            compare();
            name.setVisible(false);

        }
        if (e.getSource() == buttonL){
            table();
        }
    }

    private void compare() {
        if (userInput.contains("ROCK")) {
            if (rand1 == "PAPER") {

                compPoints++;
                cs.setText("Computer Score : " + Integer.toString(compPoints));
                ps.setText(name.getText() + "'s Score : " + Integer.toString(userPoints));
                result.setText("YOU LOSE !");


            } else if (rand1 == "SCISSORS") {

                userPoints++;
                ps.setText(name.getText() + "'s Score : " + Integer.toString(userPoints));
                result.setText("YOU WIN !");


            } else {
                result.setText("IT'S A DRAW !");
            }

        } else if (userInput.contains("PAPER")) {
            if (rand1 == "ROCK") {

                userPoints++;
                ps.setText(name.getText() + "'s Score : " + Integer.toString(userPoints));

                result.setText("YOU WIN !");

            } else if (rand1 == "SCISSORS") {

                compPoints++;
                cs.setText("Computer Score : " + Integer.toString(compPoints));
                ps.setText(name.getText() + "'s Score : " + Integer.toString(userPoints));
                result.setText("YOU LOSE !");


            } else {
                result.setText("IT'S A DRAW !");
            }

        } else if (userInput.contains("SCISSORS")) {
            if (rand1 == "PAPER") {

                userPoints++;
                ps.setText(name.getText() + "'s Score : " + Integer.toString(userPoints));
                result.setText("YOU WIN !");


            } else if (rand1 == "ROCK") {

                compPoints++;
                cs.setText("Computer Score : " + Integer.toString(compPoints));
                ps.setText(name.getText() + "'s Score : " + Integer.toString(userPoints));
                result.setText("YOU LOSE !");
            } else {
                result.setText("IT'S A DRAW !");
                ps.setText(name.getText() + "'s Score : " + Integer.toString(userPoints));
            }

        } else {
            result.setText("IT'S A DRAW !");
        }


    }

    private void table() {
         int n = 100;
         int m = 3;

            JFrame frame = new JFrame("Leaderboard Table");
            JPanel panel = new JPanel();

            String[] columnNames = {"Names", "Player Points", "Computer Points"};

            Object[][] data =
                    {
                            {"Player Name", "Player Points", "Computer Points"},
                            {"Firas", new Integer(5), new Integer(3)},
                            {"Azrie", new Integer(3), new Integer(2)},
                            {"Naqib", new Integer(2), new Integer(5)},
                            {"Imran", new Integer(20), new Integer(2)},
                            {"Azrie", new Integer(10), new Integer(6)},
                            {name.getText(), userPoints, compPoints}
                    };
        JTable table = new JTable(data,columnNames);

        panel.add(new JScrollPane(table));
        frame.add(table);
        frame.setSize(400,200);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}
