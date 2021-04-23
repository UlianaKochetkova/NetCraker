package task3;

import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class Address {
    //Поля класса в соответствии с разбиением
    private String country;
    private String region;
    private String city;
    private String street;
    private String house; 
    private String building;
    private String apartment;
    
    
    //Конвертирование, где разделитель - запятая
    public boolean convertFirst(String str){
       
        if (!str.matches("[\\w, ]+"))
                {
                    return false;
                }
        else
        {
            String[] arr=str.split(",");
            if (arr.length<7){
                return false;
            }
            else
            {
                //trim используется, чтобы убрать начальные и конечные пробелы 

                country=arr[0].trim();
                region=arr[1].trim();
                city=arr[2].trim();
                street=arr[3].trim();
                house=arr[4].trim();
                building=arr[5].trim();
                apartment=arr[6].trim();

                return true;
            }
        }
    }
    
    //Конвертирование, где разделители - ,.;-
    public boolean convertSecond(String str){
        if (!str.matches("[\\w,.;\\- ]+"))
                {
                    return false;
                }
        else {
            StringTokenizer st = new StringTokenizer(str, " ,.;-");
            if (st.countTokens()<7){
                return false;
            }
            else { 
                //trim используется, чтобы убрать начальные и конечные пробелы 
                country=st.nextToken().trim();
                region=st.nextToken().trim();
                city=st.nextToken().trim();
                street=st.nextToken().trim();
                house=st.nextToken().trim();
                building=st.nextToken().trim();
                apartment=st.nextToken().trim();

                return true;
            }
        }
    }
    
    @Override
    public String toString(){
       return "\tcountry: "+country+"\n"+"\tregion: "+region+"\n"+"\tcity: "+city+"\n"+"\tstreet: "+street+"\n\thouse: "+house+"\n"+"\tbuilding: "+building+"\n"+"\tapartment: "+apartment+"\n";
    }
    
    public class Test{
        String[] arr;
        public Test(){
            arr=new String[5];
            arr[0]="A, B,! C, D, 5, 1, 15";
            arr[1]="A, B, C, D, 5, 1, 15";
            arr[2]="A, B; C, D, 5, 1, 15";
            arr[3]="A - B; C, D, 5. 1, 15";
            arr[4]="A - B-";
        }
        
        public void check(){
            Address ad=new Address();
            for (String e: arr){
                System.out.println("Element: "+e);
                if (ad.convertFirst(e)){
                    System.out.println("ConvertFirst complete;");
                    System.out.println("\tВывод полей объекта");
                    System.out.println(ad.toString());
                }
                else System.out.println("ConvertFirst is not complete;");
                
                if (ad.convertSecond(e)){
                    System.out.println("ConvertSecond complete;");
                    System.out.println("\tВывод полей объекта");
                    System.out.println(ad.toString());
                }
                else System.out.println("ConvertSecond is not complete;");
                
                System.out.println();
            }
        }
    }
    
    public void testing(){
        Test t=new Test();
        t.check();
    }
    
    public static void main(String[] args) {
        Address ob=new Address();
        ob.testing();
    }
    
}
