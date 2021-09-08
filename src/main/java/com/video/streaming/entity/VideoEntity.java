package com.video.streaming.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class VideoEntity {
    public VideoEntity() {

    }

    @Id
    @GeneratedValue
    @Column(name = "video_id")
    private Long id;

    private String name;

    private Long viewCount;

    private LocalDateTime uploadDate;
}
