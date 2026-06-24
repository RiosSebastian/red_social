import { create } from "zustand";

import { mockNotifications }
from "@/lib/mockNotifications";

export const useNotificationStore =
create((set) => ({

  notifications:
    mockNotifications,

  markAsRead:
    (id: number) =>
      set((state: any) => ({

        notifications:
          state.notifications.map(
            (n: any) =>
              n.id === id
                ? {
                    ...n,
                    read: true,
                  }
                : n
          ),
      })),
}));