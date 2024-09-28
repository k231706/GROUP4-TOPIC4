import React from "react";
import { useNavigate } from "react-router-dom";
import "./style.scss";

const Header = () => {
  const navigate = useNavigate();

  return (
    <header className="header">
      <div className="logo">
        <img
          alt="Koi Pond Design Logo"
          height="50"
          src="https://gudlogo.com/wp-content/uploads/2019/05/logo-ca-Koi-23.png"
          width="50"
        />
        <span>Koi Pond Design</span>
      </div>
      <nav className="nav">
        <a className="active" href="#">
          Main
        </a>
        <a href="#">Projects</a>
        <a href="#">Blog</a>
        <a href="#">Contacts</a>
        <a href="#">About Us</a>
        <button className="login-btn" onClick={() => navigate("/login")}>
          Login
        </button>
      </nav>
    </header>
  );
};

export default Header;
