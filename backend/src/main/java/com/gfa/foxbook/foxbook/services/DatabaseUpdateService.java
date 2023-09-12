package com.gfa.foxbook.foxbook.services;

import com.gfa.foxbook.foxbook.models.User;
import com.gfa.foxbook.foxbook.models.nonusermodels.UserProfile;
import com.gfa.foxbook.foxbook.services.interfaces.UserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DatabaseUpdateService {
    private final RestTemplate restTemplate;
    private final UserService userService;
    private final String url = "https://air-proxy-placement.qda.cz";


//    @Scheduled(fixedRate = 60000)  // cron = "0 0 1 * * ?"
//    public void updateDatabaseFromApi() {
//        // Call the API using restTemplate
//
//        UserProfile[] responseDataArr = restTemplate.getForObject(url, UserProfile[].class);
//
//        if (responseDataArr == null){
//            return;
//        }
//        System.out.println(responseDataArr[0]);
//
//        for (int i = 0; i< responseDataArr.length;i++){
//            Optional<User> maybeUser = userService.findByEmail(responseDataArr[i].getEmail()[0]);
//            if (maybeUser.isEmpty()){
//                //user service add this user
//            }
//            // do nothing, later check
//
//        }
//
//    }

}
