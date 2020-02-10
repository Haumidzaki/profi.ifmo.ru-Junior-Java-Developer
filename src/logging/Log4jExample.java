package logging;

import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;

public class Log4jExample {
    private static final Logger LOGGER = Logger.getLogger(Log4jExample.class);

    public static void main(String[] args) {
        try {
            LOGGER.debug("3 / 0");
            int res = 3 / 0;

        } catch (Exception e) {
            LOGGER.error("Some error: ", e);
        }
    }
}

// SLF4j

class SLF4jExample {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(SLF4jExample.class);
}

