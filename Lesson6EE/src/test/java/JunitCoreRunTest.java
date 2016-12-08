import CalculatorTest.CalculatorFunctionTest;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

public class JunitCoreRunTest {

    public static void main(String[] args) {
        JUnitCore jUnitCore = new JUnitCore();
        Result run = jUnitCore.run(CalculatorFunctionTest.class);

        System.out.println(run.getFailures().size());


//        jUnitCore.addListener(new RunListener() {
//            @Override
//            public void testFailure(Failure failure) throws Exception {
//                System.out.println(failure.getDescription());
//            }
//        });
    }
}
