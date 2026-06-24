export interface Notification {
  id: number;

  type:
    | "LIKE"
    | "COMMENT"
    | "FOLLOW"
    | "MESSAGE";

  username: string;

  message: string;

  createdAt: string;

  read: boolean;
}