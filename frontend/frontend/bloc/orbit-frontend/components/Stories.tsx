export default function Stories() {

  const stories = [
    "Sebastian",
    "Carlos",
    "Ana",
    "Pedro",
    "Orbit"
  ];

  return (
    <div className="flex gap-4 overflow-x-auto mb-6">

      {stories.map((story) => (
        <div
          key={story}
          className="flex flex-col items-center"
        >
          <div
            className="
            w-16
            h-16
            rounded-full
            bg-gradient-to-r
            from-purple-500
            to-pink-500
            p-1"
          >
            <div
              className="
              w-full
              h-full
              bg-white
              rounded-full"
            />
          </div>

          <span className="text-sm mt-2">
            {story}
          </span>

        </div>
      ))}
    </div>
  );
}