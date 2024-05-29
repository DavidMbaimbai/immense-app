package com.davymbaimbai.ecommerce.client;

import com.davymbaimbai.ecommerce.exception.BusinessException;
import com.davymbaimbai.ecommerce.record.PurchaseRequest;
import com.davymbaimbai.ecommerce.record.PurchaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ProductClient {
    @Value("${application.config.product-url}")
    private String productUrl;
    private final RestTemplate restTemplate;

    public List<PurchaseResponse> purchaseProducts(List<PurchaseRequest> requestBody) {
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<List<PurchaseRequest>> requestEntity = new HttpEntity<>(requestBody, headers);
        ParameterizedTypeReference<List<PurchaseResponse>> responseType =
                new ParameterizedTypeReference<>() {
                };
        ResponseEntity<List<PurchaseResponse>> responseEntity = restTemplate.exchange(
                productUrl + "/product", HttpMethod.POST,requestEntity, responseType
        );
        if (responseEntity.getStatusCode().isError()){
            throw new BusinessException("An occurred while processing the product purchase: " + responseEntity.getStatusCode());
        }
        return responseEntity.getBody();
    }
}
