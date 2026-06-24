import { Notification }
from "@/types/notification";

export const mockNotifications:
Notification[] = [
  {
    id: 1,
    type: "LIKE",
    username: "Carlos",
    message:
      "le gustó tu publicación",
    createdAt: "Hace 5 min",
    read: false,
  },

  {
    id: 2,
    type: "COMMENT",
    username: "Ana",
    message:
      "comentó tu publicación",
    createdAt: "Hace 10 min",
    read: false,
  },

  {
    id: 3,
    type: "FOLLOW",
    username: "Juan",
    message:
      "empezó a seguirte",
    createdAt: "Hace 1 hora",
    read: true,
  },
];