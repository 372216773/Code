package Demo3;

public class Employee {

    public String employeeName;
    public String employeeId;
    private double employeeSalary;

    public void work(){
        System.out.println(employeeName+"正在工作");
    }

    public void SetEmployeeInformation(String employeeName,String employeeId,double employeeSalary){
        this.employeeName=employeeName;
        this.employeeId=employeeId;
        this.employeeSalary=employeeSalary;
    }

}
