src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── yourcompany/
│   │           ├── controller/
│   │           │   ├── ArticleController.java
│   │           │   └── AuthController.java
│   │           ├── model/
│   │           │   └── Article.java
│   │           ├── repository/
│   │           │   └── ArticleRepository.java
│   │           ├── security/
│   │           │   └── UserDetailsServiceImpl.java
│   │           ├── service/
│   │           │   ├── ArticleService.java
│   │           │   └── UserService.java
│   │           └── Application.java
│   └── resources/
│       └── templates/
│           ├── index.html
│           ├── login.html
│           └── articleForm.html
└── test/
    └── java/
        └── com/
            └── yourcompany/
                └── controller/
                    └── ArticleControllerTest.java







<dependencies>
    <!-- Spring Boot -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-security</artifactId>
    </dependency>
    <!-- Spring Data JPA -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    <!-- MySQL Connector -->
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
    </dependency>
</dependencies>







spring.datasource.url=jdbc:mysql://localhost:3306/cmsdb
spring.datasource.username=root
spring.datasource.password=password
spring.jpa.hibernate.ddl-auto=update





@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), new ArrayList<>());
    }
}







@RestController
@RequestMapping("/api/articles")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping
    public List<Article> getAllArticles() {
        return articleService.getAllArticles();
    }

    @PostMapping
    public void addArticle(@RequestBody Article article) {
        articleService.addArticle(article);
    }

    // Other CRUD operations...
}






@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    public void addArticle(Article article) {
        articleRepository.save(article);
    }

    // Other CRUD operations...
}







@Entity
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;

    // Getters and setters...
}








@Controller
public class AuthController {

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }
}





<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
</head>
<body>
    <h2>Login</h2>
    <form action="/login" method="post">
        <div>
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required>
        </div>
        <div>
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>
        </div>
        <button type="submit">Login</button>
    </form>
</body>
</html>
