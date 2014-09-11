import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Dice extends PApplet {

Die one;
Die two;
Die three;
int s;
int r;
int xgo = 0;
int sw = 1;
int l = 1;
public void setup()
{
	size(500,300);
	noLoop();
}
public void draw()
{
	background(255);
	stroke(0);
	strokeWeight(0);
	one = new Die(250,150);
	two = new Die(300,150);
	three = new Die(200,150);
	one.roll();
	two.roll();
	three.roll();
	one.show();
	two.show();
	three.show();
	text("Score:" + s, 150,150);
	text("Rolls:" + r, 350,150);
	stroke(0,255,0);
	strokeWeight(sw);
	line(0,100,xgo,100);
	text("Level:" + l, 150,250);
}
public void mousePressed()
{
	if(xgo >= 500){
		xgo = 0;
		sw = sw + 1;
		l = l + 1;
	}
	else{
		xgo = xgo + s;
	}
	r = r + 1;
	s = 0;
	background(255);
	redraw();
}
class Die //models one single dice cube
{
    int xpos, ypos, numDots;
	Die(int x, int y) //constructor
	{
		xpos = x;
		ypos = y;
		numDots = (int) (Math.random() * 6) + 1;
	}
	public void roll()
	{
			numDots = (int) (Math.random() * 6) + 1;
	}
	public void show()
	{
		fill(255);
		rect(xpos,ypos,30,30);
		if(numDots == 1){
			s = s + 1;
			fill(0);
			ellipse(xpos+15,ypos+15,5,5);
		}
		if (numDots == 2) {
			s = s + 2;
			fill(0);
			ellipse(xpos+20,ypos+10,5,5);
            ellipse(xpos+10,ypos+20,5,5);
		}
		if (numDots == 3) {
			s = s + 3;
			fill(0);
			ellipse(xpos+25,ypos+5,5,5);
            ellipse(xpos+5,ypos+25,5,5);
            ellipse(xpos+15,ypos+15,5,5);
		}
		if (numDots == 4) {
			s = s + 4;
			fill(0);
			ellipse(xpos+7,ypos+23,5,5);
            ellipse(xpos+23,ypos+7,5,5);
            ellipse(xpos+7,ypos+7,5,5);
            ellipse(xpos+23,ypos+23,5,5);
		}
		if (numDots == 5) {
			s = s + 5;
			fill(0);
			ellipse(xpos+7,ypos+23,5,5);
            ellipse(xpos+23,ypos+7,5,5);
            ellipse(xpos+7,ypos+7,5,5);
            ellipse(xpos+23,ypos+23,5,5);
            ellipse(xpos+15,ypos+15,5,5);
		}
		if (numDots == 6) {
			s = s + 6;
			fill(0);
			ellipse(xpos+7,ypos+23,5,5);
            ellipse(xpos+23,ypos+7,5,5);
            ellipse(xpos+7,ypos+7,5,5);
            ellipse(xpos+23,ypos+23,5,5);
            ellipse(xpos+7,ypos+15,5,5);
            ellipse(xpos+23,ypos+15,5,5);
		}
	}
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Dice" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
