package model;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Session {
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void archivoLog(String event) throws IOException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = sdf.format(new Date());
        try(FileWriter writer = new FileWriter("sessions.log", true)){
                writer.write(time + " " + user.getName() + " " + event + "\n");
            }catch(IOException e){
                e.printStackTrace();
        }
    }
}
