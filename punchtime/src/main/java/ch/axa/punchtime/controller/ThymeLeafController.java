package ch.axa.punchtime.controller;

import ch.axa.punchtime.domain.Entry;
import ch.axa.punchtime.repositories.EntryRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ThymeLeafController {

    @Autowired
    private EntryRepository entryRepo;


    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("entries", entryRepo.findAll());
        return "index";
    }

    @GetMapping("/add")
    public String add(Entry entry) {
        return "add";
    }


    @PostMapping("/create")
    public String create(@Valid Entry entry, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add";
        }

        entryRepo.save(entry);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, Model model) {
        Entry entry = entryRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid entry Id: " + id));
        model.addAttribute("entry", entry);
        return "edit";
    }


    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") String id, @Valid Entry entry, BindingResult result, Model model) {
        if (result.hasErrors()) {
            entry.setId(id);
            return "edit";
        }

        entryRepo.save(entry);

        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id, Model model) {
        Entry entry = entryRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid entry Id:" + id));
        entryRepo.delete(entry);

        return "redirect:/";
    }
}
