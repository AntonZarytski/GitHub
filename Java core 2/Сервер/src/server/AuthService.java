package server;

import java.util.ArrayList;
import java.util.HashMap;

public interface AuthService {
    void start();
    String getNickByLogin(String userName);
    void stop();
}
class BaseAuthService implements AuthService{
        private String userName;
        private String userPassword;
        private String nickName;
        private ArrayList<String> entries;

        public BaseAuthService(String userPassword, String nickName){
            this.userPassword=userPassword;
            this.nickName=nickName;
            entries = new ArrayList <> (  );
            entries.add ( this.userPassword );
            entries.add (this.nickName);
        }
        private static HashMap<String, ArrayList> userData = new HashMap <> (  );

    @Override
    public void start() {}
    @Override
    public void stop() {}

    public void addingToUserData (String userName){
        userData.put (userName, this.entries);
    }

    public static HashMap <String, ArrayList> getUserData() {
        return userData;
    }

    public ArrayList <String> getEntries() {
        return entries;
    }

    public String getNickByLogin(String userName) {
        if (userData.containsKey (userName)){
            String nick = (String) userData.get (userName).get (1);
            return nick;
        }else {
            return null;
        }
    }
}
