export interface Post {
  id: number;
  content: string;
  imageUrl?: string;
  createdAt: string;

  author: {
    id: number;
    username: string;
    profilePicture?: string;
  };

  likes: number;
  comments: number;
}