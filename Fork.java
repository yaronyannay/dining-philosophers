/* name: yaron yannay id:031996515
 */ 

package maman15.ex2b;

// 
public class Fork  {
    private boolean isForkLifted;
    private int forkNum;
    
    public Fork(int num){
        isForkLifted=false;
        forkNum=num;
    }
    
    public   void liftFork(){
        this.isForkLifted=true;
    }
    
    public   void putDownFork(){
        this.isForkLifted=false;
    }
    
    public boolean getStatus(){
        return isForkLifted;
    }
    
    public int getForkNum(){
        return this.forkNum;
    }
    
    
}
