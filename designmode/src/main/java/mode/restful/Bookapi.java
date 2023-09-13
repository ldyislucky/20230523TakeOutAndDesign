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
@RestController//该类中的方法都将返回 JSON、XML 或其他数据类型作为响应内容
@RequestMapping("/bookapi")
public class Bookapi {
    private List<Book> books = new ArrayList<>();
    @GetMapping("/get1")
    public List<Book> getAllBooks1() {
        Book book = new Book();
        book.setId("1");
        book.setTitle("哈利波特");
        books.add(book);
        return books;
    }

    @GetMapping("/get2")
    public String getAllBooks2() {
        Book book = new Book();
        book.setId("1");
        book.setTitle("哈利波特");
        books.add(book);
        String s = JSON.toJSONString(books);

        return s;
    }
    @GetMapping("/get3")
    public ResponseEntity<List<Book>> getBook3() {
        Book book = new Book();
        book.setId("1");
        book.setTitle("哈利波特");
        books.add(book);

        if (!books.isEmpty()) {
            return new ResponseEntity<>(books, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

}
