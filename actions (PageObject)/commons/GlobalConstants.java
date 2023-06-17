package commons;

import java.io.File;

public class GlobalConstants {
public static final String PORTAL_PAGE_URL ="https://demo.nopcommerce.com/";
public static final String ADMIN_PAGE_URL ="https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F";
public static final String JQUERY_PAGE_URL="https://blueimp.github.io/jQuery-File-Upload/#" ;

public static final String PROJECT_PATH = System.getProperty("user.dir");
public static final String OS_NAME = System.getProperty("os.name");

// windown / mac

public static final String UPLOAD_FILE_FOLDER = PROJECT_PATH + File.separator + "uploadfile" + File.separator;
public static final String DOWNLOAD_FILE_FOLDER = PROJECT_PATH + File.separator + "downloadfile";
public static final String BROWSER_LOG_FOLDER = PROJECT_PATH + File.separator + "browserlogs";
public static final String DRAG_DROP_HTML5 = PROJECT_PATH + File.separator + "dragDropHTML5";
public static final String AUTO_IT = PROJECT_PATH + File.separator + "autoIT";

// Database Account/ User/ Pass/ port

public static final String DB_DEV_URL = "34,18.252.185:9860";
public static final String DB_DEV_USER = "Automationfc";
public static final String DB_DEV_PASS = "P@ssWord12@3";

public static final String  DB_TEST_URL = "34,18.232.185:9860";
public static final String DB_TEST_USER = "Automationfctest";
public static final String DB_TEST_PASS = "P@ssWord12@3";
 
public static final long SHORT_TIMEOUT = 5;
public static final long LONG_TIMEOUT = 10;
public static final long RETRY_TEST_FAIL = 3;

}
