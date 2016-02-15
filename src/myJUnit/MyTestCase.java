package myJUnit;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyTestCase {

	public void testMethod() {
	}

	public String run() {
		TestResult result = new TestResult();
		Method[] methods = getClass().getMethods();
		for (int i = 0; i < methods.length; i++) {
			if (methods[i].getName().startsWith("test")) {
				setUp();
				result.testRuned();
				try {
					methods[i].invoke(this);
				} catch (IllegalAccessException | IllegalArgumentException
						| InvocationTargetException e) {
					result.testFailed();
					if(e.getCause().toString().equals(AssertionError.class.getName()))
						e.printStackTrace();
				}
				tearDown();
			}
		}
		return result.summary();
	}

	public void setUp() {
	}

	public void tearDown() {
	}

	public int getCountMethods() {
		Method[] methods = getClass().getMethods();
		int count = 0;
		for (int i = 0; i < methods.length; i++) {
			if (methods[i].getName().startsWith("test")) {
				count++;
			}
		}
		return count;
	}
}
