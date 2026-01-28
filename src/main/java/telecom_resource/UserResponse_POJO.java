package telecom_resource;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserResponse_POJO {
private User_POJO user;


private String token;
public String getToken() {
	return token;
}
public void setToken(String token) {
	this.token = token;
}
public User_POJO getUser() {
	return user;
}
public void setUser(User_POJO user) {
	this.user = user;
}
}
