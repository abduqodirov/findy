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

}