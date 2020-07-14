package com;

import com.i3ring.Decoder;
import com.i3ring.Password;
import com.utils.Md5;
import com.utils.StringUtils;
import org.apache.commons.codec.Encoder;
import org.apache.commons.codec.EncoderException;
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

        System.out.println(de.decode("uWxURQsg3sPAXfGtI+3JHkpTHJCzyLnLNjCqO1bdR58HdR3y0HnO9ThNfyYuDMEI7Jim9tyoIP3ygoHFrJjiLkcAete+fh41arMvI13ocG4="));
        System.out.println(de.decode("qgE5pRkjx/745GeebospSw=="));
        System.out.println(de.decode("bnSOTjuZ+bu04meJSStmKIO3x4zRORFUa6RcWGKH1dngOn0x7Khn1w=="));

        System.out.println(de.decode("uWxURQsg3sPAXfGtI+3JHkpTHJCzyLnLNjCqO1bdR58HdR3y0HnO9ThNfyYuDMEI7Jim9tyoIP3ygoHFrJjiLkcAete+fh41arMvI13ocG4="));
        System.out.println(de.decode("+wa8Vu0MokdjFQb6mRPw0Wk8BzBVqWB+95iH1xClFCoeqO42D6q7Aqd38GsVwru3xeBpFXap8nQ5x553/oKtMGKlmZnu/li4w/yN/DCCLJk="));

       // System.out.println(de.decode("ki1JvW2nfvvPWeGnsFmJT0sL1t4JIHgS"));
        //System.out.println(de.decode("kPda37chX6p749bi31uEn3fWiFM4xT4IUJ31i80GUQNiaEOawzBb1lgi5/sh8psk8z9VhQnFnFiHRglbFfxuwkXYFefIxv31KwRROtWWBNM="));
        System.out.println(de.decode("2i01fJeHyWkH24pEpIXQsj4V+pvZShwXd+EMlh7Ylaf3+0cy3R6038YB9srFF3RDqXmjsAzaNVX9dKk3h9FNl6BXuXnZNycYt1widQYCTUY="));
        System.out.println(de.decode("+wa8Vu0MokdjFQb6mRPw0Wk8BzBVqWB+95iH1xClFCoeqO42D6q7Aqd38GsVwru3xeBpFXap8nQ5x553/oKtMGKlmZnu/li4w/yN/DCCLJk="));
        System.out.println(de.decode("9xRPKbdChf3lh77rRdJeEQ=="));
        System.out.println(de.decode("bnrAehDXm3FCphiQwOnNc42spS+JBq4VHOcWcpSAcdUkC0qvWZAmW8XbZzmGuUYg"));
        System.out.println(de.decode("reRQdKefj0FAqNpK+4MDYUmBbcHRoRP++nC16m9UMuBWqNQoyJ7yVK21rgSYs0of"));

        System.out.println(de.decode("xcPjahwEJrMcLfmJ2o8NLQ=="));
        System.out.println(de.decode("ki1JvW2nfvvPWeGnsFmJT0sL1t4JIHgS"));
        System.out.println(de.decode("SnEfbZaA77EMUgc/edL/8RJO3ZWt5ZOc7HsEcnkz/3uGNTWTelpyZ9OX6PxTZspd"));

    }
}
