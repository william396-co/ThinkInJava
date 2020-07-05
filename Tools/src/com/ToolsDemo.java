package com;

import com.i3ring.Decoder;
import com.utils.Md5;
import com.utils.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.HashMap;
import java.util.Map;

public class ToolsDemo {

    protected static final Log logger = LogFactory.getLog(ToolsDemo.class);
    protected static Map<String, String> requestParams = new HashMap();


    public static void buildParams() {

        try {

            String orderId = String.valueOf(11209253);

            requestParams.put("account", "1593672156060");               //商户号
            requestParams.put("business", "方萌");         //交易方
            requestParams.put("businessBank","中国农业银行");//交易银行名称
            requestParams.put("businessCard", "6228481466819719172");      //交易卡号
            requestParams.put("businessDescription","");                         //附言
            requestParams.put("businessPhone","");                               //收款方手机号
            requestParams.put("money",
                    String.valueOf(300.0));   //转账金额（单位：元）

            requestParams.put("notifyUrl", "http://pay.bowin9.com/trans/d0031notify.action");                 //回调地址
            requestParams.put("reverseUrl","");                                  //转账冲正回调地址
            requestParams.put("shOrderId", orderId);                             //商户订单号， 不可重复

            requestParams.put("sign", buildSign());                         //MD5签名(密文大写)
        }
        catch (Exception e) {
            logger.error(e);
            e.printStackTrace();
        }
    }


    public static String buildSign() {
        Map<String, String> map = StringUtils.paraFilter(requestParams, false);
        String kvs = StringUtils.contcatKeyValueString(map, true);
        kvs = kvs + "&key=219f9dd59d09462db584f14053f95f8e";
        System.out.println(kvs);
        String md5Str=  Md5.getMD5(kvs, "UTF-8").toUpperCase();
        System.out.println(md5Str);
        return md5Str;
    }

    private  static void testResponse()
    {

        String response = "{\n" +
                "\"code\": \"100000\",\n" +
                "\"data\": {\"money\": \"129.00\",\n" +
                "\"orderId\": \"TK15417616334361\",\n" +
                "\"shOrderId\": \"\",\n" +
                "\"account\": \"1516242711234\"\n" +
                "},\n" +
                "\"message\": \"成功\",\n" +
                "\"status\": true\n" +
                "}";

        if(response.trim().startsWith("{"))
        {
            Map<String, String> data = StringUtils.jsonToMap(response);

            if (data.get("code") != null && ((String) data.get("code")).equalsIgnoreCase("100000")) {
                System.out.println("code=" + data.get("code"));
                System.out.println("message=" + data.get("message"));
                System.out.println("status=" + data.get("status"));
                System.out.println("orderId=" + data.get("orderId"));
/*                result.put("code", "0");
                result.put("message", data.get("message"));
                result.put("status", data.get("status"));*/
            } else {
              /*  result.put("code", "-1");
                result.put("msg", "请求转账接口出错：" + (String) data.get("message"));*/
                System.out.println("code=" + data.get("code"));
                System.out.println("请求转账接口出错=" + data.get("message"));
                System.out.println("status=" + data.get("status"));
            }
        }


    }

    private static String decrypt(String encrtypted) throws Exception {
        Decoder de;
        de=new Decoder();
        de.initialize("3ring");
        return de.decode(encrtypted);

    }

    public static void main(String[] args) throws Exception {


        //buildParams();
        //testResponse();

        Decoder de;
        de = new Decoder();
        try {
            de.initialize("3ring");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(de.decode("ki1JvW2nfvvPWeGnsFmJT0sL1t4JIHgS"));

    }
}
