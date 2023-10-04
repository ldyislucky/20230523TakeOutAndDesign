package mode.restful;

import com.alibaba.fastjson.JSON;
import mode.entity.Book;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("get1/{a}/{b}")
    public List<Book> getAllBooks1(@PathVariable("a") String a,@PathVariable("b")String b) {
        Book book = new Book();
        book.setId("1");
        book.setTitle("哈利波特");
        books.add(book);
        System.out.println(a+b);
        return books;
    }

    @GetMapping("get3")
    public List<Book> getAllBooks3(@RequestParam("a") String a, //这个注解可以获取json参数
                                   @RequestParam("b") String b) {
        Book book = new Book();
        book.setId("3");
        book.setTitle("哈利波特");
        books.add(book);
        System.out.println(books);
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
