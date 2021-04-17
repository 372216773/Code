public class Calculator {
    private int num1;
    private int num2;

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public int add() {
        return this.num1+this.num2;
    }
    public int sub() {
        return this.num1-this.num2;
    }
    public int mul() {
        return this.num1*this.num2;
    }
    public double dev() {
        return (double)this.num1/this.num2;
    }

    public static void main(String[] args) {
        Calculator calculator=new Calculator();
        calculator.setNum1(12);
        calculator.setNum2(12);
        System.out.println(calculator.add());
        System.out.println(calculator.dev());
        System.out.println(calculator.mul());
        System.out.println(calculator.dev());
    }
}

