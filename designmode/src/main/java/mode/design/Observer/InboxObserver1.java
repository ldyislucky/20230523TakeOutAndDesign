package mode.design.Observer;

/**
 * @author : ldy
 * @version : 1.0
 */
public class InboxObserver1 implements Observer{
    private Inbox inbox;

    public InboxObserver1(Inbox inbox) {
        this.inbox = inbox;
        inbox.addObserver(this);
    }

    @Override
    public void update() {
        System.out.println("观察者1发现了新邮件。");
    }
}
