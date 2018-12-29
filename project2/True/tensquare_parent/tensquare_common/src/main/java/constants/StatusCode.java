package constants;

/**
 * @author Jeff Shen
 * 状态码
 */

public interface StatusCode {
    /**
     * 成功
     */
    int OK = 20000;
    /**
     * 失败
     */
    int ERROR = 20001;
    /**
     * 用户名或密码错误
     */
    int LOGINERROR = 20002;
    /**
     * 权限不足
     */
    int ACCESSERROR = 20003;
    /**
     * 远程调用失败
     */
    int REMOTEERROR = 20004;
    /**
     * 重复操作
     */
    int REPERROR = 20005;
}
