import React from "react";
import "./stype.scss";
const Login = () => {
  return (
    <div class="container">
      <div class="login-box">
        <img
          alt="Koi Pond Design Logo"
          height="50"
          src="https://gudlogo.com/wp-content/uploads/2019/05/logo-ca-Koi-23.png"
          width="50"
        />
        <h1>Login</h1>
        <input placeholder="E-mail" type="text" />
        <input placeholder="Password" type="password" />
        <button>Login</button>
        <p>
          don't have an account?
          <a href="#">Create a account</a>
        </p>
        <p>
          <a href="#">Forgot password?</a>
        </p>
      </div>
    </div>
  );
};

export default Login;
