package artur.task1.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GroupDTO {
    private Long id;
    private String title;
}
