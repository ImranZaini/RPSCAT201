import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.util.Random;

public class RPS implements ActionListener {

    JFrame frame;
    JPanel panel;
    JButton buttonR;
    JButton buttonP;
    JButton buttonS;
    JLabel title;
    JLabel comChoice;
    JLabel result;

    int userPoints = 0;
    int compPoints = 0;
    String userInput;
    String rand1;



    JLabel ps;
    JLabel cs;


    public RPS() {
        frame = new JFrame();
        panel = new JPanel(new GridBagLayout());
        buttonR = new JButton("ROCK");
        buttonP = new JButton("PAPER");
        buttonS = new JButton("SCISSORS");
        title = new JLabel("ROCK vs PAPER vs SCISSORS");
        ps = new JLabel("Player Score : 0");
        cs = new JLabel("Computer Score : 0");
        comChoice = new JLabel("Computer choice : " );
        result = new JLabel("");



//        panel.setBorder(BorderFactory.createEmptyBorder(100,100,100,100));
//        panel.setLayout(new GridLayout(0, 1));


        GridBagConstraints c = new GridBagConstraints();             //ADDING THE COMPONENTS
        c.insets = new Insets(30, 30, 30, 30);
        c.gridx = 3;
        c.gridy = 0;
        title.setFont(new Font("Rockwell Condensed", Font.BOLD, 40));
        panel.add(title, c);
        c.gridx = 3;
        c.gridy = 1;
        panel.add(result, c);
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


//        buttonR.addActionListener(new ActionListener()
//        {
//            @Override
//            public void actionPerformed(ActionEvent e)
//            {
//                userInput = "ROCK";
//                Random rand = new Random();
//                String compGuess[] = {"ROCK", "PAPER", "SCISSORS"};
//                Scanner input = new Scanner(System.in);
//                String rand1 = compGuess[rand.nextInt(3)];
//                comChoice = new JLabel("Computer choice : "+ rand1);
//
//
//            }
//        });
//        buttonP.addActionListener(new ActionListener()
//        {
//            @Override
//            public void actionPerformed(ActionEvent e)
//            {
//                userInput = "PAPER";
//                Random rand = new Random();
//                String compGuess[] = {"ROCK", "PAPER", "SCISSORS"};
//                Scanner input = new Scanner(System.in);
//                String rand1 = compGuess[rand.nextInt(3)];
//                comChoice = new JLabel("Computer choice : "+ rand1);
//
//            }
//        });
//        buttonS.addActionListener(new ActionListener()
//        {
//            @Override
//            public void actionPerformed(ActionEvent e)
//            {
//                userInput = "SCISSORS";
//                Random rand = new Random();
//                String compGuess[] = {"ROCK", "PAPER", "SCISSORS"};
//                Scanner input = new Scanner(System.in);
//                String rand1 = compGuess[rand.nextInt(3)];
//                comChoice = new JLabel("Computer choice : "+ rand1);
//
//            }
//        });


//        Random rand = new Random();
//        String compGuess[] = {"ROCK", "PAPER", "SCISSORS"};
//        Scanner input = new Scanner(System.in);
//        String rand1 = compGuess[rand.nextInt(3)];
//        comChoice = new JLabel("Computer choice : "+ rand1);

//        c.insets = new Insets(15,15,15,15);
//        c.gridx = 3;
//        c.gridy = 3;
//        panel.add(comChoice, c);

        buttonR.addActionListener(this);
        buttonP.addActionListener(this);
        buttonS.addActionListener(this);


        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Rock Paper Scissors");
        frame.pack();
        frame.setVisible(true);



    }


    public static void main(String[] args) {
        new RPS();


    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonR) {
            userInput = "ROCK";
            Random rand = new Random();
            String compGuess[] = {"ROCK", "PAPER", "SCISSORS"};
            Scanner input = new Scanner(System.in);
            rand1 = compGuess[rand.nextInt(3)];
            comChoice.setText("Computer choice : "+ rand1);
            compare();

        }
        if (e.getSource() == buttonP) {
            userInput = "PAPER";
            Random rand = new Random();
            String compGuess[] = {"ROCK", "PAPER", "SCISSORS"};
            Scanner input = new Scanner(System.in);
            rand1 = compGuess[rand.nextInt(3)];
            comChoice.setText("Computer choice : "+ rand1);
            compare();
        }
        if (e.getSource() == buttonS) {

            userInput = "SCISSORS";
            Random rand = new Random();
            String compGuess[] = {"ROCK", "PAPER", "SCISSORS"};
            Scanner input = new Scanner(System.in);
            rand1 = compGuess[rand.nextInt(3)];
            System.out.println(rand1);

            System.out.println("succes");
            System.out.println(userInput);

            comChoice.setText("Computer choice : "+ rand1);
            compare();







        }

//        Random rand = new Random();
//        String compGuess[] = {"ROCK", "PAPER", "SCISSORS"};
//        Scanner input = new Scanner(System.in);
//        String rand1 = compGuess[rand.nextInt(3)];
//        comChoice = new JLabel("Computer choice : "+ rand1);


    }
    private void compare() {
        if (userInput.contains("ROCK"))
        {
            if (rand1 == "PAPER")
            {

                compPoints++;
                cs.setText("Computer Score : "+Integer.toString(compPoints));
                result.setText("YOU LOSE !");


            } else if (rand1 == "SCISSORS")
            {

                userPoints++;
                ps.setText("Player Score : "+Integer.toString(userPoints));
                result.setText("YOU WIN !");


            }
            else
            {
                result.setText("IT'S A DRAW !");
            }

        } else if (userInput.contains("PAPER"))
        {
            if (rand1 == "ROCK")
            {

                userPoints++;
                ps.setText("Player Score : "+Integer.toString(userPoints));
                result.setText("YOU WIN !");

            } else if (rand1 == "SCISSORS")
            {

                compPoints++;
                cs.setText("Computer Score : "+Integer.toString(compPoints));
                result.setText("YOU LOSE !");


            }
            else
            {
                result.setText("IT'S A DRAW !");
            }

        } else if (userInput.contains("SCISSORS"))
        {
            if (rand1 == "PAPER")
            {

                userPoints++;
                ps.setText("Player Score : "+Integer.toString(userPoints));
                result.setText("YOU WIN !");


            } else if (rand1 == "ROCK")
            {

                compPoints++;
                cs.setText("Computer Score : "+Integer.toString(compPoints));
                result.setText("YOU LOSE !");
            }
            else
            {
                result.setText("IT'S A DRAW !");
            }

        }
        else
        {
            result.setText("IT'S A DRAW !");
        }


    }

}