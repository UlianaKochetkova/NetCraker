package task4;


public class RunnerImpl {
    //Добавляющаяся величина
    private int t=0;
    //вся дистанция
    private int distance=0;
    
    public void run(){
        t++;
        distance+=t;
    }
    
    public void getDistance(){
        System.out.println(distance+"");
    }
}
