package db.javaschool.session_2.inheritance;

 public abstract class Shape implements Cloneable{
    String color;
    protected double perimetru, arie;
    protected double[] laturi;

     {
         System.out.println("Shape NOT-Static");
         this.color = "NO-COLOR";
     }

     static{ // SE EXECUTA O SINGURA DATA - La prima instantiere a clasei
        System.out.println("Shape Static");
     }

    Shape(double[] laturi) {
        this.laturi = laturi;
    }
    Shape(String color, double[] laturi){
        this.color = color;
        this.laturi = laturi;
    }

    Shape(String color){
        this.color = color;
    }
    public double getPerimetru(){
        double s=0;
        for (int i = 0; i < laturi.length; i++)
            s = s + laturi[i];
        perimetru = s;
        return perimetru;
    }

    abstract public double getArie();

     @Override
     public Shape clone() {
         try {
             Shape clone = (Shape) super.clone();
             return clone;
         } catch (CloneNotSupportedException e) {
             throw new AssertionError();
         }
     }
 }
