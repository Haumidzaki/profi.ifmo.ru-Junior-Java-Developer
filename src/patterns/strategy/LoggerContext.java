package patterns.strategy;

public class LoggerContext {
    private ILogger logger;

    public ILogger getLogger() {
        return logger;
    }

    public void setLogger(ILogger logger) {
        this.logger = logger;
    }

    public void write(String info) {
        logger.write(info);
    }
}
