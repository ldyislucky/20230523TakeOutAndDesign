package mode.design.ChainOfResponsibility;

/**
 * @author : ldy
 * @version : 1.0
 */
public class Main {
  public static void main(String[] args) {
    Handler1 handler1 = new Handler1();
    Handler2 handler2 = new Handler2();

    handler1.setNextHandler(handler2);

    TestRequest testRequest = new TestRequest(RequestType.TYPE1, "request 1 ");
    handler1.handleRequest(testRequest);

    TestRequest testRequest1 = new TestRequest(RequestType.TYPE2, "request 2 ");
    handler1.handleRequest(testRequest1);

    TestRequest testRequest2 = new TestRequest(RequestType.TYPE1, "request 3 ");
    handler1.handleRequest(testRequest2);
  }
}
