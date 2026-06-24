import { Post as PostType } from "@/types/post";
import CommentSection
from "./CommentSection";

import { usePostStore }
from "@/store/postStore";

interface Props {
  post: PostType;
}



export default function Post({ post }: Props) {
  const toggleLike =
  usePostStore(
    (state) => state.toggleLike
  );

const addComment =
  usePostStore(
    (state) => state.addComment
  );
  return (
    <div className="bg-white rounded-xl shadow overflow-hidden">

      <div className="flex items-center gap-3 p-4">
        <img
          src={post.author.profilePicture}
          alt={post.author.username}
          className="w-12 h-12 rounded-full"
        />

        <div>
          <h3 className="font-semibold">
            {post.author.username}
          </h3>

          <p className="text-sm text-gray-500">
            {post.createdAt}
          </p>
        </div>
      </div>

      {post.imageUrl && (
        <img
          src={post.imageUrl}
          alt=""
          className="w-full"
        />
      )}

      <div className="p-4">
        <p>{post.content}</p>

        <div className="flex gap-6 mt-4">

  <button
    onClick={() =>
      toggleLike(post.id)
    }
  >
    {post.liked ? "❤️" : "🤍"}
    {" "}
    {post.likes}
  </button>

  <span>
    💬 {post.comments.length}
  </span>

</div>

<CommentSection
  comments={post.comments}
  onAddComment={(text) =>
    addComment(post.id, text)
  }
/>
      </div>

    </div>
  );
}