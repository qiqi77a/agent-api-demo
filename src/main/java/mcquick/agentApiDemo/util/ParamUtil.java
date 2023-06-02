package mcquick.agentApiDemo.util;

import cn.hutool.core.text.StrBuilder;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class ParamUtil {
    /**
     * map 转 k=v&k=v
     * k 为 sign、source、others的参数不进行拼接
     * v 为null 的参数不进行拼接
     *
     * @return
     */
    public static String mapToKV(Map<String, Object> map) {
        return mapToKV(map, null);
    }

    public static String mapToKV(Map<String, Object> map, Comparator<String> comparator) {
        TreeMap<String, Object> treeMap = new TreeMap(comparator);
        treeMap.putAll(map);
        StrBuilder strBuilder = StrBuilder.create();
        treeMap.forEach((k, v) -> {
            if (
                    StrUtil.isNotBlank(k)
                            && !k.equals("sign")
                            && !k.equals("sign_type")
                            && ObjectUtil.isNotNull(v)
                            && !v.equals("")
            ) {
                strBuilder.append(k).append("=").append(v).append("&");
            }
        });
        strBuilder.del(strBuilder.length() - 1, strBuilder.length());
        return strBuilder.toString();
    }
}