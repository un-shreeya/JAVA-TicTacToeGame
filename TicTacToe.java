import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class TicTacToe implements ActionListener{
    private boolean xturn=true; 
    JButton[] buttons= new JButton[9];
    public TicTacToe(){
        JFrame frame= new JFrame("TIC-TAC-TOE");
        frame.setSize(600,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(3,3));
        
        for (int i=0; i<9; i++){
            buttons[i]=new JButton("");
            buttons[i].setFont(new Font("Arial",Font.BOLD,60));
            buttons[i].setBackground(Color.BLACK); 
            buttons[i].setForeground(Color.WHITE);
            buttons[i].setFocusPainted(false); 
            buttons[i].addActionListener(this);
            frame.add(buttons[i]);
        }
        frame.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e){
        JButton clicked= (JButton) e.getSource();
        if(!clicked.getText().equals("")) return;
        clicked.setText(xturn?"X":"O");
        play("sounds/click.wav");
        String player= xturn?"X":"O";

        int[] winner= checkWinner(player);
        if (winner!=null){
            for(int i:winner){
                buttons[i].setBackground(Color.GREEN);
            }
            play("sounds/win.wav");
            JOptionPane.showMessageDialog(null, player +" wins!");
            reset();
            return;
        }

        xturn=!xturn;

        if(isDraw()){
            JOptionPane.showMessageDialog(null,"It's a draw!");
            reset();
            return;
        }
    }

    private int[] checkWinner(String p){
        int[][] winPatterns= {
        {0,1,2}, {3,4,5}, {6,7,8},  
        {0,3,6}, {1,4,7}, {2,5,8},  
        {0,4,8}, {2,4,6}};

        for (int[] x : winPatterns){
            if (buttons[x[0]].getText().equals(p)&& buttons[x[1]].getText().equals(p)&& buttons[x[2]].getText().equals(p)){
                return x;
            }
        }
        return null;
    }

    private boolean isDraw(){
        for (JButton b: buttons){
            if (b.getText().equals("")){
                return false;
            }
        }
        return true;
    }

    private void reset(){
        for (JButton b: buttons){
            b.setText("");
            b.setBackground(Color.BLACK); 
            b.setForeground(Color.WHITE);
        }
        xturn=true;
    }

    private void play(String soundFile){
        try{
            AudioInputStream audio= AudioSystem.getAudioInputStream(new File(soundFile));
            Clip clip= AudioSystem.getClip();
            clip.open(audio);
            clip.start();
        }
        catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println("Sound error: " + e.getMessage());
        }
    }
    public static void main(String[] args){
        new TicTacToe();
    }
}