package com.devpanpan.webdian.user;

import com.devpanpan.webdian.result.Result;
import com.devpanpan.webdian.room.Room;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 10, nullable = false)
    private String nickname;

    @ColumnDefault("false")
    private boolean isAdmin = false;

    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;

    @OneToMany(mappedBy = "user")
    private List<Result> results;

    @Builder
    public User(Long id, String nickname, boolean isAdmin, Room room, List<Result> results) {
        this.id = id;
        this.nickname = nickname;
        this.isAdmin = isAdmin;
        this.room = room;
        this.results = results;
    }

}
