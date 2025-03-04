package miu.edu.cs545assignment.controller;

import miu.edu.cs545assignment.domain.dto.response.AdminResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/admin")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AdminController {
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public AdminResponse getAll() {
        return new AdminResponse("Hello from admin page");
    }
}
