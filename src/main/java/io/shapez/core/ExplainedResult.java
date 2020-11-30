package io.shapez.core;

public class ExplainedResult {
    private final boolean result;
    private String reason;

    ExplainedResult(boolean result, String reason, Object[] additionalProps) {
        this.result = result;
        this.reason = reason;
//        for (Object key : additionalProps) {
//            do something
//        }
    }

    public ExplainedResult(boolean result) {
        this.result = result;
    }

    static ExplainedResult bad(String reason, Object[] additionalProps) {
        return new ExplainedResult(false, reason, additionalProps);
    }

    public static ExplainedResult good() {
        return new ExplainedResult(true);
    }

    public static ExplainedResult bad(String reason) {
        return new ExplainedResult(false, reason, new Object[]{});
    }

    public boolean isGood() {
        return this.result;
    }
}
