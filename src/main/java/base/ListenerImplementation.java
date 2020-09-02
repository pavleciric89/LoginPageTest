package base;

import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImplementation extends BaseUtil implements ITestListener {


    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS, "Test Case: " + result.getMethod().getMethodName() + " is Passed.");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.log(Status.FAIL, "Test Case: " + result.getMethod().getMethodName() + " is Failed.");
        test.log(Status.FAIL, result.getThrowable());
//        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyy HH-mm-ss");
//        Date date = new Date();
//        String actualDate = format.format(date);
//        String screenshotPath = System.getProperty("user.dir") + "/Reports/Screenshots/photo"+actualDate+".png";
//        File dest = new File(screenshotPath);
//        try {
//            FileUtils.copyFile(src,dest);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        try {
//            test.addScreenCaptureFromPath(screenshotPath, "Test case failure screenshot");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {
        extent = ExtentReport.setupExtentReport();
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
