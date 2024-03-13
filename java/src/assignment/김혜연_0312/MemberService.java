package assignment.김혜연_0312;

public class MemberService {
    private String id;
    private String password;

    public boolean login(String id, String password){
        boolean result;
        //result = id.equals("hong") && password.equals("12345");
        result = "hong".equals(id) && "12345".equals(password);
        return result;
    }

    public void logout(String id){
        System.out.println(id+"님이 로그아웃 되었습니다.");
    }
}
