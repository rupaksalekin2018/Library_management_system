import java.util.*;
import java.io.*;

public class StudentInfo implements Serializable{
    public String firstName = "";
    public String lastName = "";
    public String username = "";
    public String email = "";
    public String contactNo = "";
    public String password = "";
    public String countryName = "";
    public String gender = "";
    public int userID;
    public ArrayList<String> booklist = new ArrayList<>();
    public ArrayList<String> datelist = new ArrayList<>();
    
    StudentInfo(String fn , String ln, String un, String em, String cn, String pw, String con, String g, int uid)
    {
        firstName = fn;
        lastName = ln;
        username = un;
        email = em;
        contactNo = cn;
        password = pw;
        countryName = con;
        gender = g;
        userID = uid;
    }
    public void addBook(String bookName)
    {
        booklist.add(bookName);
    }
}
