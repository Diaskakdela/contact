package kz.satbayev.contactbook.controller;

import kz.satbayev.contactbook.service.contact.ContactService;
import kz.satbayev.contactbook.service.contact.contactparams.ContactUpdateParam;
import kz.satbayev.contactbook.service.contact.contactparams.creating.ContactCreationParam;
import kz.satbayev.contactbook.service.contact.contactparams.searching.ContactFindParam;
import kz.satbayev.contactbook.service.contact.dto.ContactDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/contact")
@RestController
@RequiredArgsConstructor
public class ContactController {

    private final ContactService service;

    @GetMapping("/sorted")
    public ResponseEntity<List<ContactDto>> findAllAlphabetic(){
        return ResponseEntity.ok(service.findAllAlphabetically());
    }

    @GetMapping
    public ResponseEntity<ContactDto> findByName(@RequestParam String firstName, @RequestParam String lastName){
        var findParam = ContactFindParam.createByName(firstName, lastName);
        return ResponseEntity.ok(service.find(findParam));
    }

    @GetMapping
    public ResponseEntity<ContactDto> findByPhoneNumber(@RequestParam String phoneNumber){
        var findParam = ContactFindParam.createByPhone(phoneNumber);
        return ResponseEntity.ok(service.find(findParam));
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody ContactCreationParam param){
        service.add(param);
        return ResponseEntity.ok("created");
    }

    @PatchMapping()
    public ResponseEntity<String> updateByPhone(@RequestParam String phoneNumber,@RequestBody ContactUpdateParam updateParam){
        var findParam = ContactFindParam.createByPhone(phoneNumber);
        service.update(findParam, updateParam);

        return ResponseEntity.ok("ok");
    }

    @PatchMapping()
    public ResponseEntity<String> updateByName(@RequestParam String firstName,
                                               @RequestParam String lastName,
                                               @RequestBody ContactUpdateParam updateParam){
        var findParam = ContactFindParam.createByName(firstName, lastName);
        service.update(findParam, updateParam);

        return ResponseEntity.ok("ok");
    }

    @DeleteMapping
    public ResponseEntity<String> deleteByName(@RequestParam String firstName, @RequestParam String lastName){
        var findParam = ContactFindParam.createByName(firstName, lastName);
        service.remove(findParam);

        return ResponseEntity.ok("deleted");
    }
    @DeleteMapping
    public ResponseEntity<String> deleteByPhone(@RequestParam String phoneNumber){
        var findParam = ContactFindParam.createByPhone(phoneNumber);
        service.remove(findParam);

        return ResponseEntity.ok("deleted");
    }
}
