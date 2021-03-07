package com.yummyyum.Services.shouldCreateMenu;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ShouldCreateMenuService {

    void updateShouldCreateMenu(Boolean shouldCreateMenu);

}
