package com.lvy.log.logbackext;

import ch.qos.logback.classic.encoder.PatternLayoutEncoder;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.AppenderBase;

import java.io.IOException;

/**
 * Created by livvy on 14/11/7.
 */
public class CountingConsoleAppender extends AppenderBase<ILoggingEvent> {

    static int DEFAULT_LIMIT = 10;
    int counter = 0;
    int limit = DEFAULT_LIMIT;

    PatternLayoutEncoder encoder;

    public CountingConsoleAppender() {

    }

    public int getCounter() {
        return counter;
    }

    public int getLimit() {
        return limit;
    }

    public PatternLayoutEncoder getEncoder() {
        return encoder;
    }

    @Override
    public void start() {

        if (this.encoder == null) {
            addError("No layout set for the appender named [" + name + "].");
            return;
        }
        try {
            encoder.init(System.out);
        } catch (IOException e) {
        }
        super.start();
    }

    @Override
    public void append(ILoggingEvent event) {
        if (counter >= limit) {
            return;
        }

        try {
            this.encoder.doEncode(event);
        } catch (IOException e) {

        }
        counter++;
    }



}
