package mode.restful;

import com.alibaba.fastjson.JSON;
import mode.entity.Book;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : ldy
 * @version : 1.0
 */
@RestController
@RequestMapping("/jquery-server")
public class jQueryServer {
    private List<Book> books = new ArrayList<>();
    @GetMapping("get1")
    public List<Book> getAllBooks1(@PathVariable("a")int a,@PathVariable("b")int b) {
        Book book = new Book();
        book.setId("1");
        book.setTitle("哈利波特");
        books.add(book);
        System.out.println(a+b);
        return books;
    }
    @GetMapping("get2")
    public List<Book> getAllBooks2() {
        Book book = new Book();
        book.setId("1");
        book.setTitle("哈利波特");
        books.add(book);
        return books;
    }


}
