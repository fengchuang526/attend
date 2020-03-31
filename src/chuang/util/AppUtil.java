package chuang.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;


/**
 * 框架工具类
 * 
 * @author FC
 * @version v1.0 2019年6月17日
 */
public class AppUtil {

    /**
     * 请求返回map默认的数据的key
     */
    private static final String RETURN_DATA_DEFAULT_MAP_KEY = "response";

    /**
     * 返回map信息对象
     * 
     * @param flag
     *            操作成功标识
     * @param data
     *            信息
     * @return
     */
    public static Map<String, Object> getMap(Boolean flag, Object data) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("flag", flag);
        map.put("data", data);
        return map;
    }

    /**
     * 返回map信息对象
     * 
     * @param flag
     *            操作成功标识
     * @return
     */
    public static Map<String, Object> getMap(Boolean flag) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("flag", flag);
        return map;
    }

    /**
     * 获取分页数据
     *
     * @param responsePage
     *            分页对象
     * @return
     */
    public static Map<String, Object> getMap(ResponsePage responsePage) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(RETURN_DATA_DEFAULT_MAP_KEY, responsePage.getPageData());
        return map;
    }
    /**
     * 判断字符串的obj是否为空
     * 
     * @param obj
     *            字符串对象
     * @return
     */
    public static Boolean strObjectIsEmpty(Object obj) {
        if (obj != null && !"".equals(obj) && StringUtils.isNotBlank(obj.toString())) {
            return false;
        }
        return true;
    }

    /**
     * 判断字符串的obj是否不为空
     * 
     * @param obj
     *            字符串对象
     * @return
     */
    public static Boolean strObjectIsNotEmpty(Object obj) {
        return !strObjectIsEmpty(obj);
    }


    /**
     * 数组转换成sql的in条件<br/>
     * 数量不超过1000,条件的类型为字符串
     *
     * @param param
     *            数据
     * @return
     */
    public static String arrayToInString(String[] inParam) {
        if (inParam == null || inParam.length > 1000) {
            throw new RuntimeException("in条件不存在或数量超过了1000");
        }
        String in = "";
        for (int i = 0; i < inParam.length; i++) {
            String param = inParam[i];
            if (StringUtils.isBlank(param)) {
                continue;
            }
            if (i == 0) {
                in += "'" + param + "'";
            } else {
                in += ",'" + param + "'";
            }
        }
        return in;
    }

    /**
     * 保留小数（四舍五入）
     *
     * @param scale
     *            小数位,如为空则保留整数
     * @param value
     *            格式化的值
     * @return
     */
    public static String formatNumber(Integer scale, String value) {
        try {
            BigDecimal bigDecimal = new BigDecimal(value);
            if (scale == null) {
                return bigDecimal.setScale(0, RoundingMode.HALF_UP).toPlainString();
            } else {
                return bigDecimal.setScale(scale, RoundingMode.HALF_UP).toPlainString();
            }
        } catch (Exception e) {
            return value;
        }
    }

    /**
     * 判断是否window环境
     *
     * @return
     */
    public static Boolean isWindow() {
        String os = System.getProperty("os.name");
        if (os.toLowerCase().startsWith("win")) {
            return true;
        }
        return false;
    }

    /**
     * 判断是否为整数
     * 
     * @param str
     * @return
     */
    public static Boolean isInteger(String str) {
        if (null == str || "".equals(str) || StringUtils.isBlank(str)) {
            return false;
        }
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }

    /**
     * 判断是否为浮点数或整数
     * 
     * @param str
     * @return
     */
    public static Boolean isIntOrDouble(String str) {
        if (null == str || "".equals(str) || StringUtils.isBlank(str)) {
            return false;
        }
        Pattern pattern = Pattern.compile("^([-\\+]?\\d+)(\\.\\d+)?$");
        return pattern.matcher(str).matches();
    }

    /**
     * SQL拼接WHERE 还是 AND
     *
     * @param sb
     *            SQL
     * @param flag
     *            标识
     * @return
     */
    public static Boolean appendWhereOrAnd(StringBuffer sb, Boolean flag) {
        if (flag) {
            sb.append(" WHERE ");
            flag = false;
        }else {
            sb.append(" AND ");
        }
        return flag;
    }
}
