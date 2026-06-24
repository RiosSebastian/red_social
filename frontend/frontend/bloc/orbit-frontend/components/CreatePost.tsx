"use client";

import { useState } from "react";
import { usePostStore } from "@/store/postStore";

export default function CreatePost() {

  const [content, setContent] = useState("");
  const [image, setImage] = useState("");

  const addPost = usePostStore(
    (state) => state.addPost
  );

  const handleImageChange = (
    e: React.ChangeEvent<HTMLInputElement>
  ) => {

    const file = e.target.files?.[0];

    if (!file) return;

    const imageUrl =
      URL.createObjectURL(file);

    setImage(imageUrl);
  };

  const handleSubmit = () => {

    if (!content.trim() && !image)
      return;

    addPost({
      username: "Sebastian",
      content,
      createdAt: "Ahora",
      image,
    });

    setContent("");
    setImage("");
  };

  return (
    <div className="bg-white p-4 rounded-xl shadow mb-6">

      <textarea
        value={content}
        onChange={(e) =>
          setContent(e.target.value)
        }
        placeholder="¿Qué estás pensando?"
        className="
        w-full
        border
        rounded-lg
        p-3"
      />

      {image && (
        <img
          src={image}
          alt="preview"
          className="
          mt-4
          rounded-lg
          max-h-80
          w-full
          object-cover"
        />
      )}

      <div className="flex justify-between mt-4">

        <input
          type="file"
          accept="image/*"
          onChange={handleImageChange}
        />

        <button
          onClick={handleSubmit}
          className="
          bg-violet-600
          text-white
          px-4
          py-2
          rounded-lg"
        >
          Publicar
        </button>

      </div>

    </div>
  );
}