package com.abduqodirov.findy;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

@RestController
public class FindyController {

    ArrayList<LostItem> lostItems = new ArrayList<>();
    ArrayList<User> users = new ArrayList<>();


    @GetMapping("/getlostitems")
    public List<LostItem> getLostItems() {

        return lostItems;
    }

    @PostMapping("/addlostitem")
    public Response addLostItem(
            @RequestParam(value = "title", required = false) String title,
            @RequestParam(value = "gift", required = false) int gift,
            @RequestParam(value = "lostDate", required = false) long lostDate

    ) {

        lostItems.add(new LostItem(title, gift, lostDate));

        return new Response(200, "Successfully added");
    }

    @PostMapping("/signup")
    public Response signUp(
            @RequestParam(value = "firstName", required = true) String firstName,
            @RequestParam(value = "lastName", required = true) String lastName,
            @RequestParam(value = "email", required = true) String email,
            @RequestParam(value = "phoneNumber", required = true) String phoneNumber,
            @RequestParam(value = "password", required = true) String password
    ) {


        User user = new User(
                firstName,
                lastName,
                email,
                phoneNumber,
                password
        );

        users.add(user);

        return new Response(200, "Successfully signed up");
    }

    @GetMapping("/signin")
    public Response signIn(
            @RequestParam(value = "email", required = true) String email,
            @RequestParam(value = "password", required = true) String password
    ) {


        for (User user : users) {

            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {

                return new Response(200, "You've succesffully signed in");

            }


        }

        return new Response(200, "Password or email incorrect");
    }



}