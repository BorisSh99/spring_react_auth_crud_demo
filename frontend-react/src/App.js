import './App.css';
import HeaderComponent from "./components/HeaderComponent";
import FooterComponent from "./components/FooterComponent";
import CardboardComponent from "./components/CardboardComponent";

function App() {
  return (
      <div>
        <HeaderComponent />
        <div className="container">
          <CardboardComponent />
        </div>
        <FooterComponent />
      </div>
  );
}

export default App;

