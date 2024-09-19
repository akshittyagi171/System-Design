
# Observer Pattern - In-Depth Explanation

The **Observer Pattern** is a behavioral design pattern where an object (called the **subject** or **observable**) maintains a list of its dependents (called **observers**) and notifies them automatically of any state changes, usually by calling one of their methods.

## Purpose
The Observer Pattern is used to establish a one-to-many dependency between objects. When the subject's state changes, all the dependent objects (observers) are automatically notified. This pattern is useful when you have multiple objects that need to stay synchronized with the state of one object.

## Key Participants in Observer Pattern:

### 1. Subject (Observable)
The **Subject** is the object that is being observed. It is responsible for maintaining the list of observers and notifying them of any changes to its state. In our case, the `IphoneObservableImpl` class represents the subject, which manages the stock count of iPhones.

The subject class includes methods to add, remove, and notify observers when stock changes.

```java
package Observer_Pattern.Observable.ObservableImpl;

import Observer_Pattern.Observable.ObservableInterf.StocksObservable;
import Observer_Pattern.Observer.ObserverInterf.NotificationAlertObserver;

import java.util.ArrayList;
import java.util.List;

public class IphoneObservableImpl implements StocksObservable {
    public List<NotificationAlertObserver> observerList = new ArrayList<>();
    public int stockCount = 0;

    @Override
    public void add(NotificationAlertObserver observer) {
        observerList.add(observer);
    }

    @Override
    public void remove(NotificationAlertObserver observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifySubscribers() {
        for(NotificationAlertObserver observer: observerList){
            observer.update();
        }
    }

    @Override
    public void setStockCount(int newStockAdded) {
        if(stockCount == 0){
            notifySubscribers();
        }
        stockCount = stockCount + newStockAdded;
    }

    @Override
    public int getStockCount() {
        return stockCount;
    }
}
```

### 2. Observer Interface
This interface defines the contract that all observers must follow. Any class that wants to be notified of changes in the subject's state must implement this interface. In our case, the `NotificationAlertObserver` interface defines the `update()` method.

```java
package Observer_Pattern.Observer.ObserverInterf;

public interface NotificationAlertObserver {
    public void update();
}
```

### 3. Concrete Observers
The concrete observer classes implement the `NotificationAlertObserver` interface and define how they will respond to notifications from the subject.

#### EmailAlertObserverImpl
This observer sends an email alert to the user when the stock is updated.

```java
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
    }
}
```

#### MobileAlertObserverImpl
This observer sends a mobile alert to the user when the stock is updated.

```java
package Observer_Pattern.Observer.ObserverImpl;

import Observer_Pattern.Observable.ObservableInterf.StocksObservable;
import Observer_Pattern.Observer.ObserverInterf.NotificationAlertObserver;

public class MobileAlertObserverImpl implements NotificationAlertObserver {

    String userName;
    StocksObservable observable;

    public MobileAlertObserverImpl(String userName, StocksObservable observable){
        this.observable = observable;
        this.userName = userName;
    }

    @Override
    public void update(){
        sendMsgOnMobile(userName, "Product is in stock Hurry Up!");
    }

    private void sendMsgOnMobile(String userName, String msg){
        System.out.println("Message sent to: " + userName + ", " + msg);
    }
}
```

## Benefits of the Observer Pattern
1. **Loose Coupling**: The subject doesn't need to know the details of the observers. It only interacts with them via the `update()` method, allowing for flexibility.
2. **Dynamic Relationships**: Observers can be added or removed at runtime, making it easy to modify behavior without changing the subject.
3. **One-to-Many Relationship**: A single subject can notify multiple observers, ensuring that all interested parties are up-to-date.

## Example Usage
Consider the following main class, which creates an observable for iPhone stock and observers for email and mobile alerts:

```java
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
```

## Output:
```
Current iPhone stock: 0
Mail sent to: user1@example.com, Product is in stock Hurry Up!
Mail sent to: user2@example.com, Product is in stock Hurry Up!
Message sent to: John, Product is in stock Hurry Up!
Updated iPhone stock: 10
Message sent to: John, Product is in stock Hurry Up!
Mail sent to: user1@example.com, Product is in stock Hurry Up!
Updated iPhone stock: 15
```

## Conclusion
The Observer Pattern is particularly useful when there are multiple objects interested in the state of one object. This pattern ensures that all observers are notified when the subject's state changes, without the subject needing to know specific details about its observers. By using this pattern, you can easily add new observers and modify existing ones without altering the subject itself.
