package knowledge.baseKnowledge._javaCore.lombok;

/**
 * @author: Neng Qi
 * @email: neng.qi@nuance.com
 * @date: 2018/03/14 10:37
 **/

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 要使用这个对象,必须还要写一些getter和setter方法,可能还要写一个构造器、equals方法、或者hash方法.这些方法很冗长而且没有技术含量,我们叫它样板式代码.
 * lombok的主要作用是通过一些注解，消除样板式代码，像这样：
 */
//@Data
@Getter
@Setter
@ToString
public class Mountain {
    private String name;
    private double longitude;
    private String country;
}
