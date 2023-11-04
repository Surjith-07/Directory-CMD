import java.util.*;
public class Main {
    Directory root;
    Directory curr;
    Stack<String> stk;

    Main(){
        root=new Directory("C:/");
        curr=root;
        stk=new Stack<>();
        stk.push(root.getName());
    }

    public void createDir(String s){
        curr.createSub(s);
        //stk.push(s);
    }

    public String getName(){
        return curr.getName();
    }

    public void navigate(String s){
        Directory sub=curr.getDir(s);
        if(sub!=null){
            curr=sub;
            stk.push(curr.getName());
        }else {
            System.out.println("No Folder Found...!");
        }
    }

    public String getContent(){
        return curr.getContent();
    }

    public void createCont(String s,String o){
        curr.createCon(s,o);
    }


    public void goback(){
        if(curr!=root){
            curr=root;
            stk.pop();
        }else System.out.println("You are reached the root folder");
    }


    public static void main(String[] args){
        Main obj=new Main();
        int val;
        Scanner sc=new Scanner(System.in);
        while(true){
            System.out.println("CMD\n------------------------------------------------------------------------------");
            System.out.println("1.CreateDir:-\n"+"2.CurrDir\n"+"3.NavigateToSubDir\n"+"4.Goback\n"+"5.listContent\n"+"6.Create file\n"+"7.exit");
            val=sc.nextInt();
            switch (val){
                case 1:
                    System.out.println("Enter the DirName :-");
                    String str=sc.next();
                    obj.createDir(str);
                    System.out.println("Curr Path : "+obj.stk);
                    break;
                case 2:
                    System.out.println(obj.getName());
                    System.out.println("Curr Path : "+obj.stk);
                    break;
                case 3:
                    System.out.println("Enter the FolderName :-");
                    String st=sc.next();
                    obj.navigate(st);
                    System.out.println("Curr Path : "+obj.stk);
                    break;
                case 4:
                    obj.goback();
                    System.out.println("Move to Previous Directory");
                    break;
                case 5:
                    System.out.println("Content of this folder");
                    System.out.println(obj.getContent());
                    break;
                case 6:
                    System.out.println("Enter the Dir name ");
                    String p=sc.next();
                    System.out.println("Enter the content");
                    String op=sc.next();
                    obj.createCont(p,op);
                    break;
                case 7:
                    System.exit(-1);
                default:
                    System.out.println("Enter Valid Number...!");
            }
        }
    }
}