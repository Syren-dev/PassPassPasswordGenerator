import Header from "./Header";
import heroBg from "../../assets/shapes/hero-bg.svg";

function ShowcaseFrame({ children }) {
  return (
    <section className="showcase-frame">
      <img
        src={heroBg}
        alt=""
        className="showcase-bg"
        aria-hidden="true"
      />

      <div className="showcase-inner">
        <Header />

        <div className="showcase-content">
          {children}
        </div>
      </div>
    </section>
  );
}

export default ShowcaseFrame;