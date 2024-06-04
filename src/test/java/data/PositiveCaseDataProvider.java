package data;

import org.testng.annotations.DataProvider;

public class PositiveCaseDataProvider {
    @DataProvider(name = "correctDataForTestCaseName")
    public static Object[][] correctDataForCaseName() {
        return new Object[][]{
                {"t", true},
                {"59", true},
                {"Entering valid data in testcase title", true},
                {"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut " +
                        "labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco " +
                        "laboris nisi utQ", true}, //199 chars
                {"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut " +
                        "labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco " +
                        "laboris nisi ut a", true}, //200 chars
                {"!$&'()*+-/:;<=>?@[]^_`{|}~ # 123", true},
        };
    }
}
