package data;

import org.testng.annotations.DataProvider;

public class PositiveCaseDataProvider {
    @DataProvider(name = "correctDataForTestCaseName")
    public static Object[][] correctDataForCaseName() {
        return new Object[][]{
                {"t"},
                {"T"},
                {"Te"},
                {"Test"},
                {"Test aqa"},
                {"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut " +
                        "labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco " +
                        "laboris nisi utQ"}, //199 chars
                {"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut " +
                        "labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco " +
                        "laboris nisi ut a"}, //200 chars
                {"Test aqa 123"},
                {"Test aqa #"},
                {"^#%*("},
                {"5989"},
        };
    }
}
