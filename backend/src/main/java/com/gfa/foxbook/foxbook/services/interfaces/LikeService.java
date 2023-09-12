package com.gfa.foxbook.foxbook.services.interfaces;

import com.gfa.foxbook.foxbook.models.nonusermodels.Like;
import com.gfa.foxbook.foxbook.models.User;

public interface LikeService {
    void like(Long postId, Long userId);

    boolean hasUserLikedPost(Long postId, Long userId);

    public User getUser(Long userId);

    void save(Like like);

    boolean hasUserLiked(Long commentId, Long userId);

    void likePost(Long postId, Long userId);

    void like(Like like);

    void removeLike(Like like);
    void removeLike(Long postId, Long userId);
}
