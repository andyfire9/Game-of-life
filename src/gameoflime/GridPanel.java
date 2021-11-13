/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameoflime;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.Timer;

/**
 *
 * @author Franyell
 */
public class GridPanel extends javax.swing.JPanel {

//"Great adversity has a beauty — it is the fire that tempers the blade."
    
    Simulator simulator;
    final int gridW=512;
    final int gridH=512;
    final int numberOfSquares=64;
// What in the hell is a Timer
    
    public GridPanel() {
        this.initComponents();
    }
    
    public void InitSimulator(){
        //um dont forget to make the sim actually work
         simulator = new Simulator(numberOfSquares);
         
         
    }
     private void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
       
        int squareSize = gridW/this.numberOfSquares;
        
  
        int x=0;
        int y=0;
        for(int i=0;i< this.numberOfSquares; i++){
            for(int j=0;j< this.numberOfSquares;j++){
            	
//So I had to give up on the Interface. Fun.
            	// The idea wasn't even hard. I mean it was simply A called value that updates the numbers for color, it WAS MEANT TO BE SIMPLE.
            	//Assign them to ints, specify the users how they work, or even better yet. use a If, else if, Situation with Strings Detecting Purple,white,green,black,blue, etc.
            	
                Color color = Math.random()>0.5 ? Color.GREEN : Color.WHITE;
                g2d.setColor(color);
                x=squareSize*j;
                y= squareSize*i;
                
                //"There Is A Sickness In The Ancient Pitted Cobbles Of The Old Road, And On Its Writhing Path You Will Face Viciousness, Violence, And Perhaps Other Damnably Transcendent Terrors."
                 g2d.fillRect(x, y, squareSize, squareSize);
            }
        }
        
    }
     
     public void updateSimulator(){
         System.out.println("updating");
         this.simulator.update();
     }
     
     public void clickedCell(int x, int y){
    	 
         //I see you are quite the comedian as well.
    	 
        int squareSize = gridW/this.numberOfSquares;

         int j= x/squareSize;
         int i= y/squareSize;
         
          System.out.println("x: "+x+ " y: "+y +"  "+ squareSize+" i "+i+" j "+j);

        
     }
     
     

    @Override
    public void paintComponent(Graphics g) {
        System.out.print("on paint");
        super.paintComponent(g);
        doDrawing(g);
    }

  
    @SuppressWarnings("unchecked")

    private void initComponents() {

        setBackground(new java.awt.Color(255,255,0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }

   public boolean isSimulationRunning() {

       return this.simulator.isRunning();
    }

    public void startSimulation() {
       this.simulator.setRunning();
    }

    public void stopSimulation() {
       this.simulator.resetRunning();
    }

    void resetSimulator() {
       this.simulator.resetAll();
    }
    
    public int getIterations(){
       
        return this.simulator.getCountIteration();
    }

}
