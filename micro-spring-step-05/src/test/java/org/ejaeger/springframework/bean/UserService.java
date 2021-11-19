package org.ejaeger.springframework.bean;

public class UserService {

    private String uId;

    private UserDao userDao;

    public String queryUserInfo() {
        return userDao.queryUserName(uId);
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public String  toString() {
        return "UserService{" +
                "uId='" + uId + '\'' +
                ", userDao=" + userDao +
                '}';
    }
}
