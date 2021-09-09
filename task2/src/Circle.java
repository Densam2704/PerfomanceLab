public class Circle {
  private Point center;
  private float radius;
  public static final int isOnCircle=0;
  public static final int isInsideCircle=1;
  public static final int isOutsideCircle=2;
  public int pointPosition(Point p){
	if (
			(p.getX() - center.getX()) * (p.getX() - center.getX())
					+
					(p.getY() - center.getY()) * (p.getY() - center.getY())
					
					== radius * radius) {
	  return isOnCircle;
	} else if (
			(p.getX() - center.getX()) * (p.getX() - center.getX())
					+
					(p.getY() - center.getY()) * (p.getY() - center.getY())
					<= radius * radius) {
	  return isInsideCircle;
	}
	return isOutsideCircle;
	
  }
  public Circle(Point center, float radius) {
	this.center = center;
	this.radius = radius;
  }
  
  public Point getCenter() {
	return center;
  }
  
  public void setCenter(Point center) {
	this.center = center;
  }
  
  public float getRadius() {
	return radius;
  }
  
  public void setRadius(float radius) {
	this.radius = radius;
  }
}
