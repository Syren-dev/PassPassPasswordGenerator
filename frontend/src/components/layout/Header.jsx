import logo from "../../assets/logos/passpass-logo.svg";

function Header() {
  return (
    <header className="site-header">
      <div className="site-header-inner">
        <img
          src={logo}
          alt="PassPass Password Generator"
          className="site-logo"
        />

        <nav className="site-nav" aria-label="Main navigation">
          <a href="#home" className="active">Home</a>
          <a href="#features">Features</a>
          <a href="#security">Security</a>
          <a href="#faq">FAQ</a>
        </nav>

         <div className="site-header-spacer" aria-hidden="true"></div>
      </div>
    </header>
  );
}

export default Header;