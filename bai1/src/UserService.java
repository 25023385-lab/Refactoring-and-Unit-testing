//class UserService {
//    public User findById(int id) { ... }
//    public void sendWelcomeEmail(User user) { ... }
//    public void sendPasswordResetEmail(User user) { ... }
//    public void renderUserProfile(User user) { ... }
//    public String exportUserToCsv(User user) { ... }
//}
// vi phạm SRP vì class làm quá nhiều việc 1 lúc
// sử lý bang extract variable/class

class userService{
    int id;
    public userService(int id){
        this.id = id;
    }
    void findByID(int id)
}
class EmailService {
    public void sendWelcomeEmail(User user) { ... }
    public void sendPasswordResetEmail(User user) { ... }
}
class UserPresenter {
    public void renderUserProfile(User user) { ... }
}
class UserExporter {
    public String exportToCsv(User user) { ... }
}

