import './App.css';
import { createBrowserRouter, Navigate, Route, Router, RouterProvider, Routes } from 'react-router-dom';
import Login from './Components/Login/Login';
import SignUp from './Components/SignUp/SignUp';
import Contact from './Components/Contact/Contact';

function App() {
  const router = createBrowserRouter([
    {
      path: "/",
      element: <Login />,
    },
    {
      path: "login",
      element: <Login />,
    },
    {
      path: "signup",
      element: <SignUp />,
    },
    {
      path: "contact",
      element: <Contact/>,
    }
  ]);

  return <RouterProvider router={router} />;
};

export default App;
