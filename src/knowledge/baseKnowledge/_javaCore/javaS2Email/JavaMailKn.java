package knowledge.baseKnowledge._javaCore.javaS2Email;

import org.junit.Test;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import java.io.File;
import java.util.Date;
import java.util.Properties;

/**
 * @project: knowledge.baseKnowledge._javaCore.javaS2Email
 * @author: Neng Qi
 * @email: qihuaneng@163.com
 * @date: 2018/02/12 14:26
 **/
public class JavaMailKn {
    private String host = "smtp.163.com";
    private String port = "25";
    private String userName = "";
    private String password = "";
    private String to = "";

    public JavaMailKn(String userName, String password, String to) {
        this.userName = userName;
        this.password = password;
        this.to = to;
    }

    public JavaMailKn(String host, String port, String userName, String password, String to) {
        this.host = host;
        this.port = port;
        this.userName = userName;
        this.password = password;
        this.to = to;
    }

    public JavaMailKn() {
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    /**
     * send text
     *
     * @throws Exception
     */
    public void sendTextMail() throws Exception {
        Properties properties = System.getProperties();
        properties.setProperty("mail.transport.protocol", "SMTP");
        properties.setProperty("mail.smtp.host", "smtp.163.com");
        properties.setProperty("mail.smtp.port", "25");
        // 指定验证为true
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.timeout", "1000");
//        properties.put("mail.smtp.host",host);
//        properties.put("mail.smtp.port",port);
//        properties.put("mail.smtp.auth",true);
        //construct the session to send email
        Session sendMailSession = Session.getDefaultInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(userName, password);
            }
        });
        //create the message of mail
        Message mailMessage = new MimeMessage(sendMailSession);
        mailMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
        mailMessage.setSubject("Test Email");
        mailMessage.setSentDate(new Date());
        mailMessage.setText("this is a test Text mail");
        Transport.send(mailMessage);
    }

    public void sendHtmlMail() throws Exception {
        Properties pro = System.getProperties();
        pro.put("mail.smtp.host", host);
        pro.put("mail.smtp.port", port);
        pro.put("mail.smtp.auth", "true");

        // 根据邮件会话属性和密码验证器构造一个发送邮件的session
        Session sendMailSession = Session.getDefaultInstance(pro,
                new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(userName, password);
                    }
                });
        // 根据session创建一个邮件消息
        Message mailMessage = new MimeMessage(sendMailSession);
        // 设置邮件消息的发送者
        mailMessage.setFrom(new InternetAddress(userName));
        // 创建邮件的接收者地址，并设置到邮件消息中
        mailMessage.setRecipient(Message.RecipientType.TO,
                new InternetAddress(to));
        // 设置邮件消息的主题
        mailMessage.setSubject("Test Email");
        // 设置邮件消息发送的时间
        mailMessage.setSentDate(new Date());

        // MiniMultipart类是一个容器类，包含MimeBodyPart类型的对象
        Multipart mainPart = new MimeMultipart();
        // 创建一个包含HTML内容的MimeBodyPart
        BodyPart html = new MimeBodyPart();
        // 设置HTML内容
        html.setContent(
                "<html><body><img src='http://avatar.csdn.net/A/C/A/1_jianggujin.jpg'/><div>this is a HTML email.</div></body></html>",
                "text/html; charset=utf-8");
        mainPart.addBodyPart(html);
        // 将MiniMultipart对象设置为邮件内容
        mailMessage.setContent(mainPart);
        // 发送邮件
        Transport.send(mailMessage);
    }

    /**
     * 发送内嵌图片邮件
     *
     * @throws Exception
     */
    public void sendImageMail() throws Exception {
        Properties pro = System.getProperties();
        pro.put("mail.smtp.host", host);
        pro.put("mail.smtp.port", port);
        pro.put("mail.smtp.auth", "true");

        // 根据邮件会话属性和密码验证器构造一个发送邮件的session
        Session sendMailSession = Session.getDefaultInstance(pro,
                new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(userName, password);
                    }
                });
        // 根据session创建一个邮件消息
        Message mailMessage = new MimeMessage(sendMailSession);
        // 设置邮件消息的发送者
        mailMessage.setFrom(new InternetAddress(userName));
        // 创建邮件的接收者地址，并设置到邮件消息中
        mailMessage.setRecipient(Message.RecipientType.TO,
                new InternetAddress(to));
        // 设置邮件消息的主题
        mailMessage.setSubject("Test Email");
        // 设置邮件消息发送的时间
        mailMessage.setSentDate(new Date());

        MimeMultipart multipart = new MimeMultipart("related");

        BodyPart messageBodyPart = new MimeBodyPart();
        String htmlText = "<html><body><img src='cid:image'/><div>this is a HTML email.</div></body></html>";
        messageBodyPart.setContent(htmlText, "text/html; charset=utf-8");
        multipart.addBodyPart(messageBodyPart);

        MimeBodyPart imageBodyPart = new MimeBodyPart();
        DataSource fds = new FileDataSource("1_jianggujin.jpg");
        imageBodyPart.setDataHandler(new DataHandler(fds));
        imageBodyPart.setContentID("image");
        multipart.addBodyPart(imageBodyPart);

        mailMessage.setContent(multipart);
        // 发送邮件
        Transport.send(mailMessage);
    }

    /**
     * 发送附件邮件
     *
     * @throws Exception
     */
    public void sendAttachmentMail() throws Exception {
        Properties pro = System.getProperties();
        pro.put("mail.smtp.host", host);
        pro.put("mail.smtp.port", port);
        pro.put("mail.smtp.auth", "true");

        // 根据邮件会话属性和密码验证器构造一个发送邮件的session
        Session sendMailSession = Session.getDefaultInstance(pro,
                new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(userName, password);
                    }
                });
        // 根据session创建一个邮件消息
        Message mailMessage = new MimeMessage(sendMailSession);
        // 设置邮件消息的发送者
        mailMessage.setFrom(new InternetAddress(userName));
        // 创建邮件的接收者地址，并设置到邮件消息中
        mailMessage.setRecipient(Message.RecipientType.TO,
                new InternetAddress(to));
        // 设置邮件消息的主题
        mailMessage.setSubject("Test Email");
        // 设置邮件消息发送的时间
        mailMessage.setSentDate(new Date());

        MimeMultipart multipart = new MimeMultipart("mixed");

        BodyPart messageBodyPart = new MimeBodyPart();
        String htmlText = "<html><body><div>this is a Attachment email.this email has a attachment!</div></body></html>";
        messageBodyPart.setContent(htmlText, "text/html; charset=utf-8");
        multipart.addBodyPart(messageBodyPart);

        MimeBodyPart imageBodyPart = new MimeBodyPart();
        File imageFile = new File("1_jianggujin.jpg");
        DataSource fds = new FileDataSource(imageFile);
        imageBodyPart.setDataHandler(new DataHandler(fds));
        imageBodyPart.setFileName(MimeUtility.encodeWord(imageFile.getName()));
        multipart.addBodyPart(imageBodyPart);

        mailMessage.setContent(multipart);
        // 发送邮件
        Transport.send(mailMessage);
    }

    /**
     * 发送内嵌图片和附件邮件
     *
     * @throws Exception
     */
    public void sendImageAndAttachmentMail() throws Exception {
        Properties pro = System.getProperties();
        pro.put("mail.smtp.host", host);
        pro.put("mail.smtp.port", port);
        pro.put("mail.smtp.auth", "true");

        // 根据邮件会话属性和密码验证器构造一个发送邮件的session
        Session sendMailSession = Session.getDefaultInstance(pro,
                new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(userName, password);
                    }
                });
        // 根据session创建一个邮件消息
        Message mailMessage = new MimeMessage(sendMailSession);
        // 设置邮件消息的发送者
        mailMessage.setFrom(new InternetAddress(userName));
        // 创建邮件的接收者地址，并设置到邮件消息中
        mailMessage.setRecipient(Message.RecipientType.TO,
                new InternetAddress(to));
        // 设置邮件消息的主题
        mailMessage.setSubject("Test Email");
        // 设置邮件消息发送的时间
        mailMessage.setSentDate(new Date());

        // 正文
        MimeBodyPart text = new MimeBodyPart();
        text.setContent("我的头像：<img src='cid:headImg'>",
                "text/html;charset=UTF-8");

        // 正文图片
        MimeBodyPart image = new MimeBodyPart();
        image.setDataHandler(
                new DataHandler(new FileDataSource("1_jianggujin.jpg")));
        image.setContentID("headImg");

        // 附件
        MimeBodyPart attach = new MimeBodyPart();
        DataHandler dh = new DataHandler(new FileDataSource("1_jianggujin.jpg"));
        attach.setDataHandler(dh);
        attach.setFileName(MimeUtility.encodeWord(dh.getName()));

        // 描述关系:正文和图片
        MimeMultipart mp1 = new MimeMultipart();
        mp1.addBodyPart(text);
        mp1.addBodyPart(image);
        mp1.setSubType("related");

        // 正文
        MimeBodyPart content = new MimeBodyPart();
        content.setContent(mp1);

        MimeMultipart multipart = new MimeMultipart("mixed");
        multipart.addBodyPart(content);
        multipart.addBodyPart(attach);

        mailMessage.setContent(multipart);
        // 发送邮件
        Transport.send(mailMessage);
    }

    public static void main(String[] args) throws Exception {
        //main function.
        JavaMailKn javaMailKn = new JavaMailKn("neng_qi_2018@163.com", "*******", "neng_qi_2018@163.com");
        javaMailKn.sendTextMail();
    }

}
