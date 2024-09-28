import React from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Header from "./user/component/header";
import Home from "./user/component/Home";
import Footer from "./user/component/Footer";
import Login from "./user/Login";
import Project from "./user/page/Project";

const App = () => {
  return (
    <Router>
      <Routes>
        <Route
          path="/"
          element={
            <>
              <Header />
              <Home />
              <Footer />
            </>
          }
        />
        <Route path="/login" element={<Login />} />
        <Route
          path="/Project"
          element={
            <>
              <Header />
              <Project />
              <Footer />
            </>
          }
        />
      </Routes>
    </Router>
  );
};

export default App;
