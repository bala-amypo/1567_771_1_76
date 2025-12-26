@RestController
@RequestMapping("/conflict-cases")
public class ConflictCaseController {

    @Autowired
    private ConflictCaseService service;

    @PostMapping
    public ResponseEntity<ConflictCase> createCase(@RequestBody ConflictCase conflictCase) {
        ConflictCase created = service.createCase(conflictCase);
        return ResponseEntity.ok(created);
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<ConflictCase> updateCaseStatus(@PathVariable Long id, @RequestParam String status) {
        ConflictCase updated = service.updateCaseStatus(id, status);
        return ResponseEntity.ok(updated);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConflictCase> getCaseById(@PathVariable Long id) {
        ConflictCase cc = service.getCaseById(id);
        return ResponseEntity.ok(cc);
    }

    @GetMapping("/person/{personId}")
    public ResponseEntity<List<ConflictCase>> getCasesByPerson(@PathVariable Long personId) {
        List<ConflictCase> list = service.getCasesByPerson(personId);
        return ResponseEntity.ok(list);
    }

    @GetMapping
    public ResponseEntity<List<ConflictCase>> getAllCases() {
        return ResponseEntity.ok(service.getAllCases());
    }
}
