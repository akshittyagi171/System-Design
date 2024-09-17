package Observer_Pattern.Observer.ObserverImpl;

import Observer_Pattern.Observable.ObservableInterf.StocksObservable;
import Observer_Pattern.Observer.ObserverInterf.NotificationAlertObserver;

public class EmailAlertObserverImpl implements NotificationAlertObserver {

    String emailId;
    StocksObservable observable;

    public EmailAlertObserverImpl(String emailId, StocksObservable observable){
        this.observable = observable;
        this.emailId = emailId;
    }

    @Override
    public void update(){
        sendMail(emailId, "Product is in stock Hurry Up!");
    }

    private void sendMail(String emailId, String msg){
        System.out.println("Mail sent to: " + emailId + ", " + msg);
        // send the actual mail to the end User
    }
}
