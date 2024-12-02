package cz.itnetwork.springpojistovna.controllers;

import cz.itnetwork.springpojistovna.models.dto.InsuranceDTO;
import cz.itnetwork.springpojistovna.models.dto.InsuredDTO;
import cz.itnetwork.springpojistovna.models.dto.mappers.InsuredMapper;
import cz.itnetwork.springpojistovna.models.services.InsuredService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/insured")
public class InsuredController {

    @Autowired
    private InsuredService insuredService;

    @Autowired
    private InsuredMapper insuredMapper;

    @GetMapping
    public String renderIndex(Model model) {
        try {
            List<InsuredDTO> insured = insuredService.getAll();
            model.addAttribute("insured", insured);
            return "pages/insured/index";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "Nastala chyba při načítání dat.");
            return "error";
        }
    }


    @GetMapping("/create")
    public String renderCreateForm(@ModelAttribute InsuredDTO insuredDTO) {
        return "pages/insured/create";
    }


    @PostMapping("/create")
    public String createInsured(
            @Valid @ModelAttribute InsuredDTO insured,
            BindingResult result
    ) {
        if (result.hasErrors())
            return renderCreateForm(insured);
        insuredService.create(insured);
        System.out.println(insured.getSurname());
        return "redirect:/insured";
    }


    @GetMapping("/details/{insuredId}")
    public String renderDetails(@PathVariable long insuredId, Model model) {
        try {
            InsuredDTO insured = insuredService.getById(insuredId);
            model.addAttribute("insured", insured);
            model.addAttribute("insuranceId", insured.getInsuredId());
            return "pages/insured/details";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "Nastala chyba při načítání detailů pojištění.");
            return "error";
        }
    }


    @GetMapping("edit/{insuredId}")
    public String renderEditForm(
            @PathVariable Long insuredId,
            InsuredDTO insured
    ) {
        InsuredDTO fetchedInsured = insuredService.getById(insuredId);
        insuredMapper.updateInsuredDTO(fetchedInsured, insured);

        return "pages/insured/edit";
    }


    @PostMapping("edit/{insuredId}")
    public String editInsured(
            @PathVariable long insuredId,
            @Valid InsuredDTO insured,
            BindingResult result
    ) {
        if (result.hasErrors())
            return renderEditForm(insuredId, insured);

        insured.setInsuredId(insuredId);
        insuredService.edit(insured);

        return "redirect:/insured";
    }


    @GetMapping("delete/{insuredId}")
    public String deleteInsured(@PathVariable long insuredId) {
        insuredService.remove(insuredId);
        return "redirect:/insured";
    }

}
