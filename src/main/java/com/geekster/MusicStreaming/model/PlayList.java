package com.geekster.MusicStreaming.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, scope = PlayList.class,property = "playListId")
public class PlayList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long playListId;

    @NotBlank(message = "PlayList name can't be blank")
    private String playListName;

    @OneToMany
    private List<Song> songs;

    @OneToOne(mappedBy = "playList")
    private User user;
}
