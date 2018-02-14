package knowledge.baseKnowledge._javaCore.international;

import javax.swing.*;
import java.awt.*;
import java.text.NumberFormat;

/**
 * @project: knowledge.baseKnowledge._javaCore.international
 * @author: Neng Qi
 * @email: qihuaneng@163.com
 * @date: 2018/02/14 14:04
 **/
public class FormatText {
    public static void main(String[] args) {
//        EventQueue.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                JFrame frame=new NumberFormatFrame()
//            }
//        });
        Double myNumber = 2333.122222;
        Double test = 0.3434;
        //getInstance()
        //返回当前缺省语言环境的缺省数值格式。
        String myString = NumberFormat.getInstance().format(myNumber);
        System.out.println(myString);
        //getCurrencyInstance()返回当前缺省语言环境的通用格式
        myString = NumberFormat.getCurrencyInstance().format(myNumber);
        System.out.println(myString);
        //getNumberInstance() 返回当前缺省语言环境的通用数值格式。
        myString = NumberFormat.getNumberInstance().format(myNumber);
        System.out.println(myString);
        //getPercentInstance()  返回当前缺省语言环境的百分比格式。
        myString = NumberFormat.getPercentInstance().format(test);
        System.out.println(myString);
        //setMaximumFractionDigits(int) 设置数值的小数部分允许的最大位数。
        //setMaximumIntegerDigits(int)  设置数值的整数部分允许的最大位数。
        //setMinimumFractionDigits(int) 设置数值的小数部分允许的最小位数。
        //setMinimumIntegerDigits(int)  设置数值的整数部分允许的最小位数.
        NumberFormat format = NumberFormat.getInstance();
        format.setMinimumFractionDigits(3);
        format.setMaximumFractionDigits(5);
        format.setMaximumIntegerDigits(10);
        format.setMinimumIntegerDigits(0);
        System.out.println(format.format(2132323213.23266666666));

    }
}
