package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class UserSystemManager {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
//        User user = new User("XXX", 12);
//        Class<? extends User> userClass = user.getClass();
//        System.out.println("class name = " + userClass.getName());
//
//        Constructor<?>[] constructors = userClass.getDeclaredConstructors();
//        for (Constructor constructor : constructors) {
//            printModifiersById(constructor.getModifiers());
//
//            System.out.println(Arrays.toString(constructor.getGenericParameterTypes()));
//
//        }
//
//        //userClass.newInstance();
//        Field[] fields =  userClass.getDeclaredFields(); //userClass.getFields();
//        for (Field field : fields) {
//            printModifiersById(field.getModifiers());
//            System.out.println(field.getName());
//        }
//
//        System.out.println(user);
//        Field fieldName = userClass.getDeclaredField("name");
//        fieldName.setAccessible(true);
//        fieldName.set(user,"yyy");
//        System.out.println(user);


        String test ="test";
        System.out.println(test.hashCode());
        test=test.concat("_xxxx");
        System.out.println("str value= "+test+"      hc:"+ test.hashCode());

        //case with reflection
        test = "test";
        System.out.println(test.hashCode());
        Field value = test.getClass().getDeclaredField("value");
        value.setAccessible(true);
        value.set(test,"test_xxx".toCharArray());
        System.out.println("str value= "+test+"      hc:"+ test.hashCode());


    }

    private static void printModifiersById(int modifiers) {
        if (Modifier.isPublic(modifiers)) {
            System.out.println("public");
        }
        if (Modifier.isFinal(modifiers)) {
            System.out.println("final");
        }

        if (Modifier.isPrivate(modifiers)) {
            System.out.println("privat");
        }
    }
}
