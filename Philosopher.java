/* name: yaron yannay id:031996515
 */ 

package maman15.ex2b;
import javax.swing.*;
import javax.swing.ImageIcon;
import java.awt.image.BufferedImage;
 import  javax.imageio.ImageIO;
import java.io.InputStream;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.*;


enum  PhilosopherState {THINKING,
PICKEDLEFTFORK,
PICKEDRIGHTFORK,
PICKEDBOTHFORKS,
SLEEPING,
EATING,
PUTRIGHTFORK
}

public class Philosopher extends Thread{
    private String name;
    private Fork leftFork;
    private Fork rightFork;
    private PhilosopherState myState;
    private JLabel Philosopherlabel;
    private DiningPhilosophersGui gui;
    private int  philosopherNum;
    
   // constructor
    public Philosopher(String name,Fork leftFork, Fork  rightFork,JLabel PhilosopherLabel,DiningPhilosophersGui gui ,int philosopherNum ){
        this.name=name;
        this.leftFork=leftFork;
        this.rightFork=rightFork;
        this.myState=PhilosopherState.THINKING;
        this.Philosopherlabel=PhilosopherLabel;
        this.gui=gui;
        this.philosopherNum=philosopherNum;
    }
    
    // modified gif to create animation . and set sleep time between changing gif
    public void doAction(String philosopherAction,PhilosopherState newState ) throws InterruptedException {
        System.out.printf("%s", philosopherAction);
        ModifyLabel(newState );
        if (newState==PhilosopherState.EATING||newState==PhilosopherState.THINKING)
            Thread.sleep(((int) (Math.random() * 4000)));
        else
            Thread.sleep(2000);
    
}
    
   // as described in question i am preventing the deadlock 
  // by giving the forks numbers , all  Philosophers pick the fork
  // with the lower number this way i prevent a loop , or deadlock as 
  // described by Edsger Dijkstra
    
   public void run() {
       while (true){
       try{
                // thinking
                doAction(this.name  + ": Thinking\n",PhilosopherState.THINKING);
                // lifting forks
                Fork fork1,fork2;
                 if (rightFork.getForkNum()>leftFork.getForkNum() ){
                     fork1=leftFork;
                     fork2=rightFork;
                 }
                 else{
                     fork1=rightFork;
                     fork2=leftFork;
                 }
                     
                     
                 synchronized (fork1){
                   if(fork1.getStatus()){
                        try{
                            fork1.wait();
                        }
                        catch(InterruptedException e){
                        
                        }
                    }
                   fork1.liftFork();
                   doAction(this.name  + ": lifted  fork"+leftFork.getForkNum()+"\n",PhilosopherState.PICKEDLEFTFORK);
                 }          
               
                 
                 
                synchronized (fork2){
                    if (fork2.getStatus()){
                        try{
                            fork2.wait();
                        }
                        catch(InterruptedException e){
                        
                       }

                    }
                       fork2.liftFork();
                       doAction(this.name  + ": lifted  fork"+rightFork.getForkNum()+"\n",PhilosopherState.PICKEDRIGHTFORK);
                }
                
                
                // eating
                doAction(this.name  + ": eating\n",PhilosopherState.EATING);
                // puting down forks
                doAction(this.name  + ": put down  fork"+leftFork.getForkNum()+"\n",PhilosopherState.PUTRIGHTFORK);
                 synchronized (fork2){
                    fork2.putDownFork();
                    fork2.notify();
                    doAction(this.name  + ": put down  fork"+rightFork.getForkNum()+"\n",PhilosopherState.THINKING);
                 }
               
                  synchronized (fork1){
                    //thinking
                    fork1.putDownFork();
                    fork1.notify();
                    doAction(this.name  + ": Thinking\n",PhilosopherState.THINKING);
                 
             
               }
            
              
                
                
       }
       catch(InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }
       }
   }
   
   
 // modify gif  
public void ModifyLabel(PhilosopherState newState ){
     BufferedImage  mypic=null;
      if (newState==PhilosopherState.EATING)
          gui.setPhilosopherLabel(this.philosopherNum,PhilosopherState.EATING);
      else
              if (newState==PhilosopherState.PICKEDLEFTFORK)
                gui.setPhilosopherLabel(this.philosopherNum,PhilosopherState.PICKEDLEFTFORK);
              else
                   if (newState==PhilosopherState.THINKING) 
                        gui.setPhilosopherLabel(this.philosopherNum,PhilosopherState.THINKING);
                    else
                       if (newState==PhilosopherState.PICKEDRIGHTFORK) 
                           gui.setPhilosopherLabel(this.philosopherNum,PhilosopherState.PICKEDRIGHTFORK);

         
}
    
   
        
}
