package controler;

import domain.dto.PatientDto;
import domain.entity.Patient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import service.PatientService;

import java.util.List;

@Controller
@RequestMapping(value = "/api")
public class PatientApiController {
    private static final Logger LOGGER = LoggerFactory.getLogger(PatientApiController.class);

    private final PatientService patientService;

    @Autowired
    public PatientApiController(PatientService patientService) {
        this.patientService = patientService;
    }

    @CrossOrigin
    @GetMapping(value = "/patients")
    public ResponseEntity<List<PatientDto>> getPatients(){
        LOGGER.info("find all patients");

        List<PatientDto> patientDto = patientService.findAll();
        return new ResponseEntity<>(patientDto, HttpStatus.OK);
    }
}
