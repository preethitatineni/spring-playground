package com.example;

import com.example.model.Activity;
import com.example.model.UserDetails;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import com.example.model.Views;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by trainer6 on 5/1/17.
 */
@RestController
public class ActivitiesController {
    @PostMapping
    public MappingJacksonValue getActivitiesStatus(@RequestBody List<Activity> activities, @RequestHeader("Accept") String acceptHeader){
        List<UserDetails> userDetailsList = new ArrayList<>();
        for(Activity activity : activities){
            UserDetails details = new UserDetails();
            details.setDate(activity.getStatus().getDate());
            details.setEmail(activity.getUser().getEmails().get(0).getAddress());
            details.setStatusText(activity.getStatus().getText());
            details.setUser(activity.getUser().getUsername());
            details.setUserId(activity.getUser().getId());
            userDetailsList.add(details);
        }
        MappingJacksonValue value = new MappingJacksonValue(userDetailsList);
        if(acceptHeader != null && acceptHeader.equalsIgnoreCase("application/vnd.galvanize.detailed+json")){
            value.setSerializationView(Views.DetailView.class);
        }else{
            value.setSerializationView(Views.BaseView.class);
        }
        return value;
    }

}
