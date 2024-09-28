import React from "react";
import "./style.scss";
import {
  BiMap,
  BiLogoTwitter,
  BiLogoInstagramAlt,
  BiLogoFacebookSquare,
  BiLogoGmail,
  BiPhoneCall,
} from "react-icons/bi";

const Footer = () => {
  return (
    <footer className="footer">
      <div className="container">
        <div className="row">
          <div className="col-lg-4">
            <div className="footer_1">
              <ul>
                <li>
                  <img
                    src="https://gudlogo.com/wp-content/uploads/2019/05/logo-ca-Koi-23.png"
                    alt="Koi Logo"
                    className="footer__logo-img"
                  />
                </li>
                <li>KOI POND DESIGN</li>
              </ul>
            </div>
          </div>

          <div className="col-lg-4">
            <div className="footer_1">
              <h6>Information</h6>
              <ul>
                <li>Main</li>
                <li>Gallery</li>
                <li>Project</li>
                <li>Blog</li>
                <li>Contact</li>
                <li>About us</li>
              </ul>
            </div>
          </div>

          <div className="col-lg-4">
            <div className="footer_1">
              <h6>Contact</h6>
              <ul>
                <li>
                  <BiMap /> FPT UNIVERSITY
                </li>
                <li>
                  <BiPhoneCall /> 999.999.999
                </li>
                <li>
                  <BiLogoGmail /> koipondy@gmail.com
                </li>
              </ul>
            </div>
          </div>

          <div className="col-lg-4">
            <div className="footer_1">
              <h6>Social Media</h6>
              <ul>
                <li>
                  <BiLogoFacebookSquare /> Facebook
                </li>
                <li>
                  <BiLogoInstagramAlt /> Instagram
                </li>
                <li>
                  <BiLogoTwitter /> Twitter
                </li>
              </ul>
            </div>
          </div>
        </div>
        <div className="bottom-bar">© 2024 All Rights Reserved</div>
      </div>
    </footer>
  );
};

export default Footer;
