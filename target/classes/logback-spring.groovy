import ch.qos.logback.classic.encoder.PatternLayoutEncoder
import ch.qos.logback.core.rolling.RollingFileAppender
import ch.qos.logback.core.rolling.TimeBasedRollingPolicy

import static ch.qos.logback.classic.Level.INFO
import static ch.qos.logback.classic.Level.DEBUG


def LOG_HOME = "/var/log/APP/test-boot/"
def LOG_NAME = "test-boot.log"

appender("MainAppender", RollingFileAppender) {
  file = "${LOG_HOME}/${LOG_NAME}"
  rollingPolicy(TimeBasedRollingPolicy) {
	fileNamePattern = "${LOG_HOME}/${LOG_NAME}.%d{yyyy-MM-dd}"
  }
  encoder(PatternLayoutEncoder) {
	pattern = "%d [%p] [%t] [%X{tkey}] [%X{xRequestId}] [%X{TotalProcessingTime}] [%X{RequestType}] %logger{0}: %m\n"
  }
}

logger("de.malmansari", DEBUG, ["MainAppender"], false)
root(INFO, ["MainAppender"])