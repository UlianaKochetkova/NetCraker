package task4;


public class Shirt {
    
    //Поля в соответствии с диаграммой
    private String id;
    private String description;
    private String color;
    private String size;
    
    //Метод выводит объяснение и значение полей построчно
    //В данном случае, построчно - это каждая информация по полю выводится с новой строки
    @Override
    public String toString(){
       return "id: "+id+"\n"+"description: "+description+"\n"+"color: "+color+"\n"+"size: "+size;
    }
    
    //Метод преобразует строковый массив shirts в массив класса Shirt и выводит его на консоль
    public void convertTo(){
        //Введем массив
        String[] shirts=new String[11];
        shirts[0] = "S001,Black Polo Shirt,Black,XL";
        shirts[1] = "S002,Black Polo Shirt,Black,L";
        shirts[2] = "S003,Blue Polo Shirt,Blue,XL";
        shirts[3] = "S004,Blue Polo Shirt,Blue,M";
        shirts[4] = "S005,Tan Polo Shirt,Tan,XL";
        shirts[5] = "S006,Black T-Shirt,Black,XL";
        shirts[6] = "S007,White T-Shirt,White,XL";
        shirts[7] = "S008,White T-Shirt,White,L";
        shirts[8] = "S009,Green T-Shirt,Green,S";
        shirts[9] = "S010,Orange T-Shirt,Orange,S";
        shirts[10] = "S011,Maroon Polo Shirt,Maroon,S";
        
        Shirt[] result=new Shirt[11];
        for (int i=0; i<shirts.length; i++){
            String[] sp=shirts[i].split(",");
            result[i]=new Shirt();
            result[i].id=sp[0];
            result[i].description=sp[1];
            result[i].color=sp[2];
            result[i].size=sp[3];
            sp=null;
        }
        
        for (Shirt el : result){
            System.out.println(el.toString());
            System.out.println();
        }
    }
    
    
    public static void main(String[] args) {
        Shirt ob=new Shirt();
        ob.convertTo();
    }
    
}
