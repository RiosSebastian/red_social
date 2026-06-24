import { create } from "zustand";


export interface Comment {
  id: number;
  username: string;
  content: string;
}

export interface Post {
  id: number;
  username: string;
  content: string;
  createdAt: string;
  image?: string;

  likes: number;
  liked: boolean;

  comments: Comment[];
}

interface PostState {
  posts: Post[];

  addPost: (
    post: Omit<
      Post,
      "id" | "likes" | "liked" | "comments"
    >
  ) => void;

  toggleLike: (postId: number) => void;

  addComment: (
    postId: number,
    comment: string
  ) => void;
}
export const usePostStore =
  create<PostState>((set) => ({
    posts: [],

    addPost: (post) =>
      set((state) => ({
        posts: [
          {
            id: Date.now(),
            likes: 0,
            liked: false,
            comments: [],
            ...post,
          },
          ...state.posts,
        ],
      })),
    toggleLike: (postId) =>
      set((state) => ({
        posts: state.posts.map((post) =>
          post.id === postId
            ? { ...post, liked: !post.liked, likes: post.liked ? post.likes - 1 : post.likes + 1 }
            : post
        ),
      })),
    addComment: (postId, comment) =>
      set((state) => ({
        posts: state.posts.map((post) =>
          post.id === postId
            ? {
                ...post,
                comments: [
                  ...post.comments,
                  { id: Date.now(), username: "User", content: comment },
                ],
              }
            : post
        ),
      })),
  }));