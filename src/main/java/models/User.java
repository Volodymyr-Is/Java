package models;

import java.util.List;

public class User {
    private int id;
    private String username;
    private String password;
    private String city;
    private String webServer;
    private String role;
    private List<String> services;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getCity() {
        return city;
    }

    public String getWebServer() {
        return webServer;
    }

    public String getRole() {
        return role;
    }

    public List<String> getServices() {
        return services;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setWebServer(String webServer) {
        this.webServer = webServer;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setServices(List<String> services) {
        this.services = services;
    }
}
