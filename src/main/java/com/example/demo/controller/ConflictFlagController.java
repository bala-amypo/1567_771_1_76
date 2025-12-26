@RestController
@RequestMapping("/conflict-flags")
public class ConflictFlagController {

    @Autowired
    private ConflictFlagService service;

    @PostMapping
    public ResponseEntity<ConflictFlag> addFlag(@RequestBody ConflictFlag flag) {
        return ResponseEntity.ok(service.create(flag));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConflictFlag> getFlagById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getFlagById(id));
    }

    @GetMapping("/case/{caseId}")
    public ResponseEntity<List<ConflictFlag>> getFlagsByCase(@PathVariable Long caseId) {
        return ResponseEntity.ok(service.getFlagsByCase(caseId));
    }

    @GetMapping
    public ResponseEntity<List<ConflictFlag>> getAllFlags() {
        return ResponseEntity.ok(service.getAllFlags());
    }
}
