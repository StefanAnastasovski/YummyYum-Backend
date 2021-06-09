package com.yummyyum.Controllers.History;

import com.yummyyum.Model.History.ShippingAddressHistory;
import com.yummyyum.Services.History.ShippingAddressHistory.ShippingAddressHistoryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:8080")
public class ShippingAddressHistoryController {

    private final ShippingAddressHistoryService shippingAddressHistoryService;

    public ShippingAddressHistoryController(ShippingAddressHistoryService shippingAddressHistoryService) {
        this.shippingAddressHistoryService = shippingAddressHistoryService;
    }

    @GetMapping("/shipping-address/history/username={username}")
    public List<ShippingAddressHistory> getAllShippingAddressHistoriesByUsername(@PathVariable("username") String username) {
        return shippingAddressHistoryService.getAllShippingAddressHistoriesByUsername(username);
    }

    @PostMapping("/shipping-address/history/username={username}")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ShippingAddressHistory createNewShippingAddressHistory(@RequestBody ShippingAddressHistory shippingAddressHistory,
                                                                  @PathVariable("username") String username,
                                                                  HttpServletResponse response,
                                                                  UriComponentsBuilder builder) throws Exception {

        return shippingAddressHistoryService.createNewShippingAddressHistory(shippingAddressHistory.getAddress(),
                shippingAddressHistory.getZipCode(), username);
    }
}
