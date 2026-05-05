package ntu.edu.vieccanlam;

import java.util.HashMap;
import java.util.Map;

public class Task {
    private String name;
    private String message;
    private String date;
    private String priority;

    public Task() {}


    public Task(String name, String message, String date, String priority) {
        this.name = name;
        this.message = message;
        this.date = date;
        this.priority = priority;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getPriority() {
        return priority;
    }
    public void setPriority(String priority) {
        this.priority = priority;
    }

    public HashMap<String, String> toFirebaseObject() {
        HashMap<String, String> task0bject = new HashMap<String, String>();
        task0bject.put("name", name);
        task0bject.put("date", date);
        task0bject.put("message", message);
        task0bject.put("priority", priority);
        return task0bject;
    }
}
