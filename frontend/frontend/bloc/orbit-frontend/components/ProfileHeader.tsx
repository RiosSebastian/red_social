"use client";
import { User } from "@/types/user";
import { useState } from "react";

interface Props {
  user: User;
}



export default function ProfileHeader({
  user,
}: Props) {
    const [following, setFollowing] =
  useState(false);
  return (
    <div className="bg-white rounded-xl shadow overflow-hidden">

      <img
        src={user.coverImage}
        alt=""
        className="w-full h-64 object-cover"
      />

      <div className="p-6">

        <div className="flex items-center gap-6">

          <img
            src={user.avatar}
            alt=""
            className="
            w-32
            h-32
            rounded-full
            border-4
            border-white
            -mt-20"
          />

          <div>

            <h1 className="text-3xl font-bold">
              {user.fullName}
            </h1>

            <p className="text-gray-500">
              @{user.username}
            </p>

          </div>

        </div>

        <p className="mt-4">
          {user.bio}
        </p>
        <div className="flex gap-8 mt-6">

  <div>
    <strong>
      {user.posts}
    </strong>
    <p>Posts</p>
  </div>

  <div>
    <strong>
      {user.followers}
    </strong>
    <p>Seguidores</p>
  </div>

  <div>
    <strong>
      {user.following}
    </strong>
    <p>Siguiendo</p>
  </div>
<button
  onClick={() =>
    setFollowing(!following)
  }
  className="
  mt-6
  bg-violet-600
  text-white
  px-5
  py-2
  rounded-lg"
>
  {following
    ? "Siguiendo"
    : "Seguir"}
</button>
</div>

      </div>

    </div>
  );
}