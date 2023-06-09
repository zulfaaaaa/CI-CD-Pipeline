package starter.Login;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class Login {
    public String url = "https://reqres.in/api/users";

    @Step("user set valid PUT endpoint")
    public String setValidPutEndpoint(){
        return url + "/2";
    }
    @Step("user send PUT HTTP request")
    public void sendPUTHTTPRequest(){

        String body = "{\"name\":\"morpheus\", \"job\": \"zion resident\" }";

        JSONObject rBody = new JSONObject(body);

        SerenityRest.given().header("Content-Type", "application/json").body(rBody.toString()).put(setValidPutEndpoint());
    }
    @Step("user send update user data")
    public void validateValidPostDataUpdated(){
        restAssuredThat(response->response.body("'name'",equalTo("morpheus")));
        restAssuredThat(response->response.body("'job'",equalTo("zion resident")));
    }
    @Step("user received PUT HTTP response code 200")
    public void validatePUTHTTPResponseCode200(){
        restAssuredThat(response -> response.statusCode(200));
    }
}