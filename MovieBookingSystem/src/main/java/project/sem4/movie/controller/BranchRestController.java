package project.sem4.movie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.sem4.movie.entities.Branchs;
import project.sem4.movie.service.BranchService;

import java.util.List;

@RestController
@RequestMapping("/api/Branchs")
public class BranchRestController {
    private final BranchService BranchService;

    @Autowired
    public BranchRestController(BranchService BranchService) {
        this.BranchService = BranchService;
    }

    @GetMapping
    public List<Branchs> getAllBranchs() {
        return BranchService.getAllBranchs();
    }

    @GetMapping("/{BranchId}")
    public ResponseEntity<Branchs> getBranchById(@PathVariable("BranchId") int BranchId) {
        Branchs Branch = BranchService.getBranchById(BranchId);
        if (Branch != null) {
            return ResponseEntity.ok(Branch);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Branchs createBranch(@RequestBody Branchs newBranch) {
        return BranchService.pushBranch(newBranch);
    }

    @PutMapping("/{BranchId}")
    public ResponseEntity<Branchs> updateBranch(
            @RequestBody Branchs updatedBranch,
            @PathVariable("BranchId") int BranchId) {
        Branchs Branch = BranchService.updateBranch(updatedBranch, BranchId);
        if (Branch != null) {
            return ResponseEntity.ok(Branch);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{BranchId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBranch(@PathVariable("BranchId") int BranchId) {
        BranchService.deleteBranchById(BranchId);
    }
}
