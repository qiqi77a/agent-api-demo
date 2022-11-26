package mcquick.agentApiDemo.util;

public class Assert {
    public static void isNull(Object obj, RuntimeException e) {
        if (obj instanceof String){
            if (obj.equals("")) {
                return;
            }
        }
        if (obj == null) {
            return;
        }
        if (e == null) {
            e = new RuntimeException("必须是空。");
        }
        throw e;
    }

    public static void isNull(Object obj, String message) {
        isNull(obj, new RuntimeException(message));
    }

    public static void isNull(Object obj) {
        isNull(obj, (RuntimeException) null);
    }

    public static void isNotNull(Object obj, RuntimeException e) {

        if (obj instanceof String){
            if (obj.equals("")) {
                if (e == null) {
                    e = new RuntimeException("必须有值。");
                }
                throw e;
            }
        }

        if (obj != null) {
            return;
        }

        if (e == null) {
            e = new RuntimeException("必须有值。");
        }
        throw e;
    }

    public static void isNotNull(Object obj) {
        isNotNull(obj, (RuntimeException) null);
    }

    public static void isNotNull(Object obj, String message) {
        isNotNull(obj, new RuntimeException(message));
    }

    public static void isEquals(Object source, Object target, RuntimeException e) {
        if (source == null && target == null) {
            return;
        }
        if (source != null && target != null) {
            if (source instanceof Number && target instanceof Number && source.toString().equals(target.toString())) {
                return;
            }
            if (source.equals(target)) {
                return;
            }
        }
        if (e == null) {
            e = new RuntimeException(source + " 与 " + target + " 必须相同。");
        }
        throw e;
    }

    public static void isEquals(Object source, Object target) {
        isEquals(source, target, (RuntimeException) null);
    }

    public static void isEquals(Object source, Object target, String message) {
        isEquals(source, target, new RuntimeException(message));
    }

    public static void isNotEquals(Object source, Object target, RuntimeException e) {
        try {
            isEquals(source, target);
        } catch (RuntimeException ex) {
            return;
        }
        if (e == null) {
            e = new RuntimeException(source + " 与 " + target + " 必须不相同。");
        }
        throw e;
    }

    public static void isNotEquals(Object source, Object target, String message) {
        isNotEquals(source, target, new RuntimeException(message));
    }

    public static void isNotEquals(Object source, Object target) {
        isNotEquals(source, target, (RuntimeException) null);
    }

    /**
     * 判断数字大小
     */
    public static void magnitude(double small, double big, RuntimeException e) {
        if (small < big) {
            return;
        }
        if (e == null) {
            e = new RuntimeException(small + " 必须小于 " + big + "。");
        }
        throw e;
    }

    public static void isTrue(boolean b, RuntimeException e) {
        if (b == true) {
            return;
        }
        if (e == null) {
            e = new RuntimeException("必须是TRUE。");
        }
        throw e;
    }

    public static void isTrue(boolean b, String message) {
        isTrue(b, new RuntimeException(message));
    }

    public static void isTrue(boolean b) {
        isTrue(b, (String) null);
    }

    public static void isFalse(boolean b, RuntimeException e) {
        if (b == false) {
            return;
        }
        if (e == null) {
            e = new RuntimeException("必须是FALSE。");
        }
        throw e;
    }

    public static void isFalse(boolean b, String message) {
        isFalse(b, new RuntimeException(message));
    }

    public static void isFalse(boolean b) {
        isFalse(b, (String) null);
    }
}
