/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maman15.ex2b;
import java.io.*;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.*;
import java.awt.BorderLayout;
import java.io.File;
 import  javax.imageio.ImageIO;
import java.io.InputStream;
import java.awt.image.BufferedImage;

/**
 *
 * @author me
 */
public class DiningPhilosophersGui extends JPanel {
   private final int numOfPhilosophers=5; 
    private JLabel[] Jlabelphilosophers= new JLabel[numOfPhilosophers];
    private DiningPhilosophers myDinner;
    public BufferedImage[]  philosophersGrphicsDataBase=new  BufferedImage[6]; 
    
public     DiningPhilosophersGui (){

          
        
        
        JPanel philosophersNo1, philosophersNo2,philosophersNo3,philosophersNo4,philosophersNo5;
        
        JLabel tmpJLabel= new JLabel();
        
        philosophersNo1 = new javax.swing.JPanel();
        philosophersNo2 = new javax.swing.JPanel();
        philosophersNo3 = new javax.swing.JPanel();
        philosophersNo4 = new javax.swing.JPanel();
        philosophersNo5 = new javax.swing.JPanel();
        
   
        
        // init graphics
        
    //    ImageIcon[]  philosophersGrphicsDataBase=new  ImageIcon[numOfPhilosophers]; 
         
         
           InputStream imgStream =this.getClass().getClassLoader().getResourceAsStream("phil0.gif");
            BufferedImage myImg=null;      
         try{
            philosophersGrphicsDataBase[0] = ImageIO.read(imgStream);
         }
          catch(IOException e){
           
              
          }
         
         imgStream =this.getClass().getClassLoader().getResourceAsStream("phil1.gif");
              
         try{
            philosophersGrphicsDataBase[1] = ImageIO.read(imgStream);
         }
          catch(IOException e){
           
          }
          
          imgStream =this.getClass().getClassLoader().getResourceAsStream("phil2.gif");
              
         try{
            philosophersGrphicsDataBase[2] = ImageIO.read(imgStream);
         }
          catch(IOException e){
           
          }
         
         
         imgStream =this.getClass().getClassLoader().getResourceAsStream("phil3.gif");
              
         try{
            philosophersGrphicsDataBase[3] = ImageIO.read(imgStream);
         }
          catch(IOException e){
           
          }
         
            imgStream =this.getClass().getClassLoader().getResourceAsStream("phil4.gif");
              
         try{
            philosophersGrphicsDataBase[4] = ImageIO.read(imgStream);
         }
          catch(IOException e){
           
          }
         
           imgStream =this.getClass().getClassLoader().getResourceAsStream("phil5.gif");
              
         try{
            philosophersGrphicsDataBase[5] = ImageIO.read(imgStream);
         }
          catch(IOException e){
           
          }
          
          
          
              
        myDinner=new DiningPhilosophers(Jlabelphilosophers,this);
             
             
             
        ImageIcon image = new ImageIcon("table0.gif");
   
        JLabel label = new JLabel("", image, JLabel.CENTER);
        //JPanel panel = new JPanel(new BorderLayout());
        setLayout(new BorderLayout());
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        add( label, BorderLayout.CENTER );
        JPanel northJpanel= new JPanel();
        northJpanel.setLayout(new GridLayout(1,2,20,20));
       
       
        for (int i=0;i<numOfPhilosophers;i++){
            Jlabelphilosophers[i]=new javax.swing.JLabel();
            Jlabelphilosophers[i].setIcon(new javax.swing.ImageIcon(philosophersGrphicsDataBase[0]));
            
            Jlabelphilosophers[i].setHorizontalAlignment(JLabel.CENTER);
            Jlabelphilosophers[i].setVerticalAlignment(JLabel.CENTER);
        
            if (i==0)
                northJpanel.add(Jlabelphilosophers[i]);
            else
                if (i==1){
                     northJpanel.add(Jlabelphilosophers[i]);
                      add(northJpanel,BorderLayout.NORTH);
                }
                    
            else
                if (i==2)
                    add(Jlabelphilosophers[i],BorderLayout.EAST);
                else
                     if (i==3)
                         add(Jlabelphilosophers[i],BorderLayout.SOUTH);
                     else
                         if (i==4)
                            add(Jlabelphilosophers[i],BorderLayout.WEST);
        }
         
        
      
        
            //labelphilosophers[3]=new javax.swing.JLabel();
            //Jlabelphilosophers[3].setIcon(new javax.swing.ImageIcon(philosophersGrphicsDataBase[2]));
    
           
         
        validate();
                
        setVisible(true);
        repaint();
                
  //     philosophersNo5.setBackground(new java.awt.Color(255, 255, 255));

      javax.swing.GroupLayout fiveLayout = new javax.swing.GroupLayout(philosophersNo5);
        philosophersNo5.setLayout(fiveLayout);
       fiveLayout.setHorizontalGroup(
            fiveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 160, Short.MAX_VALUE)
        );
        fiveLayout.setVerticalGroup(
            fiveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 33, Short.MAX_VALUE)
        );
      //  add(fiveLayout);
}  

public JLabel getPhilosopherLabel(int num){
    
    return Jlabelphilosophers[num];
}



// change gif for a  Philosopher
public void setPhilosopherLabel(int num, PhilosopherState newState){
 
 BufferedImage  mypic=null;
         if (newState==PhilosopherState.EATING)
            Jlabelphilosophers[num].setIcon(new javax.swing.ImageIcon(philosophersGrphicsDataBase[5]));
         else
              if (newState==PhilosopherState.PICKEDLEFTFORK)
                Jlabelphilosophers[num].setIcon(new javax.swing.ImageIcon(philosophersGrphicsDataBase[1]));
              else
                   if (newState==PhilosopherState.THINKING) 
                        Jlabelphilosophers[num].setIcon(new javax.swing.ImageIcon(philosophersGrphicsDataBase[0]));
                    else
                       if (newState==PhilosopherState.PICKEDRIGHTFORK) 
                           Jlabelphilosophers[num].setIcon(new javax.swing.ImageIcon(philosophersGrphicsDataBase[2]));
                          if (newState==PhilosopherState.PICKEDRIGHTFORK) 
                            Jlabelphilosophers[num].setIcon(new javax.swing.ImageIcon(philosophersGrphicsDataBase[3]));
                    
        
 }

}




