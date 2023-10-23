package Ejercicio_3;

import java.util.logging.Formatter;
import java.util.logging.LogRecord;

class CustomLogFormatter extends Formatter {
    @Override
    public String format(LogRecord record) {
        return record.getMessage() + "\n";
    }
}