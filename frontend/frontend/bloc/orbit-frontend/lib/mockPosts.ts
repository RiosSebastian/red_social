import { Post } from "@/types/post";

export const mockPosts: Post[] = [
  {
    id: 1,
    content: "Bienvenidos a Orbit 🚀",
    imageUrl:
      "https://picsum.photos/800/500",
    createdAt: "Hace 5 min",
    likes: 15,
    comments: 4,
    author: {
      id: 1,
      username: "Orbit",
      profilePicture:
        "https://picsum.photos/100"
    }
  },
  {
    id: 2,
    content: "Trabajando en mi nueva red social.",
    imageUrl:
      "https://picsum.photos/801/500",
    createdAt: "Hace 10 min",
    likes: 8,
    comments: 2,
    author: {
      id: 2,
      username: "Sebastian",
      profilePicture:
        "https://picsum.photos/101"
    }
  }
];