package com.yummyyum.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;

@Entity(name = "should_create_menu")
@Getter
@Setter
@AllArgsConstructor
public class ShouldCreateMenu {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "should_create_menu")
    private Boolean shouldCreateMenu;

    public ShouldCreateMenu() {
    }

    public ShouldCreateMenu(Boolean shouldCreateMenu) {
        this.shouldCreateMenu = shouldCreateMenu;
    }


}

