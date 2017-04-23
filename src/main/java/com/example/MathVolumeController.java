package com.example;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by trainer6 on 4/23/17.
 */
@RestController
@RequestMapping("/math/volume")
public class MathVolumeController {

    @RequestMapping("{length}/{width}/{height}")
    public String getVolume(@PathVariable("length")int length, @PathVariable ("width") int width, @PathVariable ("height") int height){

        return String.format("The volume of a %sx%sx%s rectangle is %s", length, width, height, length*width*height);
    }
}
