package com.blazeclan.qa.utility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.blazeclan.qa.logging.Log;

public class RetryFailedTestCases implements IRetryAnalyzer {


	private int retryCnt=0;

	public boolean retry(ITestResult iTestResult) {
		int maxRetryCnt=1;
		if(retryCnt< maxRetryCnt) {
			Log.info("Retrying" + iTestResult.getName() + "again and the count is " +(retryCnt +1));
			retryCnt++;
			return true;

		}
		return false;
	}
}
