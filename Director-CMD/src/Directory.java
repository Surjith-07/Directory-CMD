import java.util.*;
public class Directory {
    Scanner sc=new Scanner(System.in);
    String name;
    Map<String,Directory> map;
    Map<String,String> files;

    Directory(String name){
        this.name=name+" > ";
        this.map=new HashMap<>();
        this.files=new HashMap<>();
    }

    public String getName(){
        return name;
    }

    public void createSub(String sub){
        map.put(sub,new Directory(sub));
    }

    public void createCon(String op,String subF){
        files.put(op,subF);
    }

    public String getContent(){
        System.out.println("Enter the DirectoryName:-");
        String s=sc.next();
        return files.get(s);
    }

    public Directory getDir(String s){
        return map.get(s);
    }
}
