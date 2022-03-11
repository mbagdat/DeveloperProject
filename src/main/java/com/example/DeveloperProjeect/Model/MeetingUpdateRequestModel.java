package com.example.DeveloperProjeect.Model;

import lombok.Data;

@Data
public class MeetingUpdateRequestModel {
    String type;
    String title;
    String description;
    String attendee;
}
