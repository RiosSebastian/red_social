import ProfileHeader
from "@/components/ProfileHeader";

import { mockUser }
from "@/lib/mockUser";

import Feed
from "@/components/Feed";

export default function ProfilePage() {

  return (
    <main
      className="
      max-w-5xl
      mx-auto
      p-6"
    >

      <ProfileHeader
        user={mockUser}
      />

      <div className="mt-8">

        <Feed />

      </div>

    </main>
  );
}