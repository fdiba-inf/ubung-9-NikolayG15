package exercise9;

public class Ellipse{
  private Point startingPoint;
  private double a;
  private double b;

  public Ellipse(){
    startingPoint = new Point(0,0);
    a = 1;
    b = 1;

  }
  public Ellipse(Point startingPoint, double a, double b){
    this.startingPoint = new Point(startingPoint);
    this.a = a;
    this.b = b;

  }
  public Ellipse(Ellipse otherEllipse){
    startingPoint = new Point(otherEllipse.startingPoint);
    a = otherEllipse.a;
    b = otherEllipse.b;

  }
  public boolean isValid(){
    return a>0 && b>0;

  }
  public void initialize(){
    do{
      System.out.println("Starting point: ");
      startingPoint.initialize();
      System.out.print("Enter a: ");
      a = Utils.INPUT.nextDouble();
      System.out.print("Enter b: ");
      b = Utils.INPUT.nextDouble();

    }while(!isValid());
  
  }
  public double Perimeter(){
    return Math.PI * (3 * (a + b) - Math.sqrt((3*a + b)* (a + 3 * b)));

  }
  public double Area(){
    return Math.PI * a * b;
  }
  public String getType(){
    if (a == b){
      return "Circle";
    } else {
      return "Ellipse";
    }
  }
  public String toString(){
    return String.format("%s-[%s, %s], %s, P=%s, A=%s", startingPoint, a, b, getType(), Perimeter(), Area());  
  }
  public boolean equals(Ellipse otherEllipse) 
    {
        boolean aEqual = Utils.equals(a, otherEllipse.a);
        boolean bEqual = Utils.equals(b, otherEllipse.b);
        boolean aEqualReversed = Utils.equals(a, otherEllipse.b);
        boolean bEqualReversed = Utils.equals(b, otherEllipse.a);

        return (aEqual && bEqual) || (aEqualReversed && bEqualReversed);
    }
} 

