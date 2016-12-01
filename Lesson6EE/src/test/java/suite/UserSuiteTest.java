package suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import user_service.UserServiceTest;
import user_service.UserServiceTest2;

@RunWith(Suite.class)
@Suite.SuiteClasses({UserServiceTest.class, UserServiceTest2.class})
public class UserSuiteTest {
}
