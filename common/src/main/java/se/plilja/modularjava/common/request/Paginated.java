package se.plilja.modularjava.common.request;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.List;

@NoArgsConstructor
@Data
public class Paginated<T> {
    private int pageSize;
    private int pageNumber;
    private int totalPages;
    private long totalCount;
    private List<T> values;

    public static <T> Paginated<T> fromPage(Page<T> page) {
        Paginated<T> result = new Paginated<>();
        result.setValues(page.getContent());
        result.setPageNumber(page.getNumber());
        result.setPageSize(page.getSize());
        result.setTotalPages(page.getTotalPages());
        result.setTotalCount(page.getTotalElements());
        return result;
    }
}
