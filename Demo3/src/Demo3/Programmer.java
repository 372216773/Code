package Demo3;

public class Programmer extends Employee {

    public Programmer(String employeeName,String employeeId,double employeeSalary){
        SetEmployeeInformation(employeeName,employeeId,employeeSalary);
    }
    public void showProgrammerInformation(){
        System.out.println("姓名:"+employeeName+"\tID:"+employeeId+"\n工资私有,不可输出");
    }

    public void work(){
        System.out.println("程序员:"+employeeName+"正在工作");
    }

}
