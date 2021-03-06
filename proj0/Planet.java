public class Planet{
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    private static final double G = 6.67e-11;

    public Planet(double xP, double yP, double xV, double yV, double m, String img)
    {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Planet(Planet b){
        xxPos = b.xxPos;
        yyPos = b.yyPos;
        xxVel = b.xxVel;
        yyVel = b.yyVel;
        mass = b.mass;
        imgFileName = b.imgFileName;
    }

    public double calcDistance(Planet a){
        return Math.sqrt(Math.pow((this.xxPos - a.xxPos), 2) + Math.pow((this.yyPos - a.yyPos), 2));
    }

    public double calcForceExertedBy(Planet a){
        return (G * this.mass * a.mass)/Math.pow(this.calcDistance(a), 2);
    }

    public double calcForceExertedByX(Planet a){
        return this.calcForceExertedBy(a) * ((a.xxPos - this.xxPos)/this.calcDistance(a));
    }

    public double calcForceExertedByY(Planet a){
        return this.calcForceExertedBy(a) * ((a.yyPos - this.yyPos)/this.calcDistance(a));
    }

    public double calcNetForceExertedByX(Planet[] a){
        double res = 0;
        for (int i=0;i<a.length;i++){
            //ignore any Planet in the array that is equal to the current Planet.
            if(this.equals(a[i])){
                continue;
            }
            res += this.calcForceExertedByX(a[i]);
        }
        return res;
    }

    public double calcNetForceExertedByY(Planet[] a){
        double res = 0;
        for (int i=0;i<a.length;i++){
            //ignore any Planet in the array that is equal to the current Planet.
            if(this.equals(a[i])){
                continue;
            }
            res += this.calcForceExertedByY(a[i]);
        }
        return res;
    }

    public void update(double t, double x, double y){
        double ax = x/this.mass;
        double ay = y/this.mass;
        this.xxVel += t * ax;
        this.yyVel += t * ay;
        this.xxPos += t * this.xxVel;
        this.yyPos += t * this.yyVel;
    }

    public void draw(){
        StdDraw.picture(this.xxPos, this.yyPos, "./images/" + this.imgFileName);
    }

}