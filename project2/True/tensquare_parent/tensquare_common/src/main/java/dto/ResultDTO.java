package dto;

import lombok.Data;

@Data
/**
 * @auther Jeff Shen
 * 返回的消息实体类
 */
public class ResultDTO {
    private boolean flag;
    private Integer code;
    private String message;
    private Object data;

    public ResultDTO(boolean flag, Integer code, String message) {
        this.flag = flag;
        this.code = code;
        this.message = message;
    }

    public ResultDTO(boolean flag, Integer code, String message, Object data) {
        this.flag = flag;
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
