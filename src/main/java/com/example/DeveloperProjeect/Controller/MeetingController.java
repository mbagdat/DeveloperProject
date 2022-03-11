package com.example.DeveloperProjeect.Controller;


import com.example.DeveloperProjeect.Entity.Meeting;
import com.example.DeveloperProjeect.Model.MeetingUpdateRequestModel;
import com.example.DeveloperProjeect.Service.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/meeting")

public class MeetingController {

    @Autowired
    private MeetingService meetingService;

    @GetMapping("/getAll")
    public List<Meeting> getAll() {
        return meetingService.findAll();
    }

    @GetMapping("/get/{id}")
    public Optional<Meeting> get(@PathVariable("id") Long id) {
        return meetingService.findById(id);
    }

    @PostMapping("/post")
    public Meeting save(@RequestBody Meeting meeting) {
        return meetingService.save(meeting);
    }

    @DeleteMapping("/delete/{id}")
    public Meeting delete(@PathVariable("id") Long id) {
        return meetingService.delete(id);
    }

    @PutMapping("/update/{id}")
    public Meeting update(@PathVariable Long id, @Valid @RequestBody MeetingUpdateRequestModel meetingUpdateRequestModel) {
        return meetingService.update(id, meetingUpdateRequestModel);
    }

}
