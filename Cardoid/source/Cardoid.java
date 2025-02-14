/* autogenerated by Processing revision 1293 on 2024-03-01 */
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

public class Cardoid extends PApplet {

float total = 250;
float r;
float factor = 0;

public PVector getVector(float index, float total){
  float angle = map(index % total, 0, total, 0, TWO_PI);
  PVector v = PVector.fromAngle(angle + PI);
  v.mult(r);
  return v;
}

public void setup() {
  /* size commented out by preprocessor */;
  r = width / 2 - 16;

}

public void draw() {
  background(0);
  translate(width/2, height/2);
  
  stroke(255);
  noFill();
  circle(0, 0, r*2);
  
  factor += 0.005f;

  for (int i = 0; i < total; i ++){
    PVector v = getVector(i, total);
    fill(factor * 255);
    circle(v.x, v.y, 16);   
  }
  
  for (int i = 0; i < total; i++){
    PVector a = getVector(i, total);
    PVector b = getVector(i * factor, total);
    line(a.x, a.y, b.x, b.y);
    stroke( factor *255, 255,255);
     
  }
 

}


  public void settings() { size(650, 650); }

  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Cardoid" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
