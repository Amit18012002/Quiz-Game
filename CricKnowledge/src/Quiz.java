
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Quiz extends JFrame implements ActionListener {
    
    String questions[][] = new String[10][5];
    String answers[][] = new String[10][2];
    String useranswers[][] = new String[10][1];
    JLabel qno, question;
    JRadioButton opt1, opt2, opt3, opt4;
    ButtonGroup groupoptions;
    JButton next, submit, lifeline;
    
    public static int timer = 15;
    public static int ans_given = 0;
    public static int count = 0;
    public static int score = 0;
    
    String name;
    
    Quiz(String name) {
        this.name = name;
        setBounds(-7, -5, 1400, 850);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/quiz.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 1440, 370);
        add(image);
        
        qno = new JLabel();
        qno.setBounds(100, 400, 50, 30);
        qno.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(qno);
        
        question = new JLabel();
        question.setBounds(125, 400, 900, 30);
        question.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(question);
        
        questions[0][0] = "Who is Captain of Rcb?";
        questions[0][1] = "VIRAT";
        questions[0][2] = "FAF";
        questions[0][3] = "MAXI";
        questions[0][4] = "ABD";
        
        questions[1][0] = "which Team has record of Highest team score in IPL?";
        questions[1][1] = "RCB";
        questions[1][2] = "KKR";
        questions[1][3] = "SRH";
        questions[1][4] = "CSK";
        
        questions[2][0] = "who was won the M.O.S in WC2011?";
        questions[2][1] = "Dhoni";
        questions[2][2] = "Yuvi";
        questions[2][3] = "Abd";
        questions[2][4] = "Virat";
        
        questions[3][0] = "Which player has a record of fastest 50,100,150 in ODI cricket?";
        questions[3][1] = "Virat";
        questions[3][2] = "Gyle";
        questions[3][3] = "ABD";
        questions[3][4] = "Dhoni";
        
        questions[4][0] = "Who Score 100 centuries in all form of cricket";
        questions[4][1] = "Sachin";
        questions[4][2] = "Dravid";
        questions[4][3] = "Dhoni";
        questions[4][4] = "Virat";
        
        questions[5][0] = "Who is MR.360 of cricket?";
        questions[5][1] = "Suriya";
        questions[5][2] = "ABD";
        questions[5][3] = "Sachin";
        questions[5][4] = "Virat";
        
        questions[6][0] = "Who has the record of height individul score in IPL?";
        questions[6][1] = "ABD";
        questions[6][2] = "Gayle";
        questions[6][3] = "Virat";
        questions[6][4] = "Sachin";
        
        questions[7][0] = "Which Country has Won most number of Wc?";
        questions[7][1] = "India";
        questions[7][2] = "AUS";
        questions[7][3] = "SA";
        questions[7][4] = "WI";
        
        questions[8][0] = "Who has record of most number of centuries in IPL?";
        questions[8][1] = "ABD";
        questions[8][2] = "DHONI";
        questions[8][3] = "VIRAT";
        questions[8][4] = "SACHIN";
        
        questions[9][0] = "Which two player has the record of highest partenership in IPL?";
        questions[9][1] = "VIRAT & ABD";
        questions[9][2] = "ABD and FAF";
        questions[9][3] = "ABD And Maxi";
        questions[9][4] = "Virat and Gayle";
        
        answers[0][1] = "FAF";
        answers[1][1] = "SRH";
        answers[2][1] = "Yuvi";
        answers[3][1] = "ABD";
        answers[4][1] = "Sachin";
        answers[5][1] = "ABD";
        answers[6][1] = "Gayle";
        answers[7][1] = "AUS";
        answers[8][1] = "VIRAT";
        answers[9][1] = "VIRAT & ABD";
        
       
        opt1 = new JRadioButton();
        opt1.setBounds(120, 450, 700, 30);
        opt1.setBackground(Color.WHITE);
        opt1.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt1);
        
        opt2 = new JRadioButton();
        opt2.setBounds(120, 480, 700, 30);
        opt2.setBackground(Color.WHITE);
        opt2.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt2);
        
        opt3 = new JRadioButton();
        opt3.setBounds(120, 510, 700, 30);
        opt3.setBackground(Color.WHITE);
        opt3.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt3);
        
        opt4 = new JRadioButton();
        opt4.setBounds(120, 540, 700, 30);
        opt4.setBackground(Color.WHITE);
        opt4.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt4);
        
        groupoptions = new ButtonGroup();
        groupoptions.add(opt1);
        groupoptions.add(opt2);
        groupoptions.add(opt3);
        groupoptions.add(opt4);
        
        next = new JButton("Next");
        next.setBounds(1100, 400, 200, 40);
        next.setFont(new Font("Tahoma", Font.PLAIN, 22));
        next.setBackground(new Color(30, 144, 255));
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);
        
        lifeline = new JButton("50-50 Lifeline");
        lifeline.setBounds(1100, 500, 200, 40);
        lifeline.setFont(new Font("Tahoma", Font.PLAIN, 22));
        lifeline.setBackground(new Color(30, 144, 255));
        lifeline.setForeground(Color.WHITE);
        lifeline.addActionListener(this);
        add(lifeline);
        
        submit = new JButton("Submit");
        submit.setBounds(1100, 600, 200, 40);
        submit.setFont(new Font("Tahoma", Font.PLAIN, 22));
        submit.setBackground(new Color(30, 144, 255));
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setEnabled(false);
        add(submit);
        
        start(count);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == next) {
            repaint();
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);
            
            ans_given = 1;
            if (groupoptions.getSelection() == null) {
               useranswers[count][0] = "";
            } else {
                useranswers[count][0] = groupoptions.getSelection().getActionCommand();
            }
            
            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            
            count++;
            start(count);
        } else if (ae.getSource() == lifeline) {
            if (count == 2 || count == 4 || count == 6 || count == 8 || count == 9) {
                opt2.setEnabled(false);
                opt3.setEnabled(false);
            } else {
                opt1.setEnabled(false);
                opt4.setEnabled(false);
            }
            lifeline.setEnabled(false);
        } else if (ae.getSource() == submit) {
            ans_given = 1;
            if (groupoptions.getSelection() == null) {
                useranswers[count][0] = "";
            } else {
                useranswers[count][0] = groupoptions.getSelection().getActionCommand();
            }

            for (int i = 0; i < useranswers.length; i++) {
                if (useranswers[i][0].equals(answers[i][1])) {
                    score += 10;
                } else {
                    score += 0;
                }
            }
            try {
                Conn conn = new Conn();
                String username;
                username = this.name;
                String query = "insert into quiz values('"+username+"','"+score+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details added successfully");
                setVisible(false);
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            setVisible(false);
            new Score(name, score);
        }
    }
    
    public void paint(Graphics g) {
        super.paint(g);
        
        String time = timer + " seconds"; // 15
        g.setColor(Color.RED);
        g.setFont(new Font("Tahoma", Font.BOLD, 25));
        
        if (timer > 0) { 
            g.drawString(time, 1200, 100);
        } else {
            g.drawString("Times up!!", 1200, 100);
        }
        
        timer--; // 14
        
        try {
            Thread.sleep(1000);
            repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        if (ans_given == 1) {
            ans_given = 0;
            timer = 15;
        } else if (timer < 0) {
            timer = 15;
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);
            
            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            if (count == 9) { // submit button
                if (groupoptions.getSelection() == null) {
                   useranswers[count][0] = "";
                } else {
                    useranswers[count][0] = groupoptions.getSelection().getActionCommand();
                }
                
                for (int i = 0; i < useranswers.length; i++) {
                    if (useranswers[i][0].equals(answers[i][1])) {
                        score += 10;
                    } else {
                        score += 0;
                    }
                }
                setVisible(false);
                new Score(name, score);
            } else { // next button
                if (groupoptions.getSelection() == null) {
                   useranswers[count][0] = "";
                } else {
                    useranswers[count][0] = groupoptions.getSelection().getActionCommand();
                }
                count++; // 0 // 1
                start(count);
                
            }
        }
        
    }
    
    public void start(int count) {
        qno.setText("" + (count + 1) + ". ");
        question.setText(questions[count][0]);
        opt1.setText(questions[count][1]);
        opt1.setActionCommand(questions[count][1]);
        
        opt2.setText(questions[count][2]);
        opt2.setActionCommand(questions[count][2]);
        
        opt3.setText(questions[count][3]);
        opt3.setActionCommand(questions[count][3]);
        
        opt4.setText(questions[count][4]);
        opt4.setActionCommand(questions[count][4]);
        
        groupoptions.clearSelection();
    }
    
    public static void main(String[] args) {
        new Quiz("User");
    }
}