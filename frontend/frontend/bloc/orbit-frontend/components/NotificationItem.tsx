interface Props {
  username: string;
  message: string;
  createdAt: string;
  read: boolean;
}

export default function NotificationItem({
  username,
  message,
  createdAt,
  read,
}: Props) {
  return (
    <div
      className={`
      p-4
      rounded-lg
      border
      ${
        read
          ? "bg-white"
          : "bg-violet-100"
      }
      `}
    >

      <p>
        <strong>
          {username}
        </strong>{" "}
        {message}
      </p>

      <span
        className="
        text-sm
        text-gray-500"
      >
        {createdAt}
      </span>

    </div>
  );
}