import './App.css';
import HeaderComponent from "./components/HeaderComponent";
import FooterComponent from "./components/FooterComponent";
import CardboardComponent from "./components/CardboardComponent";
import {BrowserRouter, Route, Routes} from "react-router-dom";
import CreateCardComponent from "./components/CreateCardComponent";

function App() {
  return (
      <div>
          <BrowserRouter>
              <HeaderComponent />
              <div className="container-fluid">
                  <Routes>
                      <Route path="/" element={<CardboardComponent />} />
                      <Route path="new" element={<CreateCardComponent />} />
                  </Routes>
              </div>
              <FooterComponent />
          </BrowserRouter>
      </div>
  );
}

export default App;

