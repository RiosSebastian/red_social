"use client";

import { usePostStore } from "@/store/postStore";

export default function Feed() {
  const posts = usePostStore((state) => state.posts);

  return (
    <div className="space-y-4">
      {posts.map((post) => (
        <div key={post.id} className="bg-white rounded-xl shadow  p-4">
          <h3 className="font-bold">{post.username}</h3>

          <p className="text-sm text-gray-500">{post.createdAt}</p>

          <div className="mt-3">
            <p>{post.content}</p>

            {post.image && (
              <img src={post.image} alt="" className="mt-4 rounded-xl w-full object-cover" />
            )}
          </div>
        </div>
      ))}
    </div>
  );
}
