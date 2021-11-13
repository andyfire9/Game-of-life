
package gameoflime;

import java.awt.Color;


class Cell {
	boolean state;
	
    public Cell(boolean state){
    	this.state = state;
    }
    
    public boolean isAlive(){
    	  return this.state;
       
    }
    
    public void setState(boolean state){
        this.state = state;
    } 
    
    public Color getColor(){
        System.out.println("White and green");
        return this.state ? Color.GREEN : Color.WHITE;

    }
}
