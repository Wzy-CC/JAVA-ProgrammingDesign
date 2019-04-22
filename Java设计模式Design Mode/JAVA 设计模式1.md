# JAVA 设计模式：

##  一.建造者模式：

### 1.简介：

在建造者模式中，一共有四个角色：

1.具体的类（最终类，直接初始化为对象）

2.建造者接口（抽象的，在后继承时具体实现）

3.实现的建造者接口（重写接口方法，实现具体的建造过程）

4.建造者模式最重要的部分：监督者。监督者函数的参数为3中的建造者。对于建造不同的类传入不同的建造者接口

### 2.代码：

待构造的类A：

```java
public class A {}
```

初始化类属性的接口：

```java
public interface IA {}
```

实现类A的接口( 等同于创建一个A的对象)：

```java
public class A1 implements IA {}
```

director类（返回IA中的建造函数）：

```java
public class Director{}
```

### 3.为什么需要建造者模式：

学习过程中的一个问题，为什么需要建造者模式？直接创建多个类和new多个对象不就好了么？

首先建造者模式使用Director完全屏蔽了建造的具体实现，建造者模式的最终目的是建造者独立易扩展（和类的继承完全一致的目的），与之可以类比c++中对抽象类的继承实现，使用建造者模式可以很好的分离代码的不同功能，更加方便的维护，重用代码。



## 二.观察者模式：

### 1.1简介：

观察者模式的定义：

在对象之间定义了一对多的依赖，这样一来，当一个对象改变状态，依赖它的对象会收到通知并自动更新。

### 1.2.组成：

在观察者模式中，一共有四个角色：

1.抽象观察者：所有观察者的共同属性抽象，在具体观察者中实现。当发布者发布消息时，更新函数被回调。

2.抽象发布者：所有发布者的共同属性抽象，在具体发布者中实现。保存了所有观察者的对象引用，通知观察者消息，并调用观察者更新函数。

3.具体观察者：例如WeChat用户，Facebook用户都是具体的观察者，在发布者更新后接收到推送，实现了抽象观察者的方法。

4.具体发布者：如微信公众号推送，实现了抽象发布者的方法。

### 2.代码：

抽象观察者（一系列函数的接口）：

```java
public interface Observer {
    public void update();
}
```

抽象发布者（对观察者的增删改查操作及通知函数）：

```java
public interface Publisher {
    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObserver();
}
```

具体观察者：

```java
public class User implements Observer {
    ...
}
```

具体发布者（list集合保存注册的观察者）：

```java
public class WechatServer implements Publisher {
    private List<Observer> list;
    private String message;
    ...
}
```

### 3.为什么需要观察者模式/观察者模式的优点：

观察者模式松耦合，改变任何一方，另一方不会受到影响（就是封装做的比较好）。但是其实说到底，观察者模式并没有体现出设计模式应有的设计思想，仅仅只是一个推送/接受推送的模型而已。



## 三.适配器模式：

### 1.1.简介：

适配器模式的定义：

将一个类的接口转成客户期望的另外一个接口。适配器模式使得原本由于接口不匹配而不能一起工作的那些类可以一起工作。

### 1.2.适配器模式分类：

类的适配器模式，对象的适配器模式，接口的适配器模式

### 1.3.组成：

适配器模式一共有四个角色：

1.客户端：client无法直接访问adaptee

2.抽象适配器（客户端接口）：客户端所期待的接口

3.需要适配的类：目标接口

4.具体适配器：在内部包装一个Adaptee（3中的对象）对象，把源接口转换为目标接口

### 2.代码：

客户端（带有typeclient源接口）

```java
public class client {
    public void typeClient(){
        ...
    }
}
```

需要适配的类/接口：

```java
public interface Target {
    void TargetInterface();    
}
```

**2.1.类的适配器模式：**

通过继承来实现适配器功能：

```java
public class Client2Target extends client implements Target {
    @Override
    public void TargetInterface() {
        typeClient();
        ...
    }
}
```

**2.2.对象的适配器模式：**

通过将客户端对象作为适配器类的成员来实现适配器的功能：

```java
public class Client2Target implements Target {
    private client clientobject;
    
    public Client2Target(client object){
        // 构造函数
        this.clientobject = object;
    }
    
    @Override
    public void TargetInterface(){
        clientobject.typeClient();
    }
}
```

**定义类X用来测试上述两个适配器：**

```java
public class X{
    public static void main(String[] args){
        // 类的适配器模式：
        Target t = new Client2Target();
        t.TargetInterface();
        
        // 对象的适配器模式：
        Client2Target c = new Client2Target(client o);
        c.TargetInterface();
    }
}
```

### 3.为什么需要适配器模式/适配器模式的优点：

灵活解耦，在不同的需求时可以使用不同的适配器模式，推荐使用对象适配器模式（对象适配器使用频率也较高）。

除此之外很平常，并没有体现什么设计思想。



## 四.策略模式：

### 1.1.简介：

策略模式的定义：

定义一组算法，将每个算法都封装起来，使得它们之间可以相互替换。策略模式让算法独立于调用它的客户端而独立变化。

### 1.2.组成：

策略模式一共有四个角色：

1.抽象策略类：定义了多个策略的公共接口，具体策略以不同的方式实现这个接口，由上下文进行调用不同算法。

2.具体策略类：实现抽象策略类或者继承于抽象策略类，封装了具体的算法和行为。

3.环境类 ：上下文环境，维护一个对抽象策略类的引用，直接给客户端调用。

4.客户端：自由调用具体策略。

### 2.代码：

抽象策略类：

```java
public interface Strategy{
    public void AlgorithmInterface();
}
```

具体策略类（实现了抽象策略类的接口）：

```java
public class ConcreteStrategy implements Strategy{
    @Override
    public void  AlgorithmInterface(){
        ...
    }
}
```

上下文环境类：

```java
public class Context{
    Strategy s;
    
    public Context(Strategy s){
        // 构造函数
        this.s = s;
    }
    
    public void setStrategy(Strategy s){
        // set方法：
        this.s = s;
    }
    
    public void AlgorithmInterface(){
        s.AlgorithmInterface();
    }
}
```

客户端调用过程:

```java
public class Client{
    public static void main (String[] args){
        // 默认策略假设为策略1：
        Context c = new Context(new ConcreteStrategy1());
        c.AlgorithmInterface();
        
        // 上下文环境发生改变，需要调用策略2：
        ...
        
        // 切换策略：
        c.set(new ConcreteStrategy2());
        c.AlgorithmInterface();
    }
}
```

### 3.为什么需要策略模式/策略模式的优点：

传递不同参数使之执行不同策略，优点是可扩展多个不同策略，缺点是客户端必须知道所有的策略类，并自行决定使用哪一种。每个具体的策略都会产生一个新类，这样会造成很多策略类。



## 五.四个java设计模式总结：

学习了设计模式后，才发现设计模式除了限制编程的开放性思维，没什么用。

Ps：还存在一个父类和派生类互相调用的对方成员的小问题，下一个md再写（包括著名的工厂模式，单例模式和原型模式）。

















