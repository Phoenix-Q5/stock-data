import React from 'react';
import './TickerDetails.css';

const TickerDetails = ({ tickerData }) => {
    if (!tickerData) {
        return null;
    }

    return (
        <div className="ticker-details-container">
            <div className="details-left">
                <h2>{tickerData.name} ({tickerData.ticker})</h2>
                <p><strong>Item Type:</strong> {tickerData.item_type}</p>
                <p><strong>Sector:</strong> {tickerData.sector}</p>
                <p><strong>Industry:</strong> {tickerData.industry}</p>
                <p><strong>Exchange Code:</strong> {tickerData.exchange_code}</p>
                <p><strong>Full-Time Employees:</strong> {tickerData.full_time_employees}</p>
                <p><strong>IPO Date:</strong> {tickerData.ipo_date || 'N/A'}</p>
                <p><strong>Date Founded:</strong> {tickerData.date_founded || 'N/A'}</p>

                <h3>Address</h3>
                <p><strong>City:</strong> {tickerData.address.city}</p>
                <p><strong>Street 1:</strong> {tickerData.address.street1}</p>
                {tickerData.address.street2 && <p><strong>Street 2:</strong> {tickerData.address.street2}</p>}
                <p><strong>Postal Code:</strong> {tickerData.address.postal_code}</p>
                <p><strong>State/Country:</strong> {tickerData.address.stateOrCountry}</p>

                <p><strong>Phone:</strong> {tickerData.phone}</p>
                <p>
                    <strong>Website:</strong>
                    <a href={tickerData.website} target="_blank" rel="noopener noreferrer">
                        {tickerData.website}
                    </a>
                </p>
            </div>

            <div className="details-right">
                <h3>Stock Exchanges</h3>
                <ul className="stock-exchanges-list">
                    {tickerData.stock_exchanges?.map((exchange, index) => (
                        <li key={index}>
                            <p>Exchange Name: {exchange.exchange_name}</p>
                            <p>Exchange MIC: {exchange.exchange_mic}</p>
                            <p>Acronym: {exchange.acronym1}</p>
                            <p>City: {exchange.city}</p>
                            <p>Country: {exchange.country}</p>
                            <p>
                                Website:
                                <a href={exchange.website} target="_blank" rel="noopener noreferrer">
                                    {exchange.website}
                                </a>
                            </p>
                        </li>
                    ))}
                </ul>
            </div>

            <div className="details-about">
                <h3>About</h3>
                <p>{tickerData.about || 'No description available.'}</p>
            </div>
        </div>
    );
};

export default TickerDetails;
