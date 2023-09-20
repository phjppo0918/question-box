import logo from "./logo.svg";
import "./App.css";
import LoginForm from "./LoginForm";
import Contact from "./Contact";
import Home from "./Home";
import About from "./About";
import Menu from "./Menu";
import SignUpForm from "./SignUpForm";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import "bootstrap/dist/css/bootstrap.min.css";
import axios from "axios";

axios.defaults.baseURL = "http://api";
axios.defaults.withCredentials = true;

function App() {
  return (
    <BrowserRouter>
      <div>
        <Menu />
        <div className="container mt-3">
          <Routes>
            {/* 홈 페이지 */}
            <Route path="/" exact element={<Home />} />
            {/* 소개 페이지 */}
            <Route path="/about" element={<About />} />
            {/* 연락처 페이지 */}
            <Route path="/contact" element={<Contact />} />
            {/* 로그인 페이지 */}
            <Route path="/login" element={<LoginForm />} />
            {/* 회원가입 페이지 */}
            <Route path="/signup" element={<SignUpForm />} />
          </Routes>
        </div>
      </div>
    </BrowserRouter>
  );
}

export default App;
