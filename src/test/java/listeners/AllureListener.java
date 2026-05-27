package listeners;

import io.qameta.allure.Attachment;
import io.restassured.response.Response;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class AllureListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {

        System.out.println(
                "Test Started : "
                        + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        System.out.println(
                "Test Passed : "
                        + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {

        System.out.println(
                "Test Failed : "
                        + result.getName());

        Throwable throwable =
                result.getThrowable();

        if (throwable != null) {

            saveFailureLog(
                    throwable.getMessage());
        }
    }

    @Override
    public void onStart(ITestContext context) {

        System.out.println(
                "Execution Started");
    }

    @Override
    public void onFinish(ITestContext context) {

        System.out.println(
                "Execution Finished");
    }

    @Attachment(
            value = "Failure Reason",
            type = "text/plain")

    public String saveFailureLog(
            String message) {

        return message;
    }

    @Attachment(
            value = "API Response",
            type = "application/json")

    public static String attachResponse(
            Response response) {

        return response.asPrettyString();
    }
}