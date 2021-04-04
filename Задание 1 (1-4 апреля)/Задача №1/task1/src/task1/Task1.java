package task1;
import java.util.*;

public class Task1 {
    
    //! - Класс для решения уравнения
    public static class Equation{
        private double a=0;
        private double b=0;
        private double c=0;
        //? - Конструктор для инициализации коэффициентов
        Equation(){
            Scanner in = new Scanner(System.in);
            System.out.print("Введите a: ");
            a=in.nextDouble();
            System.out.print("Введите b: ");
            b=in.nextDouble();
            System.out.print("Введите c: ");
            c=in.nextDouble();
            in.close();
        }
        
        //! - вложенный класс для дискриминанта
        private class Discrim {
            private double d;
            Discrim(){
            d=b*b-4*a*c;
        }
        }
        
        //? - метод для решения уравнения 
        public void solution(){
            double ds=new Discrim().d;
            if (ds<0){
                System.out.println("Дискриминант меньше 0");
            }
            else {
               double x1=(-b+Math.sqrt(ds))/2*a;
               double x2=(-b-Math.sqrt(ds))/2*a;
               if (ds==0){
                   System.out.println("Двойной корень: "+x1);  
               }
               else {
                   System.out.println("Корни: "+x1+"; "+x2);  
               }
            }
        }
    }
    
    public static void main(String[] args) {
        Equation e=new Equation();
        e.solution();
    }  
}
