package com.automationtest.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Siva.Thota on 16/Oct/2018
 **/
public class LoggingFactory {

    public static Path logLoc = Paths.get("src/main/resources", "log4j2.xml").toAbsolutePath();
    public static String loggerLocation = System.setProperty("log4j.configurationFile",logLoc.toString());
    public static Logger log = LogManager.getLogger(LoggingFactory.class);

    public LoggingFactory() { }
}
