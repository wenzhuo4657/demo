import org.example.user;
import org.example.userImpl;

module org {
//    exports org.wenzhuo4657;
    opens org.example;

    exports org.example;

    provides user with userImpl;
}