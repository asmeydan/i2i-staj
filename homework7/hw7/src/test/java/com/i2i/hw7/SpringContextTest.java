package com.i2i.hw7;

import com.i2i.hw7.model.Book;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.apache.commons.lang3.RandomStringUtils.randomNumeric;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class SpringContextTest {

    private static final String API_ROOT = "http://localhost:8080/api/books";

    @Test
    public void contextLoads() {
    }

    @Test
    public void whenGetAllBooks_thenOK() {
        Response response = RestAssured.get(API_ROOT);
        assertEquals(HttpStatus.OK.value(), response.getStatusCode());
    }

    @Test
    public void whenGetBooksByTitle_thenOK() {
        Book book = createRandomBook();
        createBookAsUri(book);

        Response response = RestAssured.get(API_ROOT + "/title/" + book.getTitle());

        assertEquals(HttpStatus.OK.value(), response.getStatusCode());

        List<Book> books = response.jsonPath().getList(".", Book.class);
        assertFalse(books.isEmpty());
    }

    private Book createRandomBook() {
        Book book = new Book();
        book.setTitle("TestTitle" + randomNumeric(5));
        book.setAuthor("TestAuthor");
        return book;
    }

    private String createBookAsUri(Book book) {
        Response response = given()
                .contentType(ContentType.JSON)
                .body(book)
                .post(API_ROOT);

        return API_ROOT + "/" + response.jsonPath().get("id");
    }
}
