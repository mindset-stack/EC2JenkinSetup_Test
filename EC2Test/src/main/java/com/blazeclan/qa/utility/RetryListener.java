package com.blazeclan.qa.utility;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

public class RetryListener implements IAnnotationTransformer {

	@SuppressWarnings("unchecked")
	public void transform(ITestAnnotation annotation, Class testClass, Constructor tesConstructor, Method testMethod) {


		annotation.setRetryAnalyzer(RetryFailedTestCases.class);
	}


}
