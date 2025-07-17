package com.andrew.demo;

public class SoftwareEngineerDTO {
    private String name;
    private String techStack;

    public SoftwareEngineerDTO() {
    }

    public SoftwareEngineerDTO(String name, String techStack) {
        this.name = name;
        this.techStack = techStack;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTechStack() {
        return techStack;
    }

    public void setTechStack(String techStack) {
        this.techStack = techStack;
    }
}
