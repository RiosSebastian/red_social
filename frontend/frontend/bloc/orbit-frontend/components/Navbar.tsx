import { useNotificationStore } from "@/store/notificationStore";

export default function Navbar() {
  const notifications =
useNotificationStore(
  (state) =>
    state.notifications
);

const unread =
notifications.filter(
  (n) => !n.read
).length;
  return (
    <nav className="bg-white shadow-md px-6 py-4 flex justify-between items-center">
      <h1 className="text-2xl font-bold text-violet-600">
        Orbit
      </h1>

      <input
        type="text"
        placeholder="Buscar..."
        className="border rounded-lg px-3 py-2"
      />

      <div className="flex gap-4">
        <button>🔔 {unread}</button>
        <button>💬</button>
        <button>👤</button>
      </div>
    </nav>
  );
}