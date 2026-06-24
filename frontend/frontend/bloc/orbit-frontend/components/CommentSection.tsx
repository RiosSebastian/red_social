"use client";

import { useState } from "react";

interface Props {
  comments: {
    id: number;
    username: string;
    content: string;
  }[];

  onAddComment: (
    content: string
  ) => void;
}

export default function CommentSection({
  comments,
  onAddComment,
}: Props) {

  const [text, setText] =
    useState("");

  const handleSubmit = () => {

    if (!text.trim())
      return;

    onAddComment(text);

    setText("");
  };

  return (
    <div className="mt-4">

      {comments.map((comment) => (
        <div
          key={comment.id}
          className="
          bg-gray-100
          rounded-lg
          p-2
          mb-2"
        >
          <strong>
            {comment.username}
          </strong>

          <p>
            {comment.content}
          </p>
        </div>
      ))}

      <div className="flex gap-2 mt-3">

        <input
          type="text"
          value={text}
          onChange={(e) =>
            setText(e.target.value)
          }
          placeholder="Escribe un comentario..."
          className="
          flex-1
          border
          rounded-lg
          px-3
          py-2"
        />

        <button onClick={handleSubmit}  className=" bg-violet-600 text-white px-4 py-2 rounded-lg">
          Enviar
        </button>

      </div>

    </div>
  );
}