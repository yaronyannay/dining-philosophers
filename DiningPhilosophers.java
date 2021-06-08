/* name: yaron yannay id:031996515
 */ 

package maman15.ex2b;
import javax.swing.*;
import java.awt.image.BufferedImage;


public class DiningPhilosophers {
    final int numOfPhilosophers=5;
    Philosopher[] philosophers = new Philosopher[numOfPhilosophers];
    JLabel[] Jlabelphilosophers;
     
     
    public DiningPhilosophers(JLabel[] LabelPhilosophers,DiningPhilosophersGui  gui){
     this.Jlabelphilosophers=LabelPhilosophers;
     Fork[] forks = new Fork[numOfPhilosophers];
     String[] names={"Philosopher 1","Philosopher 2","Philosopher 3","Philosopher 4","Philosopher 5"};
     
     for (int j = 0; j<numOfPhilosophers;j++){
          forks[j]=new Fork(j);
     }
     
     for (int j = 0; j<numOfPhilosophers;j++) {
          
            Fork leftFork = forks[j];
            Fork rightFork = forks[(j + 1) % numOfPhilosophers];

            philosophers[j] = new Philosopher(names[j],leftFork, rightFork,Jlabelphilosophers[j],gui,j);
            
            Thread t 
              = new Thread(philosophers[j], "Philosopher " + (j+ 1));
            t.start();
        }
    }
    
    
  
}
