package mode.design.Observer;

import java.util.ArrayList;

/**
 * @author : ldy
 * @version : 1.0
 */
public class Inbox extends Observable{
    private ArrayList<String> emails = new ArrayList<>();
    public void receive(String email){
        emails.add(email);
        super.notifyObserver();
    }

    public ArrayList<String> getEmails() {
        return emails;
    }
}
