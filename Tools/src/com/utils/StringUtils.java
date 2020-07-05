package com.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;

import java.util.*;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public class StringUtils {
    private static Map<String, String> tempMap = null;

    public StringUtils() {
    }

    public class MapKeyComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            return o1.compareTo(o2);
        }
    }

    public static boolean isEmpty(String s) {
        return s == null || s.equals("");
    }

    public static String changeFirstCase(String src, boolean isUpper) {
        if (src != null && !src.equals("")) {
            String fl = src.substring(0, 1);
            if (isUpper) {
                fl = fl.toUpperCase();
            } else {
                fl = fl.toLowerCase();
            }

            return String.valueOf(fl + src.substring(1, src.length()));
        } else {
            return src;
        }
    }

    public static String getRandomString(int num) {
        char[] randomMetaData = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        Random random = new Random();
        String tNonceStr = "";

        for(int i = 0; i < num; ++i) {
            tNonceStr = tNonceStr + randomMetaData[random.nextInt(randomMetaData.length - 1)];
        }

        return tNonceStr;
    }

    public static String getUID() {
        long num = System.currentTimeMillis();
        Random r = new Random();
        long d = (long)(r.nextInt(100000) + 1);
        return String.valueOf(num + d);
    }

    public static String map2xml(Map<String, String> map, String rootName) {
        String src = "<" + (rootName != null && !rootName.equals("") ? rootName : "xml") + ">";

        String key;
        for(Iterator i$ = map.keySet().iterator(); i$.hasNext(); src = src + "<" + key + ">" + (String)map.get(key) + "</" + key + ">") {
            key = (String)i$.next();
        }

        src = src + "</" + rootName + ">";
        return src;
    }

    public static String mapToJson(Map<String, String> map, String template) {
        if (map != null && !map.isEmpty()) {
            if (template != null && !template.equals("")) {
                String json = template;

                String key;
                for(Iterator i$ = map.keySet().iterator(); i$.hasNext(); json = json.replaceAll("\\{(?i)" + key + "\\}", (String)map.get(key))) {
                    key = (String)i$.next();
                }

                return json;
            } else {
                return JSONObject.toJSONString(map);
            }
        } else {
            return "";
        }
    }

    public static Map<String, String> jsonToMap(String json) {
        Map<String, String> result = new HashMap();
        if (json != null && json.trim().startsWith("{") && json.indexOf(":") > 0) {
            Map<String, String> map = new HashMap();
            Map<String, String> jm = (Map) JSON.parseObject(json, new TypeReference<HashMap<String, String>>() {
            }, new Feature[0]);

            Iterator i$ = jm.keySet().iterator();

            while(true) {
                String tkey;
                while(i$.hasNext()) {
                    tkey = (String)i$.next();

                    String val = (String)jm.get(tkey);
                    result.put(tkey, val);
                    if (val != null && val.startsWith("{") && val.indexOf(":") > 0) {
                        Map<String, String> sjm = jsonToMap(val);
                        Iterator i2$ = sjm.keySet().iterator();
                        while(i2$.hasNext()) {
                            tkey = (String)i2$.next();
                            result.put(tkey, sjm.get(tkey));
                        }
                    }

                }

                return result;
            }
        } else {
            return result;
        }
    }

    public static String mapToXml(Map<String, String> map, String rootName, String template) {
        if (map != null && !map.isEmpty()) {
            if (template != null && !template.equals("")) {
                String xml = template;

                String key;
                for(Iterator i$ = map.keySet().iterator(); i$.hasNext(); xml = xml.replaceAll("\\{(?i)" + key + "\\}", (String)map.get(key))) {
                    key = (String)i$.next();
                }

                return xml;
            } else {
                return map2xml(map, rootName);
            }
        } else {
            return "";
        }
    }

    public static Map<String, String> xmlToMap(String xmlString, String charset) {
        try {
            Document doc = DocumentHelper.parseText(xmlString);
            Element root = doc.getRootElement();
            eleToMap(root.elements());
        } catch (Exception var5) {
            var5.printStackTrace();
        }

        Map<String, String> map = new HashMap();
        Iterator i$ = tempMap.keySet().iterator();

        while(i$.hasNext()) {
            String tkey = (String)i$.next();
            map.put(tkey, tempMap.get(tkey));
        }

        return map;
    }

    private static void eleToMap(List<Element> elements) {
        tempMap = new HashMap();
        Iterator i$ = elements.iterator();

        while(i$.hasNext()) {
            Element el = (Element)i$.next();
            if (el.elements().size() > 0) {
                tempMap.put(el.getName(), el.getText());
                eleToMap(el.elements());
            } else {
                tempMap.put(el.getName(), el.getText());
            }
        }

    }

    public static String contcatKeyValueString(Map<String, String> params, boolean toSort) {
        List<String> keys = new ArrayList(params.keySet());
        if (toSort) {
            Collections.sort(keys);
        }

        String prestr = "";

        for(int i = 0; i < keys.size(); ++i) {
            String key = (String)keys.get(i);
            String value = params.get(key) == null ? "" : (String)params.get(key);
            if (i == keys.size() - 1) {
                prestr = prestr + key + "=" + value;
            } else {
                prestr = prestr + key + "=" + value + "&";
            }
        }

        return prestr;
    }

    public static String contcatForTemplate(Map<String, String> params, String template) {
        String str = template;

        String key;
        for(Iterator i$ = params.keySet().iterator(); i$.hasNext(); str = str.replaceAll("\\{(?i)" + key + "\\}", (String)params.get(key))) {
            key = (String)i$.next();
        }

        return str;
    }

    public static Map<String, String> kvStringToMap(String kvString) {
        HashMap<String, String> rps = new HashMap();
        String delimiter = "&";
        if (kvString.indexOf("&") > 0) {
            delimiter = "&";
        } else if (kvString.indexOf("|") > 0) {
            delimiter = "|";
        } else if (kvString.indexOf(",") > 0) {
            delimiter = ",";
        }

        String[] ss = kvString.split("\\" + delimiter);

        for(int i = 0; i < ss.length; ++i) {
            String is = ss[i];
            String[] iss = is.split("\\=");
            if (iss.length >= 2) {
                rps.put(iss[0], iss[1]);
            }

            if (iss.length == 1) {
                rps.put(iss[0], "");
            }
        }

        return rps;
    }


    /**
     *
     * @param sArray
     * @param ignoreEmptyValue 是否忽略空值
     * @return
     */
    public static Map<String, String> paraFilter(Map<String, String> sArray, boolean ignoreEmptyValue) {

        Map<String, String> result = new HashMap();
        if (sArray != null && sArray.size() > 0) {
            Iterator i$ = sArray.keySet().iterator();

            while(true) {
                String key;
                String value;
                while(true) {
                    if (!i$.hasNext()) {
                        return result;
                    }

                    key = (String)i$.next();
                    value = (String)sArray.get(key);
                    if (ignoreEmptyValue) {
                        if (value != null && !value.equals("")) {
                            break;
                        }
                    } else {
                        if (value == null) {
                            continue;
                        }
                        break;
                    }
                }

                result.put(key, value);
            }
        } else {
            return result;
        }
    }
}