package com.mhrimch.hospitalapp.web;

import com.mhrimch.hospitalapp.entities.Patient;
import com.mhrimch.hospitalapp.repository.PatientRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PatientController {
    private PatientRepository patientRepository;

    public PatientController(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }


    @GetMapping("/index")
    public String index(Model model,
                        @RequestParam(name = "page", defaultValue = "0")   int page,
                        @RequestParam(name = "size", defaultValue = "5")   int size,
                        @RequestParam(name = "keyword", defaultValue = "") String keyword){

        Page<Patient> patientList = patientRepository.
                findByFirstNameContainsIgnoreCaseOrLastNameContainsIgnoreCase(keyword, keyword, PageRequest.of(page, size));
        model.addAttribute("patients", patientList.getContent());
        model.addAttribute("pages", new int[patientList.getTotalPages()]);
        model.addAttribute("currentPage", page);
        model.addAttribute("keyword", keyword);

        return "view_patients";
    }

    @GetMapping("/deletePatient")
    public String delete (@RequestParam(name = "id") Long patientID, String keyword, int page ){
        patientRepository.deleteById(patientID);
        return "redirect:/index?page="+page+"&keyword="+keyword;
    }


}
