package uk.co.leemorris.starfighter.model;

/**
 * Maps standard response fields.
 * @author lmorris
 */
public abstract class BaseResponse {

    private final boolean ok;
    private final String error;

    public BaseResponse(boolean ok, String error) {
        this.ok = ok;
        this.error = error;
    }

    public boolean isOk() {
        return ok;
    }

    public String getError() {
        return error;
    }
}
