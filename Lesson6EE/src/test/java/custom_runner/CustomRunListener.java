package custom_runner;

import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

public class CustomRunListener extends RunListener {
    public CustomRunListener() {
        super();
    }

    @Override
    public void testRunStarted(Description description) throws Exception {
        System.out.println(description);
    }

    @Override
    public void testRunFinished(Result result) throws Exception {
        System.out.println(result.getFailures());
    }

    @Override
    public void testStarted(Description description) throws Exception {
        super.testStarted(description);
    }

    @Override
    public void testFinished(Description description) throws Exception {
        super.testFinished(description);
    }

    @Override
    public void testFailure(Failure failure) throws Exception {
        System.out.println(failure.getDescription());
    }

    @Override
    public void testAssumptionFailure(Failure failure) {
        System.out.println(failure.getDescription());
    }

    @Override
    public void testIgnored(Description description) throws Exception {
        System.out.println(description);
    }
}
