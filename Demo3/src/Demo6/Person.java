package Demo6;

public class Person {

    public String personId;
    private String personPassword;
    public String personEmailAddress;


    public Person(String personId,String personPassword){
        this.personId=personId;
        this.personPassword=personPassword;
        this.personEmailAddress=personId+"@gameschool.com";
    }



}
