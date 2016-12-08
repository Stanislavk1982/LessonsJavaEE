package calculatorTest;

public class Calculator {

    private int operant1;
    private int operant2;

    public Calculator(int operant1, int operant2) {
        this.operant1 = operant1;
        this.operant2 = operant2;
    }

    public Calculator() {
    }

    public int getOperant1() {
        return operant1;
    }

    public void setOperant1(int operant1) {
        this.operant1 = operant1;
    }

    public int getOperant2() {
        return operant2;
    }

    public void setOperant2(int operant2) {
        this.operant2 = operant2;
    }

    public int add () {
        return operant1+operant2;
    }

    public int substruct() {
        return operant1-operant2;
    }

    public int add(int n1, int n2) {
        return n1+n2;
    }

    @Override
    public String toString() {
        return "Calculator{" +
                "operant1=" + operant1 +
                ", operant2=" + operant2 +
                '}';
    }
}
