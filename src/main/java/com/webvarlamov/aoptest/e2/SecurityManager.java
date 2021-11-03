package com.webvarlamov.aoptest.e2;

public class SecurityManager {
    private ThreadLocal<UserInfo> threadLocal = new ThreadLocal<>();

    public void login(String username, String password) {
        threadLocal.set(new UserInfo(username, password));
    }

    public void logout() {
        threadLocal.set(null);
    }

    public UserInfo getLoggedOnUser() {
        return threadLocal.get();
    }
}
