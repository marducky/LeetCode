[Junit使用GroboUtils进行多线程测试](https://www.cnblogs.com/yangxia-test/p/4022037.html)
``` 
运行时需依赖log4j的jar文件,GroboUtils的jar包。  

 

主要关注3个类:TestRunnable,TestMonitorRunnable,MultiThreadedTestRunner,全部来自包:net.sourceforge.groboutils.junit.v1.MultiThreadedTestRunner.

(1) TestRunnable 抽象类,表示一个测试线程,实例需要实现该类的runTest()方法,在该方法中写自己用的测试代码.

    该类继承了jUnit的junit.framework.Assert类,所以可以在TestRunnable中使用各种Assert方法

    (可惜因为GroboUtils使用的jUnit版本较老,且久未更新,新版本的jUnit中已经不推荐使用这个类的方法了).

    该类实现了Runnable,在run方法中调用抽象方法runTest().

(2)   MultiThreadedTestRunner 

 这个类相当与一个ExecuteService,可以用来执行 TestRunnable,构造函数需要传入TestRunnable数组,

 表示需要测试的线程. 

 调用MultiThreadedTestRunner.runTestRunnables() 方法启动测试线程,开始执行测试.

 这个方法默认让测试线程TestRunnable的run方法最多运行1天,也可以调用

 MultiThreadedTestRunner.runTestRunnables(long maxTime) 这个方法,然测试线程TestRunnable

 最多执行 maxTime 毫秒.如果超过maxTime毫秒之后,TestRunnable还没有执行完毕,则TestRunnable

 会被中断,并且MultiThreadedTestRunner 会抛出异常,

 导致测试失败fail("Threads did not finish within " + maxTime + " milliseconds.").

 每个TestRunnable中runTest需要能够控制自己在什么时间自己结束自己,精确控制测试时间,不要利用

 上面的maxTime.

(3) TestMonitorRunnable

表示监控线程,可以让每一个TestRunnable对应一个TestMonitorRunnable,在TestMonitorRunnable中监控

TestRunnable.TestMonitorRunnable是TestRunnable的子类,提供了一些方便使用的方法.
```