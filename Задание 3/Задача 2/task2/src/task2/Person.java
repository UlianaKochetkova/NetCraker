package task2;

public class Person {
    //Поля класса: фамилия, имя, отчество
    private String lastname;
    private String firstname;
    private String middlename;
    
    //Функции, необходимые для тестов
    //Ввод фамилии
    public void setLastname(String ln){
        lastname=ln;
    }
    //Ввод имени
    public void setFirstname(String fn){
        firstname=fn;
    }
    //Ввод отчества
    public void setMiddlename(String mn){
        middlename=mn;
    }
    
    @Override
    public String toString(){
        String str=lastname+" ";
        
        if (firstname!=null && firstname!=""){
            str=str+firstname+" ";
        }
        
        if (middlename!=null && middlename!=""){
            str=str+middlename+" ";
        }
        return str;
    }
    
    public String function(){
        if (firstname==null || middlename==null || firstname=="" || middlename==""){
            return null;
        }
        else{
            //Первая буква фамилии преобразовывается к верхнему регистру, затем вставляется вся остальная фамилия
            //Далее первая буква имени преобразовывается к верхнему регистру, ставится точка
            //Далее перавя буква отчества преобразовывается к верхнему регистру, ставится точка
            return lastname.substring(0,1).toUpperCase()+lastname.substring(1)+" "+firstname.substring(0,1).toUpperCase()+"."+middlename.substring(0,1).toUpperCase()+".";     
        }
    }
    
    
    public static void main(String[] args) {
        Person[] obs=new Person[3];
        obs[0]=new Person();
        obs[0].setLastname("фамилия");
        obs[0].setFirstname("имя");
        obs[0].setMiddlename("отчетство");
        
        obs[1]=new Person();
        obs[1].setLastname("фамилия");
        obs[1].setFirstname("имя");
        
        obs[2]=new Person();
        obs[2].setLastname("фамилия");
        
        for (Person ob : obs){
            System.out.println("Test: "+ob.toString());
            System.out.println("Result: "+ob.function());
            System.out.println();
        }
    }
    
}
