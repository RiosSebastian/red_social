export interface User {
  id: number;
  username: string;

  fullName: string;

  bio: string;

  avatar: string;

  coverImage: string;

  followers: number;

  following: number;

  posts: number;

  location?: string;
}