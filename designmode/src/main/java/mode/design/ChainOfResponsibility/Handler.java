package mode.design.ChainOfResponsibility;

/**
 * @author : ldy
 * @version : 1.0
 */
abstract class Handler {
  private Handler nextHandler;

  public void setNextHandler(Handler nextHandler) {
    this.nextHandler = nextHandler;
  }

  public void handleRequest(TestRequest testRequest){
    if (canHandle(testRequest)){
      process(testRequest);
    }else if (nextHandler.canHandle(testRequest)){
      nextHandler.process(testRequest);
    }else {
      System.out.println("无法处理这个请求");
    }
  }

  abstract boolean canHandle(TestRequest testRequest) ;
  abstract void process(TestRequest testRequest);

}
