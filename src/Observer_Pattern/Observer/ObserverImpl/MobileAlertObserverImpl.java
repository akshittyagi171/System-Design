package Observer_Pattern.Observer.ObserverImpl;

import Observer_Pattern.Observable.ObservableInterf.StocksObservable;
import Observer_Pattern.Observer.ObserverInterf.NotificationAlertObserver;

public class MobileAlertObserverImpl implements NotificationAlertObserver {

    String userName;
    StocksObservable observable;

    public MobileAlertObserverImpl(String emailId, StocksObservable observable){
        this.observable = observable;
        this.userName = emailId;
    }

    @Override
    public void update(){
        sendMsgOnMobile(userName, "Product is in stock Hurry Up!");
    }

    private void sendMsgOnMobile(String emailId, String msg){
        System.out.println("Mail sent to: " + emailId + ", " + msg);
        // send the actual mail to the end User
    }
}
