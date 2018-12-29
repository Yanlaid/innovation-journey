package dto;

import lombok.Data;

import java.util.List;

/**
 * @author Jeff Shen
 * @param <T>
 *     返回的分页结果
 */
@Data
public class PageResultDTO<T> {
    private Long total;
    private List<T> rows;

    public PageResultDTO(Long total, List<T> rows) {
        this.total = total;
        this.rows = rows;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
