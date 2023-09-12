import {Like} from "./like";
import {Comment} from "./comment";

export interface Post {
  id: number;
  content: string;
  username: string;
  userId: number;
  authorProfilePic: string;
  parentPostId: number | null;
  createdAt: string;
  isLikedByCurrentUser: boolean;
  likesCount: number;
  comments: Comment[];
  likes: Like[];
}
