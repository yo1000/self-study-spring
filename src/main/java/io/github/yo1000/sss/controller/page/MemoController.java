// src/main/java/io/github/yo1000/sss/controller/page/MemoController.java
package io.github.yo1000.sss.controller.page;

import io.github.yo1000.sss.model.Memo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("memo")
public class MemoController {
    @RequestMapping("")
    public String get(Model model) {
        List<Map<String, Object>> items = new ArrayList<>();
        Map<String, Object> item = new HashMap<>();
        item.put("memo", "Empty Memo");
        item.put("author", "Empty Author");
        items.add(item);

        model.addAttribute("items", items);
        return "memo";
    }

    @RequestMapping("param/{memo:[a-zA-Z0-9]+}")
    public String getParams(@PathVariable String memo,
                            @RequestParam(required = false, defaultValue = "Default Author") String author,
                            Model model) {
        List<Memo> items = new ArrayList<>();
        Memo item = new Memo();
        item.setMemo(memo);
        item.setAuthor(author);
        items.add(item);

        model.addAttribute("items", items);
        return "memo";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String post(@ModelAttribute Memo item,
                       Model model) {
        List<Memo> items = new ArrayList<>();
        items.add(item);

        model.addAttribute("items", items);
        return "memo";
    }
}
