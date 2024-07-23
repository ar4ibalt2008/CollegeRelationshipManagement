package artur.task1.controller;


import artur.task1.model.GroupDTO;
import artur.task1.model.GroupRequestDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GroupControllerTest {
    @Autowired
    GroupController controller;

    @Test
    public void testSave() {
        GroupRequestDTO group = GroupRequestDTO.builder()
                .title("testTitle")
                .build();
        GroupDTO save = controller.createGroup(group);
        Assertions.assertNotNull(save.getId());
        Assertions.assertEquals(save.getTitle(), group.getTitle());
    }

    @Test
    public void testSaveUpdate() {
        // create group
        GroupRequestDTO group = GroupRequestDTO.builder()
                .title("testTitle")
                .build();
        GroupDTO save = controller.createGroup(group);
        //update group with new title
        String newTitle = "newTitle";
        GroupRequestDTO groupUpdateRequest = GroupRequestDTO.builder()
                .title(newTitle)
                .build();

        GroupDTO updatedGroup = controller.updateGroup(save.getId(),groupUpdateRequest);
        Assertions.assertNotNull(save.getId());
        Assertions.assertEquals(newTitle, updatedGroup.getTitle());

    }
}
