package com.levelfancy.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ChatMessage {
    private String from;
    private String text;
    private LocalDateTime time;
}
