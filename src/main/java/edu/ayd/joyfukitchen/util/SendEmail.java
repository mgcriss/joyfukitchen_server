package edu.ayd.joyfukitchen.util;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

/**
 * Created by 萝莉 on 2017/4/20.
 */
public class SendEmail {

    private static SendEmail instance = null;

    private SendEmail() {

    }

    public static SendEmail getInstance() {
        if (instance == null) {
            instance = new SendEmail();
        }
        return instance;
    }

    public String send(String username) {
        try {
//			String to[] = { "tiwsonchen@163.com", "tiwson@163.com" };
            String to[] = {username};
            Properties p = new Properties();
            p.put("mail.smtp.auth", "true");
            p.put("mail.transport.protocol", "smtp");
            p.put("mail.smtp.host", "smtp.163.com");
            p.put("mail.smtp.port", "25");
            // 建立会话
            Session session = Session.getInstance(p);
            Message msg = new MimeMessage(session); // 建立信息

            msg.setFrom(new InternetAddress("m13431572041@163.com")); // 发件人

            String toList = getMailList(to);
            InternetAddress[] iaToList = InternetAddress.parse(toList);

            msg.setRecipients(Message.RecipientType.TO, iaToList); // 收件人

            msg.setSentDate(new Date()); // 发送日期
            msg.setSubject("JoyfuKitchen"); // 主题
            msg.setText("亲爱的joyfukitchen用户，您的验证码是" + getRandomNumber() + "请输入后进行验证，谢谢！"); // 内容
            // 邮件服务器进行验证
            Transport tran = session.getTransport("smtp");
            tran.connect("smtp.163.com", "13431572041@163.com", "wto1104");
            tran.sendMessage(msg, msg.getAllRecipients()); // 发送
            System.out.println("邮件发送成功");
            return ""+identifying;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "0";

    }

    private int identifying=0;
    /**
     * 随机获得不小于100000的随机数
     * @return
     */
    private Integer getRandomNumber(){
        Random random = new Random();
        identifying= random.nextInt(899999)+100000;
        return identifying;
    }

    private String getMailList(String[] mailArray) {

        StringBuffer toList = new StringBuffer();
        int length = mailArray.length;
        if (mailArray != null && length < 2) {
            toList.append(mailArray[0]);
        } else {
            for (int i = 0; i < length; i++) {
                toList.append(mailArray[i]);
                if (i != (length - 1)) {
                    toList.append(",");
                }
            }
        }
        return toList.toString();

    }
}