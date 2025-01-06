import React, { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';
import axios from 'axios';
import './TickerList.css';

const TickerList = () => {
    const [tickers, setTickers] = useState([]);

    useEffect(() => {
        axios.get('/listTicker')
            .then(response => {
                const tickerSymbols = response.data.map(item => item.ticker);
                setTickers([...tickerSymbols, ...tickerSymbols]);
            })
            .catch(error => {
                console.error('Error fetching ticker list:', error);
            });
    }, []);

    useEffect(() => {
        if (tickers.length > 0) {
            const scrollDuration = Math.max(30, tickers.length * 2);
            document.documentElement.style.setProperty('--scroll-duration', `${scrollDuration}s`);
        }
    }, [tickers]);

    return (
        <div className="ticker-container">
            <div className="ticker-scroll">
                {tickers.map((ticker, index) => (
                    <Link key={index} to={`/ticker/${ticker}`} className="ticker-item">
                        {ticker}
                    </Link>
                ))}
            </div>
        </div>
    );
};

export default TickerList;
