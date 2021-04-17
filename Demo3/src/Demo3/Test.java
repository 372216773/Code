package Demo3;

public class Test {

    public static void main(String[] args) {

        Manager manager=new Manager("张三","001",7000,1000);
        manager.work();
        manager.showManagerInformation();

        Programmer programmer=new Programmer("李四","101",5000);
        programmer.work();
        programmer.showProgrammerInformation();
    }

}
