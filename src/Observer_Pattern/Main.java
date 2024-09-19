package Observer_Pattern;

import Observer_Pattern.Observable.ObservableImpl.IphoneObservableImpl;
import Observer_Pattern.Observer.ObserverImpl.EmailAlertObserverImpl;
import Observer_Pattern.Observer.ObserverImpl.MobileAlertObserverImpl;

public class Main {

    public static void main(String[] args) {
        // Observable: iPhone Stock
        IphoneObservableImpl iphoneStockObservable = new IphoneObservableImpl();

        // Observer: Users who want to be notified via email or mobile
        EmailAlertObserverImpl emailObserver1 = new EmailAlertObserverImpl("user1@example.com", iphoneStockObservable);
        EmailAlertObserverImpl emailObserver2 = new EmailAlertObserverImpl("user2@example.com", iphoneStockObservable);
        MobileAlertObserverImpl mobileObserver1 = new MobileAlertObserverImpl("John", iphoneStockObservable);

        // Register the observers to the observable
        iphoneStockObservable.add(emailObserver1);
        iphoneStockObservable.add(emailObserver2);
        iphoneStockObservable.add(mobileObserver1);

        // No stock, observers should not be notified
        System.out.println("Current iPhone stock: " + iphoneStockObservable.getStockCount());

        // Adding stock, all observers should be notified
        iphoneStockObservable.setStockCount(10);

        // Output stock count after notifying
        System.out.println("Updated iPhone stock: " + iphoneStockObservable.getStockCount());

        // Removing an observer
        iphoneStockObservable.remove(emailObserver2);

        // Update stock again
        iphoneStockObservable.setStockCount(5);
    }
}

