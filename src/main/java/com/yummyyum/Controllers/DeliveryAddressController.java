package com.yummyyum.Controllers;

import com.yummyyum.Model.DeliveryAddress;
import com.yummyyum.Services.DeliveryAddress.DeliveryAddressService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:8080")
public class DeliveryAddressController {

    private final DeliveryAddressService deliveryAddressService;

    public DeliveryAddressController(DeliveryAddressService deliveryAddressService) {
        this.deliveryAddressService = deliveryAddressService;
    }


    @GetMapping("/delivery-address/card-number={cardNumberId}")
    public Optional<DeliveryAddress> getDeliveryAddressByCardNumberId(@PathVariable("cardNumberId") String cardNumberId) {
        return deliveryAddressService.getDeliveryAddressByCardNumberId(cardNumberId);
    }

    @PostMapping("/delivery-address/card-number={cardNumberId}")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public DeliveryAddress createNewDeliveryAddress(@RequestBody DeliveryAddress deliveryAddress,
                                @PathVariable("cardNumberId") String cardNumberId,
                                HttpServletResponse response,
                                UriComponentsBuilder builder) {

        return deliveryAddressService.createNewDeliveryAddress(
                deliveryAddress.getAddress(), deliveryAddress.getZipCode(), cardNumberId);
    }
}
