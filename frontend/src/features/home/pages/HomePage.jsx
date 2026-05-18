import MainLayout from "../../../components/layout/MainLayout";
import ShowcaseFrame from "../../../components/layout/ShowcaseFrame";
import "../home.css";

function HomePage() {
  return (
    <MainLayout>
      <div className="container">
        <ShowcaseFrame>
          {/* Hero content goes here later */}
        </ShowcaseFrame>
      </div>
    </MainLayout>
  );
}

export default HomePage;