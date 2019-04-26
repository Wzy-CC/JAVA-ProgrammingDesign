# Java线程及进程

## 一.线程简介：

操作系统中：

1. 进程：每个进程都有独立的代码和数据空间（进程上下文） ，进程切换的开销大。
2. 线程：轻量的进程，同一类线程共享代码和数据空间，每个线程有独立的运行栈和程序计数器（PC），线程切换的开销小。
3. 多线程是多任务的一种特别的形式，但多线程使用了更小的资源开销。
4. 线程/进程的生命周期：见《操作系统》，**创建、就绪、运行、阻塞、终止。**
5. 线程安全，同步（并发和并行）：`synchronized`关键字加锁（高级锁lock类）。

## 二.Java线程及进程：

### 1.Java`线程简介`/基本概念：

**线程简介：**

Java支持多线程（所有类都在多线程模式下定义）

Java利用多线程使整个系统成为异步系统。

Java中的线程由三部分组成：

1. 虚拟的CPU，封装在`java.lang.Thread`类中。
2. CPU所执行的代码，传递给`Thread`类。
3. CPU所处理的数据，传递给`Thread`类。

**基本概念：**

线程同步，线程间通信，线程死锁，线程控制：挂起，停止和恢复

### 2.Java线程的优先级：

Java线程的优先级有助于系统确定线程的调度顺序。

Java 线程的优先级是一个整数，其取值范围是 `Thread.MIN_PRIORITY` (1) ---- `Thread.MAX_PRIORITY` (10)，默认情况下，每一个线程都会分配一个优先级 `NORM_PRIORITY`(5)

### 3.创建线程：

三种创建Java线程的方法（本质上都是通过方法run()来完成操作的，方法run()称为线程体）：

#### A.实现Runnable接口:

一个类声明实现Runnable接口就可以充当线程体，在接口Runnable中只定义了一个方法`public void run();`任何实现接口Runnable的对象都可以作为一个线程的目标对象，类Thread本身也实现了接口Runnable，因此我们也可以通过继承Thread类实现线程体。

例如：Thread类定义了多种构造函数，最常见使用形式：

```java
Thread(Runnable threadOb,String threadName)
```

其中threadOb是实现接口Runnable的类的实例，threadName指定新线程的名字。

#### B.继承Thread类：

定义一个线程类，它继承线程类Thread并重写其中的方法 run（），这时在初始化这个类的实例时，目标target可为null，表示由这个实例对来执行线程体。由于Java只支持单重继承，用这种方法定义的类不能再继承其它父类。

#### C.通过Callable和Future创建线程：

1. 创建 Callable 接口的实现类，并实现 call() 方法，该 call() 方法将作为线程执行体，并且有返回值。
2. 创建 Callable 实现类的实例，使用 FutureTask 类来包装 Callable 对象，该 FutureTask 对象封装了该 Callable 对象的 call() 方法的返回值。
3. 使用 FutureTask 对象作为 Thread 对象的 target 创建并启动新线程。
4. 调用 FutureTask 对象的 get() 方法来获得子线程执行结束后的返回值。

#### D.创建线程三种方式的对比：

1.采用实现 Runnable、Callable 接口的方式创建多线程时，线程类只是实现了 Runnable 接口或 Callable 接口，还可以继承其他类。

2.使用继承 Thread 类的方式创建多线程时，编写简单，如果需要访问当前线程，则无需使用 Thread.currentThread() 方法，直接使用 this 即可获得当前线程。

### 4.Java线程间的状态：

六种状态：
![Java线程状态](/Java线程状态.png)

### 5.基本线程类&高级多线程控制类：

略。

## 三.总结：

### 1.多线程的使用：

通过对多线程的使用，可以编写出非常高效的程序。但是如果创建太多的线程，程序的执行效率实际上是降低了，而不是提升了。

线程安全的优先级高于性能。

每个对象都有的方法：`synchronized()`，`wait()`，`notify()`。

## 四.代码/实现：

略。









