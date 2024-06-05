import Annotations.*;
import Assertions.AssertionMessage;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TestRunner {

    public static List<String> run(Class<?> testClass) {

        final Object testObj = initTestObj(testClass);
        List<Method> testMethods = new ArrayList<>();
        List<Method> beforeAllMethods = new ArrayList<>();
        List<Method> beforeEachMethods = new ArrayList<>();
        List<Method> afterAllMethods = new ArrayList<>();
        List<Method> afterEachMethods = new ArrayList<>();
        List<String> results = new ArrayList<>();

        for (Method method : testClass.getDeclaredMethods()) {
            if (method.getModifiers() == Modifier.PUBLIC) {
                if (method.getAnnotation(Test.class) != null) {
                    testMethods.add(method);
                } else if (method.getAnnotation(BeforeAll.class) != null) {
                    beforeAllMethods.add(method);
                } else if (method.getAnnotation(BeforeEach.class) != null) {
                    beforeEachMethods.add(method);
                } else if (method.getAnnotation(AfterAll.class) != null) {
                    afterAllMethods.add(method);
                } else if (method.getAnnotation(AfterEach.class) != null) {
                    afterEachMethods.add(method);
                }
            }
        }

        testMethods.sort(Comparator.comparingInt(m -> m.getAnnotation(Test.class).order()));

        for (Method method : beforeAllMethods) {
            invoke(testObj, method, results);
        }
        for (Method testMethod : testMethods) {
            for (Method method : beforeEachMethods) {
                invoke(testObj, method, results);
            }
            invoke(testObj, testMethod, results);
            for (Method method : afterEachMethods) {
                invoke(testObj, method, results);
            }
        }
        for (Method method : afterAllMethods) {
            invoke(testObj, method, results);
        }
        return results;
    }

    private static void invoke(Object o, Method method, List results) {
        try {
            method.invoke(o);
        } catch (InvocationTargetException e) {
            if (e.getCause().getClass().equals(AssertionMessage.class)) {
                results.add(method.getName() + ": " + e.getCause().getMessage());
            } else {
                e.printStackTrace();
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Попытка вызова недоступного метода");
        }
    }

    private static Object initTestObj(Class<?> testClass) {
        try {
            Constructor<?> noArgsConstructor = testClass.getConstructor();
            return noArgsConstructor.newInstance();
        } catch (NoSuchMethodException e) {
            throw new RuntimeException("Нет конструктора по умолчанию");
        } catch (InvocationTargetException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException("Не удалось создать объект тест класса");
        }
    }

}
