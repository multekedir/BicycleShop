package com.revature.singleton;

import org.apache.log4j.Logger;

public class LoggerSingleton {

    public static Logger logger = Logger.getRootLogger();
    private static LoggerSingleton loggerSingleton;


    private LoggerSingleton() {

    }

    public static LoggerSingleton getInstance() {
        if (loggerSingleton == null) {
            loggerSingleton = new LoggerSingleton();
        }
        logger.info("created singleton: " + loggerSingleton);
        return loggerSingleton;
    }
}
