package com.techelevator;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.fail;

import org.junit.Before;

public class ClassDefinitionTest<S> {

    private Class<S> subjectClass = null;
    private Constructor<S> constructor = null;

    public ClassDefinitionTest(Class<S> subjectClass) {
        this.subjectClass = subjectClass;
    }

    @Before
    public void Before() {
        constructor = SafeReflection.getConstructor(subjectClass);
        assertThat(String.format("You do not have the required default %s() constructor", getSubjectName()),
                constructor, not(nullValue()));
    }

    protected <T> void assertThatDataMemberIsReadOnly(String dataMember, Class<T> expectedReturnType) {
        dataMember = upperCaseFirstCharacter(dataMember);

        String getterName = "get" + dataMember;
        String setterName = "set" + dataMember;

        Method getter = SafeReflection.getMethod(subjectClass, getterName);
        Method setter = SafeReflection.getMethod(subjectClass, setterName, expectedReturnType);

        assertThatMethodExists(getter, getterName);
        assertThatMethodReturnsType(getter, expectedReturnType, getterName);
        assertThat(setter, is(nullValue()));
    }

    protected <T> void assertThatDataMemberIsReadWrite(String dataMember, T valueToSet) {
        dataMember = upperCaseFirstCharacter(dataMember);

        String getterName = "get" + dataMember;
        String setterName = "set" + dataMember;

        Method getter = SafeReflection.getMethod(subjectClass, getterName);
        Method setter = SafeReflection.getMethod(subjectClass, setterName, getType(valueToSet));

        assertThatMethodExists(getter, getterName);
        assertThatMethodExists(setter, setterName);

        S subject = getInstanceOfSubject();
        try {
            setter.invoke(subject, valueToSet);
            assertThat(String.format("%s() should return %s", getterName, valueToSet), getter.invoke(subject),
                    is(valueToSet));
        } catch (Exception ex) {
            fail(String.format("Unable to invoke %s() or %s(%s).", getterName, setterName,
                    valueToSet.getClass().getCanonicalName()));
            ex.printStackTrace();
        }
    }

    protected void assertThatMethodReturnsType(Method method, Class<?> expectedReturnType, String methodName) {
        assertThat(String.format("%s method needs to return type: %s", methodName, expectedReturnType.getSimpleName()),
                method.getReturnType(), equalTo(expectedReturnType));
    }

    protected void assertThatMethodExists(String methodName, Class<?> expectedReturnType, Class<?>... params) {
        Method method = SafeReflection.getMethod(getSubjectClass(), methodName, params);

        assertThatMethodExists(method, methodName);
        assertThatMethodReturnsType(method, expectedReturnType, methodName);

        assertThat(String.format(
                "%s class needs the %s method. Check the method's spelling, parameter type(s), and access modifier.",
                getSubjectName(), method), not(nullValue()));
    }

    protected void assertThatMethodExists(Method method, String methodName) {
        assertThat(String.format(
                "%s class needs the %s method. Check the method's spelling, parameter type(s), and access modifier.",
                getSubjectName(), methodName), method, not(nullValue()));
    }

    protected <T> void assertThatMethodDoesNotExist(String methodName, Class<T> param) {
        Method method = SafeReflection.getMethod(getSubjectClass(), methodName, param);

        assertThat(String.format("%s class should not have the %s method.", getSubjectName(), method), method,
                is(nullValue()));
    }

    protected S getInstanceOfSubject() {
        S subject = null;

        try {
            subject = constructor.newInstance();
        } catch (Exception e) {
            fail("Failed to instantiate " + getSubjectClass().getSimpleName());
        }

        return subject;
    }

    protected Method getMethod(String methodName, Class<?>... parameterTypes) {
        return SafeReflection.getMethod(getSubjectClass(), methodName, parameterTypes);
    }

    private Class<S> getSubjectClass() {
        return subjectClass;
    }

    private String getSubjectName() {
        return getSubjectClass().getSimpleName();
    }

    private <T> Class<?> getType(T type) {
        Class<?> klass = type.getClass();

        if (klass == Integer.class) {
            return Integer.TYPE;
        } else if (klass == Double.class) {
            return Double.TYPE;
        } else {
            return type.getClass();
        }
    }

    private String upperCaseFirstCharacter(String word) {
        char[] characters = word.toCharArray();
        characters[0] = Character.toUpperCase(characters[0]);
        return new String(characters);
    }

}