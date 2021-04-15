package spring5_1;

public class People {
    private String name;
    private String work;

    public People(String name,String work){
        this.name = name;
        this.work = work;
    }

    public void pr(){
        System.out.println(name+"::"+work);
    }
}
