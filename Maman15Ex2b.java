/* name: yaron yannay id:031996515
* put gifs in source dir , if you get nullpointerassigment you didnt put the 
* gifs in the right place. if you have problems running
* this send me a mail: yaronyy1@hotmail.com and i will send you pics or movies
 */ 

package maman15.ex2b;
import java.io.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Maman15Ex2b {

    
    public static void main(String[] args) {
   
        
         JFrame frame = new JFrame("Dinning philosophers");
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setSize(500, 500);
        DiningPhilosophersGui myGui = new DiningPhilosophersGui();
        frame.add(myGui);
        frame.setVisible(true);
      
    }
    
}
