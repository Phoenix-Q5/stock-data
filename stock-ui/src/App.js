import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import HomePage from './pages/HomePage';
import TickerDetails from './components/TickerDetails';
import './App.css';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <Router>
          <Routes>
            <Route path="/" element={<HomePage />} />
            <Route path="/ticker/:ticker" element={<TickerDetails />} />
          </Routes>
        </Router>
      </header>
    </div>
  );
}

export default App;
