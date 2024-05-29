package com.davymbaimbai.ecommerce.service;

import com.davymbaimbai.ecommerce.client.CustomerClient;
import com.davymbaimbai.ecommerce.client.ProductClient;
import com.davymbaimbai.ecommerce.exception.BusinessException;
import com.davymbaimbai.ecommerce.kafka.OrderProducer;
import com.davymbaimbai.ecommerce.mapper.OrderMapper;
import com.davymbaimbai.ecommerce.record.OrderConfirmation;
import com.davymbaimbai.ecommerce.record.OrderLineRequest;
import com.davymbaimbai.ecommerce.record.OrderRequest;
import com.davymbaimbai.ecommerce.record.PurchaseRequest;
import com.davymbaimbai.ecommerce.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final CustomerClient customerClient;
    private final ProductClient productClient;
    private final OrderMapper mapper;
    private final OrderLineService orderLineService;
    private final OrderProducer orderProducer;

    public Integer createOrder(OrderRequest request) {
        var customer = this.customerClient.findCustomerById(request.customerId())
                .orElseThrow(() -> new BusinessException("Cannot create order:: No customer exists with provided ID:: %s" + request.customerId()));
        var purchasedProducts = this.productClient.purchaseProducts(request.products());

        var order = this.orderRepository.save(mapper.toOrder(request));
        for (PurchaseRequest purchaseRequest : request.products()) {
            orderLineService.saveOrderLine(
                    new OrderLineRequest(
                            null,
                            order.getId(),
                            purchaseRequest.productId(),
                            purchaseRequest.quantity()
                    )
            );
        }
        //todo start payment process

        orderProducer.sendOrderConfirmation(
                new OrderConfirmation(
                        request.reference(),
                        request.amount(),
                        request.paymentMethod(),
                        customer,
                        purchasedProducts
                )
        );

        return order.getId();
    }
}
