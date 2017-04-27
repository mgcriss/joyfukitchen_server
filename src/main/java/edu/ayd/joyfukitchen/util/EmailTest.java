package edu.ayd.joyfukitchen.util;

/**
 * Created by 萝莉 on 2017/4/21.
 */
public class EmailTest {

    public static void main(String[] args) {

        SendEmail instance = SendEmail.getInstance();
        instance.send("1276843344@qq.com");
}


}
