package com.example.DeveloperProjeect.Service;


import com.example.DeveloperProjeect.Entity.Meeting;
import com.example.DeveloperProjeect.Model.MeetingUpdateRequestModel;
import com.example.DeveloperProjeect.Repository.MeetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class MeetingService {


    @Autowired
    private MeetingRepository meetingRepository;


    public List<Meeting> findAll() {
        return meetingRepository.findAll();
    }


    public Optional<Meeting> findById(Long id) {
        return meetingRepository.findById(id);
    }


    public Meeting save(Meeting meeting) {
        return meetingRepository.save(meeting);
    }


    public Meeting update(Long id, @Valid MeetingUpdateRequestModel meetingUpdateRequestModel) {
        Meeting meeting = meetingRepository.findById(id).orElseThrow(EntityExistsException::new);

        meeting.setType(meetingUpdateRequestModel.getType());
        meeting.setTitle(meetingUpdateRequestModel.getTitle());
        meeting.setDescription(meetingUpdateRequestModel.getDescription());
        meeting.setAttendee(meetingUpdateRequestModel.getAttendee());
        meetingRepository.save(meeting);
        return meeting;
    }


    public Meeting delete(Long id) {
        Meeting meeting = meetingRepository.findById(id).get();
        meetingRepository.deleteById(id);
        return meeting;
    }
}
