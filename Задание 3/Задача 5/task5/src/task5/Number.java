package task5;

public class Number {

   public String convertNumber(String n0){
       //Проверяем введенную строку на соответствие с первым шаблоном (+код страны...)
        if (n0.matches("(\\+)\\d*\\d{10}")){
            //Забираем 10 последних цифр - сам номер
           String cur_num=n0.substring(n0.length()-10);
           //выделяем строку без последних 10 цифр (для удобства)
           String new_num=n0.substring(0,n0.length()-10);
           //Формируем результат по шаблону
           String result=new_num+cur_num.substring(0,3)+"-"+cur_num.substring(3,6)+"-"+cur_num.substring(6);
           return result;
        }
        //Проверяем введенную строку на соответствие со вторым шаблоном (8...)
        else if (n0.matches("8\\d{10}")){
            //Забираем 10 последних цифр - сам номер
           String cur_num=n0.substring(n0.length()-10);
           //Формируем результат по шаблону
           String result="+7"+cur_num.substring(0,3)+"-"+cur_num.substring(3,6)+"-"+cur_num.substring(6);
           return result;
        }
        return null;
    }
   
   
    public static void main(String[] args) {
        //Создаем тесты. 
        //Первые 3 взяты из условия;
        //последние три - невалидные
        String[] arr=new String [6];
        arr[0]="+104289652211";
        arr[1]="+79175655655";
        arr[2]="89175655655";
        arr[3]="+10123";
        arr[4]="-12345";
        arr[5]="891756556551";
        
        Number ob=new Number();
        
        for (String el: arr){
            System.out.println("Test: "+el);
            System.out.println("Result: "+ob.convertNumber(el));
            System.out.println();
        }
         
    }
    
}
