package com.xeiam.xchange.service.polling;

import com.xeiam.xchange.BitMarket;
import com.xeiam.xchange.ExchangeSpecification;
import com.xeiam.xchange.currency.CurrencyPair;
import com.xeiam.xchange.dto.marketdata.BitMarketOrderBook;
import com.xeiam.xchange.dto.marketdata.BitMarketTicker;
import com.xeiam.xchange.dto.marketdata.BitMarketTrade;
import com.xeiam.xchange.service.BitMarketBaseService;
import si.mazi.rescu.RestProxyFactory;

import java.io.IOException;

/**
 * @author kpysniak
 */
public class BitMarketDataServiceRaw extends BitMarketBaseService {

  private final BitMarket bitMarket;

  /**
   * Constructor Initialize common properties from the exchange specification
   *
   * @param exchangeSpecification The {@link com.xeiam.xchange.ExchangeSpecification}
   */
  protected BitMarketDataServiceRaw(ExchangeSpecification exchangeSpecification) {
    super(exchangeSpecification);
    this.bitMarket = RestProxyFactory.createProxy(BitMarket.class, exchangeSpecification.getSslUri());
  }

  public BitMarketTicker getBitMarketTicker(CurrencyPair currencyPair) throws IOException {

    return bitMarket.getTicker(currencyPair.baseSymbol.toUpperCase() + currencyPair.counterSymbol.toString());
  }

  public BitMarketOrderBook getBitMarketOrderBook(CurrencyPair currencyPair) throws IOException {

    return bitMarket.getOrderBook(currencyPair.baseSymbol.toUpperCase() + currencyPair.counterSymbol.toString());
  }

  public BitMarketTrade[] getBitMarketTrades(CurrencyPair currencyPair) throws IOException {

    return bitMarket.getTrades(currencyPair.baseSymbol.toUpperCase() + currencyPair.counterSymbol.toString());
  }


}
