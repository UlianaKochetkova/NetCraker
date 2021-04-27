package task3;

import java.util.*;


public class Task3 {
    
    public String first_second(String s1, String s2){
        //Переведем строки в массивы
        char[] c1=s1.toCharArray();
        char[] c2=s2.toCharArray();
        //Создадим множества h1 и h2
        HashSet<Character> h1 = new HashSet<Character>();
        HashSet<Character> h2 = new HashSet<Character>();
        //Заполним множества
        for(int i = 0; i < s1.length(); i++)                                            
        {
          h1.add(s1.charAt(i));
        }
        for(int i = 0; i < s2.length(); i++)
        {
          h2.add(s2.charAt(i));
        }
        //Найдем пересечения этих множеств
        h1.retainAll(h2);
        return h1.toString().replaceAll(",|\\[|\\]| ","");
    }
    
    public String first_notsecond(String s1, String s2){
        //Переведем строки в массивы
        char[] c1=s1.toCharArray();
        char[] c2=s2.toCharArray();
        //Создадим множества h1 и h2
        HashSet<Character> h1 = new HashSet<Character>();
        HashSet<Character> h2 = new HashSet<Character>();
        //Заполним множества
        for(int i = 0; i < s1.length(); i++)                                            
        {
          h1.add(s1.charAt(i));
        }
        for(int i = 0; i < s2.length(); i++)
        {
          h2.add(s2.charAt(i));
        }
        //Найдем пересечения этих множеств
        h1.retainAll(h2);
        String str1=h1.toString();
        //Уберем из множества h1 все те символы, которые входят в пересечение
        return s1.replaceAll(str1, "");
    }
    
    public String onestr(String s1, String s2){
        HashSet<String> set=new HashSet<String>();
        String[] a1=s1.split("");
        String[] a2=s2.split("");
        //Заполним множество элементами из строк
        for (String el: a1){
            set.add(el);
        }
        for (String el: a2){
            set.add(el);
        }
        return set.toString().replaceAll(",|\\[|\\]| ","");
    }
    
    //Метод для третьего способа вывода
    public String third(String s, int n){
        //Создадим map. Ключом будут символы строки, значением - хэш-код символа с учетом циклического сдвига на n
        HashMap<String,Integer> mp=new HashMap<String,Integer>();
        String[] arr=s.split("");
        for (String ch: arr){
            mp.put(ch, new Integer(ch.hashCode()<<n));
        }
        //Сортировка map по значению
        mp.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue());
        String result="";
        //Выведем полученные ключи
        for (Map.Entry<String, Integer> pair: mp.entrySet()){
            result+=pair.getKey();
        }
        return result;
    }
    
    
    
    public static void main(String[] args) {
       String str1="acedhfgb";
       String str2="adfoyjk";
       System.out.println("Строка 1: "+str1);
       System.out.println("Строка 2: "+str2);
       Task3 ob=new Task3();
       String result="";
       System.out.println("Выберите условие для определения символов");
       System.out.println("1 - входят и в первую и во вторую строку;\n2 - входят в первую и не входят во вторую;\n3 - содержатся хотя бы в одной строке");
       Scanner in = new Scanner(System.in);
       int c=in.nextInt();
       switch(c){
            case 1:
               result=ob.first_second(str1, str2);
            break;
            case 2:
                result=ob.first_notsecond(str1, str2);
            break;
            case 3:
                result=ob.onestr(str1, str2);
            break;
            default:
                System.out.println("Некорректный выбор");
       }
       System.out.println("Выберите условие для вывода результата");
       System.out.println("1 - в обычном порядке;\n2 - обратном порядке;\n3 - в порядке возрастания циклического сдвига влево на n разрядов хеш-функции символа");
       c=in.nextInt();
       switch(c){
            case 1:
               System.out.println(result);
            break;
            case 2:
                System.out.println(new StringBuilder(result).reverse().toString());
            break;
            case 3:
                System.out.println("Введите n");
                int n=in.nextInt();
                System.out.println(ob.third(result, n));
            break;
            default:
                System.out.println("Некорректный выбор");
       }
    }
    
}
