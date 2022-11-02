package com.devpanpan.webdian.room;

import com.devpanpan.webdian.result.Result;
import com.devpanpan.webdian.user.User;
import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private int participant;

    @NotNull
    private int totalRound;

    @OneToMany(mappedBy = "room")
    private List<User> users;

    @OneToMany(mappedBy = "room")
    private List<Result> results;

    @Builder
    public Room(Long id, int participant, int totalRound, List<User> users, List<Result> results) {
        this.id = id;
        this.participant = participant;
        this.totalRound = totalRound;
        this.users = users;
        this.results = results;
    }

}
