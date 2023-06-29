package ChainOfResponsibility;

/**
 * @author : ldy
 * @version : 1.0
 */
public class TestRequest {
    private RequestType requestType;
    private String data;

    public TestRequest(RequestType requestType, String data) {
        this.requestType = requestType;
        this.data = data;
    }

    public RequestType getRequestType() {
        return requestType;
    }

    public String getData() {
        return data;
    }
}
