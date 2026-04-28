//

//data clump
// cách giải quyết: gom thành 1 class riêng

public class Report{
    Author author;
    private String title;
    private String content;
}
class Author{
    private String authorEmail;
    private String authorName;
    private String authorPhone;
    private String authorAddress;
}
// khi nao field di voi nhau k?
// field co the thanh 1 object khong?