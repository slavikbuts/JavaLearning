package auto.driverSetup;

import auto.driverSetup.drivers.ChromeDriverManager;
import auto.driverSetup.drivers.FireFoxDriverManager;

public class DriverManagerFactory {
    public static DriverManager getDriverManager(DriverType type) {
        DriverManager driverManager;
        switch (type) {
            case CHROME:
                driverManager = new ChromeDriverManager();
                break;
            case FIREFOX:
                driverManager = new FireFoxDriverManager();
                break;
            default:
                driverManager = new ChromeDriverManager();
                break;
        }

        return driverManager;
    }

}
