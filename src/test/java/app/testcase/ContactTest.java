package app.testcase;

import app.pages.contact.ContactPage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

@Execution(ExecutionMode.CONCURRENT)
public class ContactTest extends BaseTest {

    @Test
    public void test_search() {
        ContactPage contactPage = app.toContact().toSearch("ui");
        assertThat(contactPage.getSearchResult(),hasItem("ui"));
    }
}
