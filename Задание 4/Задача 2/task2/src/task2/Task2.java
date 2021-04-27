package task2;

import java.text.*;
import java.util.*;

public class Task2 {
   //Проверочный класс
    public static class Test{
        String[][] arr=new String[3][2];
        public Test() throws ParseException{
            //Тест с нулем в месяце и дне
            arr[0][0]="19990101";
            arr[0][1]="0000";
            //Тест с одной цифрой в месяце и дне; с одной цифрой в часе и минутах
            arr[1][0]="199921";
            arr[1][1]="12";
            //Тест с одной цифрой в месяце и двумя цифрами в дне
            arr[2][0]="1999210";
            arr[2][1]="002";
            for (int i=0; i<3; i++){
                Convert cur=new Convert(arr[i][0], arr[i][1]);
                System.out.println("Введено: "+arr[i][0]+"  "+arr[i][1]+"\nРезультат совпадения Data и Calendar: "+cur.toDate().equals(cur.toCalendar().getTime()));
                System.out.println(cur.toDate()+"\n");
            }
        }
    }
    
    //Класс для конвертирования данных
    public static class Convert{
        String syear="";
        String smonth="";
        String sday="";
        String shour="";
        String smin="";
        String str1=""; 
        String str2="";
        public Convert(String s1, String s2){
            str1=s1;
            str2=s2;
        }
        //Метод для конвертирования в формат Date
        public Date toDate() throws ParseException{
            syear=str1.substring(0,4);
            String str11=str1.substring(4);
            
            //Если в месяце одна цифра
            if (str11.matches("[0-9]\\d{1,2}")){
                smonth=str11.substring(0,1);
                sday=str11.substring(1);
            }
            //Если в месяце две цифры (включая случаи 09)
            else if (str11.matches("(0[0-9]|1[0-3])\\d{1,2}")){
                smonth=str11.substring(0,2);
                sday=str11.substring(2);
            }
            
            //Если в часе две цифры
            if (str2.matches("(0[0-9]|1\\d|2[0-3])\\d{1,2}")){
                shour=str2.substring(0,2);
                smin=str2.substring(2);
            }
            //Если в часе одна цифра
            else if (str2.matches("[0-9]\\d{1,2}")){
                shour=str2.substring(0,1);
                smin=str2.substring(1);
            }

            String input=sday+"-"+smonth+"-"+syear+" "+shour+":"+smin;
            SimpleDateFormat f1 = new SimpleDateFormat("dd-MM-yyyy HH:mm");
            return f1.parse(input);
        }
        
        //Метод для конвертирования в формат Calendar
        public Calendar toCalendar(){
            Calendar calendar=new GregorianCalendar(Integer.parseInt(syear), Integer.parseInt(smonth)-1, Integer.parseInt(sday),Integer.parseInt(shour),Integer.parseInt(smin));
            return calendar;
        }
   }
    
    public static void main(String[] args) throws ParseException {
        Test ob=new Test();
    }
    
}
