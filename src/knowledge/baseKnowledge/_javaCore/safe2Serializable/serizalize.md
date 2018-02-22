>[序列化漏洞](https://www.tuicool.com/articles/Yz6fUzE)
``` 
简单的反序列化漏洞demo

在Java反序列化中，会调用被反序列化的readObject方法，当readObject方法书写不当时就会引发漏洞。

PS：有时也会使用readUnshared()方法来读取对象，readUnshared()不允许后续的readObject和readUnshared调用引用这次调用反序列化得到的对象，而readObject读取的对象可以。
因此开发时产生的反序列化漏洞常见的有以下几种情况：

重写ObjectInputStream对象的resolveClass方法中的检测可被绕过。

使用第三方的类进行黑名单控制。虽然Java的语言严谨性要比PHP强的多，但在大型应用中想要采用黑名单机制禁用掉所有危险的对象几乎是不可能的。因此，如果在审计过程中发现了采用黑名单进行过滤的代码，多半存在一两个‘漏网之鱼’可以利用。并且采取黑名单方式仅仅可能保证此刻的安全，若在后期添加了新的功能，就可能引入了新的漏洞利用方式。所以仅靠黑名单是无法保证序列化过程的安全的。
基础库中隐藏的反序列化漏洞

优秀的Java开发人员一般会按照安全编程规范进行编程，很大程度上减少了反序列化漏洞的产生。并且一些成熟的Java框架比如Spring MVC、Struts2等，都有相应的防范反序列化的机制。如果仅仅是开发失误，可能很少会产生反序列化漏洞，即使产生，其绕过方法、利用方式也较为复杂。但其实，有很大比例的反序列化漏洞是因使用了不安全的基础库而产生的。

2015年由黑客Gabriel Lawrence和Chris Frohoff发现的‘Apache Commons Collections’类库直接影响了WebLogic、WebSphere、JBoss、Jenkins、OpenNMS等大型框架。直到今天该漏洞的影响仍未消散。
存在危险的基础库：
commons-fileupload 1.3.1
commons-io 2.4
commons-collections 3.1
commons-logging 1.2
commons-beanutils 1.9.2
org.slf4j:slf4j-api 1.7.21
com.mchange:mchange-commons-java 0.2.11
org.apache.commons:commons-collections 4.0
com.mchange:c3p0 0.9.5.2
org.beanshell:bsh 2.0b5
org.codehaus.groovy:groovy 2.3.9
org.springframework:spring-aop 4.1.4.RELEASE
某反序列化防护软件便是通过禁用以下类的反序列化来保护程序：

'org.apache.commons.collections.functors.InvokerTransformer',
'org.apache.commons.collections.functors.InstantiateTransformer',
'org.apache.commons.collections4.functors.InvokerTransformer',
'org.apache.commons.collections4.functors.InstantiateTransformer',
'org.codehaus.groovy.runtime.ConvertedClosure',
'org.codehaus.groovy.runtime.MethodClosure',
'org.springframework.beans.factory.ObjectFactory',
'xalan.internal.xsltc.trax.TemplatesImpl'
基础库中的调用流程一般都比较复杂，比如 org.apache.commons.collections.functors.InvokerTransformer 的POP链就涉及反射、泛型等，而网上也有很多复现跟踪流程的文章，比如前些天先知发布的这两篇。

Java反序列化漏洞-玄铁重剑之CommonsCollection(上)

Java反序列化漏洞-玄铁重剑之CommonsCollection(下)

这里就不再赘述了，可以跟着ysoserial的EXP去源码中一步步跟进、调试。
```