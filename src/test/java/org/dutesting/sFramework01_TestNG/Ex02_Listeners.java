package org.dutesting.sFramework01_TestNG;

import org.testng.ITestListener;
import org.testng.ITestResult;

//ITestListener
public class Ex02_Listeners implements ITestListener {   //Ctrl + I
    @Override
    public void onTestSuccess(ITestResult result) {
        ITestListener.super.onTestSuccess(result);
        System.out.println("onTestSuccess");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ITestListener.super.onTestFailure(result);
        //Screenshot
        System.out.println("onTestFailure");
        System.out.println("Fail TC Name " + result.getName());
    }

}

