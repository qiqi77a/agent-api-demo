package mcquick.agentApiDemo.exception;

import cn.hutool.core.util.StrUtil;

/**
 * 能够预料到的错误
 */
public class CheckException extends RuntimeException {
    public CheckException(CharSequence template, Object... params) {
        super(StrUtil.format(template,params));
    }
}