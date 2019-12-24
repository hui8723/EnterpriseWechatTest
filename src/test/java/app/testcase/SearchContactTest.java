package app.testcase;

import app.pages.contact.ContactPage;
import app.pages.contact.SearchContactPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

@Execution(ExecutionMode.CONCURRENT)
public class SearchContactTest extends BaseTest {

    static SearchContactPage searchContactPage;

    @BeforeAll
    public static void initSearch() {
        searchContactPage = app.toContact().toSearch();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/app/testcase/ContactTest.csv")
    public void test_search(String content) {
        searchContactPage.search(content);
        assertThat(searchContactPage.getSearchResult(),hasItem(content));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/app/testcase/ContactTest.csv")
    public void test_search_step(String content) {
        searchContactPage.search_step(content);
        assertThat(searchContactPage.getSearchResult(),hasItem(content));
    }

}
