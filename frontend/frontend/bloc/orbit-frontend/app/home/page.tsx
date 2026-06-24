import Navbar from "@/components/Navbar";
import Sidebar from "@/components/Sidebar";
import Feed from "@/components/Feed";
import Stories from "@/components/Stories";
import CreatePost from "@/components/CreatePost";

export default function HomePage() {
  return (
    <>
      <Navbar />

      <main className="grid grid-cols-12 gap-4 p-6">
        <div className="col-span-3">
          <Sidebar />
        </div>

        <div className="col-span-6">
          <CreatePost />
          <Stories />
          <Feed />
        </div>

        <div className="col-span-3">
          <div className="bg-white p-4 rounded-xl shadow">
            Tendencias
          </div>
        </div>
      </main>
    </>
  );
}