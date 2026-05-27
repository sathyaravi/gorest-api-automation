package dataproviders;

import org.testng.annotations.DataProvider;
import utils.JsonDataReader;

public class UserDataProvider {

    @DataProvider(name = "userData")

    public Object[][] getUserData() {

        return new Object[][]{

                {"createUserPositive",
                        JsonDataReader.getTestData("createUserPositive")},

                {"createUserNegative",
                        JsonDataReader.getTestData("createUserNegative")}
        };
    }
}