// Using a Timeline for animation, we move a bouncing ball around the Pane
import javafx.application.Application;
import javafx.stage.*;
import javafx.event.*;
import javafx.animation.*;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.shape.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import java.util.*;					// for Random
import javafx.util.*;
import javafx.scene.input.*;		// added from last exercise to include KeyCodes

public class Breakout extends Application 	
{
	private double bx, by, bdx, bdy;			// x,y coordinate of ball and its velocity
	private double px, pdx;						// paddle's x coordinate and x velocity	
	private Circle c;							// the ball
	private Rectangle r;
   private Rectangle b;                 //the bricks
	private Pane pane;							// the pane to draw on
		
	public static void main(String[] args)			
	{												
		launch();									
	}
	
	@Override
	public void start(Stage primaryStage)
	{
		Random g = new Random();
		bx = Math.abs(g.nextInt())%450 + 25;		// start off at random x,y coordinate
		by = Math.abs(g.nextInt())%450 + 25;
		do {										// start off with random velocity between [-3..3,-3..3]
			bdx = Math.abs(g.nextInt())%7 - 3;		
			bdy = Math.abs(g.nextInt())%7 - 3;
		}while(bdx==0||bdy==0);						// but neither should be 0
		px = 220;									// start the paddle in the middle with no velocity
		pdx = 0;		
		c = new Circle(bx,by,20);					// create the ball
		r = new Rectangle(px,450,60,8);
		pane = new Pane();						
		pane.getChildren().add(c);					// add initial ball to pane
		pane.getChildren().add(r);					// add paddle to pane
		Scene scene = new Scene(pane, 500,500);				
		Timeline timer = new Timeline(new KeyFrame(Duration.millis(20),e -> {
		    pane.getChildren().remove(c);			// set up our Timeline, for
		    pane.getChildren().remove(r);			// every action, remove current ball and paddle
		    if(bx>450) bdx*=-1;						
		    else if(bx<50) bdx*=-1;		// and adjust bdx and/or bdy if hitting a "wall"
		    if(by>450) bdy*=-1;
		    else if(by<50) bdy*=-1;
    		bx+=bdx;								// move position of ball	
    		by+=bdy;
    		c = new Circle(bx,by,20);				// redraw the ball
    		pane.getChildren().add(c);
    		if(px<50) { px = 50; pdx=0;}			// if paddle hits a wall, stop it
    		else if(px>390) {px = 390; pdx = 0;}	// note:  reset px in case its < 50 or > 390
    		px+=pdx;								// using 390 because px is the left end of the paddle, not the middle
    		r = new Rectangle(px,450,60,8);
    		pane.getChildren().add(r);
         }));
    	timer.setCycleCount(Timeline.INDEFINITE);
    	timer.play(); // Start animation    
		scene.setOnKeyPressed(e -> {          // register the event handler to the scene
			if(e.getCode()==KeyCode.LEFT&&pdx>-3) pdx--;  // change paddle's velocity based on
			else if(e.getCode()==KeyCode.RIGHT&&pdx<3) pdx++;	// left/right/down arrow
			else if(e.getCode()==KeyCode.DOWN) pdx=0;			// unless already at max velocity
	    });	        	
		primaryStage.setTitle("Breakout");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
   public void brick() {
     int bNum = 0;
     for(int rows = 0; rows<=4; rows++) {
       if(bNum < 10) {
         b = new Rectangle(px, 0, 50, 20);
         pane.getChildren().add(b);
         bNum++;
       }
     }
   }

}
  


