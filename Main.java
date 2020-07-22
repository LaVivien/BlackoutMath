package stackBlackoutMath;

public class Main{

    public static void main(String[] args){
        BlackOutMath b = new BlackOutMath();
        String exampleExpression   = "[(21+9)/4]*(2^3-2)";      //should return 42
        String MalformedExpression = "5+{7**2";                 //should return null

        String exampleEquation       = "[(137-3)/2]^2=3+2^20+6*7"; //should return the string "[(17-3)/2]^2=3+2^2+6*7"
        String exampleEquationPuzzle = "168/24+8=11*3-16";         //should return the string "18/2+8=11*3-16"

        System.out.println("Example evaluate method " + exampleExpression   + ": " + b.evaluate(exampleExpression)); //should print 42
        System.out.println("Example on solve method " + exampleEquation     + ": " + b.solve(exampleEquation));      //should print [(17-3)/2]^2=3+2^2+6*7"

        System.out.println("Example evaluate method " + exampleExpression   + ": " + b.evaluate(MalformedExpression)); //should return null
        System.out.println("Example on solve method " + exampleEquationPuzzle     + ": " + b.solve(exampleEquationPuzzle));    //should print "18/2+8=11*3-16"   
        
        //More test cases
        String s = "91+43=48*25+3*4";
        System.out.println("Example on solve method " + s     + ": " + b.solve(s));    
        
        s="26+43=94*9*2/12";
        System.out.println("Example on solve method " + s     + ": " + b.solve(s)); 
        
        s = "12*54+8*7=8+596";
        System.out.println("Example on solve method " + s     + ": " + b.solve(s));   
        
       s="2171=79*43-26*5";
       System.out.println("Example on solve method " + s     + ": " + b.solve(s)); 
          
       s="6+52*1=47+71-61";
       System.out.println("Example on solve method " + s     + ": " + b.solve(s)); 
       
       s="5*6+492=31+6*87";
       System.out.println("Example on solve method " + s     + ": " + b.solve(s)); 
       
       s="3717/7-25=3*4-6";
       System.out.println("Example on solve method " + s     + ": " + b.solve(s)); 
       
       s="56+29=4+24*2-37";
       System.out.println("Example on solve method " + s     + ": " + b.solve(s)); 
       
       s="9+4+26*96=25*41";
       System.out.println("Example on solve method " + s     + ": " + b.solve(s)); 
       
       s="34-2*43=27-36/3";
       System.out.println("Example on solve method " + s     + ": " + b.solve(s)); 
       
       s="67*3=95+56-3*26";
       System.out.println("Example on solve method " + s     + ": " + b.solve(s)); 
       
       s="62-5=948-986+45";  
       System.out.println("Example on solve method " + s     + ": " + b.solve(s)); 
       
       //More test cases
       s="28/2=269+16*16";
       System.out.println("Example on solve method " + s     + ": " + b.solve(s)); 
       
       s="63-2-9=18*2*2+2";
       System.out.println("Example on solve method " + s     + ": " + b.solve(s)); 
       
       s="6*(15-3)=100-7*2*2*2";
       System.out.println("Example on solve method " + s     + ": " + b.solve(s)); 
       
       s="38*21+63=3*7*3-10";
       System.out.println("Example on solve method " + s     + ": " + b.solve(s)); 
       
       s="466-8*51=96/16";
       System.out.println("Example on solve method " + s     + ": " + b.solve(s)); 
       
       s="510/(2*3*5)=28*5-11";
       System.out.println("Example on solve method " + s     + ": " + b.solve(s)); 
       
       s="2*25-5*5*5=66/6+5+184";
       System.out.println("Example on solve method " + s     + ": " + b.solve(s)); 
    }
}