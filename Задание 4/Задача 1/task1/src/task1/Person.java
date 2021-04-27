package task1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Person {
    Date data;
    
    public Person(String d, String m, String y) throws ParseException{
        String dt=d+"-"+m+"-"+y;
        SimpleDateFormat s = new SimpleDateFormat("dd-mm-yyyy");
        data = s.parse(dt);
    }
    
    @Override
    public String toString(){
        SimpleDateFormat s = new SimpleDateFormat("dd-mm-yyyy");
        String str=s.format(data);
        return "day: "+str.substring(0,2)+"\n"+"month: "+str.substring(3,5)+"\n"+"year: "+str.substring(6)+"\n";
    }
    
    public String toFormatString(String form){
        SimpleDateFormat s = new SimpleDateFormat(form);
        return s.format(data);
    }
    
    public static void main(String[] args) throws ParseException {
        Person ob=new Person("02","03","2004");
        System.out.println("Стандартный вывод с помощью toString()");
        System.out.println(ob.toString());
        System.out.println("Форматированный вывод");
        System.out.println(ob.toFormatString("dd/mm/yyyy"));
    }
}
