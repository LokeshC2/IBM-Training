package org.ibm.conversionservice.service;

import java.util.Date;
import java.util.List;

import org.ibm.conversionservice.client.RateClient;
import org.ibm.conversionservice.dto.ConversionModelDto;
import org.ibm.conversionservice.model.ConversionRequest;
import org.ibm.conversionservice.repository.ConversionRepository;
import org.ibm.conversionservice.ui.ConversionRequestModel;
import org.ibm.conversionservice.ui.ConversionResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConversionService {

  @Autowired
  RateClient rateClient;

  @Autowired
  ConversionRepository conversionRepository;

  public ConversionResponseModel getConversion(ConversionRequestModel conversion) {
    String[] fromto = conversion.getConvert().split(" -> ");
    String from = fromto[0];
    String to = fromto[1];

    ConversionModelDto rateServiceResponse = rateClient.getRate(from, to);

    if (rateServiceResponse == null) {
      throw new RuntimeException("Rate not found");
    }

    ConversionResponseModel response = new ConversionResponseModel();
    response.setFrom(rateServiceResponse.getFrom());
    response.setTo(rateServiceResponse.getTo());
    response.setQuantity(conversion.getQuantity());
    response.setRate(rateServiceResponse.getConversionMultiple());
    response.setTotalAmount(conversion.getQuantity() * rateServiceResponse.getConversionMultiple());
    return response;
  }

  public List<String> getSupportedCurrencies() {
    List<String> currencies = rateClient.getCurrencies();

    if (currencies == null) {
      throw new RuntimeException("Currencies not found");
    }

    return currencies;
  }

  public void saveConversion(ConversionRequestModel conversion) {
    ConversionRequest request = new ConversionRequest();
    request.setFrom(conversion.getConvert().split(" -> ")[0]);
    request.setTo(conversion.getConvert().split(" -> ")[1]);
    request.setQuantity(conversion.getQuantity());
    request.setDate(new Date());
    conversionRepository.save(request);
  }
}
