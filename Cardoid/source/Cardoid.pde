float total = 250;
float r;
float factor = 0;

PVector getVector(float index, float total){
  float angle = map(index % total, 0, total, 0, TWO_PI);
  PVector v = PVector.fromAngle(angle + PI);
  v.mult(r);
  return v;
}

void setup() {
  size(650, 650);
  r = width / 2 - 16;

}

void draw() {
  background(0);
  translate(width/2, height/2);
  
  stroke(255);
  noFill();
  circle(0, 0, r*2);
  
  factor += 0.005;

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
