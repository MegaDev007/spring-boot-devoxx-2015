@RestController
class HomeController {
	@RequestMapping("/")
	String home() {
		'Hello World'
	}

	@RequestMapping("/hello")
	String hello(@RequestParam String name) {
		"Hello $name"
	}
}
