# error to slove
>org.hamcrest.SelfDescribing ;java.lang.NoClassDefFoundError: org/hamcrest/SelfDescribing

``` 
http://blog.csdn.net/castle07/article/details/8553704
```
``` 
今天尝试使用JUnit，下载了最新的JUnit版本，是4.11，结果尝试使用发现总是报java.lang.NoClassDefFoundError: org/hamcrest/SelfDescribing这样的错误，上网查了一下，一般的解决方案是，换一个低一点的版本就好了。还有人说，是缺少hamcrest的包。去官网又看了一下，结果发现这样一段话：

junit.jar: Includes the Hamcrest classes. The simple all-in-one solution to get started quickly.Starting with version 4.11, Hamcrest is no longer included in this jar.
junit-dep.jar: Only includes the JUnit classes but not Hamcrest. Lets you use a different Hamcrest version.
注意黑色加下划线的部分。说明4.1.1中没有hamcrest包了，不知道作者是怎么想的。



最好的解决方法是：



使用是导入包的方案：junit.jar + hamcrest-core.jar + hamcrest-library.jar

或者是：junit-dep.ajr+hancrest-all.jar

这两种导入方法虽然尽量避免了导入重复的包，但使用时还是遇到了冲突。查看包中各类和文档后发现有些类(例如：断言is()）同时出现在了org.hamcrest.Mathchers和org.hamcrest.core中，则在用到时候引入的时候需要注意。


```