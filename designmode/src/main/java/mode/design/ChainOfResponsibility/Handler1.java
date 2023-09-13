package mode.design.ChainOfResponsibility;

/**
 * @author : ldy
 * @version : 1.0
 */
public class Handler1 extends Handler{
  @Override
  boolean canHandle(TestRequest testRequest) {
    return testRequest.getRequestType()==RequestType.TYPE1;
  }

  @Override
  void process(TestRequest testRequest) {
    System.out.println(testRequest.getData()+"  通过方式1处理请求！");
  }
}
