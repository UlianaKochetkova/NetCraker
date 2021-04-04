package task3;

import java.text.SimpleDateFormat;
import java.util.*;
import java.text.ParseException;

public class Task3 {
    
    //!Класс - сущность "Человек"
    public static class Human {
        public String name="";

        public String surname="";
        public Date date=null;
        public Address addr=null;

        //?Конструктор - инициализация значений 
        Human (Scanner in){
            System.out.print("Введите имя: ");
            name=in.nextLine();

            System.out.print("Введите фамилию: ");
            surname=in.nextLine();

            System.out.print("Введите дату в формате dd.mm.yyyy: ");
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
            String str=in.nextLine();

            try {
                date = sdf.parse(str);
            } 
            catch (ParseException e) {
                e.printStackTrace();
            }
            addr=this.new Address(in);
        }

        //? - метод для вывода всех данных о человеке
        void print(){
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
            System.out.print("Человек с именем "+name+", фамилией "+surname);
            System.out.print(", дата рождения "+sdf.format(date));
            System.out.print("; его адрес: улица "+addr.street+", дом "+addr.house);
            System.out.println();
        }

        //!Внутренний класс для адреса
        class Address{
            public String street="";
            public int house=-1;
            
            Address(Scanner in){
                System.out.print("Введите улицу: ");
                street=in.nextLine();
                
                System.out.print("Введите дом: ");
                house=in.nextInt();
                in.nextLine();
            }
        }
    }
    
    public static void main(String[] args) {
       Scanner in = new Scanner(System.in);
        int len=4;
        Human[] arr=new Human[len];
        
        for (int i=0; i<arr.length; i++){
            arr[i]=new Human(in);
            arr[i].print();
            System.out.println();
        }
        
        System.out.println("================================================");
        System.out.println("Поиск человека по фамилии");
                System.out.println("Введите фамилию, по которой произведем поиск");
                String sur=in.nextLine();
                for (int i=0; i<arr.length;i++){
                    if (arr[i].surname.equals(sur)){
                      arr[i].print();
                    }
                }
        System.out.println("=================================================");
        System.out.println("Поиск человека по атрибуту адреса");
                System.out.println("Введите номер дома, по которому произведем поиск");
                int home=in.nextInt();
                in.nextLine();
                for (int i=0; i<arr.length;i++){
                    if (arr[i].addr.house==home){
                      arr[i].print();
                    }
                }
        System.out.println("=================================================");
        System.out.println("Вывести людей, родившихся между опр датами");
                SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
                System.out.print("Введите нижнюю границу даты в формате dd.mm.yyyy: ");
                String str=in.nextLine();
                Date date1=null;
                Date date2=null;
            
                try {
                   date1 = sdf.parse(str);
                } catch (ParseException e) {
                   e.printStackTrace();
                }
                System.out.print("Введите верхнюю границу даты в формате dd.mm.yyyy: ");
                str=in.nextLine();
            
                try {
                   date2 = sdf.parse(str);
                } catch (ParseException e) {
                   e.printStackTrace();
                }
                
                for (int i=0; i<arr.length; i++){
                    if (date1.before(arr[i].date) & date2.after(arr[i].date)){
                        arr[i].print();
                    }
                }
        System.out.println("=================================================");
        System.out.println("Найти самого старого и молодого");
                Date dmin=arr[0].date;
                int nmin=0;
                int nmax=0;
                Date dmax=arr[0].date;
                for (int i=0; i<arr.length; i++){
                    if (dmin.after(arr[i].date)){
                        dmin=arr[i].date;
                        nmin=i;
                    }
                    if (dmax.before(arr[i].date)){
                        dmax=arr[i].date;
                        nmax=i;
                    }
                }
                System.out.println("Самый молодой:");
                arr[nmax].print();
                System.out.println("Самый старый:");
                arr[nmin].print();
        System.out.println("=================================================");
        System.out.println("Найти людей, проживающих на одной улице");
                for (int i=0; i<arr.length;i++){
                   for (int j=i+1; j<arr.length; j++){
                        if (arr[i].addr.street.equals(arr[j].addr.street)){
                             System.out.print("Человек с именем "+arr[i].name +", фамилией "+arr[i].surname);
                             System.out.println(" проживает на одной улице с человеком с именем "+arr[j].name+", фамилией "+arr[j].surname);
                         }
                    }
                }   
    }
    
}
