package com.revature.singleton;

import org.apache.log4j.Logger;

public class LoggerSingleton {

    private static Logger logger = Logger.getRootLogger();
    private static LoggerSingleton loggerSingleton;


    private LoggerSingleton() {

    }


    /**
     * Gets logger.
     *
     * @return Value of logger.
     */
    public static Logger getLogger() {
        if (loggerSingleton == null) {
            loggerSingleton = new LoggerSingleton();
            logger.info("created singleton: Logger");
        }
        return logger;
    }
}
