package Lesson7;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws Exception {
        Class aClass = MyClass.class;
        Object obj = aClass.newInstance();
        Method[] methods = aClass.getDeclaredMethods();
        ArrayList<Method> al = new ArrayList<>();

        Method before = null;
        Method after = null;
        for (Method o : aClass.getDeclaredMethods()) {
            if (o.isAnnotationPresent(Test.class)) {
                al.add(o);
            }
            if(o.isAnnotationPresent(BeforeSuite.class)) {
                if(before == null) before = o;
                else throw new RuntimeException("Больше одного метода с аннотацией BeforeSuite");
            }
            if(o.isAnnotationPresent(AfterSuite.class)) {
                if(after == null) after = o;
                else throw new RuntimeException("Больше одного метода с аннотацией AfterSuite");
            }
            al.sort(new Comparator<Method>() {
                @Override
                public int compare(Method o1, Method o2) {
                    return o2.getAnnotation(Test.class).priority() - o1.getAnnotation(Test.class).priority();
                }
            });
        }

        if (before != null) before.invoke(obj,null);
        for (Method o : al) o.invoke(obj,null);
        if (after != null) after.invoke(obj,null);
    }


}
