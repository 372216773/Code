package Demo3;

public class Manager extends Employee {


    private double employeeBonus;

    public Manager(String employeeName,String employeeId,double employeeSalary,double employeeBonus){
        SetEmployeeInformation(employeeName,employeeId,employeeSalary);
        this.employeeBonus=employeeBonus;
    }

    public void showManagerInformation(){
        System.out.println("姓名:"+employeeName+"\tID:"+employeeId+"\n工资私有,不可输出"+"\t奖金私有,不可输出");
    }

    public void work(){
        System.out.println("经理:"+employeeName+"正在工作");
    }

}
