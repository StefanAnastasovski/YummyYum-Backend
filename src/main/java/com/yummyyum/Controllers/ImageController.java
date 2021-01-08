package com.yummyyum.Controllers;

import com.yummyyum.Model.Image;
import com.yummyyum.Services.Image.ImageService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:8080")
public class ImageController {

    private final ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping("/images")
    public List<Image> getAllImages() {
        return imageService.getAllImages();
    }

    @PostMapping("/images")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Image createNewImage(@RequestBody Image image,
                                HttpServletResponse response,
                                UriComponentsBuilder builder) {

        Boolean isChef = image.getIsChefImg();
        Boolean isMain = image.getIsMainRecipeImg();
        Pattern pattern = Pattern.compile("\\d+");
        Boolean isStepOrder;
//        Image image1 = null;
         Image image1 = imageService.createNewImage(
                image.getUrl(), image.getAlt(),
                image.getStepOrderNumber(), image.getIsChefImg(),
                image.getIsMainRecipeImg());
//                 , image.getMeal());
//        if (!(image.getStepOrderNumber() == null)) {
//            isStepOrder = pattern.matcher(image.getStepOrderNumber().toString()).matches();
//        } else {
//            isStepOrder = false;
//        }
//        System.out.println(image);
//        System.out.println(image.getMeal());
//
//        if (isChef && isMain ||
//                isChef && isStepOrder ||
//                isMain && isStepOrder) {
//            System.out.println("both can't be true");
//        } else {
//            if (!isChef && !isMain) {
//                if (isStepOrder) {
//                    image1 = imageService.createNewImage(
//                            image.getUrl(), image.getAlt(),
//                            image.getStepOrderNumber(), image.getIsChefImg(),
//                            image.getIsMainRecipeImg(), image.getMeal());
//                }
//            } else if (image.getStepOrderNumber() == null) {
//                if (isChef) {
//                    image1 = imageService.createNewImage(
//                            image.getUrl(), image.getAlt(),
//                            image.getStepOrderNumber(), image.getIsChefImg(),
//                            image.getIsMainRecipeImg(), image.getMeal());
//                } else if (isMain) {
//                    image1 = imageService.createNewImage(
//                            image.getUrl(), image.getAlt(),
//                            image.getStepOrderNumber(), image.getIsChefImg(),
//                            image.getIsMainRecipeImg(), image.getMeal());
//                }
//            }
//        }

        response.setHeader("Location", builder.path("/api/images/" + image.getId()).
                buildAndExpand(image.getId()).toUriString());

        return image1;
    }

}
