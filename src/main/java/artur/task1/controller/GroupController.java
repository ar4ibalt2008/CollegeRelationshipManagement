package artur.task1.controller;

import artur.task1.entity.Group;
import artur.task1.model.GroupDTO;
import artur.task1.model.GroupRequestDTO;
import artur.task1.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/groups")
public class GroupController {

    public GroupDTO updateGroup;
    @Autowired
    private GroupRepository groupRepository;

    @GetMapping
    public List<Group> getAllGroups() {
        return groupRepository.findAll();
    }

    @GetMapping("/{id}")
    public Group getGroupById(@PathVariable Long id) {
        return groupRepository.findById(id).orElse(null);
    }

    @PostMapping
    public GroupDTO createGroup(@RequestBody GroupRequestDTO group) {
        return groupRepository.save(Group.builder()
                .title(group.getTitle())
                .build()).toDto();
    }

    @PutMapping("/{id}")
    public GroupDTO updateGroup(@PathVariable Long id, @RequestBody  GroupRequestDTO  group) {
        Group a, result;
        a = groupRepository.findById(id).orElse(null);
        a.setTitle(group.getTitle());
        result = groupRepository.save(a);
        return result.toDto();

    }

    @DeleteMapping("/{id}")
    public void deleteGroup(@PathVariable Long id) {
        groupRepository.deleteById(id);
    }

    @GetMapping("/title/{title}")
    public Group getGroupByTitle(@PathVariable String title) {
        return groupRepository.findByTitle(title);
    }
}
