package cz.itnetwork.springpojistovna.controllers;

import cz.itnetwork.springpojistovna.models.dto.InsuranceDTO;
import cz.itnetwork.springpojistovna.models.dto.mappers.InsuranceMapper;
import cz.itnetwork.springpojistovna.models.services.InsuranceService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/insurance")
public class InsuranceController {

    @Autowired
    InsuranceService insuranceService;

    @Autowired
    InsuranceMapper insuranceMapper;

    @GetMapping
    public String renderIndex(Model model) {
        try {
            List<InsuranceDTO> insurance = insuranceService.getAll();
            model.addAttribute("insurance", insurance);
            return "pages/insurance/index";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "Nastala chyba při načítání dat.");
            return "error";
        }
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/create")
    public String renderCreateForm(@ModelAttribute("insuranceDTO") InsuranceDTO insuranceDTO) {
        return "pages/insurance/create";
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("/create")
    public String createInsurance(
            @Valid @ModelAttribute InsuranceDTO insurance,
            BindingResult result
    ) {
        if (result.hasErrors())
            return renderCreateForm(insurance);
        insuranceService.create(insurance);
        System.out.println(insurance.getTypeOfInsurance());
        return "redirect:/insurance";
    }


    @GetMapping("/details/{insuranceId}")
    public String renderDetails(@PathVariable long insuranceId, Model model) {
        try {
            InsuranceDTO insurance = insuranceService.getById(insuranceId);
            model.addAttribute("insurance", insurance);
            return "pages/insurance/details"; // Ujistěte se, že tato šablona existuje
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "Nastala chyba při načítání detailů pojištění.");
            return "error";
        }
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("edit/{insuranceId}")
    public String renderEditForm(@PathVariable Long insuranceId,InsuranceDTO insurance) {
        InsuranceDTO fetchedInsurance = insuranceService.getById(insuranceId);
        insuranceMapper.updateInsuranceDTO(fetchedInsurance, insurance);

        return "pages/insurance/edit";
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("edit/{insuranceId}")
    public String editInsurance(
            @PathVariable long insuranceId,
            @Valid InsuranceDTO insurance,
            BindingResult result
    ) {
        if (result.hasErrors())
            return renderEditForm(insuranceId, insurance);

        insurance.setInsuranceID(insuranceId);
        insuranceService.edit(insurance);

        return "redirect:/insurance";
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("delete/{insuranceId}")
    public String deleteInsurance(@PathVariable long insuranceId) {
        insuranceService.remove(insuranceId);

        return "redirect:/insurance";
    }

}
