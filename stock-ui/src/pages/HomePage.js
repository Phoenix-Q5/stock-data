import React, { useState } from 'react';
import axios from 'axios';
import TickerList from '../components/TickerList';
import './HomePage.css';
import TickerDetails from "../components/TickerDetails";

const HomePage = () => {
    const [ticker, setTicker] = useState('');
    const [tickerData, setTickerData] = useState(null);
    const [error, setError] = useState(null);

    const handleSearch = async (e) => {
        e.preventDefault();

        if (!ticker) {
            return;
        }

        try {
            const response = await axios.get(`/ticker/${ticker}`);
            setTickerData(response.data);
            setError(null);
        } catch (err) {
            setError('Ticker not found! Please select from the above values.');
            setTickerData(null);
        }
    };

    return (
        <div className="home-page">
            <h1>Stock Exchange</h1>
            <TickerList />
            <div className="search-bar-container">
                <input
                    type="text"
                    className="search-bar-input"
                    placeholder="Enter ticker symbol from the above list"
                    value={ticker}
                    onChange={(e) => setTicker(e.target.value)}
                />
                <button className="search-bar-button" onClick={handleSearch}>
                    Search
                </button>
            </div>

            {error && <div className="error-message">{error}</div>}
            {tickerData && (
                <div>
                    <TickerDetails tickerData={tickerData} />
                </div>
            )}
        </div>
    );
};

export default HomePage;
