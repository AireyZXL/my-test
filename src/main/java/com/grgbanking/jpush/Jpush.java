package com.grgbanking.jpush;


import cn.jiguang.common.ClientConfig;
import cn.jiguang.common.ServiceHelper;
import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jpush.api.JPushClient;

import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.Options;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.AndroidNotification;
import cn.jpush.api.push.model.notification.Notification;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import org.apache.log4j.Logger;


import static cn.jpush.api.push.model.notification.PlatformNotification.ALERT;

/**
 * TODO
 *
 * @auther zxlei1
 * @date 2018/1/26
 */
public class Jpush {
    public static Logger LOG = Logger.getLogger(Jpush.class);

    public static final String APP_KEY = "ec1467b09e6cdf6141c8fabd";
    public static final String MASTER_SECRET = "f1d6000b33bfaf9204189aa3";

    public static void main(String[] args) {
        testSendPushWithCid();
    }

    public static void testSendPushWithCid() {
        JPushClient jPushClient = new JPushClient(MASTER_SECRET, APP_KEY, null, ClientConfig.getInstance());
      //  PushPayload pushPayload = buildPushObject_android_cid();
      //  PushPayload pushPayload =buildPushObject_android_newly_support();
        PushPayload pushPayload =buildPushObject_android_tagAnd_alertWithExtrasAndMessage();
        try {
            PushResult result = jPushClient.sendPush(pushPayload);
            System.out.println(result);
            LOG.info("Got result - " + result);
        } catch (APIConnectionException e) {
            LOG.error("Connection error. Should retry later. ", e);
        } catch (APIRequestException e) {
            LOG.error("Error response from JPush server. Should review and fix it. ", e);
            LOG.info("HTTP Status: " + e.getStatus());
            LOG.info("Error Code: " + e.getErrorCode());
            LOG.info("Error Message: " + e.getErrorMessage());
        }
    }


    public static PushPayload buildPushObject_all_all_alert() {
        return PushPayload.alertAll(ALERT);
    }

    public static PushPayload buildPushObject_android_newly_support() {
        JsonObject inbox = new JsonObject();
        inbox.add("line1", new JsonPrimitive("line1 string"));
        inbox.add("line2", new JsonPrimitive("line2 string"));
        inbox.add("contentTitle", new JsonPrimitive("title string"));
        inbox.add("summaryText", new JsonPrimitive("+3 more"));
        Notification notification = Notification.newBuilder()
                .addPlatformNotification(AndroidNotification.newBuilder()
                        .setAlert("I'm Server!")
                        .setBigPicPath("path to big picture")
                        .setBigText("long text")
                        .setBuilderId(1)
                        .setCategory("CATEGORY_SOCIAL")
                        .setInbox(inbox)
                        .setStyle(1)
                        .setTitle("Alert test")
                        .setPriority(1)
                        .build())
                .build();
        return PushPayload.newBuilder()
                .setPlatform(Platform.all())
               // .setAudience(Audience.all())
                .setAudience(Audience.registrationId("1104a89792a3e59e958"))
                .setNotification(notification)
                .setOptions(Options.newBuilder()
                        .setApnsProduction(true)
                        .setSendno(ServiceHelper.generateSendno())
                        .build())
                .build();
    }

    public static PushPayload buildPushObject_android_cid() {

        JsonObject inbox = new JsonObject();
        inbox.add("line1", new JsonPrimitive("line1 string"));
        inbox.add("line2", new JsonPrimitive("line2 string"));
        inbox.add("contentTitle", new JsonPrimitive("title string"));
        inbox.add("summaryText", new JsonPrimitive("+3 more"));
        Notification notification = Notification.newBuilder()
                .addPlatformNotification(AndroidNotification.newBuilder()
                        .setAlert("I'm Server!")
                        .setBigPicPath("path to big picture")
                        .setBigText("long text")
                        .setBuilderId(1)
                        .setCategory("CATEGORY_SOCIAL")
                        .setInbox(inbox)
                        .setStyle(1)
                        .setTitle("Alert test")
                        .setPriority(1)
                        .build())
                .build();

        return PushPayload.newBuilder()
                .setPlatform(Platform.android())
                .setAudience(Audience.registrationId("1104a89792a3e59e958"))
                .setNotification(notification)
                .setCid("cid")
                .build();
    }


    public static PushPayload buildPushObject_android_tagAnd_alertWithExtrasAndMessage() {
        JsonObject inbox = new JsonObject();
        inbox.add("line1", new JsonPrimitive("line1 string"));
        inbox.add("line2", new JsonPrimitive("line2 string"));
        inbox.add("contentTitle", new JsonPrimitive("title string"));
        inbox.add("summaryText", new JsonPrimitive("+3 more"));
        System.out.println(inbox);
        return PushPayload.newBuilder()
                .setPlatform(Platform.android())
                .setAudience(Audience.registrationId("1104a89792a3e59e958"))
                .setNotification(Notification.newBuilder()
                        .addPlatformNotification(AndroidNotification.newBuilder()
                                .setAlert("Hi,I'm Server!")
                                .setTitle("我是这条消息的标题")
                                .setPriority(1)
                                .addExtra("regId","1104a89792a3e59e958")
                                .addExtra("pushType","1")
                                .addExtra("data",inbox)
                                .build())
                        .build())
                //.setMessage(Message.content("广电运通！"))
                .setMessage(Message.newBuilder().setTitle("显著的标题")
                        .setMsgContent("GRGBANKING!")
                        .addExtra("name","Airey")
                        .addExtra("data","map")
                        .addExtra("money","17241.31")
                        .build())
                .setOptions(Options.newBuilder()
                        .setApnsProduction(true)
                        .build())
                .build();
    }


}
