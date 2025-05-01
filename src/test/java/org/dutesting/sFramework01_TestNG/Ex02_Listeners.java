package org.dutesting.sFramework01_TestNG;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.awt.event.ItemListener;

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

    }

}

