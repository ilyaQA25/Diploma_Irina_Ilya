package data;

import org.testng.annotations.DataProvider;

public class PositiveCaseDataProvider {
    @DataProvider(name = "correctDataForTestCaseName")
    public static Object[][] correctDataForCaseName() {
        return new Object[][]{
                {"t"},
                {"59"},
                {"Entering valid data in testcase title"},
                {"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut " +
                        "labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco " +
                        "laboris nisi utQ"}, //199 chars
                {"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut " +
                        "labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco " +
                        "laboris nisi ut a"}, //200 chars
                {"!$&'()*+-/:;<=>?@[]^_`{|}~ # 123"},
        };
    }
}
