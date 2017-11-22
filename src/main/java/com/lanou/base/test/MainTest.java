package com.lanou.base.test;

import com.lanou.mail.Mail;
import com.lanou.mail.MailUtils;
import com.lanou.user.domain.Admin;
import com.lanou.user.domain.Privilege;
import com.lanou.user.domain.Role;
import com.lanou.user.mapper.AdminMapper;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.mail.MessagingException;
import javax.mail.Session;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *  测试类.
 */
public class MainTest {


    private ApplicationContext context;
    private AdminMapper adminMapper;

//    @Before
//    public void init(){
//        /*启动Spring容器*/
//        context = new ClassPathXmlApplicationContext("spring-config.xml");
//
//        /* 用户管理模块 */
//        adminMapper = context.getBean(AdminMapper.class);
//    }


    @Test
    public void selectTest(){
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        df.format(date);
        System.out.println(df.format(date));
    }

    @Test
    public void selectTest1(){

    }

    @Test
    public void send() throws IOException, MessagingException {
       /*   1>. 得到 session   */
        Session session =
                MailUtils.createSession("smtp.163.com","xinrugao@163.com", "why1993521");
        /*   2>.创建邮件对象   */
        Mail mail = new Mail("xinrugao@163.com","jasowei@163.com","FROM.Jaso.wei",
                "<h1>NetAccount</h1><hr><br><h2>您的新的初始密码 : 000000</h2><h4>*为了账户安全,建议您尽快修改初始密码.</h4>");
        /*  3>.发送    */
        MailUtils.send(session,mail);
    }
}
