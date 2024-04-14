/* autogenerated by Processing revision 1293 on 2024-02-29 */
import processing.core.*;
import processing.data.*;
import processing.event.*;
import processing.opengl.*;

import peasy.*;

import java.util.HashMap;
import java.util.ArrayList;
import java.io.File;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;

public class MandelBulb extends PApplet {



int DIM = 64;
PeasyCam cam;

ArrayList<PVector> mandelbulb = new ArrayList<PVector>();

public void setup(){
  /* size commented out by preprocessor */;
  windowMove(1200, 100);
  cam = new PeasyCam(this, 500);
  
    for (int i = 0; i < DIM; i++){
      for (int j = 0; j < DIM; j++){
        boolean edge =false;
        for (int k = 0; k < DIM; k++) {
          float x = map(i, 0, DIM, -1, 1);
          float y = map(j, 0, DIM, -1, 1);    
          float z = map(k, 0, DIM, -1, 1);
       
          PVector zeta = new PVector(0,0,0);
          int n = 16;
          int max_iteration = 20;
          int iteration = 0;
        
        while (true){
          
          Spherical sphericalZ = spherical(zeta.x,zeta.y,zeta.z);
          float newX = pow(sphericalZ.r,n) * sin(sphericalZ.theta*n) * cos(sphericalZ.phi*n);
          float newY = pow(sphericalZ.r,n) * sin(sphericalZ.theta*n) * sin(sphericalZ.phi*n);
          float newZ = pow(sphericalZ.r,n) * cos(sphericalZ.theta*n);
          
          zeta.x = newX + x;
          zeta.y = newY + y;
          zeta.z = newZ + z;
          
          iteration ++;
          
          if (sphericalZ.r > 2){
            if (edge){
              edge = false;
            }
              break;
          }
          
          if (iteration > max_iteration){
            if (!edge){
              edge = true;
              mandelbulb.add(new PVector(x*100, y*100, z*100));
            }
            break;
          }
        }
        

      }
    }  
  }
  
}

class Spherical {
  float r, theta, phi;
   Spherical(float r, float theta, float phi) {
       this.r = r;
       this.theta = theta;
       this.phi = phi;
   }
}

public Spherical spherical(float x, float y, float z){
  float r = sqrt(x*x + y*y + z*z);
  float theta = atan2(sqrt(x*x + y+y), z);
  float phi = atan2(y, z);
  return new Spherical(r, theta, phi);
 }
       


public void draw(){
  background(0);
  
  for (PVector v : mandelbulb){
    stroke(255);
    point(v.x, v.y, v.z);
  }

}


  public void settings() { size(600, 600, P3D); }

  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "--full-screen", "--bgcolor=#666666", "--stop-color=#cccccc", "MandelBulb" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
