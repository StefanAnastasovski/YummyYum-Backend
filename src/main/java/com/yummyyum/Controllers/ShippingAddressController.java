package com.yummyyum.Controllers;

import com.yummyyum.Model.ShippingAddress;
import com.yummyyum.Services.ShippingAddress.ShippingAddressService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:8080")
public class ShippingAddressController {

    private final ShippingAddressService shippingAddressService;

    public ShippingAddressController(ShippingAddressService shippingAddressService) {
        this.shippingAddressService = shippingAddressService;
    }

    @GetMapping("/shipping-address")
    public List<ShippingAddress> getAllShippingAddress() {
        return shippingAddressService.getAllShippingAddresses();
    }

    @GetMapping("/shipping-address/username/{username}")
    public Optional<ShippingAddress> getShippingAddressByUsername(@PathVariable("username") String username) {
        return shippingAddressService.getShippingAddressByUsername(username);
    }

    @PostMapping("/shipping-address/username/{username}")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ShippingAddress createNewShippingAddress(@RequestBody ShippingAddress shippingAddress,
                                                    @PathVariable("username") String username,
                                                    HttpServletResponse response,
                                                    UriComponentsBuilder builder) throws Exception {

        return shippingAddressService.createShippingAddress(shippingAddress.getAddress(), shippingAddress.getZipCode(),
                username);
    }

    @PutMapping("/shipping-address/username/{username}")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ShippingAddress updateUser(@RequestBody ShippingAddress shippingAddress,
                           @PathVariable("username") String username,
                           HttpServletResponse response,
                           UriComponentsBuilder builder) {

        return shippingAddressService.updateShippingAddress(shippingAddress.getAddress(),
                shippingAddress.getZipCode(), username);
    }
}
