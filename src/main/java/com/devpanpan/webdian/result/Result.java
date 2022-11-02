package com.devpanpan.webdian.result;

import com.devpanpan.webdian.room.Room;
import com.devpanpan.webdian.user.User;
import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private int round;

    @Column(length = 3, nullable = false)
    private String card;

    @Column(length = 1)
    private String state;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;

    @Builder
    public Result(Long id, int round, String card, String state, User user, Room room) {
        this.id = id;
        this.round = round;
        this.card = card;
        this.state = state;
        this.user = user;
        this.room = room;
    }

}
