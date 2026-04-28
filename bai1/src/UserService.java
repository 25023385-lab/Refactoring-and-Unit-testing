//class UserService {
//    public User findById(int id) { ... }
//    public void sendWelcomeEmail(User user) { ... }
//    public void sendPasswordResetEmail(User user) { ... }
//    public void renderUserProfile(User user) { ... }
//    public String exportUserToCsv(User user) { ... }
//}
// vi phạm SRP vì class làm quá nhiều việc 1 lúc
// sử lý bang extract variable/class

class UserService{
    //lop quản lý dữ liệu
    public User findById(int id)
}
class EmailService{
    //lớp quản lý notification
    public void sendWelcomeEmail(User user){}
    public void senPasswordResetEmail(User user){
    }
}
class Userpresenter{
    //lớp quản lý hiện thị dữ liệu
    public void renderUserProfile(User user){
        // cấu trúc profile
    }
}
class Userexport{
    // phụ trách định dạng dữ liệu
    public String exportToCsv(User user) {
        //export thành data
    }
}
// đảm bảo tính SRP; không thay đổi code cũ; k phụ thuộc vào nhau
//SOLID
//dễ testing hơn
// phù hợp nghiệp vụ