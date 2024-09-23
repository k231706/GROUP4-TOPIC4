import React from "react";
import './Footer.css';
import logo from '../Assests/logo-navbar.png';

const Footer = () => {
    return (
        <footer className="footer bg-dark text-light py-5">
        <div className="container">
            <div className="row">
                {/* Logo */}
                <div className="col-md-3 text-center">
                    <img src={logo} alt="LOGO" className="footer-img mb-2" />
                    <p className="mb-1">KOI POND DESIGN</p>
                    <p>YOUR CHOICE YOUR HAPPY</p>
                </div>

                {/* Information */}
                <div className="col-md-3">
                    <h5 className="text-uppercase">Information</h5>
                    <ul className="list-unstyled">
                        <li><a href="/" className="text-light">Main</a></li>
                        <li><a href="/project" className="text-light">Project</a></li>
                        <li><a href="/service" className="text-light">Services</a></li>
                        <li><a href="/contact" className="text-light">Contact</a></li>
                        <li><a href="/blog" className="text-light">Blog</a></li>
                        <li><a href="/about-us" className="text-light">About Us</a></li>
                    </ul>
                </div>

                {/* Contact */}
                <div className="col-md-3">
                    <h5 className="text-uppercase">Contacts</h5>
                    <p><i className="fas fa-map-marker-alt"></i> FPT UNIVERSITY</p>
                    <p><i className="fas fa-phone"></i> 999.999.9999</p>
                    <p><i className="fas fa-envelope"></i> koipondy@gmail.com</p>
                </div>

                {/* Social Media */}
                <div className="col-md-3">
                    <h5 className="text-uppercase">Social Media</h5>
                    <ul className="list-inline">
                        <li className="list-inline-item"><a href="#" className="text-light"><i className="fab fa-facebook"></i></a></li>
                        <li className="list-inline-item"><a href="#" className="text-light"><i className="fab fa-twitter"></i></a></li>
                        <li className="list-inline-item"><a href="#" className="text-light"><i className="fab fa-instagram"></i></a></li>
                        <li className="list-inline-item"><a href="#" className="text-light"><i className="fab fa-youtube"></i></a></li>
                    </ul>
                </div>
            </div>

            {/* Footer Bottom */}
            <div className="text-center mt-4 pt-4 border-top border-secondary">
                <p className="mb-0">&copy; 2024 All Rights Reserved</p>
            </div>
        </div>
    </footer>
    );

}
export default Footer;