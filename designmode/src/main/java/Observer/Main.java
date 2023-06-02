package Observer;

/**
 * @author : ldy
 * @version : 1.0
 */
public class Main {
  public static void main(String[] args) {
    Inbox inbox = new Inbox();
    InboxObserver1 inboxObserver1 = new InboxObserver1(inbox);
    InboxObserver2 inboxObserver2 = new InboxObserver2(inbox);
    inbox.receive("xxx的邮件");
    inbox.receive("sss的邮件");
    System.out.println(inbox.getEmails());
  }
}
