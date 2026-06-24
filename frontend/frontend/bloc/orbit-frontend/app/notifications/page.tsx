"use client";

import NotificationItem
from "@/components/NotificationItem";

import {
  useNotificationStore
}
from "@/store/notificationStore";

export default function NotificationsPage() {

  const notifications =
    useNotificationStore(
      (state: any) =>
        state.notifications
    );

  return (
    <main
      className="
      max-w-3xl
      mx-auto
      p-6"
    >

      <h1
        className="
        text-3xl
        font-bold
        mb-6"
      >
        Notificaciones
      </h1>

      <div
        className="
        flex
        flex-col
        gap-4"
      >

        {notifications.map(
          (notification: any) => (

            <NotificationItem
              key={notification.id}
              {...notification}
            />

          )
        )}

      </div>

    </main>
  );
}