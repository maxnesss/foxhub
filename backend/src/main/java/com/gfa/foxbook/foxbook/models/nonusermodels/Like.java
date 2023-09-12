package com.gfa.foxbook.foxbook.models.nonusermodels;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.gfa.foxbook.foxbook.models.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "_likes")
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "post_id")
    @JsonBackReference
    private Post post;

    private Long userId;
    private Integer likes;
    private Boolean hasVoted;

    public Like(Post post, Long userId, Integer likes, Boolean hasVoted) {
        this.post = post;
        this.userId = userId;
        this.likes = likes;
        this.hasVoted = hasVoted;
    }

    public Like(User user) {
        this.userId = user.getId();
        this.likes = 0;
        this.hasVoted = false;
    }
}
