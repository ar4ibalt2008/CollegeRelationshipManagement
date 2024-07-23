package artur.task1.entity;

import artur.task1.model.GroupDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "groups")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String title;

    public GroupDTO toDto(){
        return GroupDTO.builder()
                .id(id)
                .title(title)
                .build();
    }
}