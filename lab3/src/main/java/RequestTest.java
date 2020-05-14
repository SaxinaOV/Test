package lab3;

import org.junit.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.Matchers.*;

public class RequestTest {
    @Test
    public void userInfoTest(){
        when()
                .get("https://api.vk.com/method/users.get?user_ids=82611734&access_token=0f77d93b26d27f7575110d51262548a096ff20c0b06e587b70e52be26a9e383d468c8f66b425e0cad9e75&v=5.103.")
                .then()
                .statusCode(200)
                .body("response.id", hasItem(82611734),
                        "response.first_name", hasItem("Ольга"),
                        "response.last_name", hasItem("Саксина"),
                        "response.is_closed", hasItem(false));

    }

    @Test
    public void groupMemberTest(){
        when()
                .get("https://api.vk.com/method/groups.isMember?group_id=takiedela_ru&user_id=82611734&extended=1&access_token=0f77d93b26d27f7575110d51262548a096ff20c0b06e587b70e52be26a9e383d468c8f66b425e0cad9e75&v=5.103.")
                .then()
                .statusCode(200)
                .body(
                        "response.member", equalTo(1)
                );
    }
}
