package com.lvy.framework.crystalgrape.log;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.CoreConstants;
import ch.qos.logback.core.LayoutBase;

/**
 * Created by livvy on 14/11/24.
 */
public class SimpleLayout extends LayoutBase<ILoggingEvent> {

    @Override
    public String doLayout(ILoggingEvent event) {
        StringBuffer sb = new StringBuffer(128);
        sb.append(event.getTimeStamp() - event.getLoggerContextVO().getBirthTime());
        sb.append(" ");
        sb.append(event.getLevel());
        sb.append(" [");
        sb.append(event.getThreadName());
        sb.append("] ");
        sb.append(event.getLoggerName());
        sb.append(" - ");
        sb.append(event.getFormattedMessage());
        sb.append(" [written by livvy]");
        sb.append(CoreConstants.LINE_SEPARATOR);
        return sb.toString();
    }
}
