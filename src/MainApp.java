public class MainApp {
    public static String[] model = new String[10];
    public  static java.util.Scanner scanner = new java.util.Scanner(System.in);
    public static void main(String[] args){
        System.out.println("Welcome to ToDo List App");
        viewList();
    }

    public static void showList(){
        for (var i = 0; i < model.length; i++) {
            var toDo = model[i];
            var no = i + 1;
            if(toDo != null){
                System.out.println(no + ". " + toDo);
            }
        }
    }

    public static void addList(String list){
        var full = true;
        for(var i = 0; i < model.length; i++){
            if (model[i] == null){
                full = false;
                break;
            }
        }
        if(full){
            var temp = model;
            model = new String[model.length + 10];
            for (int i = 0; i < temp.length; i++) {
                model[i] = temp[i];
            }
        }
        for (var i = 0; i < model.length; i++) {
            if (model[i] == null){
                model[i] = list;
                System.out.println("List Successfully Added");
                break;
            }
        }
    }

    public static void removeList(int no){
        if((no-1) >= model.length){
            System.out.println("Number Out of Bound");
        }
        else if (model[no-1] == null){
            System.out.println("List is Empty");
        }else {
            model[no-1] = null;
            for(int i = no-1; i < model.length; i++){
                if(i == model.length - 1){
                    model[i] = null;
                } else {
                    model[i] = model[i+1];
                }
            }
            System.out.println("List Successfully Deleted");
        }
    }

    public static void updateList(int no, String list){
        if((no-1) >= model.length){
            System.out.println("Index Out of Bound");
        } else if (model[(no -1)] == null){
            System.out.println("List number " + (no-1) + " is empty");
        }else {
            model[no-1] = list;
            System.out.println("List Successfully Updated");
        }
    }

    public static void viewList(){
        System.out.println("Your List :");
        showList();
        System.out.println("Type A for Add, Type R for Remove, Type U for Update, Type Q for Quit");
        var action = scanner.nextLine();
        switch (action){
            case "A", "a": viewAddList();
            case "R", "r" : viewRemoveList();
            case "U", "u" : viewUpdateList();
            case "Q", "q" : System.exit(0);
            default:
                System.out.println("Invalid Input");
                viewList();
        }
    }

    public static void addAction(){
        System.out.println("Type Q to Back, Type A to add more List");
        var action = scanner.nextLine();
        switch (action) {
            case "Q", "q":
                viewList();
            case "A", "a":
                viewAddList();
            default:
                System.out.println("Invalid Input");
                viewAddList();
        }
    }
    public static void viewAddList(){
        showList();
        System.out.println("Add : ");
        var list = scanner.nextLine();
        addList(list);
        addAction();
    }

    public static void removeAction(){
        System.out.println("Type Q to Back, Type R to Remove More List");
        var input = scanner.nextLine();
        switch (input){
            case "Q", "q" : viewList();
            case "R", "r" : viewRemoveList();
            default:
                System.out.println("Invalid Input");
                viewRemoveList();
        }
    }
    public static void viewRemoveList(){
        showList();
        System.out.println("Remove List Number : ");
        int no = Integer.parseInt(scanner.nextLine());
        System.out.println("Are you sure you want to remove from the list? <Y/N>");
        var action = scanner.nextLine();
        switch (action){
            case "Y", "y" : removeList(no); removeAction();
            case "N", "n" :
                System.out.println("List did not Removed"); removeAction();
            default:
                System.out.println("Invalid Input"); removeAction();
        }
    }

    public static void updateAction(){
        System.out.println("Type Q to Back, Type U to update more List");
        var input = scanner.nextLine();
        switch (input){
            case "Q", "q" : viewList();
            case "U", "u" : viewUpdateList();
            default:
                System.out.println("Invalid Input");
                viewUpdateList();
        }
    }
    public static void viewUpdateList(){
        showList();
        System.out.println("Update Number : ");
        int no = Integer.parseInt(scanner.nextLine());
        System.out.println("With : ");
        var list = scanner.nextLine();
        System.out.println("Are you sure? <Y/N>");
        var action = scanner.nextLine();
        switch (action){
            case "Y", "y" : updateList(no, list); updateAction();
            case "N", "n" :
                System.out.println("Data did not Updated"); updateAction();
            default:
                System.out.println("Invalid Input");
                updateAction();
        }
    }
}
