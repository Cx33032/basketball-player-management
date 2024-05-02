package com.player.player;

public class PlayersData {
    private int rank;
    private String firstName;
    private String lastName; 
    private int age;
    private String phoneNumber;
    private String email;
    private String position;
    
    public int getRank(){return rank;}
    public void setRank(int newRank){this.rank = newRank;}

    public String getFirstName(){return firstName;} /*getter*/
    public void setFirstName(String newFirstName){this.firstName = newFirstName;} /*setter*/

    public String getLastName(){return lastName;} /*getter*/
    public void setLastName(String newLastName){this.lastName = newLastName;} /*setter*/

    public int getAge(){return age;} /*getter*/
    public void setAge(int newAge){this.age = newAge;} /*setter*/

    public String getPhoneNumber(){return phoneNumber;} /*getter*/
    public void setPhoneNumber(String newPhoNum){this.phoneNumber = newPhoNum;} /*setter*/
    
    public String getEmail(){return email;} /*getter*/
    public void setEmail(String newEmail){this.email = newEmail;} /*setter*/

    public String getPosition(){return position;} /*getter*/
    public void setPosition(String newPosition){this.position = newPosition;} /*setter*/
    
    //Constructor
    public PlayersData(int rank, String newFirstName, String newLastName, int newAge, String newPhoNum, String newEmail, String newPosition)
    {
        //Assigns variables on initialization of object
        this.rank = rank;
        this.firstName = newFirstName;
        this.lastName = newLastName;
        this.age = newAge;
        this.phoneNumber = newPhoNum;
        this.email = newEmail;
        this.position = newPosition;
    }

    // private static String numberSufix(int num)
    // {
    //     if(num / 10 == 1) return "th"; /*11, 12, and 13 use the th sufix*/
    //     switch(num%10)
    //     {
    //     case 1:
    //         return "st";
    //     case 2:
    //         return "nd";
    //     case 3:
    //         return "rd";
    //     default:
    //         return "th";
    //     }
    // }
}
