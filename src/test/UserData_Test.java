package test;
import dao.UserData;
import domain.User;
import org.junit.Test;
public class UserData_Test {
    @Test
    public void testLogin(){
        User loginuser =new User();
        loginuser.setUsername("rqr");
        loginuser.setPassword("14");
        UserData userData=new UserData();
        User user1 = userData.login(loginuser);
        System.out.println(user1);


}

}
