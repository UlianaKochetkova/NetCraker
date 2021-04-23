package task3;

public class ExtendedClass {
   private byte b;
   private int i;
   private double d;
   private String s;
   
   public ExtendedClass(byte b, int i, double d, String s){
       this.b=b;
       this.i=i;
       this.d=d;
       this.s=s;
   }
   
   @Override
   public boolean equals(Object anObject){
       if (anObject==this){
           return true;
       }
       if (anObject==null){
           return false;
       }
       if (this.getClass()!=anObject.getClass())
           return false;
       
       ExtendedClass o=(ExtendedClass)anObject;
       if (b!=o.b){
           return false;
       }
       if (i!=o.i){
           return false;
       }
       if (d!=o.d){
           return false;
       }
       if (!s.equals(o.s)){
           return false;
       }
       return true;
   }
   
   @Override 
   public int hashCode(){
        int prime = 31;
	int result = 1;
	result = prime * result + (int)b;
	result = prime * result + i;
        result = prime * result + (int)d;
        result = prime * result + s.length();
	return result;
   }
   
   @Override 
   public String toString(){
       return "byte: "+b+"\nint: "+i+"\ndouble: "+d+"\nstring: "+s;
   }
    
    public static void main(String[] args) {
        ExtendedClass e1=new ExtendedClass((byte)1,1,1,"1");
        ExtendedClass e2=new ExtendedClass((byte)2,2,2,"2");
        ExtendedClass e3=new ExtendedClass((byte)1,1,1,"1");
        
        System.out.println("Имеются следующие объекты");
        System.out.println("e1");
        System.out.println(e1.toString());
        System.out.println();
        
        System.out.println("e2");
        System.out.println(e2.toString());
        System.out.println();
        
        System.out.println("e3");
        System.out.println(e3.toString());
        System.out.println();
        
        System.out.println("Test: равенство e1 и e1");
        System.out.println("Expected: true");
        System.out.println(e1.equals(e1));
        System.out.println();
        
        System.out.println("Test: равенство e1 и e3");
        System.out.println("Expected: true");
        System.out.println(e1.equals(e3));
        System.out.println();
        
        System.out.println("Test: равенство e1 и e2");
        System.out.println("Expected: false");
        System.out.println(e1.equals(e2));
        System.out.println();
        
        System.out.println("Test: hashcode e1");
        System.out.println(e1.hashCode());
        System.out.println();
        
        System.out.println("Test: hashcode e2");
        System.out.println(e2.hashCode());
        System.out.println();
        
        System.out.println("Test: hashcode e3");
        System.out.println(e3.hashCode());
        System.out.println();
    }
    
}
